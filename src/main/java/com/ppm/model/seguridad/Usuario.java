package com.ppm.model.seguridad;

import com.ppm.model.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad - tabla usuario
 *
 * @author Karla
 * @since 2021-02-21
 */

@Entity
@Table(name = "usuario")
public class Usuario extends BaseEntity {
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(	name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> roles = new HashSet<>();

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
