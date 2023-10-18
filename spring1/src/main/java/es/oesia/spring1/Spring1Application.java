package es.oesia.spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.oesia.spring1.services.PersonaService;

@SpringBootApplication
public class Spring1Application implements CommandLineRunner{

	@Autowired
	PersonaService personaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
	}

	@Override
	public void run(String... args)  {
	
	
		System.out.println(personaService.buscarUno(1));
		
		
	}

}
