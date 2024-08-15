package com.info.febreserva;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;




import com.info.febreserva.models.ReservaModel;
import com.info.febreserva.repositories.ReservaRepository;

@SpringBootApplication
public class FebReservaApplication  implements RepositoryRestConfigurer{
	
	private static final Logger log = LoggerFactory.getLogger(FebReservaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FebReservaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ReservaRepository repository) {
		return (args) -> {
			
			// save a few reserva  (String nome, int quarto, int paxadulto, int paxcrianca, String hora, String hoster, String observacao, String horaentrada, 
			//LocalDateTime datareserva)
		      repository.save(new ReservaModel("Tabanka", 101, "Jack",  1, 0, "19:30", "Helena", "", "19:30", LocalDate.now()));
		      repository.save(new ReservaModel("Tabanka", 102, "Jose",  2, 1, "19:30", "Helena", "", "19:30", LocalDate.now()));
		      repository.save(new ReservaModel("Tabanka", 104, "Paulo",  2, 0, "19:30", "Helena", "", "20:30", LocalDate.now()));
		      repository.save(new ReservaModel("Tabanka", 209, "Anita",  4, 0, "19:30", "Helena", "", "19:30", LocalDate.now()));
		      repository.save(new ReservaModel("Tradicao", 104, "Afonso",  2, 1, "19:30", "Helena", "", "20:30", LocalDate.now()));
		      repository.save(new ReservaModel("Tradicao", 304, "Renato",  2, 0, "19:30", "Helena", "", "19:30", LocalDate.now()));
		      repository.save(new ReservaModel("Tradicao", 504, "Carla",  2, 0, "19:30", "Helena", "", "19:30", LocalDate.now()));
		      repository.save(new ReservaModel("Tradicao", 602, "Fernanda",  2, 2, "19:30", "Helena", "", "20:30", LocalDate.now()));
		      repository.save(new ReservaModel("Tradicao", 904, "Maria",  2, 0, "19:30", "Helena", "", "20:30", LocalDate.now()));
		      repository.save(new ReservaModel("Tradicao", 1004, "Daluz",  2, 0, "19:30", "Helena", "", "20:30", LocalDate.now()));
		      
		   // fetch all reserva
		      log.info("ReservaModel found with findAll():");
		      log.info("-------------------------------");
		      repository.findAll().forEach(reserva -> {
		        log.info(reserva.toString());
		      });
		      log.info("");

	    	
	    };
	  }
	
	
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration restconfig, CorsRegistry cors) {

		//Expoem ID
		restconfig.exposeIdsFor(ReservaModel.class);

		
		/*
		ExposureConfiguration config = restconfig.getExposureConfiguration();
        config.forDomainType(Item.class).withItemExposure((metadata, httpMethods) ->
          httpMethods.disable(HttpMethod.POST));
          */
		
		
 
	}

}
