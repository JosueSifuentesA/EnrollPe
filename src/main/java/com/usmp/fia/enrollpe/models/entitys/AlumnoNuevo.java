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
@Table(name = "solicitudes_alumnos")
public class AlumnoNuevo implements Serializable{
	
	@PrePersist
	public void prePersist() {
		fecCre=new Date();
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=3,max=20)
	private String nomApo,nomAluN;
	
	@NotEmpty
	@Size(min=3,max=30)
	private String apeAluN1,apeAluN2,apeApo1,apeApo2;
	
	@NotEmpty
	@Size(min=8,max=8)
	private String numDApo,numDAluN;
	
	@NotEmpty
	@Size(min=9,max=9)
	private String celular;
	
	@NotEmpty
	private String fecNac,escuela,depa,prov,dire;
	
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

	public String getNomApo() {
		return nomApo;
	}

	public void setNomApo(String nomApo) {
		this.nomApo = nomApo;
	}

	public String getNomAluN() {
		return nomAluN;
	}

	public void setNomAluN(String nomAluN) {
		this.nomAluN = nomAluN;
	}

	public String getApeAluN1() {
		return apeAluN1;
	}

	public void setApeAluN1(String apeAluN1) {
		this.apeAluN1 = apeAluN1;
	}

	public String getApeAluN2() {
		return apeAluN2;
	}

	public void setApeAluN2(String apeAluN2) {
		this.apeAluN2 = apeAluN2;
	}

	public String getApeApo1() {
		return apeApo1;
	}

	public void setApeApo1(String apeApo1) {
		this.apeApo1 = apeApo1;
	}

	public String getApeApo2() {
		return apeApo2;
	}

	public void setApeApo2(String apeApo2) {
		this.apeApo2 = apeApo2;
	}

	public String getNumDApo() {
		return numDApo;
	}

	public void setNumDApo(String numDApo) {
		this.numDApo = numDApo;
	}

	public String getNumDAluN() {
		return numDAluN;
	}

	public void setNumDAluN(String numDAluN) {
		this.numDAluN = numDAluN;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFecNac() {
		return fecNac;
	}

	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}

	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public String getDepa() {
		return depa;
	}

	public void setDepa(String depa) {
		this.depa = depa;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getDire() {
		return dire;
	}

	public void setDire(String dire) {
		this.dire = dire;
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
