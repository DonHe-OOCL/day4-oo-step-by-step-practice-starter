package oo;


public class Student extends Person{

    private Klass klass;

    public Student() {
    }

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduceFormat = "My name is %s. I am %d years old. I am a student. ";
        return klass.isLeader(this) ?
                String.format(introduceFormat + "I am the leader of class %d.", name, age, klass.getNumber())
                : String.format(introduceFormat + "I am in class %d.", name, age, klass.getNumber());
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
}
