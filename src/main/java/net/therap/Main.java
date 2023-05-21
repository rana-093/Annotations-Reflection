package net.therap;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.therap.controller.*;
import net.therap.model.*;

/**
 * @author masud.rana
 * @since 23/03/2021
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Building building = new Building(5);
        Person p = new Person("Abcde Fghij", 17, building);
        List<ValidationError> errors = new ArrayList<>();
        AnnotatedValidator.Validate(p, errors);
        AnnotatedValidator.print(errors);
    }
}
