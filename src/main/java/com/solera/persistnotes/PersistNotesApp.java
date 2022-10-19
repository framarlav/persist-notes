package com.solera.persistnotes;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.solera.persistnotes.Note;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) 
public class PersistNotesApp {

	private static final Logger log = LoggerFactory.getLogger(PersistNotesApp.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(PersistNotesApp.class, args);
		
	}
	
	@Bean
	public CommandLineRunner demo(NoteRepository repository) {
		return (args)->{
			repository.save(new Note("Descripcion de la nota1","Texto de la nota1","marca.com","@fran1", 10, new Date()));
			repository.save(new Note("Descripcion de la nota2","Texto de la nota2","marca.com","@fran2", 8, new Date()));
			repository.save(new Note("Descripcion de la nota3","Texto de la nota3","marca.com","@fran3",4, new Date()));
			repository.save(new Note("Descripcion de la nota4","Texto de la nota4","marca.com","@fran4",3, new Date()));
			
			log.info("Notes List");
			for (Note note : repository.findAll()) {
				log.info(note.toString());
			}
		};
	}

}
