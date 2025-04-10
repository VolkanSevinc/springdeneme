package com.volkan.parserservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FlightDataProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "flight-raw-data";

    @Autowired
    public FlightDataProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Kafka'ya veri gönderildi: " + message);
    }
}