package com.ufps.microservice.tutoring.comun.infraestructura.error;

public class CategoriaNoEncontrada extends RuntimeException{
    public CategoriaNoEncontrada(String mensaje) {
        super(mensaje);
    }
}
