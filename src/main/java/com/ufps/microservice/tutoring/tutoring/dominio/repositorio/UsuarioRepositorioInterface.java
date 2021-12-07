package com.ufps.microservice.tutoring.tutoring.dominio.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.User;

import java.util.Optional;

public interface UsuarioRepositorioInterface {
    Usuario findByCode(String code);

    void saveRole(Usuario usuario);
}
