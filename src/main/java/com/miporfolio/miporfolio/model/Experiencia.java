
package com.miporfolio.miporfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;
    private String Puesto;
    private String Empresa;
    private String Actividades;
    private String Fecha_inicio;
    private String Fecha_fin;
    private String Logo_empresa;

    public Experiencia() {
    }

    public Experiencia(Long id, String Puesto, String Empresa, String Actividades, String Fecha_inicio, String Fecha_fin, String Logo_empresa) {
        this.id = id;
        this.Puesto = Puesto;
        this.Empresa = Empresa;
        this.Actividades = Actividades;
        this.Fecha_inicio = Fecha_inicio;
        this.Fecha_fin = Fecha_fin;
        this.Logo_empresa = Logo_empresa;
    }

}

