package net.therap.model;

import net.therap.annotation.Size;

import java.util.*;

/**
 * @author masud.rana
 * @since 24/03/2021
 */
public class Person {
    @Size(max = 10)
    private String name;

    @Size(min = 18, message = "Age can not be less than {min}")
    private int age;

    @Size(min = 1, max = 10)
    private List<String> phoneNumbers;

    public Person(String name, int age, List<String> list) {
        this.phoneNumbers = list;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
