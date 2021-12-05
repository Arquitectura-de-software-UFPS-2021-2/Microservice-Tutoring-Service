package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Categoria {

    private Integer id;
    private String name;

    public Categoria(Integer id, String name){
        actualizarCategoria(id, name);
    }

    public void actualizarCategoria(Integer id, String name){
        this.id = id;
        this.name = name;
    }

}
