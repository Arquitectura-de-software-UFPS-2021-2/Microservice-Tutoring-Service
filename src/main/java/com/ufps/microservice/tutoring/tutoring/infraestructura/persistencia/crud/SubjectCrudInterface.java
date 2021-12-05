package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud;

import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectCrudInterface extends JpaRepository<Subject, Integer> {
    Optional<Subject> findByName (String name);
}
