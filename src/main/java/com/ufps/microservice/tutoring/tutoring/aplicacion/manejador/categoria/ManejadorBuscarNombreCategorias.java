package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.CategoriaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorBuscarNombreCategorias {

    private final CategoriaRepositorioInterface categoriaRepositorioInterface;

    public Categoria find(String nombre) throws NotFoundException {
        Optional<Categoria> categoriaBusqueda = categoriaRepositorioInterface.findName(nombre);

        if (categoriaBusqueda.isEmpty()) {
            throw new NotFoundException("No se encontro la categoria");
        }
        return categoriaBusqueda.get();
    }

}
