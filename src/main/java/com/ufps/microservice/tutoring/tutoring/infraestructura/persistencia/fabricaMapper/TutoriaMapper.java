package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TutoriaMapper {

    Tutoria toTutoriaDto(Tutoring tutoring);

    List<Tutoria> toTutoriaDtos(List<Tutoring> tutorings);

    @InheritInverseConfiguration
    Tutoring toTutoringEntity(Tutoria tutoria);

}
