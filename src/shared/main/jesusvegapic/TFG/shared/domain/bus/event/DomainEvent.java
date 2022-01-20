package jesusvegapic.TFG.shared.domain.bus.event;

import jesusvegapic.TFG.shared.domain.Utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;
import java.time.LocalDateTime;

public abstract class DomainEvent {
    private String aggregateId;
    private String eventId;
    private String ocurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.ocurredOn = Utils.dateToString(LocalDateTime.now());
    }

    public DomainEvent(String aggregateId, String eventId, String ocurredOn) {
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.ocurredOn = ocurredOn;
    }

    protected DomainEvent() {
    }

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitives();

    public abstract DomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    );

    public String aggregateId() { return aggregateId;}

    public String eventId() { return eventId;}

    public String occurredOn() {return ocurredOn;}

}
