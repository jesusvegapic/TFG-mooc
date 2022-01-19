package jesusvegapic.TFG.mooc.students.application;

import jesusvegapic.TFG.mooc.students.domain.StudentId;
import jesusvegapic.TFG.mooc.students.domain.StudentRepository;
import jesusvegapic.TFG.shared.domain.Service;
import jesusvegapic.TFG.shared.domain.bus.event.EventBus;

@Service
public final class StudentCreator {
    private final StudentRepository repository;
    private final EventBus          eventBus;

    public StudentCreator(StudentRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

}
