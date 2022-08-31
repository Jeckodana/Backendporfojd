package com.miporfolio.miporfolio.controller;

import com.miporfolio.miporfolio.model.Skills;
import com.miporfolio.miporfolio.service.ISkillsService;
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
public class controlerSkills {
    @Autowired
    private ISkillsService skillServ;
    
   // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skill/new")
    public void agregarSkills(@RequestBody Skills skills){
        skillServ.agregarSkills(skills);
    }
    
    @GetMapping("/skill/ver")
    @ResponseBody
    public List<Skills> verSkills(){
        return skillServ.verSkills();
    }
    
    @GetMapping("/skill/buscar/{id}")
    @ResponseBody
    public Skills buscarSkills(@PathVariable("id") Long id){
        Skills skills = skillServ.buscarSkills(id);
        return skillServ.buscarSkills(id);
    }
     
    //@PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    @PutMapping("/skill/actualizar/{id}")
    public Skills actualizarPersona(@PathVariable Long id,@RequestBody Skills newSkills)                    
    {  
        Skills skills = skillServ.buscarSkills(id);
        skills.setHabilidad(newSkills.getHabilidad());
        skills.setNivel(newSkills.getNivel());
        skills.setDetalle(newSkills.getDetalle());
        skillServ.agregarSkills(skills);
        return skills;
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skill/borrar/{id}")
    public void eliminarSkills(@PathVariable Long id){
        skillServ.eliminarSkills(id);
        } 
}
