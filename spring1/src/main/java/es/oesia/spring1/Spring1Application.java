package es.oesia.spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.oesia.spring1.services.PersonaService;
// proyecto de seguridad
@SpringBootApplication
public class Spring1Application {
	@Autowired
	PersonaService personaService;

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
		
	}

}
