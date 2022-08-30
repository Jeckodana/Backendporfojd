package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Educacion;
import com.miporfolio.miporfolio.repository.EducacionRepository;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {
    @Autowired
    public EducacionRepository eduRepo;

    @Override
    public List<Educacion> verEducacion() {
        List <Educacion> educacion = eduRepo.findAll(); 
        return educacion;
    }

    @Override
    public void agregarEducacion(Educacion educacion) {
         eduRepo.save(educacion); 
    }

    @Override
    public void eliminarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
       Educacion educacion = eduRepo.findById(id).orElse(null); 
        return educacion;
    }

    
}
