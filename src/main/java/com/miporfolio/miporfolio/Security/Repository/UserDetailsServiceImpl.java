package com.miporfolio.miporfolio.Security.Repository;

import com.miporfolio.miporfolio.Security.Entity.Usuario;
import com.miporfolio.miporfolio.Security.Entity.UsuarioPpal;
import com.miporfolio.miporfolio.Security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class  UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userService.getByUsername(username).get();
        return UsuarioPpal.build(usuario);
    }
    
}
