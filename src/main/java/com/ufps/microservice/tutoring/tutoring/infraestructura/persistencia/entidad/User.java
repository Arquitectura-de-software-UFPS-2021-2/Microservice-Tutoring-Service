package com.ufps.microservice.tutoring.tutoring.infraestructura.persistencia.entidad;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Column(nullable = false)
    private String role;

    @ManyToMany(mappedBy = "userList")
    private List<Subject> subjectList;

    @ManyToMany(mappedBy = "userList")
    private List<Tutoring> tutoringList;

}
