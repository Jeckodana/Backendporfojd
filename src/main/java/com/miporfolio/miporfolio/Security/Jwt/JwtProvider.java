package com.miporfolio.miporfolio.Security.Jwt;

import com.miporfolio.miporfolio.Security.Entity.UsuarioPpal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;

    private int expiration;
    
    //Método para Generar Token
    public String generateToken(Authentication authentication){
        UsuarioPpal usuarioPpal =(UsuarioPpal)authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPpal.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
   
    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody()
                .getSubject();
    }
    //Método para Validar el Token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch(MalformedJwtException e){
            logger.error("Error en la formacion del Token");
        } catch(UnsupportedJwtException e){
            logger.error("Token no soportado");
        } catch(ExpiredJwtException e){
            logger.error("El Token ha expirado");
        } catch(IllegalArgumentException e){
            logger.error("El Token está vacio");
        } catch(SignatureException e){
            logger.error("La firma es invalida");
        }
        return false;
    }
}
