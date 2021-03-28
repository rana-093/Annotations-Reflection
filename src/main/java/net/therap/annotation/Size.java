package net.therap.annotation;

import net.therap.model.Person;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author masud.rana
 * @since 24/03/2021
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {
    int min() default 1;

    int max() default 100;

    String message() default "Length must be within {min} - {max}";

    Class ValueProvider()  default Person.class;
}
