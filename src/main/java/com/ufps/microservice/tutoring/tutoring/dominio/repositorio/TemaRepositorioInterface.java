package com.ufps.microservice.tutoring.tutoring.dominio.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;

import java.util.Optional;

public interface TemaRepositorioInterface {

    Optional<Tema> findName(String name);

    Optional<Tema> findId(Integer id);

    void save(Tema tema);

    void delete(Tema tema);

    Subject renEntity(String name);

}
