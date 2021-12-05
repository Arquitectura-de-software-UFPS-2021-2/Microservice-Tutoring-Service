package com.ufps.microservice.tutoring.tutoring.dominio.modelo;

import java.time.LocalDateTime;

public class Tutoria {

    private Integer id;
    private String reason;
    private String description;
    private boolean state;
    private LocalDateTime dateEnd;
    private LocalDateTime dateStrat;
    private Usuario userCreator;
    private Usuario userTutor;
    private Categoria category;

    public Tutoria(){
        actualizarReason(reason);
        actualizarDescription(description);
        actualizarState(state);
        actualizarDateEnd(dateEnd);
        actualizarDateStart(dateStrat);
        actualizarUsuarioCreator(userCreator);
        actualizarUsuarioTutor(userTutor);
        actualizarCategoria(category);
    }

    public void actualizarReason(String reason){
        this.reason = reason;
    }

    public void actualizarDescription(String description){
        this.description = description;
    }

    public void actualizarState(boolean state){
        this.state = state;
    }

    public void actualizarDateEnd(LocalDateTime dateEnd){
        this.dateEnd = dateEnd;
    }

    public void actualizarDateStart(LocalDateTime dateStart) {
        this.dateStrat = dateStart;
    }

    public void actualizarUsuarioCreator(Usuario usuarioCreator){
        this.userCreator = usuarioCreator;
    }

    public void actualizarUsuarioTutor(Usuario usuarioTutor){
        this.userTutor = usuarioTutor;
    }

    public void actualizarCategoria(Categoria categoria){
        this.category = categoria;
    }


}
