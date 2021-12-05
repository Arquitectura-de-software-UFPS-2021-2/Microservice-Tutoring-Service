package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud;

import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaCrudInterface  extends JpaRepository<Category, Integer> {
    Optional<Category> findByName (String name);
}
