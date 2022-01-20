package jesusvegapic.TFG.shared.infrastructure.validation;

import jesusvegapic.TFG.shared.domain.Service;
import jesusvegapic.TFG.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
