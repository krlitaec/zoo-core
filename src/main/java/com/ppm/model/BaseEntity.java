package com.ppm.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Clase con campos comunes de Entidades
 *
 * @author Karla
 * @since 2021-02-21
 */

@MappedSuperclass
public abstract class BaseEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "sequenceGenerator")
    private Integer id;

    @NotNull
    @Column(name = "activo", nullable = false)
    private Boolean activo = Boolean.TRUE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
