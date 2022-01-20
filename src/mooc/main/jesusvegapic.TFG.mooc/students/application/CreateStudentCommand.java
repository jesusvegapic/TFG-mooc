package jesusvegapic.TFG.mooc.students.application;

import jesusvegapic.TFG.shared.domain.bus.command.Command;

public class CreateStudentCommand implements Command {
    private final String id;
    private final String name;
    private final String familyName;
    private final String email;

    public CreateStudentCommand(String id, String name, String familyName, String email) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.email = email;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String familyName() {
        return name;
    }

    public String email() {
        return email;
    }
}
