package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Persona;
import java.util.List;



public interface IPersonaService {
    public List<Persona> verPersona();//Metodo para ver un objeto Persona
    public void agregarPersona(Persona persona);//Metodo para Guardar un objeto Persona
    public void eliminarPersona(Long id);//Metodo para borrar un objeto Persona
    public Persona buscarPersona(Long id);//Metodo para buscar objeto Persona por Id

}
