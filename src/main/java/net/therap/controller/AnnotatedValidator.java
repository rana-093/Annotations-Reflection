package net.therap.controller;

import net.therap.annotation.Size;
import net.therap.model.ValidationError;
import net.therap.util.ValidationUtil;

import java.lang.reflect.Field;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @author masud.rana
 * @since 24/03/2021
 */
public class AnnotatedValidator {
    public static void Validate(Object object, List<ValidationError> errors) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getModifiers() == Modifier.PRIVATE) {
                field.setAccessible(true);
            }
            if (!field.isAnnotationPresent(Annotation.class)) {
                continue;
            }
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Size) {
                    Size size = (Size) annotation;
                    String errorMsg = ValidationUtil.validateFields(field, size, object);
                    if (errorMsg.length() > 0) {
                        ValidationError validationError = new ValidationError();
                        validationError.setErrorMessage(errorMsg);
                        errors.add(validationError);
                    }
                }
            }
        }
    }

    public static void print(List<ValidationError> errors) {
        for (int i = 0; i < errors.size(); i++) {
            ValidationError validationError = errors.get(i);
            System.out.println(validationError.getErrorMessage());
        }
    }
}
