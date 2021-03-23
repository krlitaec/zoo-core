package com.ppm.model.catalogos;

import com.ppm.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidad - tabla grupo
 *
 * @author Karla
 * @since 2021-02-21
 */

@Entity
@Table(name = "grupo")
public class Grupo extends BaseEntity {
    @Column(name = "nombre")
    private String nombre;

    public Grupo() {
    }

    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
