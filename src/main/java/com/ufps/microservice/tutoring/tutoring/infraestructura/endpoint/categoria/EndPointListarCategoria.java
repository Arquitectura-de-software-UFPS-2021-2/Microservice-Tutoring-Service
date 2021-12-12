package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.categoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria.ManejadorListarCategorias;
import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
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

import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CATEGORIA;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CONTROLADOR;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_LIST;

@RestController
@RequestMapping(REST_CONTROLADOR+REST_CATEGORIA)
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointListarCategoria {

    @Autowired
    private ManejadorListarCategorias manejadorListarCategorias;

    //---LISTAR---
    @GetMapping(REST_LIST)
    @ApiOperation("listar una categoria")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "no se encontraron categorias")
    })
    public ResponseEntity<List<Categoria>> getAll() throws NotFoundException {
        List<Categoria> categorias = manejadorListarCategorias.list();
        if (categorias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

}
