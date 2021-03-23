package com.ppm.repository.catalogos;

import com.ppm.model.catalogos.TipoAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository para métodos de la Entidad TipoAnimal
 *
 * @author Karla
 * @since 2021-02-21
 */

@Repository
public interface TipoAnimalRepository extends JpaRepository<TipoAnimal, Integer> {

}
