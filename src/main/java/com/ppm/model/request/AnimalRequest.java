package com.ppm.model.request;

import com.ppm.model.catalogos.TipoAnimal;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotBlank;

public class AnimalRequest {
    @NotBlank
    private String nombre;

    private String especie;

    private TipoAnimal tipoAnimal;

    private Pageable pageable;

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

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }
}
