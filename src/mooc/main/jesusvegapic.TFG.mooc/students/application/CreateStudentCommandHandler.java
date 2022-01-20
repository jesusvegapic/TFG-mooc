package jesusvegapic.TFG.mooc.students.application;

import jesusvegapic.TFG.mooc.students.domain.StudentId;
import jesusvegapic.TFG.shared.domain.Service;
import jesusvegapic.TFG.shared.domain.bus.command.CommandHandler;

@Service
public class CreateStudentCommandHandler implements CommandHandler<CreateStudentCommand> {
    private final StudentCreator creator;

    public CreateStudentCommandHandler(StudentCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateStudentCommand command) {
        StudentId       id       = new StudentId(command.id());
        String     name     = command.name();
        String familyName = command.familyName();
        String email = command.email();

        creator.create(id, name, familyName, email);
    }
}
