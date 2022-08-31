package com.miporfolio.miporfolio.controller;

import com.miporfolio.miporfolio.model.Persona;
import com.miporfolio.miporfolio.service.IPersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping
@CrossOrigin(origins="http://localhost:4200")
public class controller {
    
    @Autowired
    private IPersonaService persoServ;
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/new")
    public void agregarPersona(@RequestBody Persona persona){
        persoServ.agregarPersona(persona);
    }
    
    @GetMapping("/persona/ver")
    @ResponseBody
    public List<Persona> verPersona(){
        return persoServ.verPersona();
    }
    @GetMapping("/persona/buscar/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable("id") Long id){
        Persona persona = persoServ.buscarPersona(id);
        return persoServ.buscarPersona(id);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    @PutMapping("/persona/actualizar/{id}")
    public Persona actualizarPersona(@PathVariable Long id,@RequestBody Persona newPersona)                                                  
    {  
        
        Persona persona = persoServ.buscarPersona(id);
        persona.setNombre(newPersona.getNombre());
        persona.setApellido(newPersona.getApellido());
        persona.setInfo_profesional(newPersona.getInfo_profesional());
        persona.setFoto_perfil(newPersona.getFoto_perfil());
        persoServ.agregarPersona(persona);
        return persona;
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/borrar/{id}")
    public void eliminarPersona(@PathVariable Long id){
        persoServ.eliminarPersona(id);
        } 
    
}

