package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TPAGARE_MAESTRO_LIQUIDACION database table.
 * 
 */
@Entity
@Table(name="TPAGARE_MAESTRO_LIQUIDACION")
@NamedQuery(name="TpagareMaestroLiquidacion.findAll", query="SELECT t FROM TpagareMaestroLiquidacion t")
public class TpagareMaestroLiquidacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MALI")
   // @SequenceGenerator(name="SEC_MALI_GENERATOR", sequenceName="SEC_MALI",allocationSize=1)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEC_MALI_GENERATOR")
	private String idMali;

	private String afiliado;

	private String atributo1;

	private String atributo10;

	private String atributo2;

	private String atributo3;

	private String atributo4;

	private String atributo5;

	private String atributo6;

	private String atributo7;

	private String atributo8;

	private String atributo9;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="ID_PROD")
	private String idProd;

	@Column(name="NUMERO_APROBACION")
	private String numeroAprobacion;

	private String referencia1;

	private String referencia10;

	@Temporal(TemporalType.DATE)
	private Date referencia11;

	@Temporal(TemporalType.DATE)
	private Date referencia12;

	@Temporal(TemporalType.DATE)
	private Date referencia13;

	@Temporal(TemporalType.DATE)
	private Date referencia14;

	private String referencia2;

	private String referencia3;

	private String referencia4;

	private String referencia5;

	private String referencia6;

	private String referencia7;

	private String referencia8;

	private String referencia9;

	private String rsecod;

	private String seccional;

	private String sucursal;

	@Column(name="TASA_INTERES")
	private String tasaInteres;

	@Column(name="TOTAL_NEGOCIO")
	private String totalNegocio;

	private String usuario;

	
	
	
	@Column(name="SEGURO")
	private String seguro;
	
	
	@Column(name="CREDITO_SEGURO")
	private String creditoSeguro;
	
	
	@Column(name="VALOR_VEHICULO")
	private String valorVehiculo;
	
	
	
	
	public TpagareMaestroLiquidacion() {
	}


	
	

	public String getIdMali() {
		return idMali;
	}





	public void setIdMali(String idMali) {
		this.idMali = idMali;
	}





	public String getAfiliado() {
		return this.afiliado;
	}

	public void setAfiliado(String afiliado) {
		this.afiliado = afiliado;
	}

	public String getAtributo1() {
		return this.atributo1;
	}

	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	public String getAtributo10() {
		return this.atributo10;
	}

	public void setAtributo10(String atributo10) {
		this.atributo10 = atributo10;
	}

	public String getAtributo2() {
		return this.atributo2;
	}

	public void setAtributo2(String atributo2) {
		this.atributo2 = atributo2;
	}

	public String getAtributo3() {
		return this.atributo3;
	}

	public void setAtributo3(String atributo3) {
		this.atributo3 = atributo3;
	}

	public String getAtributo4() {
		return this.atributo4;
	}

	public void setAtributo4(String atributo4) {
		this.atributo4 = atributo4;
	}

	public String getAtributo5() {
		return this.atributo5;
	}

	public void setAtributo5(String atributo5) {
		this.atributo5 = atributo5;
	}

	public String getAtributo6() {
		return this.atributo6;
	}

	public void setAtributo6(String atributo6) {
		this.atributo6 = atributo6;
	}

	public String getAtributo7() {
		return this.atributo7;
	}

	public void setAtributo7(String atributo7) {
		this.atributo7 = atributo7;
	}

	public String getAtributo8() {
		return this.atributo8;
	}

	public void setAtributo8(String atributo8) {
		this.atributo8 = atributo8;
	}

	public String getAtributo9() {
		return this.atributo9;
	}

	public void setAtributo9(String atributo9) {
		this.atributo9 = atributo9;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIdProd() {
		return this.idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public String getNumeroAprobacion() {
		return this.numeroAprobacion;
	}

	public void setNumeroAprobacion(String numeroAprobacion) {
		this.numeroAprobacion = numeroAprobacion;
	}

	public String getReferencia1() {
		return this.referencia1;
	}

	public void setReferencia1(String referencia1) {
		this.referencia1 = referencia1;
	}

	public String getReferencia10() {
		return this.referencia10;
	}

	public void setReferencia10(String referencia10) {
		this.referencia10 = referencia10;
	}

	public Date getReferencia11() {
		return this.referencia11;
	}

	public void setReferencia11(Date referencia11) {
		this.referencia11 = referencia11;
	}

	public Date getReferencia12() {
		return this.referencia12;
	}

	public void setReferencia12(Date referencia12) {
		this.referencia12 = referencia12;
	}

	public Date getReferencia13() {
		return this.referencia13;
	}

	public void setReferencia13(Date referencia13) {
		this.referencia13 = referencia13;
	}

	public Date getReferencia14() {
		return this.referencia14;
	}

	public void setReferencia14(Date referencia14) {
		this.referencia14 = referencia14;
	}

	public String getReferencia2() {
		return this.referencia2;
	}

	public void setReferencia2(String referencia2) {
		this.referencia2 = referencia2;
	}

	public String getReferencia3() {
		return this.referencia3;
	}

	public void setReferencia3(String referencia3) {
		this.referencia3 = referencia3;
	}

	public String getReferencia4() {
		return this.referencia4;
	}

	public void setReferencia4(String referencia4) {
		this.referencia4 = referencia4;
	}

	public String getReferencia5() {
		return this.referencia5;
	}

	public void setReferencia5(String referencia5) {
		this.referencia5 = referencia5;
	}

	public String getReferencia6() {
		return this.referencia6;
	}

	public void setReferencia6(String referencia6) {
		this.referencia6 = referencia6;
	}

	public String getReferencia7() {
		return this.referencia7;
	}

	public void setReferencia7(String referencia7) {
		this.referencia7 = referencia7;
	}

	public String getReferencia8() {
		return this.referencia8;
	}

	public void setReferencia8(String referencia8) {
		this.referencia8 = referencia8;
	}

	public String getReferencia9() {
		return this.referencia9;
	}

	public void setReferencia9(String referencia9) {
		this.referencia9 = referencia9;
	}

	public String getRsecod() {
		return this.rsecod;
	}

	public void setRsecod(String rsecod) {
		this.rsecod = rsecod;
	}

	public String getSeccional() {
		return this.seccional;
	}

	public void setSeccional(String seccional) {
		this.seccional = seccional;
	}

	public String getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getTasaInteres() {
		return this.tasaInteres;
	}

	public void setTasaInteres(String tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	public String getSeguro() {
		return seguro;
	}





	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}





	public String getCreditoSeguro() {
		return creditoSeguro;
	}





	public void setCreditoSeguro(String creditoSeguro) {
		this.creditoSeguro = creditoSeguro;
	}





	public String getValorVehiculo() {
		return valorVehiculo;
	}





	public void setValorVehiculo(String valorVehiculo) {
		this.valorVehiculo = valorVehiculo;
	}





	public String getTotalNegocio() {
		return this.totalNegocio;
	}

	public void setTotalNegocio(String totalNegocio) {
		this.totalNegocio = totalNegocio;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "TpagareMaestroLiquidacionpre [idMali=" + idMali + ", afiliado="
				+ afiliado + ", atributo1=" + atributo1 + ", atributo10="
				+ atributo10 + ", atributo2=" + atributo2 + ", atributo3="
				+ atributo3 + ", atributo4=" + atributo4 + ", atributo5="
				+ atributo5 + ", atributo6=" + atributo6 + ", atributo7="
				+ atributo7 + ", atributo8=" + atributo8 + ", atributo9="
				+ atributo9 + ", fecha=" + fecha + ", idProd=" + idProd
				+ ", numeroAprobacion=" + numeroAprobacion + ", referencia1="
				+ referencia1 + ", referencia10=" + referencia10
				+ ", referencia11=" + referencia11 + ", referencia12="
				+ referencia12 + ", referencia13=" + referencia13
				+ ", referencia14=" + referencia14 + ", referencia2="
				+ referencia2 + ", referencia3=" + referencia3
				+ ", referencia4=" + referencia4 + ", referencia5="
				+ referencia5 + ", referencia6=" + referencia6
				+ ", referencia7=" + referencia7 + ", referencia8="
				+ referencia8 + ", referencia9=" + referencia9 + ", rsecod="
				+ rsecod + ", seccional=" + seccional + ", sucursal="
				+ sucursal + ", tasaInteres=" + tasaInteres + ", totalNegocio="
				+ totalNegocio + ", usuario=" + usuario + "]";
	}
	
	

}