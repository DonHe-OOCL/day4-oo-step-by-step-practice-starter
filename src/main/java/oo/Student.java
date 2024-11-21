package oo;


public class Student extends Person{

    private Klass klass;

    private School school;

    public Student() {
    }

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduceFormat = "My name is %s. I am %d years old. I am a student.";
        if (klass == null) {
            String introduce = String.format(introduceFormat, name, age);
            System.out.println(introduce);
            return introduce;
        }
        String introduceSuffix = klass.isLeader(this) ? " I am the leader of class %d." : " I am in class %d.";
        String introduce = String.format(introduceFormat + introduceSuffix, name, age, klass.getNumber());
        System.out.println(introduce);
        return introduce;
    }

    public String knowLeader() {
        String knowLeaderSentence = String.format("I am %s, student of Class %d. I know %s become Leader.",
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
