package com.ppm.seguridad;

import com.ppm.TestUtil;
import com.ppm.ZooCoreApplication;
import com.ppm.model.request.LoginRequest;
import com.ppm.model.seguridad.Usuario;
import com.ppm.repository.seguridad.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests de integración para el controlador REST: AuthController.
 */
@AutoConfigureMockMvc
@SpringBootTest(classes = ZooCoreApplication.class)
public class AuthControllerTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void testLogin() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("usuario-auth-controller");
        usuario.setEmail("usuario-auth-controller@example.com");
        usuario.setActivo(true);
        usuario.setPassword(passwordEncoder.encode("test"));
        usuarioRepository.saveAndFlush(usuario);
        LoginRequest login = new LoginRequest();
        login.setUsername("usuario-auth-controller");
        login.setPassword("test");
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(login)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.access_token").isString())
                .andExpect(jsonPath("$.access_token").isNotEmpty());
    }
}
