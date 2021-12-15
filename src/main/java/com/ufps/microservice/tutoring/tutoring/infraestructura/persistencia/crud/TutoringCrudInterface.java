package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud;

import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TutoringCrudInterface extends JpaRepository<Tutoring, Integer> {
    Optional<Tutoring> findById(Integer id);

    Optional<Tutoring> findByReason(String reason);

    @Query(value = "SELECT t.* FROM tutoring t WHERE t.state = true", nativeQuery=true)
    List<Tutoring> findByStatetrue();

    @Query(value = "SELECT t.* FROM tutoring t WHERE t.state = false", nativeQuery=true)
    List<Tutoring> findByStatefalse();
}
