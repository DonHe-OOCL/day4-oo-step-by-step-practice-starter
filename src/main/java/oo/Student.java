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
        return String.format("My name is %s. I am %d years old. I am a student. I am in class %d.", name, age, klass.getNumber());
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public boolean isIn(Klass klass) {
        if (this.klass == null) {
            return false;
        }
        return Integer.compare(klass.getNumber(), this.klass.getNumber()) == 0;
    }
}
