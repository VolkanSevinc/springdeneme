package com.volkan.parserservice.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FlightBinaryProducer {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private final String topic = "flight-raw-bin";

    @Autowired
    public FlightBinaryProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendBinary(byte[] data) {
        kafkaTemplate.send(new ProducerRecord<>(topic, null, data));
        System.out.println("Kafka'ya binary veri gönderildi: " + data.length + " byte");
    }
}