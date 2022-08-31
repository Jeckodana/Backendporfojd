package com.miporfolio.miporfolio.controller;

import com.miporfolio.miporfolio.model.Proyecto;
import com.miporfolio.miporfolio.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin(origins="https://fporfoliojd.firebaseapp.com")
//@CrossOrigin(origins="http://localhost:4200")
public class controllerProyecto {
     @Autowired
    private IProyectoService proyeServ;
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyecto/new")
    public void agregarProyecto(@RequestBody Proyecto proyecto){
        proyeServ.agregarProyecto(proyecto);
    }
    
    @GetMapping("/proyecto/ver")
    @ResponseBody
    public List<Proyecto> verProyecto(){
        return proyeServ.verProyecto();
    }
    @GetMapping("/proyecto/buscar/{id}")
    @ResponseBody
    public Proyecto buscarProyecto(@PathVariable("id") Long id){
        Proyecto proyecto = proyeServ.buscarProyecto(id);
        return proyeServ.buscarProyecto(id);
    }
     
   // @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    @PutMapping("/proyecto/actualizar/{id}")
    public Proyecto actualizarProyecto(@PathVariable Long id,@RequestBody Proyecto newProyecto)                      
    {  
        Proyecto proyecto = proyeServ.buscarProyecto(id);
        proyecto.setNombre_proyecto(newProyecto.getNombre_proyecto());
        proyecto.setFecha_fin(newProyecto.getFecha_fin());
        proyecto.setDescripcion(newProyecto.getDescripcion());
        proyecto.setLink_evidencia(newProyecto.getLink_evidencia());
        proyecto.setFoto_proyecto(newProyecto.getFoto_proyecto());
        proyeServ.agregarProyecto(proyecto);
        return proyecto;
    }
   
   // @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyecto/borrar/{id}")
    public void eliminarProyecto(@PathVariable Long id){
        proyeServ.eliminarProyecto(id);
        } 
}
