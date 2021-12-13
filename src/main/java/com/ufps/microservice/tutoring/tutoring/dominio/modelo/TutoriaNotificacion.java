package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class TutoriaNotificacion {

    private Integer id;
    private String reason;
    private String description;
    private boolean state;
    private LocalDateTime dateEnd;
    private LocalDateTime dateStrat;
    private int userCreator;
    private int userTutor;
    private String correotutor;
    private String telefonotutor;
    private List<UsuarioNotificacion>  usuarios;

    public TutoriaNotificacion() {
        actualizarReason(reason);
        actualizarDescription(description);
        actualizarState(state);
        actualizarDateEnd(dateEnd);
        actualizarDateStart(dateStrat);
        actualizarUsuarioCreator(userCreator);
        actualizarUsuarioTutor(userTutor);
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

}
