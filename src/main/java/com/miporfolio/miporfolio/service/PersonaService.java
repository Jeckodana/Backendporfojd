package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Persona;
import com.miporfolio.miporfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//@Transaccional
public class PersonaService implements IPersonaService{
    
    @Autowired
    public PersonaRepository persoRepo;

    
    @Override
    public List<Persona> verPersona() {
        List <Persona> persona = persoRepo.findAll(); 
        return persona;
    }

    @Override
    public void agregarPersona(Persona persona) {
        persoRepo.save(persona); 
    }

    @Override
    public void eliminarPersona(Long id) {
        persoRepo.deleteById(id); 
    }

    @Override
    public Persona buscarPersona(Long id) {
        Persona persona = persoRepo.findById(id).orElse(null); 
        return persona;
    }
    
    
   
}

