package dev.rkuzmych.kafka.kafka;

import dev.rkuzmych.Customer;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerProducer implements ApplicationListener<ApplicationReadyEvent> {

    private static final String TOPIC_NAME = "customer-registration";

    private final KafkaTemplate<String, Customer> kafkaTemplate;

    public CustomerProducer(KafkaTemplate<String, Customer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Customer customer = Customer
                .newBuilder()
                .setId(3)
                .setName(1)
                .build();

        kafkaTemplate.send(TOPIC_NAME, customer);
    }
}
