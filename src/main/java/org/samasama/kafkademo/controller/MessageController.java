package org.samasama.kafkademo.controller;

import org.samasama.kafkademo.payload.TestSubject;
import org.samasama.kafkademo.producer.KafkaJsonProducer;
import org.samasama.kafkademo.producer.KafkaStringProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public record MessageController(KafkaJsonProducer kafkaJsonProducer, KafkaStringProducer kafkaStringProducer) {
    @PostMapping("/string")
    public ResponseEntity<String> publish(
            @RequestBody String message
    ) {
        kafkaStringProducer.publish(message);
        return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> publish(
            @RequestBody TestSubject message
    ) {
        kafkaJsonProducer.publish(message);
        return ResponseEntity.ok("Message queued successfully");
    }
}
