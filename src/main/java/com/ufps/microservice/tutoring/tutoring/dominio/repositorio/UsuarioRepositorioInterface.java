package com.ufps.microservice.tutoring.tutoring.dominio.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.User;

import java.util.Optional;

public interface UsuarioRepositorioInterface {

    Optional<Usuario> findRole(String role);

    Optional<Usuario> findId(Integer id);

    void save(Usuario usuario);

    void delete(Usuario usuario);

    User renEntity(String name);

}
