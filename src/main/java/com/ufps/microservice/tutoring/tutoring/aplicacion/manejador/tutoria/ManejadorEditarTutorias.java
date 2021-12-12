package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorEditarTutorias {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    public Tutoria ejecutar(Tutoria tutoria) throws NotFoundException {
        Optional<Tutoria> tutoriaBusqueda = tutoriaRepositorioInterface.findId(tutoria.getId());
        if (tutoriaBusqueda.isEmpty()) {
            throw new NotFoundException("No se encontro la tutoria");
        }

        return tutoriaBusqueda.get();
    }

}
