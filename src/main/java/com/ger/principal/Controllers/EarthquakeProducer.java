package com.ger.principal.Controllers;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EarthquakeProducer {

    private static final String TOPIC = "earthquakes";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final RestTemplate restTemplate;

    public EarthquakeProducer(KafkaTemplate<String, String> kafkaTemplate, RestTemplate restTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.restTemplate = restTemplate;
    }

    public void fetchAndSendEarthquakeData() {
        // API URL
        String apiUrl = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";

        
        EarthquakeResponse earthquakeResponse = restTemplate.getForObject(apiUrl, EarthquakeResponse.class);

        
        for (EarthquakeResponse.Feature feature : earthquakeResponse.getFeatures()) {
            String message = feature.getProperties().toString(); 
            kafkaTemplate.send(new ProducerRecord<>(TOPIC, feature.getId(), message));
        }
    }
}
