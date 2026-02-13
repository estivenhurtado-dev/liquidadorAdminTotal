package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TSOLIC_LOG_PRELIQUIDACION")
@NamedQuery(name = "TsolicLogPreliquidacion.findAll", query = "SELECT t FROM TsolicLogPreliquidacion t")
public class TsolicLogPreliquidacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEC_LOG_PRELIQUIDACION_GENERATOR", sequenceName = "FDC01.SEC_LOG_PRELIQUIDACION", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_LOG_PRELIQUIDACION_GENERATOR")
	@Column(name = "ID")
	private BigDecimal id;

	@Column(name="CODIGO_INSTITUCION")
	private String codigoInstitucion;
	

	@Column(name="NOMBRE_ESTUDIANTE")
	private String nombreEstudiante;
	private String correo;
	private String celular;
			
	@Column(name="CODIGO_OTP")
	private String codigoOtp;
	@Column(name="CODIGO_CONFIRMADO")
	private String codigoConfirmado;
	
	
	@Column(name="RESPUESTA_SERVICIO")
	private String respuestaServicio;
	
	
	
	
	
	
	
	
	public String getRespuestaServicio() {
		return respuestaServicio;
	}

	public void setRespuestaServicio(String respuestaServicio) {
		this.respuestaServicio = respuestaServicio;
	}

	public TsolicLogPreliquidacion() {
		
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getCodigoInstitucion() {
		return codigoInstitucion;
	}

	public void setCodigoInstitucion(String codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCodigoOtp() {
		return codigoOtp;
	}

	public void setCodigoOtp(String codigoOtp) {
		this.codigoOtp = codigoOtp;
	}

	public String getCodigoConfirmado() {
		return codigoConfirmado;
	}

	public void setCodigoConfirmado(String codigoConfirmado) {
		this.codigoConfirmado = codigoConfirmado;
	}
	
	

}
