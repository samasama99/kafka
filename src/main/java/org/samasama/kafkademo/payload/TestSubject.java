package org.samasama.kafkademo.payload;

import java.time.LocalDateTime;

public record TestSubject(int id, String data, LocalDateTime stamp) {
}
