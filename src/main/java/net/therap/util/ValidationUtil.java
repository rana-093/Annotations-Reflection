package net.therap.util;

import net.therap.annotation.Size;
import net.therap.model.ValidationError;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
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
            throws IllegalAccessException {
        String errorMsg = "";
        if (!(annotation instanceof Size)) {
            return errorMsg;
        }
        Object fieldValue = field.get(object);
        if (String.class.equals(field.getType())) {
            String name = (String) fieldValue;
            boolean valid = isValid(((Size) annotation).min(), ((Size) annotation).max(), name.length());
            if (!valid) {
                errorMsg = formatString(((Size) annotation).message(), field,
                        ((Size) annotation).min(), ((Size) annotation).max());
                return errorMsg;
            }
        } else if (int.class.equals(field.getType())) {
            int age = (int) fieldValue;
            boolean valid = isValid(((Size) annotation).min(), ((Size) annotation).max(), age);
            if (!valid) {
                errorMsg = formatString(((Size) annotation).message(), field,
                        ((Size) annotation).min(), ((Size) annotation).max());
                return errorMsg;
            }
        } else if (List.class.equals(field.getType())) {
            List list = (List) fieldValue;
            boolean valid = isValid(((Size) annotation).min(), ((Size) annotation).max(),
                    (list == null) ? 0 : list.size());
            if (!valid) {
                errorMsg = formatString(((Size) annotation).message(), field,
                        ((Size) annotation).min(), ((Size) annotation).max());
                return errorMsg;
            }
        } else if (Map.class.equals(field.getType())) {
            Map map = (Map) fieldValue;
            boolean valid = isValid(((Size) annotation).min(), ((Size) annotation).max(),
                    (map == null) ? 0 : map.size());
            if (!valid) {
                errorMsg = formatString(((Size) annotation).message(), field,
                        ((Size) annotation).min(), ((Size) annotation).max());
                return errorMsg;
            }
        }
        return errorMsg;
    }
}
