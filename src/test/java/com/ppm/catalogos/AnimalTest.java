package com.ppm.catalogos;

import com.ppm.model.catalogos.Animal;
import com.ppm.repository.catalogos.AnimalRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class AnimalTest {

    @MockBean
    private AnimalRepository tipoAnimalRepository;

    @Before
    public void init() {

    }

    @Test
    public void verificarAnimales() {
        List<Animal> tipos = tipoAnimalRepository.findAll();
        Assert.assertEquals(tipos.size(), 0);
    }

}
