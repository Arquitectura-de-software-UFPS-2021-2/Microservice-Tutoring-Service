package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoriaentrada;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.CategoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TemaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.UsuarioRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Category;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.User;
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

    private final UsuarioRepositorioInterface usuarioRepositorioInterface;

    private final CategoriaRepositorioInterface categoriaRepositorioInterface;

    private final TemaRepositorioInterface temaRepositorioInterface;

    private final UsuarioMapper usuarioMapper;

    private final CategoriaMapper categoriaMapper;

    private final TemaMapper temaMapper;

    public Tutoria guardar(Tutoriaentrada tutoria) throws NotFoundException {
        User usuario = usuarioMapper.toUserEntity(usuarioRepositorioInterface.findByCode(String.valueOf(tutoria.getUserTutor())));
        User usuariocreador = usuarioMapper.toUserEntity(usuarioRepositorioInterface.findByCode(String.valueOf(tutoria.getUserCreator())));
        Optional<Categoria> categoria = categoriaRepositorioInterface.findId(tutoria.getId());
        Category category = categoriaMapper.toCategoryEntity(categoria.get());
        List<Optional<Tema>> listtemas = new ArrayList<>();
        for(Integer tema : tutoria.getLissubjets())
        {
            listtemas.add(temaRepositorioInterface.findId(tema));
        }
        List<Subject> listsubjects = new ArrayList<>();
        for(Optional<Tema> temas : listtemas)
        {
            listsubjects.add(temaMapper.toSubjectEntity(temas.get()));
        }
        Tutoring tutoriaGuardar = new Tutoring();
        tutoriaGuardar.setId(tutoria.getId());
        tutoriaGuardar.setCategory(category);
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
