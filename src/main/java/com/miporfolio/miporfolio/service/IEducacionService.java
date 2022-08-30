package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Educacion;
import java.util.List;


public interface IEducacionService {
    public List<Educacion> verEducacion();//Metodo para ver lista de objetos Educacion
    public void agregarEducacion(Educacion educacion);//Metodo para Guardar un objeto Educacion
    public void eliminarEducacion(Long id);//Metodo para borrar un objeto Educacion
    public Educacion buscarEducacion(Long id);//Metodo para buscar objeto Educacion por Id

}
