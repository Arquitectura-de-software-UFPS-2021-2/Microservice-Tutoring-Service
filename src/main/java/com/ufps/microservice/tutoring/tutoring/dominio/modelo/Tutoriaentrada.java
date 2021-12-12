package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Tutoriaentrada {

    private Integer id;
    private String reason;
    private String description;
    private boolean state;
    private LocalDateTime dateEnd;
    private LocalDateTime dateStrat;
    private int userCreator;
    private int userTutor;
    private int idcategory;
    private List<Integer> lissubjets;

    public Tutoriaentrada() {
        actualizarReason(reason);
        actualizarDescription(description);
        actualizarState(state);
        actualizarDateEnd(dateEnd);
        actualizarDateStart(dateStrat);
        actualizarUsuarioCreator(userCreator);
        actualizarUsuarioTutor(userTutor);
        actualizarCategoria(idcategory);
        actualizarListsubject(lissubjets);
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
        this.dateStrat = dateStart;
    }

    public void actualizarUsuarioCreator(int usuarioCreator) {
        this.userCreator = usuarioCreator;
    }

    public void actualizarUsuarioTutor(int usuarioTutor) {
        this.userTutor = usuarioTutor;
    }

    public void actualizarCategoria(int idcategory) {
        this.idcategory = idcategory;
    }

    public void actualizarListsubject(List<Integer> lissubjets) {
        this.lissubjets = lissubjets;
    }


}
