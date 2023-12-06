package com.usmp.fia.enrollpe.models.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="boletas")
public class Boleta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	  
	  private String descripcion;
	  private String observacion;
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name="fecha_creacion")
	  private Date fecha;
	  
	  
	  @PrePersist public void prePersist() { 
		  fecha=new Date(); 
	  }

	  @ManyToOne(fetch = FetchType.LAZY )
	  @JoinColumn(name="pagador_id")
	  private Pagador pagador;
	  
	  @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	  @JoinColumn(name="boleta_id")
	  public List<ItemBoleta> items;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public List<ItemBoleta> getItems() {
		return items;
	}

	public void setItems(List<ItemBoleta> items) {
		this.items = items;
	}
	
	public void addItemBoleta(ItemBoleta item) {
		this.items.add(item);
	}
	
	public Boleta() {
		this.items=new ArrayList<ItemBoleta>();
	}
	
	public Double getTotal() {
		Double total=0.0;
		
		int size=items.size();
		
		for(int i=0;i<size;i++) {
			total +=items.get(i).CalcularImporte();
		}
		return total;	
	}
	public Pagador getPagador() {
		return pagador;
	}

	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}

	
	
}
