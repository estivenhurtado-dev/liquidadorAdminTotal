package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TSOLIC_PARAMETROS_CRE_LI")
@NamedQuery(name = "TsolicParametrosCreLi.findAll", query = "SELECT t FROM TsolicParametrosCreLi t")
public class TsolicParametrosCreLi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private BigDecimal id;
	
	
	private String nombre;
	
	private String valor;	
	private String descripcion;	
	private String ayuda;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAyuda() {
		return ayuda;
	}
	public void setAyuda(String ayuda) {
		this.ayuda = ayuda;
	}
	
	
	
	
	
	

}
