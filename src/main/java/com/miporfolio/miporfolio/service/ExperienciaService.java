package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Experiencia;
import com.miporfolio.miporfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    @Autowired
    public ExperienciaRepository expeRepo;

    @Override
    public List<Experiencia> verExperiencia() {
        List <Experiencia> experiencia = expeRepo.findAll(); 
        return experiencia; 
    }

    @Override
    public void agregarExperiencia(Experiencia experiencia) {
        expeRepo.save(experiencia);
    }

    @Override
    public void eliminarExperiencia(Long id) {
       expeRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
       Experiencia experiencia = expeRepo.findById(id).orElse(null); 
        return experiencia;
    }
   
}
