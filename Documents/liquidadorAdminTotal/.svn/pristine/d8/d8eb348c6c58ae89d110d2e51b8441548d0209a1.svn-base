package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TAT_TEMP_LIQUIDACION database table.
 * 
 */
@Entity
@Table(name="TAT_TEMP_LIQUIDACION")
@NamedQuery(name="TatTempLiquidacion.findAll", query="SELECT t FROM TatTempLiquidacion t")
public class TatTempLiquidacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MALI")
	private String idMali;

	private String afiliado;

	public TatTempLiquidacion() {
	}

	public String getIdMali() {
		return idMali;
	}

	public void setIdMali(String idMali) {
		this.idMali = idMali;
	}

	public String getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(String afiliado) {
		this.afiliado = afiliado;
	}



}