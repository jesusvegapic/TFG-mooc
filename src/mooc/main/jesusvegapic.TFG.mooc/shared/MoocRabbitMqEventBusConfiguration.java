package jesusvegapic.TFG.mooc.shared;

import jesusvegapic.TFG.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import jesusvegapic.TFG.shared.infrastructure.bus.event.rabbitMq.RabbitMqEventBus;
import jesusvegapic.TFG.shared.infrastructure.bus.event.rabbitMq.RabbitMqPublisher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoocRabbitMqEventBusConfiguration {
    private final RabbitMqPublisher publisher;
    private final MySqlEventBus failoverPublisher;

    public MoocRabbitMqEventBusConfiguration(
        RabbitMqPublisher publisher,
        @Qualifier("moocMysqlEventBus") MySqlEventBus failoverPublisher
    ) {
        this.publisher         = publisher;
        this.failoverPublisher = failoverPublisher;
    }

    @Bean
    public RabbitMqEventBus moocRabbitMqEventBus() {
        return new RabbitMqEventBus(publisher, failoverPublisher);
    }
}
