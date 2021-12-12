package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ManejadorListarTutorias {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    public List<Tutoria> list() throws NotFoundException {
        List<Tutoria> tutoriaBusqueda = tutoriaRepositorioInterface.findAll();
        if (tutoriaBusqueda.isEmpty()){
            throw new NotFoundException("No se encontro la tutoria");
        }
        return tutoriaBusqueda;
    }

}
