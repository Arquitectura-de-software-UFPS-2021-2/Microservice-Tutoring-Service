package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.categoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.CategoriaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorGuardarCategorias {

    private final CategoriaRepositorioInterface categoriaRepositorioInterface;

    public Categoria guardar(Categoria categoria) throws NotFoundException {
        Categoria categoriaGuardar = categoria;
        categoriaRepositorioInterface.save(categoriaGuardar);
        return categoriaGuardar;
    }


}
