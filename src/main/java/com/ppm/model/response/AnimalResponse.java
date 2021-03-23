package com.ppm.model.response;

import com.ppm.model.catalogos.Animal;
import java.math.BigDecimal;

/**
 * Response para la Entidad Animal
 *
 * @author Karla
 * @since 2021-02-21
 */

public class AnimalResponse {
    private Integer idAnimal;
    private String nombre;
    private String especie;
    private Integer edad;
    private Boolean esCarnivoro = Boolean.FALSE;
    private Boolean esHervivoro = Boolean.FALSE;
    private Boolean tieneCrias = Boolean.FALSE;
    private BigDecimal peso;
    private byte[] foto;
    private Integer idTipoAnimal;
    private String tipoAnimal;
    private Integer idGrupo;
    private String grupo;

    public AnimalResponse() {
    }

    public AnimalResponse(Animal animal) {
        this.idAnimal = animal.getId();
        this.nombre = animal.getNombre();
        this.especie = animal.getEspecie();
        this.edad = animal.getEdad();
        this.esCarnivoro = animal.getEsCarnivoro();
        this.esHervivoro = animal.getEsHervivoro();
        this.tieneCrias = animal.getTieneCrias();
        this.peso = animal.getPeso();
        this.foto = animal.getFoto();
        if (animal.getTipoAnimal() != null) {
            this.idTipoAnimal = animal.getTipoAnimal().getId();
            this.tipoAnimal = animal.getTipoAnimal().getNombre();
            if (animal.getTipoAnimal().getGrupo() != null) {
                this.idGrupo = animal.getTipoAnimal().getId();
                this.grupo = animal.getTipoAnimal().getNombre();
            }
        }
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
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

    public Integer getIdTipoAnimal() {
        return idTipoAnimal;
    }

    public void setIdTipoAnimal(Integer idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
