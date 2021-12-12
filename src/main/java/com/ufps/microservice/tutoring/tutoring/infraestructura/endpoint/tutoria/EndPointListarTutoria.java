package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.tutoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria.ManejadorListarTutorias;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.TutoriaSalida;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_TUTORIA;

@RestController
@RequestMapping(REST_CONTROLADOR+REST_TUTORIA)
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointListarTutoria {

    @Autowired
    private ManejadorListarTutorias manejadorListarTutorias;

    //---GUARDAR---
    @GetMapping(REST_LIST)
    @ApiOperation("listar una tutoria")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "no se encontraron tutorias")
    })
    public ResponseEntity<List<TutoriaSalida>> getAll() throws NotFoundException {
        List<TutoriaSalida> tutorias = manejadorListarTutorias.list();
        if (tutorias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(tutorias, HttpStatus.OK);
    }

}
