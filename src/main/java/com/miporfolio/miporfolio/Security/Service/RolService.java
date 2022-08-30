package com.miporfolio.miporfolio.Security.Service;

import com.miporfolio.miporfolio.Security.Entity.Rol;
import com.miporfolio.miporfolio.Security.Enum.RolName;
import com.miporfolio.miporfolio.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;
    public Optional<Rol> getByRolName(RolName rolName){
        return iRolRepository.findByRolName(rolName);
    }
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}
