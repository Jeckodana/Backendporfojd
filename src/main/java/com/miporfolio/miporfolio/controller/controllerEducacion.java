package com.miporfolio.miporfolio.controller;

import com.miporfolio.miporfolio.model.Educacion;
import com.miporfolio.miporfolio.service.IEducacionService;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@CrossOrigin(origins="http://localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
public class controllerEducacion {
    @Autowired
    private IEducacionService eduServ;
 
    
    @PostMapping("/educacion/new")
    public void agregarEducacion(@RequestBody Educacion educacion){
        eduServ.agregarEducacion(educacion);
    }
    
    @GetMapping("/educacion/ver")
    @ResponseBody
    public List<Educacion> verEducacion(){
        return eduServ.verEducacion();
    }
    
    @GetMapping("/educacion/buscar/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable("id") Long id){
        Educacion educacion = eduServ.buscarEducacion(id);
        return eduServ.buscarEducacion(id);
    }
    
   
    @ResponseBody
    @PutMapping("/educacion/actualizar/{id}")
    public Educacion actualizarEducacion(@PathVariable Long id,@RequestBody Educacion newEducacion)
         
    {   
        Educacion educacion = eduServ.buscarEducacion(id);
        educacion.setTitulo(newEducacion.getTitulo());
        educacion.setInstitucion(newEducacion.getInstitucion());
        educacion.setPeriodo(newEducacion.getPeriodo());
        educacion.setLogo_institucion(newEducacion.getLogo_institucion());
        eduServ.agregarEducacion(educacion);
        return educacion;
    }

   
    @DeleteMapping("/educacion/borrar/{id}")
    public void eliminarEducacion(@PathVariable Long id){
        eduServ.eliminarEducacion(id);
        } 
}
