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

import java.util.ArrayList;
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
    public Usuario findByCode(String code, String token) {
        ResponseEntity<Map<String, Object>> usuarioResponseEntity = usuarioClient.findByCodigo(Map.of("code", code, "api_token", token));
        if (!usuarioResponseEntity.hasBody()) {
            throw new RuntimeException("No se encontro el usuario");
        }
        Usuario usuario = mapToUsuario(usuarioResponseEntity.getBody());

        User user = findUser(usuario.getCode().toString());

        usuario.setRole(user.getRole());

        return usuario;
    }

    @Override
    public void saveRole(Usuario usuario) {
        User user = findUser(usuario.getCode().toString());
        user.setRole(usuario.getRole());
        userCrudInterface.save(user);
    }

    private Usuario mapToUsuario(Map<String, Object> usuarioMap) {
        Usuario usuario = new Usuario();
        ArrayList<Object> message = (ArrayList<Object>) usuarioMap.get("message");
        usuarioMap = (Map<String, Object>) message.get(0);
        usuario.setCode(Integer.parseInt(usuarioMap.get("code").toString()));
        usuario.setName(usuarioMap.get("name").toString());
        usuario.setLastName(usuarioMap.get("last_name").toString());
        usuario.setAddress(usuarioMap.get("address").toString());
        usuario.setAge(usuarioMap.get("age").toString());
        usuario.setPhone(usuarioMap.get("phone").toString());
        usuario.setEmail(usuarioMap.get("email").toString());
        usuario.setSemester(usuarioMap.get("semester").toString());
        usuario.setUniversityCareer(usuarioMap.get("university_career").toString());
        return usuario;
    }

    private User findUser(String code) {
        Optional<User> userOptional = userCrudInterface.findById(Integer.parseInt(code));
        User user = User.builder().build();
        if (userOptional.isEmpty()) {
            user.setId(Integer.parseInt(code));
            user.setRole("ROLE_USER");
            userCrudInterface.save(user);
        } else {
            user = userOptional.get();
        }
        return user;
    }
}
