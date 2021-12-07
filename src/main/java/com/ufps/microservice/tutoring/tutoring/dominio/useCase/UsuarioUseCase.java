package com.ufps.microservice.tutoring.tutoring.dominio.useCase;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.UsuarioRepositorioInterface;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioUseCase {

    private final UsuarioRepositorioInterface usuarioRepositorio;

    public Usuario findByCode(String code) {
        return usuarioRepositorio.findByCode(code);
    }

    public void saveRole(Usuario usuario) {
        usuarioRepositorio.saveRole(usuario);
    }
}
