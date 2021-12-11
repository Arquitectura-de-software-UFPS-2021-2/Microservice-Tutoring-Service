package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tutoria;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tutoria;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TutoriaRepositorioInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorEliminarTutorias {

    private final TutoriaRepositorioInterface tutoriaRepositorioInterface;

    public ResponseEntity<Tutoria> eliminar(Integer id, String nombre) {
        Optional<Tutoria> tutoriaBusqueda = tutoriaRepositorioInterface.findId(id);
        if (!tutoriaBusqueda.isEmpty()) {
            tutoriaRepositorioInterface.delete(tutoriaBusqueda.get());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
