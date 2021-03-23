package com.ppm.controller.catalogos;

import com.ppm.model.catalogos.Animal;
import com.ppm.model.request.AnimalRequest;
import com.ppm.model.response.AnimalResponse;
import com.ppm.model.response.Response;
import com.ppm.repository.catalogos.AnimalRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Controlador para métodos de la Entidad Animal
 *
 * @author Karla
 * @since 2022-02-21
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/animales")
@Api(tags = "Gestión de Animales", value = "Gestión de Animales", description = "Controlador para Gestión de Animales")
public class AnimalController {
    private static final String ENTITY_NAME = "animal";

    @Autowired
    AnimalRepository animalRepository;

    /**
     * {@code POST  /crear} : Crear un nuevo animal.
     *
     * @param animal el animal a crear.
     * @return the {@link ResponseEntity} with status {@code 201 (Creado)} and with body the new animal, or with status {@code 400 (Bad Request)} if the animal has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/crear")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Crear un nuevo Animal")
    public ResponseEntity<AnimalResponse> crearAnimal(@RequestBody Animal animal) throws URISyntaxException {
        if (animal.getId() != null) {
            Response result = new Response("[AnimalController] - Un nuevo animal no puede tener un ID"
                    , 400, "Error");
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
        Animal result = animalRepository.save(animal);
        AnimalResponse animalResponse = new AnimalResponse(animal);
        return ResponseEntity.created(new URI("/api/animales/crear/" + result.getId())).body(animalResponse);
    }

    /**
     * {@code PUT  /actualizar} : Updates an existing animal.
     *
     * @param animal the animal to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated animal,
     * or with status {@code 400 (Bad Request)} if the animal is not valid,
     * or with status {@code 500 (Internal Server Error)} if the animal couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Actualizar un Animal")
    public ResponseEntity<AnimalResponse> updateAnimal(@RequestBody Animal animal) throws URISyntaxException {
        if (animal.getId() == null) {
            Response result = new Response("[AnimalController] - ID incorrecto"
                    , 400, "Error");
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
        animal.setModificaInfo("Animal actualizado");
        Animal result = animalRepository.save(animal);
        AnimalResponse animalResponse = new AnimalResponse(animal);
        return ResponseEntity.ok().body(animalResponse);
    }

    /**
     * {@code GET  /lista} : get all the animales.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of animales in body.
     */
    @GetMapping("/lista")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Obtener listado completo de Animales")
    public ResponseEntity<List<Animal>> obtenerAnimales(Pageable pageable) {
        Page<Animal> page = animalRepository.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /filtros} : get all the animales.
     *
     * @param request the pagination and filter information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of animales in body.
     */
    @GetMapping("/filtros")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Obtener listado de Animales dados filtros")
    public ResponseEntity<List<Animal>> obtenerAnimalesFiltros(@RequestBody AnimalRequest request) {
        Page<Animal> page = null;
        if (request.getNombre() == null && request.getTipoAnimal() == null) {
            page = animalRepository.findAll(request.getPageable());
        } else {
            if (request.getTipoAnimal() == null) {
                page = animalRepository.findByNombre(request.getNombre(), request.getPageable());
            } else {
                if (request.getNombre() == null) {
                    page = animalRepository.findByTipoAnimal(request.getTipoAnimal(), request.getPageable());
                } else {
                    page = animalRepository.findByNombreAndTipoAnimal(request.getNombre(), request.getTipoAnimal()
                            , request.getPageable());
                }
            }
        }
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /animals/:id} : get the "id" animal.
     *
     * @param id the id of the animal to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the animal, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/animals/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Obtener un animal dado su id")
    public ResponseEntity<Animal> getAnimal(@PathVariable Integer id) {
        Optional<Animal> animal = animalRepository.findById(id);
        return (ResponseEntity)animal.map((response) -> {
            return ((ResponseEntity.BodyBuilder)ResponseEntity.ok()).body(response);
        }).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    /**
     * {@code DELETE  /eliminar/:id} : delete the "id" animal.
     *
     * @param id the id of the animal to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Eliminar un animal dado su id")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Integer id) {
        animalRepository.deleteById(id);
        return ResponseEntity.noContent()//.headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                .build();
    }


}
