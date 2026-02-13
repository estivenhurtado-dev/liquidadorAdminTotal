package com.fenalcovalle.liquidadorAdminTotal.vista.delegado;



import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.fenalcovalle.estandar.modelo.utilidades.Parametros;
import com.fenalcovalle.estandar.vista.utilidades.ServiceLocator;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TconsultaReporte;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareDetalleLiquidacionpre;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareMaestroLiquidacionpre;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VBasicosVoucher;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAfiliado;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAprobacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VODetalleAprobacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session.SBConsultasOpenLocal;


@ManagedBean(value = "DNConsultasOpencard")
@ApplicationScoped
public class DNConsultasOpencard {

	SBConsultasOpenLocal sBConsultasOpenLocal;

	public DNConsultasOpencard() throws Exception {
		sBConsultasOpenLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBConsultasOpen"
						+ Parametros.PREFIJO_ADICIONAL_JNDI
						+ "SBConsultasOpenLocal",
						SBConsultasOpenLocal.class);
	}

	

	public VBasicosVoucher buscarAprobacionOpen(String numeroAprobacion,
			String afiliado, String cuotas, String valotTotal, String cedula)
			throws Exception {
		return sBConsultasOpenLocal.buscarAprobacionOpen(numeroAprobacion,
				afiliado, cuotas, valotTotal, cedula);
	}

	public VOAfiliado consultarAfiliado(String codigoAfiliado) throws Exception {
		return sBConsultasOpenLocal.consultarAfiliado(codigoAfiliado);
	}

	public VOAprobacion consultarAprobacion(String numeroAprobacion, String afiliado) throws Exception {
		return sBConsultasOpenLocal.consultarAprobacion(numeroAprobacion, afiliado);
	}

	public List<VODetalleAprobacion> consultarDetalleAprobacion(String numeroAprobacion, String codigoAfiliado)
			throws Exception {
		return sBConsultasOpenLocal.consultarDetalleAprobacion(numeroAprobacion, codigoAfiliado);
	}

	
	



	
	
	
}
