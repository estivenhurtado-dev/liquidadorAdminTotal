package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.util.Date;

public class VOAprobacion {
	private String numeroAprobacion;
	private String cedulaGirador;
	private String nombreGirador;
	private String direccion;
	private String telefono1;
	private String telefono2;
	private String celular;
	private String fecha;
	private String cedulaCodeudor;
	private String nombreCodeudor;
	private String direccionCodeudor;
	private String telefonoCodeudor1;
	private String telefonoCodeudor2;
	private String celularCodeudor;
	private String observaciones;
	private String establecimiento;
	private String hora;
	private String numeroTarjeta;
private String valorTotal;
private String numeroCuotas;
	
	private String codigoAfiliado;
	
	
	
	
	public VOAprobacion() {
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(String numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public String getCodigoAfiliado() {
		return codigoAfiliado;
	}

	public void setCodigoAfiliado(String codigoAfiliado) {
		this.codigoAfiliado = codigoAfiliado;
	}

	public String getNumeroAprobacion() {
		return numeroAprobacion;
	}

	public void setNumeroAprobacion(String numeroAprobacion) {
		this.numeroAprobacion = numeroAprobacion;
	}

	public String getCedulaGirador() {
		return cedulaGirador;
	}

	public void setCedulaGirador(String cedulaGirador) {
		this.cedulaGirador = cedulaGirador;
	}

	public String getNombreGirador() {
		return nombreGirador;
	}

	public void setNombreGirador(String nombreGirador) {
		this.nombreGirador = nombreGirador;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCedulaCodeudor() {
		return cedulaCodeudor;
	}

	public void setCedulaCodeudor(String cedulaCodeudor) {
		this.cedulaCodeudor = cedulaCodeudor;
	}

	public String getNombreCodeudor() {
		return nombreCodeudor;
	}

	public void setNombreCodeudor(String nombreCodeudor) {
		this.nombreCodeudor = nombreCodeudor;
	}

	public String getDireccionCodeudor() {
		return direccionCodeudor;
	}

	public void setDireccionCodeudor(String direccionCodeudor) {
		this.direccionCodeudor = direccionCodeudor;
	}

	public String getTelefonoCodeudor1() {
		return telefonoCodeudor1;
	}

	public void setTelefonoCodeudor1(String telefonoCodeudor1) {
		this.telefonoCodeudor1 = telefonoCodeudor1;
	}

	public String getTelefonoCodeudor2() {
		return telefonoCodeudor2;
	}

	public void setTelefonoCodeudor2(String telefonoCodeudor2) {
		this.telefonoCodeudor2 = telefonoCodeudor2;
	}

	public String getCelularCodeudor() {
		return celularCodeudor;
	}

	public void setCelularCodeudor(String celularCodeudor) {
		this.celularCodeudor = celularCodeudor;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	@Override
	public String toString() {
		return "VOAprobacion [numeroAprobacion=" + numeroAprobacion + ", cedulaGirador=" + cedulaGirador
				+ ", nombreGirador=" + nombreGirador + ", direccion=" + direccion + ", telefono1=" + telefono1
				+ ", telefono2=" + telefono2 + ", celular=" + celular + ", fecha=" + fecha + ", cedulaCodeudor="
				+ cedulaCodeudor + ", nombreCodeudor=" + nombreCodeudor + ", direccionCodeudor=" + direccionCodeudor
				+ ", telefonoCodeudor1=" + telefonoCodeudor1 + ", telefonoCodeudor2=" + telefonoCodeudor2
				+ ", celularCodeudor=" + celularCodeudor + ", observaciones=" + observaciones + ", establecimiento="
				+ establecimiento + ", hora=" + hora + ", numeroTarjeta=" + numeroTarjeta + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
