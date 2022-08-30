package com.miporfolio.miporfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;
    private String Titulo;
    private String Institucion;
    private String Periodo;
    private String Logo_institucion;

    public Educacion() {
    }

    public Educacion(Long id, String Titulo, String Institucion, String Periodo, String Logo_institucion) {
        this.id = id;
        this.Titulo = Titulo;
        this.Institucion = Institucion;
        this.Periodo = Periodo;
        this.Logo_institucion = Logo_institucion;
    }
    
}

