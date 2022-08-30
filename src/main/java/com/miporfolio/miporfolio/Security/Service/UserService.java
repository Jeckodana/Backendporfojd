package com.miporfolio.miporfolio.Security.Service;

import com.miporfolio.miporfolio.Security.Entity.Usuario;
import com.miporfolio.miporfolio.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class UserService {
    @Autowired
    IUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getByUsername(String username){
        return iUsuarioRepository.findByUsername(username);
    }
    
    public boolean existsByUsername(String username){
        return iUsuarioRepository.existsByUsername(username);
    }
    
    public boolean existsByEmail(String email){
        return iUsuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
}
