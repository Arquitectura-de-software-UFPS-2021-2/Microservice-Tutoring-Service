package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.TutoriaSalida;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.CategoriaMapper;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.TemaMapper;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorListarTutorias {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    private final CategoriaMapper categoriaMapper;

    private final TemaMapper temaMapper;

    public List<TutoriaSalida> list() throws NotFoundException {
        List<Tutoring> tutoriaBusqueda = tutoriaRepositorioInterface.findAll();
        if (tutoriaBusqueda.isEmpty()){
            throw new NotFoundException("No se encontro la tutoria");
        }
        List<TutoriaSalida> listtutorias = new ArrayList<>();
        for(Tutoring tutoria : tutoriaBusqueda)
        {
            TutoriaSalida newtutoria = new TutoriaSalida();
            newtutoria.setId(tutoria.getId());
            newtutoria.setDateEnd(tutoria.getDateEnd());
            newtutoria.setDescription(tutoria.getDescription());
            newtutoria.setState(true);
            newtutoria.setCategory(tutoria.getCategory().getName());
            newtutoria.setReason(tutoria.getReason());
            newtutoria.setDateStrat(tutoria.getDateStart());
            newtutoria.setUserTutor(tutoria.getUserTutor().getId());
            newtutoria.setUserCreator(tutoria.getUserCreator().getId());
            List<String> names = new ArrayList<>();
            for(Subject subject : tutoria.getSubjectList())
            {
                names.add(subject.getName());
            }
            newtutoria.setLissubjets(names);
            listtutorias.add(newtutoria);
        }
        return listtutorias;
    }

}
