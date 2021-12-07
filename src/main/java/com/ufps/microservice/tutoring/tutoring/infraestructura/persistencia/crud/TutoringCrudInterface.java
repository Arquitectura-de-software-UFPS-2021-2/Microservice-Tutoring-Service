package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud;

import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutoringCrudInterface extends JpaRepository<Tutoring, Integer> {
    Optional<Tutoring> findById(Integer id);

    Optional<Tutoring> findByReason(String reason);
}
