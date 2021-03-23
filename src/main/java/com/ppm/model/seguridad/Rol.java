package com.ppm.model.seguridad;

import com.ppm.model.BaseEntity;

import javax.persistence.*;

/**
 * Entidad - tabla rol
 *
 * @author Karla
 * @since 2021-02-21
 */

@Entity
@Table(name = "rol")
public class Rol extends BaseEntity {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
