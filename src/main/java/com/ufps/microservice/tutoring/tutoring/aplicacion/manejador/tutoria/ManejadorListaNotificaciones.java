package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.*;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.UsuarioRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.User;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.CategoriaMapper;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.TemaMapper;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.UsuarioMapper;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ManejadorListaNotificaciones {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    private final UsuarioRepositorioInterface usuarioRepositorioInterface;

    private final UsuarioMapper usuarioMapper;

    private final CategoriaMapper categoriaMapper;

    private final TemaMapper temaMapper;

    public List<TutoriaNotificacion> list(String token) throws NotFoundException {
        List<Tutoring> tutoriaBusqueda = tutoriaRepositorioInterface.findAll();
        if (tutoriaBusqueda.isEmpty()){
            throw new NotFoundException("No se encontro la tutoria");
        }
        List<TutoriaNotificacion> listtutorias = new ArrayList<>();
        for(Tutoring tutoria : tutoriaBusqueda)
        {
            TutoriaNotificacion newtutoria = new TutoriaNotificacion();
            newtutoria.setId(tutoria.getId());
            newtutoria.setDateEnd(tutoria.getDateEnd());
            newtutoria.setDescription(tutoria.getDescription());
            newtutoria.setState(true);//Fixed
            newtutoria.setReason(tutoria.getReason());
            newtutoria.setDateStrat(tutoria.getDateStart());
            newtutoria.setUserTutor(tutoria.getUserTutor().getId());
            newtutoria.setUserCreator(tutoria.getUserCreator().getId());
            Usuario usuario = usuarioRepositorioInterface.findByCode(String.valueOf(tutoria.getUserTutor()), token);
            newtutoria.setCorreotutor(usuario.getEmail());
            newtutoria.setTelefonotutor(usuario.getPhone());
            listtutorias.add(newtutoria);
        }
        return listtutorias;
    }
}
