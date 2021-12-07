package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.CategoriaRepositorioInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorEliminarCategorias {

    private final CategoriaRepositorioInterface categoriaRepositorioInterface;

    public ResponseEntity<Categoria> eliminar(Integer id, String nombre) {
        Optional<Categoria> categoriaBusqueda = categoriaRepositorioInterface.findId(id);
        if (!categoriaBusqueda.isEmpty()) {
            categoriaRepositorioInterface.delete(categoriaBusqueda.get());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
