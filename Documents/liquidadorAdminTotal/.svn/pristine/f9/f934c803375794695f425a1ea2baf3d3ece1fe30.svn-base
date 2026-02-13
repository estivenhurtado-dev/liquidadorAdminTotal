package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TPRODUCTOS_DE_CREDITO database table.
 * 
 */
@Entity
@Table(name="TPRODUCTOS_DE_CREDITO")
@NamedQuery(name="TproductosDeCredito.findAll", query="SELECT t FROM TproductosDeCredito t")
public class TproductosDeCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PRODUCTO")
	private String idProducto;

	private String activo;

	@Column(name="COMISION_TRANSFERENCIA")
	private String comisionTransferencia;

	private String descripcion;

	@Column(name="ID_PRODUCTO_PADRE")
	private String idProductoPadre;

	public TproductosDeCredito() {
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getComisionTransferencia() {
		return comisionTransferencia;
	}

	public void setComisionTransferencia(String comisionTransferencia) {
		this.comisionTransferencia = comisionTransferencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdProductoPadre() {
		return idProductoPadre;
	}

	public void setIdProductoPadre(String idProductoPadre) {
		this.idProductoPadre = idProductoPadre;
	}

	@Override
	public String toString() {
		return "TproductosDeCredito [idProducto=" + idProducto + ", activo="
				+ activo + ", comisionTransferencia=" + comisionTransferencia
				+ ", descripcion=" + descripcion + ", idProductoPadre="
				+ idProductoPadre + "]";
	}

	
	
	

	
	
	

}