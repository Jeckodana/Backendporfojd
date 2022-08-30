package com.miporfolio.miporfolio.repository;

import com.miporfolio.miporfolio.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Long>{
  public Optional<Experiencia> findById(int id);
    
}
