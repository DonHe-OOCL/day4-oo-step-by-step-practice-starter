package oo;

import java.util.*;

public class Klass {

    public static final Integer UNDEFINED_CLASS_NUMBER = Integer.MIN_VALUE;

    private static final String STUDENT_NOT_IN_CLASS = "It is not one of us.";

    private Integer number;

    private Student leader;

    private School school;

    private Set<Student> students = new HashSet<>();

    private Set<Teacher> teachers = new HashSet<>();

    public Klass() {
        this.number = UNDEFINED_CLASS_NUMBER;
    }

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student student) {
        if (student == null || !student.isIn(this)) {
            System.out.println(STUDENT_NOT_IN_CLASS);
            return;
        }
        leader = student;
        students.add(student);
        students.forEach(Student::knowLeader);
        teachers.forEach(teacher -> teacher.knowLeader(this));
    }

    public boolean isLeader(Student student) {
        if (leader == null || student == null) {
            return false;
        }
        return leader.equals(student);
    }

    public void attach(Student student) {
        if (student == null) {
            return;
        }
        students.add(student);
        student.join(school);
    }

    public void attach(Teacher teacher) {
        if (teacher == null) {
            return;
        }
        teachers.add(teacher);
        teacher.join(school);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return Objects.equals(number, klass.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
