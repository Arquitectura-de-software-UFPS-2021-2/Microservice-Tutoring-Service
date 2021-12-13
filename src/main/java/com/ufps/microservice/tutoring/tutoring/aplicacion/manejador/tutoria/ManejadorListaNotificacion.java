package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.TutoriaNotificacion;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.useCase.UsuarioUseCase;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.CategoriaMapper;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.TemaMapper;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.UsuarioMapper;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorListaNotificacion {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    private final UsuarioUseCase usuarioUseCase;

    private final UsuarioMapper usuarioMapper;

    private final CategoriaMapper categoriaMapper;

    private final TemaMapper temaMapper;

    public TutoriaNotificacion list(String nombre, String token) throws NotFoundException {
        Optional<Tutoring> tutoria = tutoriaRepositorioInterface.findReason(nombre);
        if (tutoria.isEmpty()){
            throw new NotFoundException("No se encontro la tutoria");
        }
        TutoriaNotificacion listtutorias = new TutoriaNotificacion();
        TutoriaNotificacion newtutoria = new TutoriaNotificacion();
        newtutoria.setId(tutoria.get().getId());
        newtutoria.setDateEnd(tutoria.get().getDateEnd());
        newtutoria.setDescription(tutoria.get().getDescription());
        newtutoria.setState(true);//Fixed
        newtutoria.setReason(tutoria.get().getReason());
        newtutoria.setDateStrat(tutoria.get().getDateStart());
        newtutoria.setUserTutor(tutoria.get().getUserTutor().getId());
        newtutoria.setUserCreator(tutoria.get().getUserCreator().getId());
        Usuario usuario = usuarioUseCase.findByCode(String.valueOf(tutoria.get().getUserTutor().getId()), token);
        newtutoria.setCorreotutor(usuario.getEmail());
        newtutoria.setTelefonotutor(usuario.getPhone());

        return newtutoria;
    }

}
