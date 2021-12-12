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

    public static final String REST_USUARIO_CAMBIAR_ROL="/{id}/rol/{rol}";

}
