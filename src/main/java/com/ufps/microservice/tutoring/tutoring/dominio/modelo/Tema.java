package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

public class Tema {

    private Integer id;
    private String name;

    public Tema(){
        actualizarTema(id, name);
    }

    public void actualizarTema(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
