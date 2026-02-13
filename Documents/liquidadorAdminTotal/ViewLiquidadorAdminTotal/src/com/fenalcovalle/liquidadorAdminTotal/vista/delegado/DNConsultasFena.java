package com.fenalcovalle.liquidadorAdminTotal.vista.delegado;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.fenalcovalle.estandar.modelo.utilidades.Parametros;
import com.fenalcovalle.estandar.vista.utilidades.ServiceLocator;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.DatosLiquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.LogSendLiquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TatComisionFenalcheque;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TatOtrasPlaza;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TatTempLiquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareDetalleLiquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareFechasVencimiento;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareMaestroLiquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareTasaInteres;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TsolicLogPreliquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TsolicParametrosCreLi;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TsolicSolicitud;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TsolicUniversidad;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session.SBConsultasFenaLocal;

@ManagedBean(value = "DNConsultasFena")
@ApplicationScoped
public class DNConsultasFena {

	SBConsultasFenaLocal sBConsultasFenaLocal;

	public DNConsultasFena() throws Exception {
		sBConsultasFenaLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI + "SBConsultasFena"
				+ Parametros.PREFIJO_ADICIONAL_JNDI + "SBConsultasFenaLocal", SBConsultasFenaLocal.class);
	}

	public TatComisionFenalcheque buscarComisionFenalCheque(String codigoAfiliado) throws Exception {
		return sBConsultasFenaLocal.buscarComisionFenalCheque(codigoAfiliado);
	}

	public TpagareTasaInteres buscarTasaInteresPagare(String codigoAfiliado) throws Exception {
		return sBConsultasFenaLocal.buscarTasaInteresPagare(codigoAfiliado);
	}

	public Double ComisionTransferenciaxProducto(String id_prod) throws Exception {
		return sBConsultasFenaLocal.ComisionTransferenciaxProducto(id_prod);
	}

	public TatOtrasPlaza consultarOtrasPlazas() throws Exception {
		return sBConsultasFenaLocal.consultarOtrasPlazas();
	}

	public TpagareFechasVencimiento buscarFechasVencimientoPagare() throws Exception {
		return sBConsultasFenaLocal.buscarFechasVencimientoPagare();
	}

	public TpagareMaestroLiquidacion registrarMaestro(TpagareMaestroLiquidacion registro) throws Exception {
		return sBConsultasFenaLocal.registrarMaestro(registro);
	}

	public TpagareDetalleLiquidacion registrarDetalle(TpagareDetalleLiquidacion registro) throws Exception {
		return sBConsultasFenaLocal.registrarDetalle(registro);
	}

	public TpagareMaestroLiquidacion buscarNumeroAprobacion(String numeroAprobacion) throws Exception {
		return sBConsultasFenaLocal.buscarNumeroAprobacion(numeroAprobacion);
	}

	public TatTempLiquidacion registrarTemporalReporteUAO(TatTempLiquidacion registro) throws Exception {
		return sBConsultasFenaLocal.registrarTemporalReporteUAO(registro);
	}

	public List<TsolicUniversidad> getAllTsolicUniversidad() throws Exception {
		return sBConsultasFenaLocal.getAllTsolicUniversidad();
	}

	public TsolicUniversidad consultarTsolicUniversidadPorId(BigDecimal cod) throws Exception {
		return sBConsultasFenaLocal.consultarTsolicUniversidadPorId(cod);
	}

	public TsolicLogPreliquidacion registrarTsolicLogPreliquidacion(TsolicLogPreliquidacion registro) throws Exception {
		return sBConsultasFenaLocal.registrarTsolicLogPreliquidacion(registro);
	}

	public boolean validarReenvioMensaje(String numeroCelular) throws Exception {
		return sBConsultasFenaLocal.validarReenvioMensaje(numeroCelular);
	}

	public TsolicParametrosCreLi consultarTsolicParametrosCreLiPorId(BigDecimal cod) throws Exception {
		return sBConsultasFenaLocal.consultarTsolicParametrosCreLiPorId(cod);
	}

	public String validarLiquidacionUniversidad(String numeroCelular) throws Exception {
		return sBConsultasFenaLocal.validarLiquidacionUniversidad(numeroCelular);
	}

	public boolean validarCreacionSolicitud(String numeroCelular) throws Exception {
		return sBConsultasFenaLocal.validarCreacionSolicitud(numeroCelular);
	}

	public TsolicLogPreliquidacion consultarTsolicLogPreliquidacion(BigDecimal cod) throws Exception {
		return sBConsultasFenaLocal.consultarTsolicLogPreliquidacion(cod);
	}

	public TsolicLogPreliquidacion modificarTsolicLogPreliquidacion(TsolicLogPreliquidacion registro) throws Exception {
		return sBConsultasFenaLocal.modificarTsolicLogPreliquidacion(registro);
	}

	public TsolicSolicitud consultarTsolicSolicitudPorId(BigDecimal cod) throws Exception {
		return sBConsultasFenaLocal.consultarTsolicSolicitudPorId(cod);
	}

	public TsolicSolicitud modificarTsolicSolicitud(TsolicSolicitud registro) throws Exception {
		return sBConsultasFenaLocal.modificarTsolicSolicitud(registro);
	}

	public LogSendLiquidacion registrarLogSendLiquidacion(LogSendLiquidacion registro) throws Exception {
		return sBConsultasFenaLocal.registrarLogSendLiquidacion(registro);
	}

	public DatosLiquidacion consultaDatosLiquidacion(String idSolicitud) throws Exception {
		return sBConsultasFenaLocal.consultaDatosLiquidacion(idSolicitud);
	}

	
	
	

	
	
}
