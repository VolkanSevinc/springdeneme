package com.volkan.consumerservice.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FlightBinaryConsumer {

    @KafkaListener(topics = "flight-raw-bin", groupId = "flight-consumer-debug-2")
    public void consume(ConsumerRecord<String, byte[]> record) {
        byte[] rawData = record.value();

        System.out.println("🔥 MESAJ TESPİT EDİLDİ!");
        System.out.println("✅ Offset: " + record.offset());
        System.out.println("✅ Boyut: " + record.value().length + " byte");
    }
}
