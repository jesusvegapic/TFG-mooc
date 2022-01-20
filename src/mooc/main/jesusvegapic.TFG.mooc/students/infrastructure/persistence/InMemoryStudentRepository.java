package jesusvegapic.TFG.mooc.students.infrastructure.persistence;

import jesusvegapic.TFG.mooc.students.domain.Student;
import jesusvegapic.TFG.mooc.students.domain.StudentRepository;

import java.util.HashMap;


public class InMemoryStudentRepository implements StudentRepository {
    private HashMap<String, Student> students= new HashMap<>();

    @Override
    public void save(Student student) {
        students.put(student.studentId().value(), student);
    }
}
