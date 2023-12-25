package org.samasama.kafkademo.controller;

import org.samasama.kafkademo.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public record MessageController(KafkaProducer kafkaProducer) {
    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestBody String message
    ) {
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }
}
