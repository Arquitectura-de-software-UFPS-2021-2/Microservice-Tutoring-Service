package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.TutoriaSalida;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorBuscarNombreTutorias {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    public TutoriaSalida find(String nombre) throws NotFoundException {
        Optional<Tutoring> tutoria = tutoriaRepositorioInterface.findReason(nombre);
        if (tutoria.isEmpty()) {
            throw new NotFoundException("No se encontro la tutoria");
        }
        TutoriaSalida newtutoria = new TutoriaSalida();
        newtutoria.setId(tutoria.get().getId());
        newtutoria.setDateEnd(tutoria.get().getDateEnd());
        newtutoria.setDescription(tutoria.get().getDescription());
        newtutoria.setState(true);//Fixed
        newtutoria.setCategory(tutoria.get().getCategory().getName());
        newtutoria.setReason(tutoria.get().getReason());
        newtutoria.setDateStrat(tutoria.get().getDateStart());
        newtutoria.setUserTutor(tutoria.get().getUserTutor().getId());
        newtutoria.setUserCreator(tutoria.get().getUserCreator().getId());
        List<String> names = new ArrayList<>();
        for(Subject subject : tutoria.get().getSubjectList())
        {
            names.add(subject.getName());
        }
        newtutoria.setLissubjets(names);
        return newtutoria;
    }

}
