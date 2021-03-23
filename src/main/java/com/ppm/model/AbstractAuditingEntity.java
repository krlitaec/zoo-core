package com.ppm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Base abstract class for entities which will hold definitions for created, last modified, created by,
 * last modified by attributes.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @CreatedBy
    @Column(name = "creacion_usuario", nullable = false, length = 50, updatable = false)
    @JsonIgnore
    private Integer creacionUsuario;

    @Column(name = "creacion_info", nullable = false, length = 500, updatable = false)
    @JsonIgnore
    private String creacionInfo = "Entity created";

    @CreatedDate
    @Column(name = "creacion_fecha", updatable = false)
    @JsonIgnore
    private Instant creacionFecha = Instant.now();

    @LastModifiedBy
    @Column(name = "modifica_usuario", length = 50)
    @JsonIgnore
    private Integer modificaUsuario;// = "admin";

    @Column(name = "modifica_info", length = 500)
    @JsonIgnore
    private String modificaInfo;

    @LastModifiedDate
    @Column(name = "modifica_fecha")
    @JsonIgnore
    private Instant modificaFecha = Instant.now();

//    public String getCreacionUsuario() {
//        return creacionUsuario;
//    }
//
//    public void setCreacionUsuario(String creacionUsuario) {
//        this.creacionUsuario = creacionUsuario;
//    }

    public String getCreacionInfo() {
        return creacionInfo;
    }

    public void setCreacionInfo(String creacionInfo) {
        this.creacionInfo = creacionInfo;
    }

    public Instant getCreacionFecha() {
        return creacionFecha;
    }

    public void setCreacionFecha(Instant creacionFecha) {
        this.creacionFecha = creacionFecha;
    }

//    public String getModificaUsuario() {
//        return modificaUsuario;
//    }
//
//    public void setModificaUsuario(String modificaUsuario) {
//        this.modificaUsuario = modificaUsuario;
//    }

    public String getModificaInfo() {
        return modificaInfo;
    }

    public void setModificaInfo(String modificaInfo) {
        this.modificaInfo = modificaInfo;
    }

    public Instant getModificaFecha() {
        return modificaFecha;
    }

    public void setModificaFecha(Instant modificaFecha) {
        this.modificaFecha = modificaFecha;
    }

    public Integer getCreacionUsuario() {
        return creacionUsuario;
    }

    public void setCreacionUsuario(Integer creacionUsuario) {
        this.creacionUsuario = creacionUsuario;
    }

    public Integer getModificaUsuario() {
        return modificaUsuario;
    }

    public void setModificaUsuario(Integer modificaUsuario) {
        this.modificaUsuario = modificaUsuario;
    }
}