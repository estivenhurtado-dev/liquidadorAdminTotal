package com.fenalcovalle.liquidadorAdminTotal.vista.delegado;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.fenalcovalle.estandar.modelo.utilidades.Parametros;
import com.fenalcovalle.estandar.vista.utilidades.ServiceLocator;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TconsultaReporte;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareDetalleLiquidacionpre;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareMaestroLiquidacionpre;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VBasicosVoucher;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAfiliado;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session.SBConsultasAS400Local;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session.SBConsultasOpenLocal;


@ManagedBean(value = "DNConsultasAS400")
@ApplicationScoped
public class DNConsultasAS400 {

	SBConsultasAS400Local sBConsultasAS400Local;

	public DNConsultasAS400() throws Exception {
		sBConsultasAS400Local = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI
				+ "SBConsultasAS400" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBConsultasAS400Local",
				SBConsultasAS400Local.class);
	}

	public VOAfiliado consultarAfiliadoCupo(String aficodscc, String aficon, String afinumsuc) throws Exception {
		return sBConsultasAS400Local.consultarAfiliadoCupo(aficodscc, aficon, afinumsuc);
	}
	

}
