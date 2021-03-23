package com.ppm.controller.seguridad;

import com.ppm.model.request.LoginRequest;
import com.ppm.model.response.JwtResponse;
import com.ppm.model.response.TokenReponse;
import com.ppm.model.response.UsuarioResponse;
import com.ppm.security.services.UsuarioImpl;
import com.ppm.security.token.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para Proceso de autenticación
 *
 * @author Karla
 * @since 2021-02-21
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Api(tags = "Gestión de Autenticación", value = "Gestión de Autenticación", description = "Gestión de Autenticación")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * Método para realizar el login
     * @param loginRequest
     * @return la respuesta es un token de tipo jwt
     */
    @PostMapping("/login")
    @ApiOperation(value = "Método para realizar el login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UsuarioImpl usuario = (UsuarioImpl) authentication.getPrincipal();
        List<String> roles = usuario.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        JwtResponse jwtResponse = new JwtResponse(jwt,
                usuario.getIdUsuario(),
                usuario.getUsername(),
                usuario.getEmail(),
                roles);
        TokenReponse tokenReponse = new TokenReponse();
        tokenReponse.setAccessToken(jwtResponse.getAccessToken());
        tokenReponse.setType(jwtResponse.getTokenType());
        return ResponseEntity.ok(tokenReponse);
    }

    /**
     * Método para obtener la información del usuario actual
     * @return
     */
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    @ApiOperation(value = "Método para obtener la información del usuario actual")
    public ResponseEntity<?> infoUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsuarioImpl usuario = (UsuarioImpl) authentication.getPrincipal();
        UsuarioResponse usuarioResponse = new UsuarioResponse(usuario);
        return ResponseEntity.ok(usuarioResponse);
    }
}
