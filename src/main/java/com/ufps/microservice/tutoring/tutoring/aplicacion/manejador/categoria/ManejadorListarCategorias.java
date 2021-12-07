package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.CategoriaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ManejadorListarCategorias {

    private final CategoriaRepositorioInterface categoriaRepositorioInterface;

    public List<Categoria> list() throws NotFoundException {
        List<Categoria> categoriaBusqueda = categoriaRepositorioInterface.findAll();
        if (categoriaBusqueda.isEmpty()){
            throw new NotFoundException("No se encontro la categoria");
        }
        return categoriaBusqueda;
    }

}
