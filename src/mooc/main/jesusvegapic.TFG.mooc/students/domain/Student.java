package jesusvegapic.TFG.mooc.students.domain;

import jesusvegapic.TFG.shared.domain.AggregateRoot;

public class Student extends AggregateRoot {

    private StudentId studentId;

    private String name;

    private String familyName;

    private String email;

}
