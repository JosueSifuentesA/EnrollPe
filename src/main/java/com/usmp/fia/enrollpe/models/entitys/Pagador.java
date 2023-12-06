package com.usmp.fia.enrollpe.models.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pagadores")
public class Pagador implements Serializable {

	@PrePersist
	public void prePersist() {
		fecCre=new Date();
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=16,max=16)
	private String numTar;
	
	@NotEmpty
	private String cvv;
	
	@NotEmpty
	private String titularTarjeta;
	
	@NotEmpty
	@Email
	private String correoAlumno;
	
	@Column(name="fecha_caducidad")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/mm")
	private Date fecCad;
	
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date fecCre;
	
	@OneToMany(mappedBy = "pagador", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Boleta> boletas;
	

	public Pagador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumTar() {
		return numTar;
	}

	public void setNumTar(String numTar) {
		this.numTar = numTar;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getTitularTarjeta() {
		return titularTarjeta;
	}

	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}

	public String getCorreoAlumno() {
		return correoAlumno;
	}

	public void setCorreoAlumno(String correoAlumno) {
		this.correoAlumno = correoAlumno;
	}

	public Date getFecCad() {
		return fecCad;
	}

	public void setFecCad(Date fecCad) {
		this.fecCad = fecCad;
	}

	public Date getFecCre() {
		return fecCre;
	}

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}

	public List<Boleta> getFacturas() {
		return boletas;
	}

	public void setFacturas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public void addFactura(Boleta boleta) {
		boletas.add(boleta);
		
	}
	
}
