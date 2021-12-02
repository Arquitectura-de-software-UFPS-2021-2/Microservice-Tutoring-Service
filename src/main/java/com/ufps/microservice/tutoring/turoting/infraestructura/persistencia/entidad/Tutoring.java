package com.ufps.microservice.tutoring.turoting.infraestructura.persistencia.entidad;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tutoring implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean state;

    @Column(name = "date_end", nullable = false)
    private LocalDateTime dateEnd;

    @Column(name = "date_start", nullable = false)
    private LocalDateTime dateStart;

    @ManyToOne
    @JoinColumn(name = "id_user_creator", nullable = false)
    private User userCreator;

    @ManyToOne
    @JoinColumn(name = "id_user_tutor", nullable = false)
    private User userTutor;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "tutoring_received",
            joinColumns = {@JoinColumn(name = "id_tutoring")},
            inverseJoinColumns = {@JoinColumn(name = "id_user")}
    )
    private List<User> userList;

    @ManyToMany(mappedBy = "tutoringList")
    private List<Subject> subjectList;

}
