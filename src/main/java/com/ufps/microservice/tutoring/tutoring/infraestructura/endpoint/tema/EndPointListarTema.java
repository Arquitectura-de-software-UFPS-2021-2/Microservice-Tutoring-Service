package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.tema;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tema.ManejadorListarTemas;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CONTROLADOR;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_LIST;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_TEMA;

@RestController
@RequestMapping(REST_CONTROLADOR+REST_TEMA)
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointListarTema {
    @Autowired
    private final ManejadorListarTemas manejadorListarTemas;

    //---Buscar Tema---
    @GetMapping(REST_LIST)
    @ApiOperation("obtiene los temas")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Tema>> listar() throws NotFoundException {
        List<Tema> tema = manejadorListarTemas.listar();
        return new ResponseEntity<>(tema, HttpStatus.OK);
    }
}
