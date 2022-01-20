package jesusvegapic.TFG.mooc.students.domain;

import jesusvegapic.TFG.shared.domain.AggregateRoot;
import jesusvegapic.TFG.shared.domain.student.StudentCreatedDomainEvent;

import java.util.Objects;

public class Student extends AggregateRoot {

    private StudentId studentId;

    private String name;

    private String familyName;

    private String email;

    public Student(StudentId studentId, String name, String familyName, String email) {
        this.studentId = studentId;
        this.name = name;
        this.familyName = familyName;
        this.email = email;
    }

    private Student() {
        studentId = null;
        name = null;
        familyName = null;
        email = null;
    }

    public static Student create (StudentId studentId, String name, String familyName, String email) {

        Student student = new Student(studentId, name, familyName, email);

        student.record(new StudentCreatedDomainEvent(studentId.value(), name, familyName, email));

        return student;
    }

    public StudentId studentId() {
        return studentId;
    }

    public String name() {
        return name;
    }

    public String familyName() {
        return familyName;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return studentId.equals(student.studentId) &&
                name.equals(student.name) &&
                familyName.equals(student.familyName) &&
                email.equals(student.email);
    }

    @Override
    public int hashCode() { return Objects.hash(studentId, name, familyName, email);
    }

}
