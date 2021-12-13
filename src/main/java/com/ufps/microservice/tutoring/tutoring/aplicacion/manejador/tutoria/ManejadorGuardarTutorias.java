package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.*;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.CategoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TemaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.useCase.UsuarioUseCase;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.CategoriaMapper;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.TemaMapper;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.UsuarioMapper;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorGuardarTutorias {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    private final UsuarioUseCase usuarioUseCase;

    private final CategoriaRepositorioInterface categoriaRepositorioInterface;

    private final TemaRepositorioInterface temaRepositorioInterface;

    private final UsuarioMapper usuarioMapper;

    private final CategoriaMapper categoriaMapper;

    private final TemaMapper temaMapper;

    public Tutoria guardar(Tutoriaentrada tutoria, String token) throws NotFoundException {
        Usuario usuario = usuarioUseCase.findByCode(String.valueOf(tutoria.getUserTutor()), token);
        Usuario usuariocreador = usuarioUseCase.findByCode(String.valueOf(tutoria.getUserCreator()), token);
        Optional<Categoria> categoria = categoriaRepositorioInterface.findId(tutoria.getIdcategory());
        List<Optional<Tema>> listtemas = new ArrayList<>();
        for(Integer tema : tutoria.getLissubjets())
        {
            listtemas.add(temaRepositorioInterface.findId(tema));
        }
        List<Tema> listsubjects = new ArrayList<>();
        for(Optional<Tema> temas : listtemas)
        {
            listsubjects.add(temas.get());
        }
        Tutoria tutoriaGuardar = new Tutoria();
        tutoriaGuardar.setId(tutoria.getId());
        tutoriaGuardar.setCategory(categoria.get());
        tutoriaGuardar.setUserCreator(usuariocreador);
        tutoriaGuardar.setUserTutor(usuario);
        tutoriaGuardar.setSubjectList(listsubjects);
        tutoriaGuardar.setReason(tutoria.getReason());
        tutoriaGuardar.setState(true);
        tutoriaGuardar.setDescription(tutoria.getDescription());
        tutoriaGuardar.setDateStart(tutoria.getDateStrat());
        tutoriaGuardar.setDateEnd(tutoria.getDateEnd());
        tutoriaRepositorioInterface.save(tutoriaGuardar);
        Optional<Tutoria> tutoriaBusqueda = tutoriaRepositorioInterface.findId(tutoriaGuardar.getId());
        if (tutoriaBusqueda.isEmpty()) {
            throw new NotFoundException("No se encontro la tutoria");
        }
        return tutoriaBusqueda.get();
    }


}
