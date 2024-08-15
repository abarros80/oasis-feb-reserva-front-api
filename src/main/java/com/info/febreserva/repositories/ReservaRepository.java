package com.info.febreserva.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.info.febreserva.models.ReservaModel;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "reservas", path = "reservas")
public interface ReservaRepository extends JpaRepository<ReservaModel, UUID> {
	
	 /*
	
	// delete operation isn't exposed via rest
    @Override
    @RestResource(exported = false)
    void deleteById(UUID id);
 
 // delete operation isn't exposed via rest
    @Override
    @RestResource(exported = false)
    void delete(ReservaModel reservaModel);
 

   
    // save operation isn't exposed via rest
    @Override
    @RestResource(exported=false)
    ReservaModel save(ReservaModel reservaModel);
    
    */
	
	// Assinatura para fazer find de Nome do Departamento
	
	Optional<ReservaModel> findByid(UUID id);
	
	Page<ReservaModel> findBynome(String nome, Pageable pageable);

}
