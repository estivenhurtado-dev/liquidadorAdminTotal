package com.fenalcovalle.estandar.vista.dto;

public class CorreoTemplateNotificacionDTO {

	private String key;
	private String value;
	private CorreoTemplateDTO correo;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public CorreoTemplateDTO getCorreo() {
		return correo;
	}
	public void setCorreo(CorreoTemplateDTO correo) {
		this.correo = correo;
	}

	
}