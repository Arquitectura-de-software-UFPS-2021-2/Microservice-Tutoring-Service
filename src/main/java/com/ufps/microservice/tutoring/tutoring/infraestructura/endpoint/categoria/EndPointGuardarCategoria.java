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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias")
@RequiredArgsConstructor
@Validated
public class EndPointGuardarCategoria {

    @Autowired
    private ManejadorGuardarCategorias manejadorGuardarCategorias;

    //---GUARDAR---
    @PostMapping("/save")
    @ApiOperation("guarda una categoria")
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<Categoria> save (@RequestBody Categoria categoria) throws NotFoundException {
        manejadorGuardarCategorias.guardar(categoria);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
