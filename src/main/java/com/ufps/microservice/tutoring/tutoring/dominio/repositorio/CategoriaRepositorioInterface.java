package com.ufps.microservice.tutoring.tutoring.dominio.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Category;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepositorioInterface {

    Optional<Categoria> findName(String name);

    Optional<Categoria> findId(Integer id);

    List<Categoria> findAll();

    void save(Categoria categoria);

    void delete(Categoria categoria);

    Category renEntity(String name);

}
