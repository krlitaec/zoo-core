package com.ppm.controller.catalogos;

import com.ppm.model.catalogos.TipoAnimal;
import com.ppm.repository.catalogos.TipoAnimalRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para métodos de la Entidad TipoAnimal
 *
 * @author Karla
 * @since 2021-02-21
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tipoAnimal")
@Api(tags = "Gestión de Tipos de Animal", value = "Gestión de Tipos de Animal", description = "Controlador para Gestión de Tipos de Animal")
public class TipoAnimalController {
    @Autowired
    TipoAnimalRepository tipoAnimalRepository;

    /**
     * {@code GET  /tiposAnimal} : get all the tiposAnimal.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tiposAnimal in body.
     */
    @GetMapping("/lista")
    @ApiOperation(value = "Obtener listado completo de Tipos de Animal")
    public ResponseEntity<List<TipoAnimal>> obtenerTipo(Pageable pageable) {
        Page<TipoAnimal> page = tipoAnimalRepository.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

}
