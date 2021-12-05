package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toCategoriaDto(Category category);

    @InheritInverseConfiguration
    Category toCategoryEntity(Categoria categoria);
}
