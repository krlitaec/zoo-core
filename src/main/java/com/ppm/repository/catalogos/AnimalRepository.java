package com.ppm.repository.catalogos;

import com.ppm.model.catalogos.Animal;
import com.ppm.model.catalogos.TipoAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    Page<Animal> findByNombre(String nombre, Pageable pageable);

    Page<Animal> findByNombreAndTipoAnimal(String nombre, TipoAnimal tipoAnimal, Pageable pageable);

    Page<Animal> findByTipoAnimal(TipoAnimal tipoAnimal, Pageable pageable);


}
