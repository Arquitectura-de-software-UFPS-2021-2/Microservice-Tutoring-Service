package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TutoriaMapper {

    UsuarioMapper usuario = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "userCreator.id", target = "userCreator.code")
    @Mapping(source = "userTutor.id", target = "userTutor.code")
    Tutoria toTutoriaDto(Tutoring tutoring);

    List<Tutoria> toTutoriaDtos(List<Tutoring> tutorings);

    @InheritInverseConfiguration
    @Mapping(source = "userCreator.code", target = "userCreator.id")
    @Mapping(source = "userTutor.code", target = "userTutor.id")
    Tutoring toTutoringEntity(Tutoria tutoria);

    @InheritInverseConfiguration
    List<Tutoring> toTutoringsEntity(List<Tutoria> tutorias);

}
