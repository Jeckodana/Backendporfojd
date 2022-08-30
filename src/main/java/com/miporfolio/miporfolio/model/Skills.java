package com.miporfolio.miporfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)  
   private Long id; 
   private String Habilidad;
   private String Detalle;
   private int Nivel;

    public Skills() {
    }

    public Skills(String Habilidad, String Detalle, int Nivel) {
        this.Habilidad = Habilidad;
        this.Detalle = Detalle;
        this.Nivel = Nivel;
    }
   
   
}
