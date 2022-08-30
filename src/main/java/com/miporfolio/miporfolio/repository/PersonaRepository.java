package com.miporfolio.miporfolio.repository;

import com.miporfolio.miporfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository  extends JpaRepository <Persona, Long>{
    
}
