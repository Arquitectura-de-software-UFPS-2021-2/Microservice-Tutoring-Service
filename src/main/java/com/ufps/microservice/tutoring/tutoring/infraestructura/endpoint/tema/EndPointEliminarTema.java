package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.tema;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tema.ManejadorEliminarTemas;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("temas")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointEliminarTema {
    @Autowired
    private ManejadorEliminarTemas manejadorEliminarTemas;

    //---ELIMINAR---
    @DeleteMapping("/tema/{id}/{nombre}")
    @ApiOperation("elimina un tema")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Tema> dalete(
            @PathVariable("id") Integer id,
            @PathVariable("nombre") String nombre
    ) throws NotFoundException {
        manejadorEliminarTemas.eliminar(id, nombre);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
