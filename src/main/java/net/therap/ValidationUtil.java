package net.therap;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author masud.rana
 * @since 24/03/2021
 */
public class ValidationUtil {
    public static void ValidateName(String name, Annotation annotation, List<ValidationError> errors) {
        String errorMsg = "";
        if (annotation instanceof Size) {
            if (!(name.length() >= ((Size) annotation).min() && name.length() <= ((Size) annotation).max())) {
                errorMsg = "name(String): Length must be {" + ((Size) annotation).min() + "} - {" + ((Size) annotation).max() + "}";
            }
        }
        if (errorMsg.length() > 0) {
            ValidationError validationError = new ValidationError();
            validationError.setErrorMessage(errorMsg);
            errors.add(validationError);
        }
    }

    public static void ValidateAge(int age, Annotation annotation, List<ValidationError> errors) {
        String errorMsg = "";
        System.out.println(age);
        if (annotation instanceof Size) {
            if (!(age >= ((Size) annotation).min() && age <= ((Size) annotation).max())) {
                errorMsg = "age(int): " + ((Size) annotation).message();
            }
        }
        if (errorMsg.length() > 0) {
            ValidationError validationError = new ValidationError();
            validationError.setErrorMessage(errorMsg);
            errors.add(validationError);
        }
    }
}
