package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud;

import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCrudInterface extends JpaRepository<User, Integer> {
    Optional<User> findById (Integer id);

    Optional<User> findByRole(String role);
}