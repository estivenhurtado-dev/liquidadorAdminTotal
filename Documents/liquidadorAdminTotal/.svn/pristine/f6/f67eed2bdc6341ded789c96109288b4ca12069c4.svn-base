package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TLIQ_FACTOR_AJUSTE database table.
 * 
 */
@Entity
@Table(name="TLIQ_FACTOR_AJUSTE")
@NamedQuery(name="TliqFactorAjuste.findAll", query="SELECT t FROM TliqFactorAjuste t")
public class TliqFactorAjuste implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FAAJ")
	private String idFaaj;

	private String activo;

	private String factor;

	
	private String  fechaCreacion;

	private String  plazo;


	private String  valorInferior;

	
	private String  valorSuperior;

	public TliqFactorAjuste() {
	}

	public String getIdFaaj() {
		return idFaaj;
	}

	public void setIdFaaj(String idFaaj) {
		this.idFaaj = idFaaj;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getValorInferior() {
		return valorInferior;
	}

	public void setValorInferior(String valorInferior) {
		this.valorInferior = valorInferior;
	}

	public String getValorSuperior() {
		return valorSuperior;
	}

	public void setValorSuperior(String valorSuperior) {
		this.valorSuperior = valorSuperior;
	}

	@Override
	public String toString() {
		return "TliqFactorAjuste [idFaaj=" + idFaaj + ", activo=" + activo
				+ ", factor=" + factor + ", fechaCreacion=" + fechaCreacion
				+ ", plazo=" + plazo + ", valorInferior=" + valorInferior
				+ ", valorSuperior=" + valorSuperior + "]";
	}

	
	
	

}