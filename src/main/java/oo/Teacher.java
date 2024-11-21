package oo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Teacher extends Person{

    private Set<Klass> teachClasses;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String klassNumbers = teachClasses.stream()
                .map(klass -> klass.getNumber().toString())
                .collect(Collectors.joining(", "));
        return String.format("My name is %s. I am %d years old. I am a teacher. I teach Class %s.", name, age, klassNumbers);
    }

    public void assignTo(Klass klass) {
        if (teachClasses == null) {
            teachClasses = new HashSet<>();
        }
        teachClasses.add(klass);
    }

    public boolean belongsTo(Klass klass) {
        if (teachClasses == null) {
            return false;
        }
        return teachClasses.contains(klass);
    }

    public boolean isTeaching(Student student) {
        if (teachClasses == null) {
            return false;
        }
        return teachClasses.stream().anyMatch(student::isIn);
    }
}
