package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TutoriaMapper {

    Tutoria toTutoriaDto(Tutoring tutoring);

    @InheritInverseConfiguration
    Tutoring toTutoringEntity(Tutoria tutoria);

}
