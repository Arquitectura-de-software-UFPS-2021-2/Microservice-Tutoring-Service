package com.ufps.MicroserviceTutoringService.model;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "subject")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_subject;

	@Column(nullable = false)
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
            name = "tutor_subject",
            joinColumns = {@JoinColumn(name = "id_subject")},
            inverseJoinColumns = {@JoinColumn(name = "id_user")}
    )
    private Set<Users> users;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
            name = "tutoria_subject",
            joinColumns = {@JoinColumn(name = "id_subject")},
            inverseJoinColumns = {@JoinColumn(name = "id_tutoria")}
    )
    private Set<Tutoria> tutoria;

	public Integer getId_subject() {
		return id_subject;
	}

	public void setId_subject(Integer id_subject) {
		this.id_subject = id_subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Tutoria> getTutoria() {
		return tutoria;
	}

	public void setTutoria(Set<Tutoria> tutoria) {
		this.tutoria = tutoria;
	}

}
