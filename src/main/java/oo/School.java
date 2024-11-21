package oo;

import java.util.HashSet;
import java.util.Set;

public class School {

    private String name;

    private final Set<Student> students = new HashSet<>();

    private final Set<Teacher> teachers = new HashSet<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void startSchool() {
        students.forEach(Student::introduce);
        teachers.forEach(Teacher::introduce);
    }

    public String getName() {
        return name;
    }
}
