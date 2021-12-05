package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TemaMapper {

    Tema toSubjectDto(Subject subject);

    @InheritInverseConfiguration
    Subject toSubjectEntity(Tema tema);

}
