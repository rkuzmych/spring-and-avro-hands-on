package dev.rkuzmych.kafka;

import dev.rkuzmych.Customer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CustomerConsumer {

    @KafkaListener(topics = "customer-registration")
    public void listenGroupFoo(@Payload Customer message) {
        Logger.getAnonymousLogger().info("Received Message in group foo: " + message);
    }
}
