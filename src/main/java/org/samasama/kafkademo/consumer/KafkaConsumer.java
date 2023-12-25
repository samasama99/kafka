package org.samasama.kafkademo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "test", groupId = "test-group")
    public void consumeMsg(String msg) {
        log.info(format("Consuming message to test Topic: %s", msg));
    }
}
