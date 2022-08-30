package com.miporfolio.miporfolio.Security.Entity;

import com.miporfolio.miporfolio.Security.Enum.RolName;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Rol {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @NotNull
   @Enumerated(EnumType.STRING)
   private RolName rolName;

     public Rol() {
    }
    public Rol( RolName rolName) {
        this.rolName = rolName;
    }

  
}
