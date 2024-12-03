package com.ger.principal.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer.class);
	private KafkaTemplate<String,String> kafkaTemplate;
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void enviarMensaje(String mensaje) {
		LOGGER.info(String.format("Mensaje enviado: %s.", mensaje));
		kafkaTemplate.send("Prueba", mensaje);
	}

}
