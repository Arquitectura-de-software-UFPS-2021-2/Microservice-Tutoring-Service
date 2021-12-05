package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.UsuarioRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud.UserCrudInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.User;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UsuarioRepositorio implements UsuarioRepositorioInterface {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UserCrudInterface userCrudInterface;

    @Override
    public Optional<Usuario> findRole(String role) {
        Optional<User> user = userCrudInterface.findByRole(role);
        return user.map(user1 -> usuarioMapper.toUsuarioDto(user1));
    }

    @Override
    public Optional<Usuario> findId(Integer id) {
        Optional<User> user = userCrudInterface.findById(id);
        return user.map(user1 -> usuarioMapper.toUsuarioDto(user1));
    }

    @Override
    public void save(Usuario usuario) {
        User user = usuarioMapper.toUserEntity(usuario);
        userCrudInterface.save(user);
    }

    @Override
    public void delete(Usuario usuario) {
        User user = usuarioMapper.toUserEntity(usuario);
        userCrudInterface.delete(user);
    }

    @Override
    public User renEntity(String name) {
        return null;
    }
}
