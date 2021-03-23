package com.ppm.repository.seguridad;


import com.ppm.model.seguridad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    Boolean existsByNombreUsuario(String nombreUsuario);

    Boolean existsByEmail(String email);
}
