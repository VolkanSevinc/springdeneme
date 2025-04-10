package com.volkan.parserservice;

import com.volkan.parserservice.kafka.FlightBinaryProducer;
import com.volkan.parserservice.util.FlightBinGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;

@Component
public class StartupRunner implements CommandLineRunner {

    private final FlightBinaryProducer producer;

    @Autowired
    public StartupRunner(FlightBinaryProducer producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. .bin dosyasını oluştur
        Path binPath = Path.of("sample-flight.bin");
        FlightBinGenerator.generateBinFile(binPath.toString(), 100);

        // 2. Dosyayı 24 byte bloklara ayırarak Kafka'ya gönder
        File file = binPath.toFile();
        try (FileInputStream in = new FileInputStream(file)) {

            byte[] buffer = new byte[24];
            int bytesRead;
            
            while ((bytesRead = in.read(buffer)) != -1) {

                if (bytesRead == 24) {

                    producer.sendBinary(buffer.clone());
                }
            }
        }
    }
}