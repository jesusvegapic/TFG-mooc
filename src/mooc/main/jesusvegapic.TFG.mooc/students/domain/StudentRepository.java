package jesusvegapic.TFG.mooc.students.domain;

import reactor.core.publisher.Mono;

public interface StudentRepository {
    Mono<Student> save(Student student);
}
