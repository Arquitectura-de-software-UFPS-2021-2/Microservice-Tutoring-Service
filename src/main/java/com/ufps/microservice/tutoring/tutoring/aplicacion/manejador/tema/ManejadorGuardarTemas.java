package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tema;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TemaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorGuardarTemas {

    private final TemaRepositorioInterface temaRepositorioInterface;

    public Tema guardar(Tema tema) throws NotFoundException {
        Tema temaGuardar = tema;
        temaRepositorioInterface.save(temaGuardar);
        return temaGuardar;
    }
}
