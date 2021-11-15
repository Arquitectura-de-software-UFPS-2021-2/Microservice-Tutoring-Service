package com.ufps.MicroserviceTutoringService.model;



import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tutoria")
public class Tutoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tutoria;

	@Column(nullable = false)
	private String reason;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private boolean state;
	
	@Column(nullable = false)
	private Date date_end;
	
	@Column(nullable = false)
	private Date date_start;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_user_creator", referencedColumnName = "id_user")
	private Users id_user_creator;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_user_tutor", referencedColumnName = "id_user")
	private Users id_user_tutor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_category", referencedColumnName = "id_category")
	private Categoria id_category;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
            name = "tutoria_recibida",
            joinColumns = {@JoinColumn(name = "id_tutoria")},
            inverseJoinColumns = {@JoinColumn(name = "id_user")}
    )
    private Set<Users> users;
	
	@ManyToMany(mappedBy = "tutoria")
    private Set<Tema> subject;

	public Integer getId_tutoria() {
		return id_tutoria;
	}

	public void setId_tutoria(Integer id_tutoria) {
		this.id_tutoria = id_tutoria;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Users getId_user_creator() {
		return id_user_creator;
	}

	public void setId_user_creator(Users id_user_creator) {
		this.id_user_creator = id_user_creator;
	}

	public Users getId_user_tutor() {
		return id_user_tutor;
	}

	public void setId_user_tutor(Users id_user_tutor) {
		this.id_user_tutor = id_user_tutor;
	}

	public Categoria getId_category() {
		return id_category;
	}

	public void setId_category(Categoria id_category) {
		this.id_category = id_category;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Tema> getSubject() {
		return subject;
	}

	public void setSubject(Set<Tema> subject) {
		this.subject = subject;
	}
	
}
