package jesusvegapic.TFG.apps.mooc.controller.students;

import jesusvegapic.TFG.mooc.students.application.CreateStudentCommand;
import jesusvegapic.TFG.shared.domain.DomainError;
import jesusvegapic.TFG.shared.domain.bus.command.CommandBus;
import jesusvegapic.TFG.shared.domain.bus.command.CommandHandlerExecutionError;
import jesusvegapic.TFG.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class StudentsPutController extends ApiController {
    public StudentsPutController(
            CommandBus commandBus
    ) {
        super(commandBus);
    }

    @PutMapping(value = "/students/{id}")
    public ResponseEntity<String> index(
            @PathVariable String id,
            @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new CreateStudentCommand(id, request.name(), request.familyName(), request.email()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {return null;}

    public final class Request {
        private String name;
        private String familyName;
        private String email;

        public void setName(String name) { this.name = name;}

        public void setFamilyName(String familyName) { this.familyName = familyName;}

        public void setEmail(String email) { this.email = email;}

        String name() { return name; }

        String familyName() { return familyName;}

        String email() { return email;}
    }
}
