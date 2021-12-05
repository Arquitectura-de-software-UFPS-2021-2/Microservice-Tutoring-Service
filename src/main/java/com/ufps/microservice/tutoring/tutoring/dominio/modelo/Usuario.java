package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

public class Usuario {

    private Integer id;
    private String role;

    public Usuario(){
        actualizarUsuario(id, role);
    }

    public void actualizarUsuario(Integer id, String role){
        this.id = id;
        this.role = role;
    }

}
