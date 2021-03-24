package net.therap;

/**
 * @author masud.rana
 * @since 24/03/2021
 */
public class Person {
    @Size(max = 10)
    private String name;

    @Size(min = 18, message = "Age can not be less than 18")
    private int age;

    public Person(String name, int age) {
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
