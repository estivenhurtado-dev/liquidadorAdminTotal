package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TPAGARE_DETALLE_LIQUIDACIONPRE database table.
 * 
 */
@Entity
@Table(name="TPAGARE_DETALLE_LIQUIDACIONPRE")
@NamedQuery(name="TpagareDetalleLiquidacionpre.findAll", query="SELECT t FROM TpagareDetalleLiquidacionpre t")
public class TpagareDetalleLiquidacionpre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MALI")
	private String idMali;

	
	@Column(name="NUMERO_CUOTA")
	private String numCuota;
	
	
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


	@Column(name="FECHA_VENCIMIENTO")
	private String fechaVencimiento;

	@Column(name="NUMERO_PAGARE")
	private String numeroPagare;

	private String referencia1;

	private String referencia10;

	@Temporal(TemporalType.DATE)
	private Date  referencia11;

	@Temporal(TemporalType.DATE)
	private Date  referencia12;

	@Temporal(TemporalType.DATE)
	private Date  referencia13;

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

	@Column(name="SALDO_CAPITAL")
	private String saldoCapital;

	@Column(name="VALOR_CAPITAL")
	private String valorCapital;

	@Column(name="VALOR_CUOTA")
	private String valorCuota;

	@Column(name="VALOR_INTERES")
	private String valorInteres;

	public TpagareDetalleLiquidacionpre() {
	}

	public String getIdMali() {
		return idMali;
	}

	public void setIdMali(String idMali) {
		this.idMali = idMali;
	}

	public String getNumCuota() {
		return numCuota;
	}

	public void setNumCuota(String numCuota) {
		this.numCuota = numCuota;
	}

	public String getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	public String getAtributo10() {
		return atributo10;
	}

	public void setAtributo10(String atributo10) {
		this.atributo10 = atributo10;
	}

	public String getAtributo2() {
		return atributo2;
	}

	public void setAtributo2(String atributo2) {
		this.atributo2 = atributo2;
	}

	public String getAtributo3() {
		return atributo3;
	}

	public void setAtributo3(String atributo3) {
		this.atributo3 = atributo3;
	}

	public String getAtributo4() {
		return atributo4;
	}

	public void setAtributo4(String atributo4) {
		this.atributo4 = atributo4;
	}

	public String getAtributo5() {
		return atributo5;
	}

	public void setAtributo5(String atributo5) {
		this.atributo5 = atributo5;
	}

	public String getAtributo6() {
		return atributo6;
	}

	public void setAtributo6(String atributo6) {
		this.atributo6 = atributo6;
	}

	public String getAtributo7() {
		return atributo7;
	}

	public void setAtributo7(String atributo7) {
		this.atributo7 = atributo7;
	}

	public String getAtributo8() {
		return atributo8;
	}

	public void setAtributo8(String atributo8) {
		this.atributo8 = atributo8;
	}

	public String getAtributo9() {
		return atributo9;
	}

	public void setAtributo9(String atributo9) {
		this.atributo9 = atributo9;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNumeroPagare() {
		return numeroPagare;
	}

	public void setNumeroPagare(String numeroPagare) {
		this.numeroPagare = numeroPagare;
	}

	public String getReferencia1() {
		return referencia1;
	}

	public void setReferencia1(String referencia1) {
		this.referencia1 = referencia1;
	}

	public String getReferencia10() {
		return referencia10;
	}

	public void setReferencia10(String referencia10) {
		this.referencia10 = referencia10;
	}

	
	
	

	
	
	
	public Date getReferencia11() {
		return referencia11;
	}

	public void setReferencia11(Date referencia11) {
		this.referencia11 = referencia11;
	}

	public Date getReferencia12() {
		return referencia12;
	}

	public void setReferencia12(Date referencia12) {
		this.referencia12 = referencia12;
	}

	public Date getReferencia13() {
		return referencia13;
	}

	public void setReferencia13(Date referencia13) {
		this.referencia13 = referencia13;
	}

	public Date getReferencia14() {
		return referencia14;
	}

	public void setReferencia14(Date referencia14) {
		this.referencia14 = referencia14;
	}

	public String getReferencia2() {
		return referencia2;
	}

	public void setReferencia2(String referencia2) {
		this.referencia2 = referencia2;
	}

	public String getReferencia3() {
		return referencia3;
	}

	public void setReferencia3(String referencia3) {
		this.referencia3 = referencia3;
	}

	public String getReferencia4() {
		return referencia4;
	}

	public void setReferencia4(String referencia4) {
		this.referencia4 = referencia4;
	}

	public String getReferencia5() {
		return referencia5;
	}

	public void setReferencia5(String referencia5) {
		this.referencia5 = referencia5;
	}

	public String getReferencia6() {
		return referencia6;
	}

	public void setReferencia6(String referencia6) {
		this.referencia6 = referencia6;
	}

	public String getReferencia7() {
		return referencia7;
	}

	public void setReferencia7(String referencia7) {
		this.referencia7 = referencia7;
	}

	public String getReferencia8() {
		return referencia8;
	}

	public void setReferencia8(String referencia8) {
		this.referencia8 = referencia8;
	}

	public String getReferencia9() {
		return referencia9;
	}

	public void setReferencia9(String referencia9) {
		this.referencia9 = referencia9;
	}

	public String getSaldoCapital() {
		return saldoCapital;
	}

	public void setSaldoCapital(String saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	public String getValorCapital() {
		return valorCapital;
	}

	public void setValorCapital(String valorCapital) {
		this.valorCapital = valorCapital;
	}

	public String getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(String valorCuota) {
		this.valorCuota = valorCuota;
	}

	public String getValorInteres() {
		return valorInteres;
	}

	public void setValorInteres(String valorInteres) {
		this.valorInteres = valorInteres;
	}

	@Override
	public String toString() {
		return "TpagareDetalleLiquidacionpre [idMali=" + idMali + ", numCuota="
				+ numCuota + ", atributo1=" + atributo1 + ", atributo10="
				+ atributo10 + ", atributo2=" + atributo2 + ", atributo3="
				+ atributo3 + ", atributo4=" + atributo4 + ", atributo5="
				+ atributo5 + ", atributo6=" + atributo6 + ", atributo7="
				+ atributo7 + ", atributo8=" + atributo8 + ", atributo9="
				+ atributo9 + ", fechaVencimiento=" + fechaVencimiento
				+ ", numeroPagare=" + numeroPagare + ", referencia1="
				+ referencia1 + ", referencia10=" + referencia10
				+ ", referencia11=" + referencia11 + ", referencia12="
				+ referencia12 + ", referencia13=" + referencia13
				+ ", referencia14=" + referencia14 + ", referencia2="
				+ referencia2 + ", referencia3=" + referencia3
				+ ", referencia4=" + referencia4 + ", referencia5="
				+ referencia5 + ", referencia6=" + referencia6
				+ ", referencia7=" + referencia7 + ", referencia8="
				+ referencia8 + ", referencia9=" + referencia9
				+ ", saldoCapital=" + saldoCapital + ", valorCapital="
				+ valorCapital + ", valorCuota=" + valorCuota
				+ ", valorInteres=" + valorInteres + "]";
	}

	
	
	
	
	
	

}