package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.CategoriaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorGuardarCategorias {

    private final CategoriaRepositorioInterface categoriaRepositorioInterface;

    public ResponseEntity<Categoria> guardar(Categoria categoria) throws NotFoundException {
        Optional<Categoria> categoriaBusqueda = categoriaRepositorioInterface.findId(categoria.getId());
        if (categoriaBusqueda.isEmpty()){
            throw new NotFoundException("No se encontro la categoria");
        }
        categoriaBusqueda.get().actualizarCategoria(categoria.getId(), categoria.getName());
        categoriaRepositorioInterface.save(categoriaBusqueda.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
