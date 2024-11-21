package oo;

import oo.observer.Event;

public class KnowLeaderEvent extends Event {
    private Student student;
    private Klass klass;

    public KnowLeaderEvent(Student student, Klass klass) {
        this.student = student;
        this.klass = klass;
    }

    public Student getStudent() {
        return student;
    }

    public Klass getKlass() {
        return klass;
    }
}
