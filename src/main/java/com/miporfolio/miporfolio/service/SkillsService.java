package com.miporfolio.miporfolio.service;

import com.miporfolio.miporfolio.model.Skills;
import com.miporfolio.miporfolio.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService implements ISkillsService{
    
    @Autowired
    public SkillsRepository skillRepo;

    @Override
    public List<Skills> verSkills() {
         List <Skills> skills = skillRepo.findAll(); 
        return skills;
    }

    @Override
    public void agregarSkills(Skills skills) {
        skillRepo.save(skills);
    }

    @Override
    public void eliminarSkills(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skills buscarSkills(Long id) {
        Skills skills = skillRepo.findById(id).orElse(null);
        return(skills);
    }
    
}
