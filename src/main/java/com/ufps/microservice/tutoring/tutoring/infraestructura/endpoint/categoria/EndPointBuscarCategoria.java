package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.categoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria.ManejadorBuscarNombreCategorias;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
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
@RequestMapping("categorias")
@RequiredArgsConstructor
@Validated
public class EndPointBuscarCategoria {

    @Autowired
    private final ManejadorBuscarNombreCategorias manejadorBuscarNombreCategorias;

    //---ENCONTRAR CATEGORIA---
    @GetMapping("/busquedaNombre/{nombre}")
    @ApiOperation("obtiene una categoria por su nombre")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Categoria> getIdentification(
            @PathVariable("nombre")
                    String nombre) throws NotFoundException {
        Categoria categoria = manejadorBuscarNombreCategorias.find(nombre);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }



}
