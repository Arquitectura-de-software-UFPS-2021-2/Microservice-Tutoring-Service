package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.tutoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria.ManejadorBuscarNombreTutorias;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tutorias")
@RequiredArgsConstructor
@Validated
public class EndPointBuscarTutoria {

    @Autowired
    private final ManejadorBuscarNombreTutorias manejadorBuscarNombreTutorias;

    //---ENCONTRAR TUTORIA---
    @GetMapping("/busquedaNombre/{nombre}")
    @ApiOperation("obtiene una tutoria por su nombre")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Tutoria> getIdentification(
            @PathVariable("nombre")
                    String nombre) throws NotFoundException {
        Tutoria tutoria = manejadorBuscarNombreTutorias.find(nombre);
        return new ResponseEntity<>(tutoria, HttpStatus.OK);
    }


}
