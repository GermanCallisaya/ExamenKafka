package com.ger.principal;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EarthquakeApplication implements CommandLineRunner {

    private final EarthquakeProducer earthquakeProducer;

    public EarthquakeApplication(EarthquakeProducer earthquakeProducer) {
        this.earthquakeProducer = earthquakeProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(EarthquakeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        earthquakeProducer.fetchAndSendEarthquakeData();
    }


    @Scheduled(fixedRate = 60000)    public void scheduleEarthquakeDataFetch() {
        earthquakeProducer.fetchAndSendEarthquakeData();
    }
}
