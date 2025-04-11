package com.volkan.parserservice;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfigChecker {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @PostConstruct
    public void checkConfig() {
        System.out.println("✅ Kafka Bootstrap Address (Config): " + kafkaServer);
    }
}
