package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TconsultaReporte;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VBasicosVoucher;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAfiliado;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAprobacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VODetalleAprobacion;

@Local
public interface SBConsultasOpenLocal {

	

	
	
	public VBasicosVoucher buscarAprobacionOpen(String numeroAprobacion,String afiliado,String cuotas, 
			String valotTotal, String cedula) throws Exception;
	
	
	public  VOAfiliado consultarAfiliado(String codigoAfiliado) throws Exception;
	
	public VOAprobacion  consultarAprobacion(String numeroAprobacion,String afiliado) throws Exception;
	
	
	public List<VODetalleAprobacion> consultarDetalleAprobacion(String numeroAprobacion, String codigoAfiliado)
			throws Exception; 
	
}
