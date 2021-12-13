package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

import lombok.Data;

@Data
public class UsuarioNotificacion {

    private Integer code;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String studentEmail;
}
