package oo;


import static oo.common.Constant.*;

public class Student extends Person {

    private Klass klass;

    private School school;

    public Student() {
    }

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduceFormat = STUDENT_INTRODUCE_FORMAT;
        if (klass == null) {
            String introduce = String.format(introduceFormat, name, age);
            System.out.println(introduce);
            return introduce;
        }
        String introduceSuffix = klass.isLeader(this)
                ? STUDENT_LEADER_INTRODUCE_FORMAT_SUFFIX
                : STUDENT_IN_CLASS_INTRODUCE_FORMAT_SUFFIX;
        String introduce = String.format(introduceFormat + SPACE + introduceSuffix, name, age, klass.getNumber());
        System.out.println(introduce);
        return introduce;
    }

    public String knowLeader() {
        String knowLeaderSentence = String.format(STUDENT_KNOW_LEADER_FORMAT,
                name, klass.getNumber(), klass.getLeader().getName());
        System.out.println(knowLeaderSentence);
        return knowLeaderSentence;
    }

    public void join(Klass klass) {
        this.klass = klass;
        klass.attach(this);
    }

    public boolean isIn(Klass klass) {
        if (this.klass == null || klass == null) {
            return false;
        }
        return this.klass.equals(klass);
    }

    public void join(School school) {
        this.school = school;
    }
}
