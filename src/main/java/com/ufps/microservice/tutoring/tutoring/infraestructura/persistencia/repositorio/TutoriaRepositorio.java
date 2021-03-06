package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.TutoriaSalida;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud.TutoringCrudInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Category;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Tutoring;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.User;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.TutoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TutoriaRepositorio implements TutoriaRepositorioInterface {

    @Autowired
    private TutoriaMapper tutoriaMapper;

    @Autowired
    private TutoringCrudInterface tutoringCrudInterface;

    @Override
    public Optional<Tutoring> findReason(String reason) {
        Optional<Tutoring> tutoring = tutoringCrudInterface.findByReason(reason);
        return tutoring;
    }

    @Override
    public List<Tutoring> findAll() {
        List<Tutoring> tutorings = tutoringCrudInterface.findAll();
        return tutorings;
    }

    @Override
    public Optional<Tutoria> findId(Integer id) {
        Optional<Tutoring> tutoring = tutoringCrudInterface.findById(id);
        return tutoring.map(tutoring1 -> tutoriaMapper.toTutoriaDto(tutoring1));
    }

    @Override
    public void save(Tutoria tutoria) {
        tutoringCrudInterface.save(tutoriaMapper.toTutoringEntity(tutoria));

    }

    @Override
    public void saveinscripcion(Tutoria tutoria) {
        Tutoring guardartutoria = tutoriaMapper.toTutoringEntity(tutoria);
        List<User> usuarios = new ArrayList<>();

        for(Usuario user: tutoria.getUserList())
        {
            User newuser = new User();
            newuser.setId(user.getCode());
            newuser.setRole(user.getRole());
            usuarios.add(newuser);
        }
        guardartutoria.setUserList(usuarios);
        tutoringCrudInterface.save(guardartutoria);
    }

    @Override
    public void delete(Tutoria tutoria) {
        Tutoring tutoring = tutoriaMapper.toTutoringEntity(tutoria);
        tutoringCrudInterface.delete(tutoring);
    }

    @Override
    public Tutoring renEntity(String name) {
        return null;
    }

    @Override
    public List<Tutoring> findTutoriasTrue()
    {
        return tutoringCrudInterface.findByStatetrue();
    }

    @Override
    public List<Tutoring> findTutoriasFalse()
    {
        return tutoringCrudInterface.findByStatefalse();
    }
}
