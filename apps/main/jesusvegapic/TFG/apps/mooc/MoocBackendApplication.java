package jesusvegapic.TFG.apps.mooc;

import jesusvegapic.TFG.apps.mooc.command.ConsumeRabbitMqDomainEventsCommand;
import jesusvegapic.TFG.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import jesusvegapic.TFG.apps.mooc.command.ConsumeMySqlDomainEventsCommand;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
        value = {"jesusvegapic.TFG.shared", "jesusvegapic.TFG.mooc", "jesusvegapic.TFG.apps.mooc"}
)
public class MoocBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
            put("domain-events:mysql:consume", ConsumeMySqlDomainEventsCommand.class);
            put("domain-events:rabbitmq:consume", ConsumeRabbitMqDomainEventsCommand.class);
        }};
    }
}