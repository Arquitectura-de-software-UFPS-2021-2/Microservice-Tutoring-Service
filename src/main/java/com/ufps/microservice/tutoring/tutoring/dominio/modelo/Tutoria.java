package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Tutoria {

    private Integer id;
    private String reason;
    private String description;
    private boolean state;
    private LocalDateTime dateEnd;
    private LocalDateTime dateStart;
    private Usuario userCreator;
    private Usuario userTutor;
    private Categoria category;
    private List<Tema> subjectList;

    public Tutoria() {
        actualizarReason(reason);
        actualizarDescription(description);
        actualizarState(state);
        actualizarDateEnd(dateEnd);
        actualizarDateStart(dateStart);
        actualizarUsuarioCreator(userCreator);
        actualizarUsuarioTutor(userTutor);
        actualizarCategoria(category);
        actualizarListSubject(subjectList);
    }

    public void actualizarReason(String reason) {
        this.reason = reason;
    }

    public void actualizarDescription(String description) {
        this.description = description;
    }

    public void actualizarState(boolean state) {
        this.state = state;
    }

    public void actualizarDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void actualizarDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public void actualizarUsuarioCreator(Usuario usuarioCreator) {
        this.userCreator = usuarioCreator;
    }

    public void actualizarUsuarioTutor(Usuario usuarioTutor) {
        this.userTutor = usuarioTutor;
    }

    public void actualizarCategoria(Categoria categoria) {
        this.category = categoria;
    }

    public void actualizarListSubject(List<Tema> subjectList) {
        this.subjectList = subjectList;
    }
}
