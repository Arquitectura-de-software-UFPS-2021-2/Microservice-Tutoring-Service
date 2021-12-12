package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorBuscarNombreTutorias {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    public Tutoria find(String nombre) throws NotFoundException {
        Optional<Tutoria> tutoriaBusqueda = tutoriaRepositorioInterface.findReason(nombre);

        if (tutoriaBusqueda.isEmpty()) {
            throw new NotFoundException("No se encontro la tutoria");
        }
        return tutoriaBusqueda.get();
    }

}
