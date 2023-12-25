package org.samasama.kafkademo.producer;

import org.samasama.kafkademo.payload.TestSubject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public record KafkaJsonProducer(KafkaTemplate<String, TestSubject> kafkaTemplate) {
    public void publish(TestSubject testSubject) {
        Message<TestSubject> message = MessageBuilder
                .withPayload(testSubject)
                .setHeader(KafkaHeaders.TOPIC, "test")
                .build();
        kafkaTemplate.send(message);
    }
}
