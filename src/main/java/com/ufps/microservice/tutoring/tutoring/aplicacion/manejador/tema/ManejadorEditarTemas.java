package com.ufps.microservice.tutoring.tutoring.aplicacion.manejador.tema;

import com.ufps.microservice.tutoring.tutoring.dominio.modelo.Tema;
import com.ufps.microservice.tutoring.tutoring.dominio.repositorio.TemaRepositorioInterface;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ManejadorEditarTemas {

    private final TemaRepositorioInterface temaRepositorioInterface;

    public Tema ejecutar(Tema tema) throws NotFoundException {
        Optional<Tema> temaBusqueda = temaRepositorioInterface.findId(tema.getId());
        if (temaBusqueda.isEmpty()) {
            throw new NotFoundException("No se encontro el tema");
        }
        temaBusqueda.get().actualizarTema(tema.getId(), tema.getName());
        temaRepositorioInterface.save(temaBusqueda.get());
        return temaBusqueda.get();
    }
}
