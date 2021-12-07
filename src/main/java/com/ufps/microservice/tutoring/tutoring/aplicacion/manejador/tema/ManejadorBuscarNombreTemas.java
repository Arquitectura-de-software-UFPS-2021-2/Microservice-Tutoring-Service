package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tema;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TemaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorBuscarNombreTemas {

    private final TemaRepositorioInterface temaRepositorioInterface;

    public Tema find(String nombre) throws NotFoundException {
        Optional<Tema> temaBusqueda = temaRepositorioInterface.findName(nombre);

        if (temaBusqueda.isEmpty()) {
            throw new NotFoundException("No se encontro el tema");
        }
        return temaBusqueda.get();
    }
}
