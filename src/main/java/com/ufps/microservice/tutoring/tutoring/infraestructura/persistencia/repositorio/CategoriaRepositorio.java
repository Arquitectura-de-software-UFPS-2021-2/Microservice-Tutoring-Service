package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.repositorio;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Categoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.CategoriaRepositorioInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.crud.CategoriaCrudInterface;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Category;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.fabricaMapper.CategoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoriaRepositorio implements CategoriaRepositorioInterface {

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private CategoriaCrudInterface categoriaCrudInterface;

    @Override
    public Optional<Categoria> findName(String name) {
        Optional<Category> category = categoriaCrudInterface.findByName(name);
        return category.map(category1 -> categoriaMapper.toCategoriaDto(category1));
    }

    @Override
    public Optional<Categoria> findId(Integer id) {
        Optional<Category> category = categoriaCrudInterface.findById(id);
        return category.map(category1 -> categoriaMapper.toCategoriaDto(category1));
    }

    @Override
    public void save(Categoria categoria) {
        Category category = categoriaMapper.toCategoryEntity(categoria);
        categoriaCrudInterface.save(category);
    }

    @Override
    public void delete(Categoria categoria) {
        Category category = categoriaMapper.toCategoryEntity(categoria);
        categoriaCrudInterface.delete(category);
    }

    @Override
    public Category renEntity(String name) {
        return null;
    }
}
