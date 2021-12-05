package com.ufps.microservice.tutoring.comun.infraestructura.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {
    private String nombre;
    private String mensaje;
}
