package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.categoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria.ManejadorEditarCategorias;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CATEGORIA;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CONTROLADOR;

@RestController
@RequestMapping(REST_CONTROLADOR+REST_CATEGORIA)
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointEditarCategoria {

    @Autowired
    private ManejadorEditarCategorias manejadorEditarCategorias;

    //---ACTUALIZAR---
    @PutMapping
    @ApiOperation("actualiza una categoria")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) throws NotFoundException {
        Categoria categoriaBusqueda = manejadorEditarCategorias.ejecutar(categoria);
        return new ResponseEntity<>(categoriaBusqueda, HttpStatus.OK);
    }

}
