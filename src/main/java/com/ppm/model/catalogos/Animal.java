package com.ppm.model.catalogos;

import com.ppm.model.BaseEntity;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Entidad - tabla animal
 *
 * @author Karla
 * @since 2021-02-21
 */

@Entity
@Table(name = "animal")
public class Animal extends BaseEntity {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "especie")
    private String especie;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "es_carnivoro", nullable = false)
    private Boolean esCarnivoro = Boolean.FALSE;
    @Column(name = "es_hervivoro", nullable = false)
    private Boolean esHervivoro = Boolean.FALSE;
    @Column(name = "tiene_crias", nullable = false)
    private Boolean tieneCrias = Boolean.FALSE;
    @Column(name = "peso")
    private BigDecimal peso;
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_animal", nullable = false, updatable = false)
    private TipoAnimal tipoAnimal;

    public Animal() {
    }

    public Animal(String nombre, TipoAnimal tipoAnimal) {
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getEsCarnivoro() {
        return esCarnivoro;
    }

    public void setEsCarnivoro(Boolean esCarnivoro) {
        this.esCarnivoro = esCarnivoro;
    }

    public Boolean getEsHervivoro() {
        return esHervivoro;
    }

    public void setEsHervivoro(Boolean esHervivoro) {
        this.esHervivoro = esHervivoro;
    }

    public Boolean getTieneCrias() {
        return tieneCrias;
    }

    public void setTieneCrias(Boolean tieneCrias) {
        this.tieneCrias = tieneCrias;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
}
