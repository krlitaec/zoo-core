package com.ppm.catalogos;

import com.ppm.TestUtil;
import com.ppm.ZooCoreApplication;
import com.ppm.model.catalogos.Animal;
import com.ppm.model.catalogos.TipoAnimal;
import com.ppm.repository.catalogos.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Tests de integración para el controlador REST: AnimalController.
 */
@AutoConfigureMockMvc
@SpringBootTest(classes = ZooCoreApplication.class)
public class AnimalControllerTest {

    private static final String NOMBRE_CREAR = "AAAAAAAAAA";
    private static final String NOMBRE_MODIFICAR = "BBBBBBBBBB";

    private static final Integer DEFAULT_ID = 1;
    
    private static final Integer EDAD_CREAR = 1;
    private static final Integer EDAD_MODIFICAR = 2;

    private static final String NOMBRE_GRUPO = "Mamíferos";
    private static final String NOMBRE_TIPO = "Tigre";

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private MockMvc mockMvc;

    private Animal animal;

    /**
     * Crear Entidad para este test.
     */
    public static Animal crearEntidad() {
        TipoAnimal tipoAnimal = new TipoAnimal();
        tipoAnimal.setId(DEFAULT_ID);
        Animal animal = new Animal(NOMBRE_CREAR, tipoAnimal);
        animal.setEdad(EDAD_CREAR);
        return animal;
    }

    @BeforeEach
    public void initTest() {
        animal = crearEntidad();
    }

    @Test
    @Transactional
    public void crearAnimal() throws Exception {
        int databaseSizeBeforeCrear = animalRepository.findAll().size();
        // Crear el Animal
        mockMvc.perform(post("/api/animales/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(animal)))
                .andExpect(status().isCreated());
        // Validar el Animal en la base de datos
        List<Animal> animalList = animalRepository.findAll();
        assertThat(animalList).hasSize(databaseSizeBeforeCrear + 1);
        Animal testAnimal = animalList.get(animalList.size() - 1);
        assertThat(testAnimal.getNombre()).isEqualTo(NOMBRE_CREAR);
        assertThat(testAnimal.getEdad()).isEqualTo(EDAD_CREAR);
    }

    @Test
    @Transactional
    public void actualizarAnimal() throws Exception {
        // Initializar la base de datos
        animalRepository.save(animal);

        int databaseSizeBeforeUpdate = animalRepository.findAll().size();

        // Actualiza el animal
        Animal updatedAnimal = animalRepository.findById(animal.getId()).get();

        updatedAnimal.setNombre(NOMBRE_MODIFICAR);
        updatedAnimal.setEdad(EDAD_MODIFICAR);

        mockMvc.perform(put("/api/animales/actualizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(updatedAnimal)))
                .andExpect(status().isOk());

        // Validate the Animal in the database
        List<Animal> animalList = animalRepository.findAll();
        assertThat(animalList).hasSize(databaseSizeBeforeUpdate);
        Animal testAnimal = animalList.get(animalList.size() - 1);
        assertThat(testAnimal.getNombre()).isEqualTo(NOMBRE_MODIFICAR);
        assertThat(testAnimal.getEdad()).isEqualTo(EDAD_MODIFICAR);
    }
}
