package com.usmp.fia.enrollpe.models.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable{

	@PrePersist
	public void prePersist() {
		fecCre=new Date();
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre_alumno")
	@NotEmpty
	@Size(min=3,max=20)
	private String nomAlu;
	
	@Column(name="apellido_alumno")
	@NotEmpty
	@Size(min=3,max=20)
	private String apeAlu;
	
	@NotEmpty
	@Size(min=3,max=20)
	private String grado;
	
	@NotEmpty
	@Size(min=1,max=1)
	private String seccion;
	
	@NotEmpty
	@Email
	private String email;
	
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecCre;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomAlu() {
		return nomAlu;
	}


	public void setNomAlu(String nomAlu) {
		this.nomAlu = nomAlu;
	}


	public String getApeAlu() {
		return apeAlu;
	}


	public void setApeAlu(String apeAlu) {
		this.apeAlu = apeAlu;
	}


	public String getGrado() {
		return grado;
	}


	public void setGrado(String grado) {
		this.grado = grado;
	}


	public String getSeccion() {
		return seccion;
	}


	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFecCre() {
		return fecCre;
	}


	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}
	
	
}
