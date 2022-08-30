package com.miporfolio.miporfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
//@Table(name= "persona")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;
    private String Nombre;
    private String Apellido;
    private String Info_profesional;
    private String Foto_perfil;
 
  //  @OneToMany(mappedBy="persona", cascade = CascadeType.ALL)
   //List<Educacion> educacion;
      
    public Persona(){
    }
    
    public Persona(Long id, String Nombre, String Apellido, String Info_profesional, String Foto_perfil){
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Info_profesional = Info_profesional;
        this.Foto_perfil = Foto_perfil;
              
    }
}
  