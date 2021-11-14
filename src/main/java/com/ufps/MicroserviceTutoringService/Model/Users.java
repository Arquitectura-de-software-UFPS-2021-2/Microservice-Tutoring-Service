package com.ufps.MicroserviceTutoringService.Model;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;

	@Column(nullable = false)
	private String rol;
	
	@ManyToMany(mappedBy = "users")
    private Set<Tema> subject;
	
	@ManyToMany(mappedBy = "users")
    private Set<Tutoria> tutoria;

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Set<Tema> getSubject() {
		return subject;
	}

	public void setSubject(Set<Tema> subject) {
		this.subject = subject;
	}

	public Set<Tutoria> getTutoria() {
		return tutoria;
	}

	public void setTutoria(Set<Tutoria> tutoria) {
		this.tutoria = tutoria;
	}
	
}
