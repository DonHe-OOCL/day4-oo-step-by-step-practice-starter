package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import oo.Klass;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_print_message_when_teacher_is_assigned_to_school() {
        // Given
        School school = new School("OOCL School");
        Teacher bob = new Teacher(1, "Bob", 22);

        // When
        school.addTeacher(bob);
        school.startSchool();

        // Then
        assertThat(systemOut()).contains("My name is Bob. I am 22 years old. I am a teacher.");
    }

    @Test
    public void should_print_message_when_teacher_assigned_to_class() {
        // Given
        School school = new School("OOCL School");
        Klass klass = new Klass(2);
        Teacher bob = new Teacher(1, "Bob", 22);
        school.addTeacher(bob);

        // When
        bob.assignTo(klass);
        klass.attach(bob);
        school.startSchool();

        // Then
        assertThat(systemOut()).contains("My name is Bob. I am 22 years old. I am a teacher. I teach Class 2.");
    }

    @Test
    public void should_print_message_when_student_assigned_as_leader_in_school() {
        // Given
        School school = new School("OOCL School");
        Klass klass = new Klass(2);
        Teacher bob = new Teacher(1, "bob", 22);
        school.addTeacher(bob);
        bob.assignTo(klass);
        klass.attach(bob);
        Student tom = new Student(1, "Tom", 18);
        school.addStudent(tom);
        tom.join(klass);

        // When
        klass.assignLeader(tom);
        school.startSchool();

        // Then
        assertThat(systemOut()).contains("I am bob, teacher of Class 2. I know Tom become Leader.");
        assertThat(systemOut()).contains("My name is Tom. I am 18 years old. I am a student. I am the leader of class 2.");
    }

    @Test
    public void should_print_message_when_multiple_students_are_in_class() {
        // Given
        School school = new School("OOCL School");
        Klass klass = new Klass(2);
        Teacher jerry = new Teacher(1, "Jerry", 22);
        school.addTeacher(jerry);
        jerry.assignTo(klass);
        klass.attach(jerry);
        Student tom = new Student(1, "Tom", 18);
        Student bob = new Student(2, "Bob", 19);
        school.addStudent(tom);
        school.addStudent(bob);
        tom.join(klass);
        bob.join(klass);

        // When
        klass.assignLeader(tom);
        school.startSchool();

        // Then
        assertThat(systemOut()).contains("I am Jerry, teacher of Class 2. I know Tom become Leader.");
        assertThat(systemOut()).contains("My name is Tom. I am 18 years old. I am a student. I am the leader of class 2.");
        assertThat(systemOut()).contains("My name is Bob. I am 19 years old. I am a student. I am in class 2.");
    }
}
