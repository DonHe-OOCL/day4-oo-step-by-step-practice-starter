package oo;

import java.util.Objects;

public class Person {
    private Integer id;

    private String name;

    private Integer age;

    public Person() {
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }
}
