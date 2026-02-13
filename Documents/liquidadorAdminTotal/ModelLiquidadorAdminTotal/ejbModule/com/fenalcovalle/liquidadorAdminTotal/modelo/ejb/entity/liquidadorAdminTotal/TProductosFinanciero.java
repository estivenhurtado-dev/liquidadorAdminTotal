package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;


/**
 * The persistent class for the T_PRODUCTOS_FINANCIEROS database table.
 * 
 */
@Entity
@Table(name="T_PRODUCTOS_FINANCIEROS")
@NamedQuery(name="TProductosFinanciero.findAll", query="SELECT t FROM TProductosFinanciero t")
public class TProductosFinanciero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PROD")
	private String idProd;

	private String activo;

	private String codigo;

	private String descripcion;

	@Column(name="FECHA_CREACION")
	private String fechaCreacion;

	private String fenaldescuento;

	@Column(name="OTROS_CARGOS")
	private String otrosCargos;

	@Column(name="OTROS_CARGOS_2")
	private String otrosCargos2;

	@Column(name="TASA_FINANCIAMIENTO")
	private String tasaFinanciamiento;
	
	@Column(name="COMISION")
	private String comision;
	
	
	@Column(name="SEGURO")
	private String seguro;
	
	@Column(name="SEGURO_COMISION")
	private String seguroComision;
	
	@Column(name="CODIGO_ASEGURADORA")
	private String codigoAseguradora;
	
	@Column(name="IVA")
	private String iva;
	
	@Column(name="TASA_FIJA")
	private String tasaFija;
	
	
	public TProductosFinanciero() {
	}

	


	public String getCodigoAseguradora() {
		return codigoAseguradora;
	}




	public void setCodigoAseguradora(String codigoAseguradora) {
		this.codigoAseguradora = codigoAseguradora;
	}




	public String getIdProd() {
		return idProd;
	}




	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}




	public String getActivo() {
		return activo;
	}




	public void setActivo(String activo) {
		this.activo = activo;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getFechaCreacion() {
		return fechaCreacion;
	}




	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}




	public String getFenaldescuento() {
		return fenaldescuento;
	}




	public void setFenaldescuento(String fenaldescuento) {
		this.fenaldescuento = fenaldescuento;
	}




	public String getOtrosCargos() {
		return otrosCargos;
	}




	public void setOtrosCargos(String otrosCargos) {
		this.otrosCargos = otrosCargos;
	}




	public String getOtrosCargos2() {
		return otrosCargos2;
	}




	public void setOtrosCargos2(String otrosCargos2) {
		this.otrosCargos2 = otrosCargos2;
	}




	public String getTasaFinanciamiento() {
		return tasaFinanciamiento;
	}




	public void setTasaFinanciamiento(String tasaFinanciamiento) {
		this.tasaFinanciamiento = tasaFinanciamiento;
	}




	public String getComision() {
		return comision;
	}




	public void setComision(String comision) {
		this.comision = comision;
	}




	public String getSeguro() {
		return seguro;
	}




	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}




	public String getSeguroComision() {
		return seguroComision;
	}




	public void setSeguroComision(String seguroComision) {
		this.seguroComision = seguroComision;
	}




	public String getIva() {
		return iva;
	}




	public void setIva(String iva) {
		this.iva = iva;
	}




	public String getTasaFija() {
		return tasaFija;
	}




	public void setTasaFija(String tasaFija) {
		this.tasaFija = tasaFija;
	}




	@Override
	public String toString() {
		return "TProductosFinanciero [idProd=" + idProd + ", activo=" + activo
				+ ", codigo=" + codigo + ", descripcion=" + descripcion
				+ ", fechaCreacion=" + fechaCreacion + ", fenaldescuento="
				+ fenaldescuento + ", otrosCargos=" + otrosCargos
				+ ", otrosCargos2=" + otrosCargos2 + ", tasaFinanciamiento="
				+ tasaFinanciamiento + "]";
	}

	
	
	
}