package net.therap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author masud.rana
 * @since 23/03/2021
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person("Abcde Fghij", 18);
        List<ValidationError> errors = new ArrayList<>();
        AnnotatedValidator.Validate(p, errors);
        AnnotatedValidator.print(errors);
    }
}
