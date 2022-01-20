package jesusvegapic.TFG.shared.domain.student;

import jesusvegapic.TFG.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class StudentCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final String familyName;
    private final String email;

    public StudentCreatedDomainEvent() {
        super(null);

        this.name = null;
        this.familyName = null;
        this.email = null;
    }

    public StudentCreatedDomainEvent(String aggregateId, String name, String familyName, String email) {
        super(aggregateId);

        this.name = name;
        this.familyName= familyName;
        this.email = email;
    }

    public StudentCreatedDomainEvent(
            String aggregatedId,
            String eventId,
            String ocurredOn,
            String name,
            String familyName,
            String email
    ) {
        super(aggregatedId, eventId, ocurredOn);

        this.name = name;
        this.familyName = familyName;
        this.email = email;
    }

    @Override
    public String eventName() {
        return "student.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("familyName", familyName);
            put("email", email);
        }};
    }

    @Override
    public StudentCreatedDomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String ocurredOn
    ) {
        return new StudentCreatedDomainEvent(
                aggregateId,
                eventId,
                ocurredOn,
                (String) body.get("name"),
                (String) body.get("familyName"),
                (String) body.get("email")
        );
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
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentCreatedDomainEvent that = (StudentCreatedDomainEvent) o;
        return name.equals(that.name) &&
                familyName.equals(that.familyName) &&
                email.equals(that.email);
     }

     @Override
    public int hashCode() {
        return Objects.hash(name, familyName, email);
     }
}
