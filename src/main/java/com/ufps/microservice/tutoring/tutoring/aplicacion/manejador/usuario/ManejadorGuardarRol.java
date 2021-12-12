package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.usuario;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.dominio.useCase.UsuarioUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManejadorGuardarRol {

    private final UsuarioUseCase usuarioUseCase;

    public void ejecutar(String code, String token, String rol) {
        Usuario usuario = usuarioUseCase.findByCode(code, token);
        usuario.setRole(rol);
        usuarioUseCase.saveRole(usuario);
    }
}
