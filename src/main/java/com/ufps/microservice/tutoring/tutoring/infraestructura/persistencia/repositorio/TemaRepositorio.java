package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TemaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud.SubjectCrudInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.TemaMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TemaRepositorio implements TemaRepositorioInterface {

    @Autowired
    private TemaMapper temaMapper;

    @Autowired
    private SubjectCrudInterface subjectCrudInterface;

    @Override
    public Optional<Tema> findName(String name) {
        Optional<Subject> subject = subjectCrudInterface.findByName(name);
        return subject.map(subject1 -> temaMapper.toSubjectDto(subject1));
    }

    @Override
    public Optional<Tema> findId(Integer id) {
        Optional<Subject> subject = subjectCrudInterface.findById(id);
        return subject.map(subject1 -> temaMapper.toSubjectDto(subject1));
    }

    @Override
    public void save(Tema tema) {
        Subject subject = temaMapper.toSubjectEntity(tema);
        subjectCrudInterface.save(subject);
    }

    @Override
    public void delete(Tema tema) {
        Subject subject = temaMapper.toSubjectEntity(tema);
        subjectCrudInterface.delete(subject);
    }

    @Override
    public Subject renEntity(String name) {
        return null;
    }
}
