package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the LOG_SEND_LIQUIDACION database table.
 * 
 */
@Entity
@Table(name="FDC01.LOG_SEND_LIQUIDACION")
@NamedQuery(name="LogSendLiquidacion.findAll", query="SELECT l FROM LogSendLiquidacion l")
public class LogSendLiquidacion implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_LOG_SEND_LIQUIDACION")
	@SequenceGenerator(name = "SEC_LOG_SEND_LIQUIDACION", sequenceName = "FDC01.SEC_LOG_SEND_LIQUIDACION", allocationSize = 1)
	@Id
	private long id;

	private String correo;

	@Column(name="ESTADO_ENVIO")
	private String estadoEnvio;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;

	@Column(name="NOMBRE_ARCHIVO")
	private String nombreArchivo;

	@Column(name="NOMBRE_CLIENTE")
	private String nombreCliente;

	@Column(name="NUMERO_DOCUMENTO")
	private BigDecimal numeroDocumento;

	@Column(name="RUTA_ARCHIVO")
	private String rutaArchivo;

	private String solicitud;

	@Column(name="TIPO_DOCUMENTO")
	private BigDecimal tipoDocumento;

	public LogSendLiquidacion() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstadoEnvio() {
		return this.estadoEnvio;
	}

	public void setEstadoEnvio(String estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public BigDecimal getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(BigDecimal numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getRutaArchivo() {
		return this.rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public String getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public BigDecimal getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(BigDecimal tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}