package oo;

import java.util.Objects;

public class Teacher {
    private Integer id;

    private String name;

    private Integer age;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a teacher.", name, age);
    }
}
