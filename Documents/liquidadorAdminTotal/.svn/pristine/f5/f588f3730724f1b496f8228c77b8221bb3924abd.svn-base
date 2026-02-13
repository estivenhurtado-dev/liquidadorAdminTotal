package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

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

@Local
public interface SBConsultasFenaLocal {

	public TatComisionFenalcheque buscarComisionFenalCheque(String codigoAfiliado) throws Exception;

	public TpagareTasaInteres buscarTasaInteresPagare(String codigoAfiliado) throws Exception;

	public Double ComisionTransferenciaxProducto(String id_prod) throws Exception;

	public TatOtrasPlaza consultarOtrasPlazas() throws Exception;

	public TpagareFechasVencimiento buscarFechasVencimientoPagare() throws Exception;
	
	public TpagareMaestroLiquidacion registrarMaestro(
			TpagareMaestroLiquidacion registro) throws Exception;
	public TpagareDetalleLiquidacion registrarDetalle(
			TpagareDetalleLiquidacion registro) throws Exception;
	
	public TpagareMaestroLiquidacion buscarNumeroAprobacion(
			String numeroAprobacion) throws Exception ;
	
	public TatTempLiquidacion registrarTemporalReporteUAO(TatTempLiquidacion registro) throws Exception ;
	
	  public List<TsolicUniversidad> getAllTsolicUniversidad() throws Exception ;
	  public TsolicUniversidad consultarTsolicUniversidadPorId(BigDecimal cod) throws Exception;
	  
	public TsolicLogPreliquidacion registrarTsolicLogPreliquidacion(TsolicLogPreliquidacion registro) throws Exception;
	public TsolicLogPreliquidacion consultarTsolicLogPreliquidacion(BigDecimal cod) throws Exception ;
	public TsolicLogPreliquidacion modificarTsolicLogPreliquidacion(TsolicLogPreliquidacion registro) throws Exception ;
    public boolean validarReenvioMensaje(String numeroCelular) throws Exception;
	
	public TsolicParametrosCreLi consultarTsolicParametrosCreLiPorId(BigDecimal cod) throws Exception;
	
	   public String validarLiquidacionUniversidad(String numeroCelular) throws Exception ;
	    public boolean validarCreacionSolicitud(String numeroCelular) throws Exception ;
		public TsolicSolicitud consultarTsolicSolicitudPorId(BigDecimal cod) throws Exception;
		public TsolicSolicitud modificarTsolicSolicitud(TsolicSolicitud registro) throws Exception;
		
		public LogSendLiquidacion registrarLogSendLiquidacion(LogSendLiquidacion registro) throws Exception ;
		
		
		public DatosLiquidacion consultaDatosLiquidacion(String idSolicitud) throws Exception ;
		
}
