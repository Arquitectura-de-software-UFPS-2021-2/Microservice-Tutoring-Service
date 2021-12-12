package com.ufps.microservice.tutoring.tutoring.infraestructura.clientefeign;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Component
@FeignClient(name = "UsuarioClient", url = "http://18.235.152.56")
public interface UsuarioClient {

    @PostMapping(value = "/student/show")
    @Headers("Content-Type: application/json")
    ResponseEntity<Map<String, Object>> findByCodigo(@RequestBody Map<String, String> body);
}
