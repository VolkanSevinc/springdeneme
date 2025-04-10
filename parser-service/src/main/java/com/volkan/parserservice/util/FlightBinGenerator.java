package com.volkan.parserservice.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

public class FlightBinGenerator {

    public static void generateBinFile(String path, int messageCount) throws IOException {

        try (FileOutputStream out = new FileOutputStream(path)) {

            long startTime = System.currentTimeMillis();
            Random random = new Random();

            for (int i = 0; i < messageCount; i++) {

                ByteBuffer buffer = ByteBuffer.allocate(24);

                long timestamp = startTime + i * 1000L; // 1 saniyelik artış
                int flightId = 1000 + random.nextInt(50); // 1000–1050 arasında uçuş
                float lat = 39.9f + random.nextFloat() * 0.1f;
                float lon = 32.8f + random.nextFloat() * 0.1f;
                float alt = 10000 + random.nextFloat() * 5000;

                buffer.putLong(timestamp);
                buffer.putInt(flightId);
                buffer.putFloat(lat);
                buffer.putFloat(lon);
                buffer.putFloat(alt);

                out.write(buffer.array());
            }
        }
        
        System.out.println("✅ .bin dosyası üretildi: " + messageCount + " mesaj, yol: " + path);
    }
}