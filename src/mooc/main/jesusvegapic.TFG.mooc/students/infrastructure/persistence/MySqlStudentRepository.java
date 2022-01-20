package jesusvegapic.TFG.mooc.students.infrastructure.persistence;

import jesusvegapic.TFG.mooc.students.domain.Student;
import jesusvegapic.TFG.mooc.students.domain.StudentRepository;
import jesusvegapic.TFG.shared.domain.Service;
import jesusvegapic.TFG.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional("mooc-transaction_manager")
public class MySqlStudentRepository extends HibernateRepository<Student> implements StudentRepository {
    public MySqlStudentRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Student.class);
    }

    @Override
    public void save(Student student) {
        persist(student);
    }

}
