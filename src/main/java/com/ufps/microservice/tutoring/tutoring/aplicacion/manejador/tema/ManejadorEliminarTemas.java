package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tema;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TemaRepositorioInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorEliminarTemas {

    private final TemaRepositorioInterface temaRepositorioInterface;

    public ResponseEntity<Tema> eliminar(Integer id, String nombre){
        Optional<Tema> temaBusqueda = temaRepositorioInterface.findId(id);
        if (!temaBusqueda.isEmpty()){
            temaRepositorioInterface.delete(temaBusqueda.get());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
