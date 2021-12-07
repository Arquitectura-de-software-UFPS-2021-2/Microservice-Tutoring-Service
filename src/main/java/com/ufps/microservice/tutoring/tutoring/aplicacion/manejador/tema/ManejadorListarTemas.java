package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tema;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TemaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorListarTemas {

    private final TemaRepositorioInterface temaRepositorioInterface;

    public List<Tema> listar() throws NotFoundException {
        List<Tema> listTemas = temaRepositorioInterface.findAll();
        return listTemas;
    }
}
