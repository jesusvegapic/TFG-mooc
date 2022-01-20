package jesusvegapic.TFG.shared.infrastructure.spring;

import jesusvegapic.TFG.shared.domain.DomainError;
import jesusvegapic.TFG.shared.domain.bus.command.Command;
import jesusvegapic.TFG.shared.domain.bus.command.CommandBus;
import jesusvegapic.TFG.shared.domain.bus.command.CommandHandlerExecutionError;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public abstract class ApiController {
    private final CommandBus commandBus;

    public ApiController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}
