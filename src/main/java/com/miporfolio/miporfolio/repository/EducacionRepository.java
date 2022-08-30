package com.miporfolio.miporfolio.repository;

import com.miporfolio.miporfolio.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducacionRepository extends JpaRepository <Educacion, Long>{

    public Optional<Educacion> findById(int id);
    
    
}
