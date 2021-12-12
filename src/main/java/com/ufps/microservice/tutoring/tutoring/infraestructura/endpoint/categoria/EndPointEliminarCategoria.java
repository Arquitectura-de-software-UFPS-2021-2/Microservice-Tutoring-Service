package com.ufps.microservice.tutoring.tutoring.infraestructura.endpoint.categoria;

import com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria.ManejadorEliminarCategorias;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CATEGORIA;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CATEGORIA_ELIMINAR;
import static com.ufps.microservice.tutoring.comun.infraestructura.utils.PersonalizedNameCustomer.REST_CONTROLADOR;

@RestController
@RequestMapping(REST_CONTROLADOR+REST_CATEGORIA)
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointEliminarCategoria {

    @Autowired
    private ManejadorEliminarCategorias manejadorEliminarCategorias;

    //---ELIMINAR---
    @DeleteMapping(REST_CATEGORIA_ELIMINAR)
    @ApiOperation("elimina una categoria")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Categoria> dalete(
            @PathVariable("id") Integer id,
            @PathVariable("nombre") String nombre
    ) throws NotFoundException {
        manejadorEliminarCategorias.eliminar(id, nombre);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
