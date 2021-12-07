package com.ufps.microservice.tutoring.tutoring.dominio.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;

public interface UsuarioRepositorioInterface {
    Usuario findByCode(String code);

    void saveRole(Usuario usuario);
}
