package com.volkan.consumerservice;

import com.volkan.consumerservice.kafka.KafkaProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication(scanBasePackages = "com.volkan")
@EnableKafka
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(KafkaProducerService producerService) {
        return args -> {
            producerService.sendTestMessage();
        };
    }

}

