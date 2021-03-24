package net.therap;

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
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Size) {
                    Size size = (Size) annotation;
                    if (field.getModifiers() == Modifier.PRIVATE) {
                        field.setAccessible(true);
                    }
                    Object fieldValue = field.get(object);
                    switch (field.getName()) {
                        case "name":
                            ValidationUtil.ValidateName((String) fieldValue, size, errors);
                            break;
                        case "age":
                            ValidationUtil.ValidateAge((int) fieldValue, size, errors);
                            break;
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
