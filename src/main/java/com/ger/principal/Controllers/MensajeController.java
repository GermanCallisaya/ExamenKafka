package com.ger.principal.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ger.principal.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")// localhost:9092/api/kafka
public class MensajeController {
	private KafkaProducer kafkaProd;

	public MensajeController(KafkaProducer kafkaProd) {
		super();
		this.kafkaProd = kafkaProd;
	}
	@GetMapping("/publicar")// localhost:9092/api/kafka/publicar
	public ResponseEntity<String> publicar(@RequestParam("Mensaje")String msj){
		kafkaProd.enviarMensaje(msj);
		return ResponseEntity.ok("Mensaje enviado al topico");
	}
	
	

}
