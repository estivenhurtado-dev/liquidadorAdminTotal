package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TSOLIC_UNIVERSIDADES")
@NamedQuery(name = "TsolicUniversidad.findAll", query = "SELECT t FROM TsolicUniversidad t")
public class TsolicUniversidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO")
	private BigDecimal codigo;
	private String nombre;

	@Column(name = "ID_SUCURSAL")
	private BigDecimal idSucursal;
	@Column(name = "NIT_AFILIADO")
	private BigDecimal nitAfiliado;

	private String activo;

	public TsolicUniversidad() {

	}

	public BigDecimal getCodigo() {
		return codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public BigDecimal getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(BigDecimal idSucursal) {
		this.idSucursal = idSucursal;
	}

	public BigDecimal getNitAfiliado() {
		return nitAfiliado;
	}

	public void setNitAfiliado(BigDecimal nitAfiliado) {
		this.nitAfiliado = nitAfiliado;
	}
	
	

}
