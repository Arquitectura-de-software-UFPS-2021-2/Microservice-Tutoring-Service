package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorGuardarTutorias {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    public Tutoria guardar(Tutoria tutoria) throws NotFoundException {
        Tutoria tutoriaGuardar = tutoria;
        tutoriaRepositorioInterface.save(tutoriaGuardar);
        Optional<Tutoria> tutoriaBusqueda = tutoriaRepositorioInterface.findId(tutoriaGuardar.getId());
        if (tutoriaBusqueda.isEmpty()) {
            throw new NotFoundException("No se encontro la tutoria");
        }
        return tutoriaBusqueda.get();
    }


}
