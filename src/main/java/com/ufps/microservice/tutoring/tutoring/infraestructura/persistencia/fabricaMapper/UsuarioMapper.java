package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "code", source = "id")
    @Mapping(target = "apiToken", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "age", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "semester", ignore = true)
    @Mapping(target = "universityCareer", ignore = true)
    @Mapping(target = "studentEmail", ignore = true)
    Usuario toUsuarioDto(User user);

    @InheritInverseConfiguration
    User toUserEntity(Usuario usuario);

}
