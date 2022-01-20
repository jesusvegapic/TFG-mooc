package jesusvegapic.TFG.apps.mooc.command;

import jesusvegapic.TFG.shared.infrastructure.bus.event.rabbitMq.RabbitMqDomainEventsConsumer;
import jesusvegapic.TFG.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeRabbitMqDomainEventsCommand extends ConsoleCommand {
    private final RabbitMqDomainEventsConsumer consumer;

    public ConsumeRabbitMqDomainEventsCommand(RabbitMqDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute(String[] args) {
        consumer.consume();
    }
}