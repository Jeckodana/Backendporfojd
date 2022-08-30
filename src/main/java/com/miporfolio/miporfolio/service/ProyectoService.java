package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Proyecto;
import com.miporfolio.miporfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public ProyectoRepository proyeRepo;
    
    @Override
    public List<Proyecto> verProyecto() {
        List <Proyecto> proyecto = proyeRepo.findAll(); 
        return proyecto;
    }

    @Override
    public void agregarProyecto(Proyecto proyecto) {
        proyeRepo.save(proyecto);
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyeRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        Proyecto proyecto = proyeRepo.findById(id).orElse(null);
        return(proyecto);
    }
    
}
