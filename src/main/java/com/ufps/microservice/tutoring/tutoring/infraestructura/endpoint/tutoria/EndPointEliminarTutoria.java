package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.tutoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria.ManejadorEliminarTutorias;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tutorias")
@RequiredArgsConstructor
@Validated
public class EndPointEliminarTutoria {

    @Autowired
    private ManejadorEliminarTutorias manejadorEliminarTutorias;

    //---ELIMINAR---
    @DeleteMapping("/tutoria/{id}/{nombre}")
    @ApiOperation("elimina una tutoria")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Tutoria> dalete(
            @PathVariable("id") Integer id,
            @PathVariable("nombre") String nombre
    ) throws NotFoundException {
        manejadorEliminarTutorias.eliminar(id, nombre);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
