package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Tema {

    private Integer id;
    private String name;

    public Tema(Integer id, String name) {
        actualizarTema(id, name);
    }

    public void actualizarTema(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
