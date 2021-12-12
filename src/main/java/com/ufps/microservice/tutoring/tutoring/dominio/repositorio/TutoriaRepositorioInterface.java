package com.ufps.microservice.tutoring.tutoring.dominio.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;

import java.util.List;
import java.util.Optional;

public interface TutoriaRepositorioInterface {

    Optional<Tutoring> findReason(String reason);

    List<Tutoring> findAll();

    Optional<Tutoria> findId(Integer id);

    void save(Tutoring tutoria);

    void delete(Tutoria tutoria);

    Tutoring renEntity(String name);

}
