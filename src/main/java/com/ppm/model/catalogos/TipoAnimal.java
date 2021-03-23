package com.ppm.model.catalogos;

import com.ppm.model.BaseEntity;

import javax.persistence.*;

/**
 * Entidad - tabla tipo_animal
 *
 * @author Karla
 * @since 2021-02-21
 */

@Entity
@Table(name = "tipo_animal")
public class TipoAnimal extends BaseEntity {
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grupo", nullable = false, updatable = false)
    private Grupo grupo;

    public TipoAnimal() {
    }

    public TipoAnimal(Integer id) {
        setId(id);
    }

    public TipoAnimal(String nombre, Grupo grupo) {
        this.nombre = nombre;
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
