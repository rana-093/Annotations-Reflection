package net.therap.util;

import net.therap.annotation.Size;
import net.therap.controller.AnnotatedValidator;
import net.therap.model.Building;
import net.therap.model.BuildingProvider;
import net.therap.model.ValidationError;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author masud.rana
 * @since 24/03/2021
 */
public class ValidationUtil {
    static boolean isValid(int minSize, int maxSize, int curSize) {
        return (curSize >= minSize) && (curSize <= maxSize);
    }

    static String formatString(String errorMsg, Field field, int min, int max) {
        String minValueString = String.valueOf(min);
        String maxValueString = String.valueOf(max);
        errorMsg = errorMsg.replace("min", minValueString);
        errorMsg = errorMsg.replace("max", maxValueString);
        errorMsg = field.getName() + "(" + field.getType() + ") " + errorMsg;
        return errorMsg;
    }

    public static String validateFields(Field field, Annotation annotation, Object object)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String errorMsg = "";
        if (!(annotation instanceof Size)) {
            return errorMsg;
        }
        if (String.class.equals(field.getType())) {
            Object fieldValue = field.get(object);
            String name = (String) fieldValue;
            boolean valid = isValid(((Size) annotation).min(), ((Size) annotation).max(), name.length());
            if (!valid) {
                errorMsg = formatString(((Size) annotation).message(), field,
                        ((Size) annotation).min(), ((Size) annotation).max());
                return errorMsg;
            }
        } else if (int.class.equals(field.getType())) {
            Object fieldValue = field.get(object);
            int age = (int) fieldValue;
            boolean valid = isValid(((Size) annotation).min(), ((Size) annotation).max(), age);
            if (!valid) {
                errorMsg = formatString(((Size) annotation).message(), field,
                        ((Size) annotation).min(), ((Size) annotation).max());
                return errorMsg;
            }
        } else {
            Object fieldValue = field.get(object);
            Method method = ((Size) annotation).ValueProvider().getDeclaredMethod("getSize", field.getType());
            method.invoke(((Size) annotation).ValueProvider().getClass(), field.getType());
            boolean valid = isValid(((Size) annotation).min(), ((Size) annotation).max(), (int) fieldValue);
            if (!valid) {
                errorMsg = formatString(errorMsg, field, ((Size) annotation).min(), ((Size) annotation).max());
            }
        }
        return errorMsg;
    }
}
