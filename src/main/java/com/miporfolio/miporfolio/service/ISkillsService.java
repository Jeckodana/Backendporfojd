package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Skills;
import java.util.List;


public interface ISkillsService {
    public List<Skills> verSkills();//Metodo para ver un objeto Skills
    public void agregarSkills(Skills skills);//Metodo para Guardar un objeto Skillsa
    public void eliminarSkills(Long id);//Metodo para borrar un objeto Skills
    public Skills buscarSkills(Long id);//Metodo para buscar objeto Skills por Id
}
