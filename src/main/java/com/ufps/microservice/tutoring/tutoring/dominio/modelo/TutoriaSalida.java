package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Category;
import com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad.Subject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TutoriaSalida {

    private Integer id;
    private String reason;
    private String description;
    private boolean state;
    private LocalDateTime dateEnd;
    private LocalDateTime dateStrat;
    private int userCreator;
    private int userTutor;
    private String category;
    private List<String> lissubjets;

    public TutoriaSalida() {
        actualizarReason(reason);
        actualizarDescription(description);
        actualizarState(state);
        actualizarDateEnd(dateEnd);
        actualizarDateStart(dateStrat);
        actualizarUsuarioCreator(userCreator);
        actualizarUsuarioTutor(userTutor);
        actualizarCategoria(category);
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

    public void actualizarCategoria(String category) {
        this.category = category;
    }

    public void actualizarListsubject(List<String> lissubjets) {
        this.lissubjets = lissubjets;
    }
}
