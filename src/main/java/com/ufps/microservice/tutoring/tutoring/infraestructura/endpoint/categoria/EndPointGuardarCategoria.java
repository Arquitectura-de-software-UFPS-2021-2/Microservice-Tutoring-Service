package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.categoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria.ManejadorGuardarCategorias;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CATEGORIA;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CONTROLADOR;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_SAVE;

@RestController
@RequestMapping(REST_CONTROLADOR+REST_CATEGORIA)
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointGuardarCategoria {

    @Autowired
    private ManejadorGuardarCategorias manejadorGuardarCategorias;

    //---GUARDAR---
    @PostMapping(REST_SAVE)
    @ApiOperation("guarda una categoria")
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) throws NotFoundException {
        manejadorGuardarCategorias.guardar(categoria);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
