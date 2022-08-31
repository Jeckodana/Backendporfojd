package com.miporfolio.miporfolio.Security.Controller;

import com.miporfolio.miporfolio.Security.Dto.JwtDto;
import com.miporfolio.miporfolio.Security.Dto.LoginUser;
import com.miporfolio.miporfolio.Security.Dto.NewUser;
import com.miporfolio.miporfolio.Security.Entity.Rol;
import com.miporfolio.miporfolio.Security.Entity.Usuario;
import com.miporfolio.miporfolio.Security.Enum.RolName;
import com.miporfolio.miporfolio.Security.Jwt.JwtProvider;
import com.miporfolio.miporfolio.Security.Service.RolService;
import com.miporfolio.miporfolio.Security.Service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="https://fporfoliojd.firebaseapp.com")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired 
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/new")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser,
            BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"),
                    HttpStatus.BAD_REQUEST);
        
        if(userService.existsByUsername(newUser.getUsername()))
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"),
                    HttpStatus.BAD_REQUEST);
        
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(newUser.getName(), newUser.getUsername(),
            newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        userService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser,
            BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), 
                    HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate
        (new UsernamePasswordAuthenticationToken(
        loginUser.getUsername(), loginUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails
                .getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }  
    
    
}
