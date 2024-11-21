package oo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static oo.common.Constant.*;

public class Teacher extends Person{

    private Set<Klass> teachClasses;

    private School school;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduceFormat = TEACHER_INTRODUCE_FORMAT;
        if (teachClasses == null || teachClasses.isEmpty()) {
            String introduce = String.format(introduceFormat,
                    name, age);
            System.out.println(introduce);
            return introduce;
        }
        String klassNumbers = teachClasses.stream()
                .map(klass -> klass.getNumber().toString())
                .collect(Collectors.joining(", "));

        String introduce = String.format(introduceFormat + SPACE + TEACHER_TEACH_CLASS_FORMAT_SUFFIX,
                name, age, klassNumbers);
        System.out.println(introduce);
        return introduce;
    }

    public String knowLeader(Klass klass) {
        String knowLeaderSentence = String.format(TEACHER_KNOW_LEADER_FORMAT,
                name, klass.getNumber(), klass.getLeader().getName());
        System.out.println(knowLeaderSentence);
        return knowLeaderSentence;
    }

    public void assignTo(Klass klass) {
        if (teachClasses == null) {
            teachClasses = new HashSet<>();
        }
        teachClasses.add(klass);
        klass.attach(this);
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

    public void join(School school) {
        this.school = school;
    }
}
