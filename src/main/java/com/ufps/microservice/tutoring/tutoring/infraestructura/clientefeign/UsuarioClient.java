package com.ufps.microservice.tutoring.tutoring.infraestructura.clientefeign;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "account", url = "http://18.235.152.56")
public interface UsuarioClient {

    @PostMapping("/student/show")
    ResponseEntity<Usuario> findByCodigo(@RequestBody Map<String, String> codigo);
}
