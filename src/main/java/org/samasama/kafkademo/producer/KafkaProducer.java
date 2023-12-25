package org.samasama.kafkademo.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    public final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String msg) {
        log.info(format("Publishing message to test Topic: %s", msg));
        kafkaTemplate.send("test", msg);
    }
}
