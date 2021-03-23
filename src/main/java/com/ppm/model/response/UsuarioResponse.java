package com.ppm.model.response;

import com.ppm.security.services.UsuarioImpl;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponse {
    private Integer id;
    private String username;
    private String email;
    private List<String> roles;

    public UsuarioResponse() {
    }

    public UsuarioResponse(UsuarioImpl usuario) {
        this.id = usuario.getIdUsuario();
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
        this.roles = usuario.getAuthorities().stream()
                .map(role -> role.getAuthority())
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
