package net.therap;

import java.util.ArrayList;
import java.util.List;

import net.therap.controller.*;
import net.therap.model.*;
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
