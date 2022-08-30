package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    public List<Experiencia> verExperiencia();//Metodo para ver un objeto Experiencia
    public void agregarExperiencia(Experiencia Experiencia);//Metodo para Guardar un objeto Experiencia
    public void eliminarExperiencia(Long id);//Metodo para borrar un objeto Experiencia
    public Experiencia buscarExperiencia(Long id);//Metodo para buscar objeto Experiencia por Id
    
}  