package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toCategoriaDto(Category category);

    List<Categoria> toCategoriaDtos(List<Category> categories);

    @InheritInverseConfiguration
    Category toCategoryEntity(Categoria categoria);

}
