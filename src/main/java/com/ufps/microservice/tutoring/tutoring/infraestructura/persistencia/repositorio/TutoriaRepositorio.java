package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud.TutoringCrudInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Category;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.TutoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TutoriaRepositorio implements TutoriaRepositorioInterface {

    @Autowired
    private TutoriaMapper tutoriaMapper;

    @Autowired
    private TutoringCrudInterface tutoringCrudInterface;

    @Override
    public Optional<Tutoria> findReason(String reason) {
        Optional<Tutoring> tutoring = tutoringCrudInterface.findByReason(reason);
        return tutoring.map(tutoring1 -> tutoriaMapper.toTutoriaDto(tutoring1));
    }

    @Override
    public List<Tutoria> findAll() {
        List<Tutoring> tutorings = tutoringCrudInterface.findAll();
        return tutoriaMapper.toTutoriaDtos(tutorings);
    }

    @Override
    public Optional<Tutoria> findId(Integer id) {
        Optional<Tutoring> tutoring = tutoringCrudInterface.findById(id);
        return tutoring.map(tutoring1 -> tutoriaMapper.toTutoriaDto(tutoring1));
    }

    @Override
    public void save(Tutoria tutoria) {
        Tutoring tutoring = tutoriaMapper.toTutoringEntity(tutoria);
        tutoringCrudInterface.save(tutoring);
    }

    @Override
    public void delete(Tutoria tutoria) {
        Tutoring tutoring = tutoriaMapper.toTutoringEntity(tutoria);
        tutoringCrudInterface.delete(tutoring);
    }

    @Override
    public Tutoring renEntity(String name) {
        return null;
    }
}
