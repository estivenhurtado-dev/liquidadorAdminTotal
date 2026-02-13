package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TAT_OTRAS_PLAZAS database table.
 * 
 */
@Entity
@Table(name="TAT_OTRAS_PLAZAS")
@NamedQuery(name="TatOtrasPlaza.findAll", query="SELECT t FROM TatOtrasPlaza t")
public class TatOtrasPlaza implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	
	@Column(name="ADICIONA_PORTES_TELEX")
	private String adicionaPortesTelex;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HASTA")
	private Date fechaHasta;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_MANTENIMIENTO")
	private Date fechaMantenimiento;
	@Id
	@Column(name="ID_OTPL")
	private String idOtpl;

	private String iva;

	@Column(name="PORCENTAJE_ADICION")
	private String porcentajeAdicion;

	private String usuario;

	@Column(name="VALOR_TOPE")
	private String valorTope;

	public TatOtrasPlaza() {
	}

	

	public String getAdicionaPortesTelex() {
		return adicionaPortesTelex;
	}



	public void setAdicionaPortesTelex(String adicionaPortesTelex) {
		this.adicionaPortesTelex = adicionaPortesTelex;
	}



	public String getIdOtpl() {
		return idOtpl;
	}



	public void setIdOtpl(String idOtpl) {
		this.idOtpl = idOtpl;
	}



	public String getIva() {
		return iva;
	}



	public void setIva(String iva) {
		this.iva = iva;
	}



	public String getPorcentajeAdicion() {
		return porcentajeAdicion;
	}



	public void setPorcentajeAdicion(String porcentajeAdicion) {
		this.porcentajeAdicion = porcentajeAdicion;
	}



	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Date getFechaMantenimiento() {
		return this.fechaMantenimiento;
	}

	public void setFechaMantenimiento(Date fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
	}



	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getValorTope() {
		return valorTope;
	}



	public void setValorTope(String valorTope) {
		this.valorTope = valorTope;
	}

	

}