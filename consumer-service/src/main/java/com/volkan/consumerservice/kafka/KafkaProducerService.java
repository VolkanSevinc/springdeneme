package com.volkan.consumerservice.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private final String topic = "flight-raw-bin";

    public KafkaProducerService(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTestMessage() {
        String message = "Hello from producer";
        byte[] byteMessage = message.getBytes();

        ProducerRecord<String, byte[]> record = new ProducerRecord<>(topic, null, byteMessage);
        kafkaTemplate.send(record);
        System.out.println("✅ Producer mesajı gönderdi: " + message);
    }
}