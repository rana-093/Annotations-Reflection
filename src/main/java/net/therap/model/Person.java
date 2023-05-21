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

    @Size(min = 5, max = 10, ValueProvider = BuildingProvider.class)
    private Building building;

    public Person(String name, int age, Building building) {
        this.name = name;
        this.age = age;
        this.building = building;
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

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return this.building;
    }
}
