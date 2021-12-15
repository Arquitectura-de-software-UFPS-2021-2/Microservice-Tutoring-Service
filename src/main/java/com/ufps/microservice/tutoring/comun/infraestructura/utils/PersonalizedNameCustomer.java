package com.ufps.microservice.tutoring.comun.infraestructura.utils;

public class PersonalizedNameCustomer {
    public static final String REST_CONTROLADOR="/tutoriaServicio";

    public static final String REST_CATEGORIA="/categoria";
    public static final String REST_TEMA="/tema";
    public static final String REST_TUTORIA="/tutoria";
    public static final String REST_USUARIO="/usuario";

//    public static final String REST_ALL="/all";
    public static final String REST_LIST="/list";
    public static final String REST_SAVE="/save";


    public static final String REST_CATEGORIA_ELIMINAR="/delete/{id}/{nombre}";
    public static final String REST_CATEGORIA_BUSCAR="/busquedaNombre/{nombre}";

    public static final String REST_TEMA_ELIMINAR="/delete/{id}/{nombre}";
    public static final String REST_TEMA_BUSCAR="/busquedaNombre/{nombre}";

    public static final String REST_TUTORIA_ELIMINAR="/delete/{id}/{nombre}";
    public static final String REST_TUTORIA_BUSCAR="/busquedaNombre/{nombre}";
    public static final String REST_TUTORIA_TERMINAR="/terminartutoria/{id}";
    public static final String REST_TUTORIA_INSCRIPCION="/inscribirse/{id}/{idusuario}";
    public static final String REST_TUTORIA_LISTAR_NOTIFICACIONES="/notificacionesall";
    public static final String REST_TUTORIA_LISTAR_NOTIFICACION="/notificacion/{nombre}";
    public static final String REST_TUTORIA_LISTAR_TRUE="/activas";
    public static final String REST_TUTORIA_LISTAR_FALSE="/terminadas";

    public static final String REST_USUARIO_CAMBIAR_ROL="/{id}/rol/{rol}";

}
