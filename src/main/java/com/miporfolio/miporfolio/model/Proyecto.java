package com.miporfolio.miporfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;
    private String nombre_proyecto;
    private String fecha_fin;
    private String descripcion;
    private String link_evidencia;
    private String foto_proyecto;

    public Proyecto() {
    }

    public Proyecto(String nombre_proyecto, String fecha_fin, String descripcion, String link_evidencia, String foto_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
        this.link_evidencia =link_evidencia;
        this.foto_proyecto = foto_proyecto;
    }
    
    
}
