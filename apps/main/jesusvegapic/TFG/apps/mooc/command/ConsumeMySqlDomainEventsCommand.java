package jesusvegapic.TFG.apps.mooc.command;

import jesusvegapic.TFG.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import jesusvegapic.TFG.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeMySqlDomainEventsCommand extends ConsoleCommand {

    private final MySqlDomainEventsConsumer consumer;

    public ConsumeMySqlDomainEventsCommand(MySqlDomainEventsConsumer consumer) { this.consumer = consumer; }

    @Override
    public void execute(String[] args) { consumer.consume();}


}
