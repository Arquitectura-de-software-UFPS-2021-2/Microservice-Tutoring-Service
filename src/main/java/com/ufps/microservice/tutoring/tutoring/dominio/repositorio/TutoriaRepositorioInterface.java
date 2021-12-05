package com.ufps.microservice.tutoring.tutoring.dominio.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;

import java.util.Optional;

public interface TutoriaRepositorioInterface {

    Optional<Tutoria> findReason(String reason);

    Optional<Tutoria> findId(Integer id);

    void save(Tutoria tutoria);

    void delete(Tutoria tutoria);

    Tutoring renEntity(String name);

}
