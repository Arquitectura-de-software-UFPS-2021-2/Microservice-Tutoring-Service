package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.useCase.UsuarioUseCase;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorInscribirseTutoria {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    private final UsuarioUseCase usuarioUseCase;

    public Tutoria end(Integer id, Integer id_usuario, String token) throws NotFoundException {
        Optional<Tutoria> tutoria = tutoriaRepositorioInterface.findId(id);
        if (tutoria.isEmpty()) {
            throw new NotFoundException("No se encontro la tutoria");
        }
        Usuario usuario = usuarioUseCase.findByCode(String.valueOf(id_usuario), token);
        List<Usuario> listusuarios = new ArrayList<>();
        listusuarios.add(usuario);
        tutoria.get().actualizarListUser(listusuarios);
        tutoriaRepositorioInterface.saveinscripcion(tutoria.get());
        return tutoria.get();
    }

}
