package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.tema;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tema.ManejadorBuscarNombreTemas;
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
public class EndPointBuscarTema {

    @Autowired
    private final ManejadorBuscarNombreTemas manejadorBuscarNombreTemas;

    //---Buscar Tema---
    @GetMapping("/busquedaNombre/{nombre}")
    @ApiOperation("obtiene un tema por su nombre")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Tema> getIdentification(
            @PathVariable("nombre")
                    String nombre) throws NotFoundException {
        Tema tema = manejadorBuscarNombreTemas.find(nombre);
        return new ResponseEntity<>(tema, HttpStatus.OK);
    }

}
