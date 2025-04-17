package com.volkan.consumerservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FlightTestConsumer {

    @KafkaListener(topics = "flight-raw-bin", groupId = "flight-consumer-debug-NEW")
    public void listenTest(byte[] message) {
        System.out.println("✅ [TEST] Kafka'dan gelen mesaj (raw): " + Arrays.toString(message));
    }
}