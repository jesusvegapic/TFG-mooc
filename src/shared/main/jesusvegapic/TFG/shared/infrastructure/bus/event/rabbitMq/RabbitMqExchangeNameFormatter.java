package jesusvegapic.TFG.shared.infrastructure.bus.event.rabbitMq;

public final class RabbitMqExchangeNameFormatter {
    public static String retry(String exchangeName) {
        return String.format("retry-%s", exchangeName);
    }

    public static String deadLetter(String exchangeName) {
        return String.format("dead_letter-%s", exchangeName);
    }
}