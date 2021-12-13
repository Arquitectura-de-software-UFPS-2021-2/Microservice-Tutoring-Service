package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.TutoriaNotificacion;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoriaentrada;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.useCase.UsuarioUseCase;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;
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
public class ManejadorTerminarTutoria {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    public Tutoria end(Integer id) throws NotFoundException {
        Optional<Tutoria> tutoria = tutoriaRepositorioInterface.findId(id);
        if (tutoria.isEmpty()) {
            throw new NotFoundException("No se encontro la tutoria");
        }
        tutoria.get().actualizarReason(tutoria.get().getReason());
        tutoria.get().actualizarDateEnd(tutoria.get().getDateEnd());
        tutoria.get().actualizarDateStart(tutoria.get().getDateStart());
        tutoria.get().actualizarCategoria(tutoria.get().getCategory());
        tutoria.get().actualizarState(false);
        tutoria.get().actualizarDescription(tutoria.get().getDescription());
        tutoria.get().actualizarListSubject(tutoria.get().getSubjectList());
        tutoria.get().actualizarUsuarioCreator(tutoria.get().getUserCreator());
        tutoria.get().actualizarUsuarioTutor(tutoria.get().getUserTutor());
        tutoriaRepositorioInterface.save(tutoria.get());
        return tutoria.get();
    }
}
