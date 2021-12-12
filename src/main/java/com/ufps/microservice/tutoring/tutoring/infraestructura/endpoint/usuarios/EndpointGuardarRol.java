package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.usuarios;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.usuario.ManejadorGuardarRol;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_USUARIO;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_USUARIO_CAMBIAR_ROL;

@RestController
@RequestMapping(REST_USUARIO)
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndpointGuardarRol {

    @Autowired
    private ManejadorGuardarRol manejadorGuardarRol;

    @RequestMapping(REST_USUARIO_CAMBIAR_ROL)
    public ResponseEntity<Usuario> guardarRol(@PathVariable(value = "id") String id, @PathVariable(value = "rol") String rol, @RequestHeader(value = "Authorization") String token) {
        manejadorGuardarRol.ejecutar(id, rol, token);
        return new ResponseEntity<Usuario>(HttpStatus.OK);
    }
}
