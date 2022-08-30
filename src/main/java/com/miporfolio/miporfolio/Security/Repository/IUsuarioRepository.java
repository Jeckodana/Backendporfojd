package com.miporfolio.miporfolio.Security.Repository;

import com.miporfolio.miporfolio.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository <Usuario, Integer>{
    Optional<Usuario> findByUsername(String Username);
    
    boolean existsByUsername(String username); 
    boolean existsByEmail(String email);
}
