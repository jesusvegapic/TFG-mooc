package jesusvegapic.TFG.mooc.students.domain;

import reactor.core.publisher.Mono;

public interface StudentRepository {
    public void save(Student student);
}
