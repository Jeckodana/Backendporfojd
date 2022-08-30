package com.miporfolio.miporfolio.Security.Dto;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter @Setter
public class JwtDto {
    private String Token;
    private String Username;
    private String bearer ="Bearer";
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto() {
    }

    public JwtDto(String Token, String Username, Collection<? extends GrantedAuthority> authorities) {
        this.Token = Token;
        this.Username = Username;
        this.authorities = authorities;
    }
     
}
