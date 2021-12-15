package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.tutoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria.ManejadorInscribirseTutoria;
import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria.ManejadorTerminarTutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.*;

@RestController
@RequestMapping(REST_CONTROLADOR+REST_TUTORIA)
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointInscribirseTutoria {

    @Autowired
    private final ManejadorInscribirseTutoria manejadorInscribirseTutoria;

    //---ENCONTRAR TUTORIA---
    @GetMapping(REST_TUTORIA_INSCRIPCION)
    @ApiOperation("incribirse a la tutoria")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Tutoria> getIdentification(
            @PathVariable("id") Integer id, @PathVariable("idusuario") Integer id_usuario, @RequestHeader(value = "Authorization") String token
            ) throws NotFoundException {
        Tutoria tutoria = manejadorInscribirseTutoria.end(id, id_usuario, token);
        return new ResponseEntity<>(tutoria, HttpStatus.OK);
    }
}
