package com.fenalcovalle.estandar.vista.dto;

import java.util.List;

public class RespuestaPagareDto {

	private String message;

//	private List<ConsultaPagaresResDTO>   data;

	
	private String  data;
	private String type;

	private String ext;
	
	
	
	
	

	public RespuestaPagareDto() {
	
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
//
//	public List<ConsultaPagaresResDTO> getData() {
//		return data;
//	}
//
//	public void setData(List<ConsultaPagaresResDTO> data) {
//		this.data = data;
//	}
//
//
//	
//	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	





}
