package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

public class VODetalleAprobacion {
	private String noCuota;
	private String noPagare;
	private String valor;
	private String fecha;

	public VODetalleAprobacion() {
	}

	public String getNoCuota() {
		return noCuota;
	}

	public void setNoCuota(String noCuota) {
		this.noCuota = noCuota;
	}

	public String getNoPagare() {
		return noPagare;
	}

	public void setNoPagare(String noPagare) {
		this.noPagare = noPagare;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
