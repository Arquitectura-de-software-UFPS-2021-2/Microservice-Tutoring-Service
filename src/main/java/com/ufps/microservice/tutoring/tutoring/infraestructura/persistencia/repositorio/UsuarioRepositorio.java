package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.UsuarioRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.clientefeign.UsuarioClient;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud.UserCrudInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.User;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class UsuarioRepositorio implements UsuarioRepositorioInterface {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UserCrudInterface userCrudInterface;

    @Autowired
    private UsuarioClient usuarioClient;

    @Override
    public Usuario findByCode(String code) {
        ResponseEntity<Usuario> usuarioResponseEntity = usuarioClient.findByCodigo(Map.of("codigo", code));
        if (!usuarioResponseEntity.hasBody()) {
            throw new RuntimeException("No se encontro el usuario");
        }
        Usuario usuario = usuarioResponseEntity.getBody();

        Optional<User> userOptional = userCrudInterface.findById(Integer.parseInt(code));
        userOptional.ifPresent(user -> usuario.setRole(user.getRole()));

        return usuario;
    }

    @Override
    public void saveRole(Usuario usuario) {
        User user = usuarioMapper.toUserEntity(usuario);
        userCrudInterface.save(user);
    }
}
