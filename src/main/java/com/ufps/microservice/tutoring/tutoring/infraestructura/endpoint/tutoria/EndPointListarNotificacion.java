package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.tutoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria.ManejadorListaNotificacion;
import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria.ManejadorListaNotificaciones;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.TutoriaNotificacion;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.*;

@RestController
@RequestMapping(REST_CONTROLADOR+REST_TUTORIA)
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointListarNotificacion {

    @Autowired
    private ManejadorListaNotificacion manejadorListaNotificacion;

    //---GUARDAR---
    @GetMapping(REST_TUTORIA_LISTAR_NOTIFICACION)
    @ApiOperation("listar una tutoria para notificacion")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "no se encontraron tutorias")
    })
    public ResponseEntity<TutoriaNotificacion> getAll(@RequestHeader(value = "Authorization") String token, @PathVariable("nombre")
            String nombre) throws NotFoundException {
        TutoriaNotificacion tutorias = manejadorListaNotificacion.list(nombre, token);
        return new ResponseEntity<>(tutorias, HttpStatus.OK);
    }
}
