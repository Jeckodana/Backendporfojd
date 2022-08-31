package com.miporfolio.miporfolio.controller;

import com.miporfolio.miporfolio.model.Experiencia;
import com.miporfolio.miporfolio.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping
//@CrossOrigin(origins = "https://fporfoliojd.web.app/porfolio", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
public class controllerExperiencia {
    @Autowired
    private IExperienciaService expeServ;
     
   // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia/new")
    public void agregarExperiencia(@RequestBody Experiencia experiencia){
        expeServ.agregarExperiencia(experiencia);
    }
    
    @GetMapping("/experiencia/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia(){
        return expeServ.verExperiencia();
    }
    
    @GetMapping("/experiencia/buscar/{id}")
    @ResponseBody
    public Experiencia buscarExperiencia(@PathVariable("id") Long id){
        Experiencia experiencia = expeServ.buscarExperiencia(id);
        return expeServ.buscarExperiencia(id); 
    }
    
  //  @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    @PutMapping("/experiencia/actualizar/{id}")
    public Experiencia actualizarExperiencia(@PathVariable Long id,@RequestBody Experiencia newExperiencia)
    {  
        
        Experiencia experiencia = expeServ.buscarExperiencia(id);
        experiencia.setPuesto(newExperiencia.getPuesto());
        experiencia.setEmpresa(newExperiencia.getEmpresa());
        experiencia.setActividades(newExperiencia.getActividades());
        experiencia.setFecha_inicio(newExperiencia.getFecha_inicio());
        experiencia.setFecha_fin(newExperiencia.getFecha_fin());
        experiencia.setLogo_empresa(newExperiencia.getLogo_empresa());
        expeServ.agregarExperiencia(experiencia);
        return experiencia;
    }
    
    
    @DeleteMapping("/experiencia/borrar/{id}")
    public void eliminarExperiencia(@PathVariable Long id){
        expeServ.eliminarExperiencia(id);
        } 
}
