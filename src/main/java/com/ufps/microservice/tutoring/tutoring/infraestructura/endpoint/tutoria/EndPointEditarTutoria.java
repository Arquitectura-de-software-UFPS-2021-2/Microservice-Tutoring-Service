package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.tutoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria.ManejadorEditarTutorias;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CONTROLADOR;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_TUTORIA;

@RestController
@RequestMapping(REST_CONTROLADOR+REST_TUTORIA)
@RequiredArgsConstructor
@Validated
public class EndPointEditarTutoria {

    @Autowired
    private ManejadorEditarTutorias manejadorEditarTutorias;

    //---ACTUALIZAR---
    @PutMapping
    @ApiOperation("actualiza una tutoria")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Tutoria> update(@RequestBody Tutoria tutoria) throws NotFoundException {
        Tutoria tutoriaBusqueda = manejadorEditarTutorias.ejecutar(tutoria);
        return new ResponseEntity<>(tutoriaBusqueda, HttpStatus.OK);
    }

}
