package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    public List<Proyecto> verProyecto();//Metodo para ver un objeto Proyecto
    public void agregarProyecto(Proyecto proyecto);//Metodo para Guardar un objeto Proyecto
    public void eliminarProyecto(Long id);//Metodo para borrar un objeto Proyecto
    public Proyecto buscarProyecto(Long id);//Metodo para buscar objeto Proyectoa por Id
}
