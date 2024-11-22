package oo;

import oo.observer.BasePublisher;
import oo.observer.Event;
import oo.observer.Listener;
import oo.observer.Publisher;

import java.util.*;

import static oo.common.Constant.STUDENT_NOT_IN_CLASS;

public class Klass extends BasePublisher {

    public static final Integer UNDEFINED_CLASS_NUMBER = Integer.MIN_VALUE;

    private Integer number;

    private Student leader;

    private School school;

    private Set<Student> students;

    private Set<Teacher> teachers;

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
        if (students == null) {
            students = new HashSet<>();
        }
        students.add(student);
        notifyListeners(new KnowLeaderEvent(leader, this));
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
        if (students == null) {
            students = new HashSet<>();
        }
        students.add(student);
        student.join(school);
        addListener(student);
    }

    public void attach(Teacher teacher) {
        if (teacher == null) {
            return;
        }
        if (teachers == null) {
            teachers = new HashSet<>();
        }
        teachers.add(teacher);
        teacher.join(school);
        addListener(teacher);
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
