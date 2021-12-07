package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

import lombok.Data;

@Data
public class Usuario {

    private Integer code;
    private String role;

    private String apiToken;
    private String name;
    private String lastName;
    private String address;
    private String age;
    private String phone;
    private String email;
    private String semester;
    private String universityCareer;
    private String studentEmail;
}
