package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.fenalcovalle.estandar.modelo.ejb.session.SBFacadeLiquidadorAdminTotalLocal;
import com.fenalcovalle.estandar.modelo.utilidades.Parametros;
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

/**
 * Session Bean implementation class SBTatComisionFenalcheque
 */
@Stateless
@LocalBean
public class SBConsultasFena implements SBConsultasFenaLocal {

	/**
	 * Default constructor.
	 */
	public SBConsultasFena() {
		// TODO Auto-generated constructor stub
	}

	@EJB
	SBFacadeLiquidadorAdminTotalLocal sbFacadeFena;

	@Override
	public TatComisionFenalcheque buscarComisionFenalCheque(String codigoAfiliado) throws Exception {

		TatComisionFenalcheque tempTatComisionFenalcheque = null;
		Date fechaHoy = new Date();

		String query = "select ID_TCFC , VALOR, FONDO_SOLIDARIDAD, TASA_PREFERENCIAL,COMISION,CODIGO_BARRAS "
				+ "FROM TAT_COMISION_FENALCHEQUE WHERE " + "TAT_COMISION_FENALCHEQUE.CODIGO_AFILIADO = ?1"
				+ "  AND TRUNC(TAT_COMISION_FENALCHEQUE.FECHA_DESDE) <= TRUNC(SYSDATE) "
				+ "AND TRUNC(TAT_COMISION_FENALCHEQUE.FECHA_HASTA) >= TRUNC(SYSDATE) ";

		HashMap parametros = new HashMap();
		parametros.put("1", codigoAfiliado);
		//System.out.println("query " + query + "\n" + "parametros: " + codigoAfiliado);
		List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, parametros);
		TatComisionFenalcheque vo = null;

		for (int i = 0; i < registrosList.size(); i++) {

			vo = new TatComisionFenalcheque();

			vo.setIdTcfc(registrosList.get(i)[0] + "");
			vo.setValor(registrosList.get(i)[1] + "");
			vo.setFondoSolidaridad(registrosList.get(i)[2] + "");
			vo.setTasaPreferencial(registrosList.get(i)[3] + "");
			vo.setComision(registrosList.get(i)[4] + "");
			vo.setCodigoBarras(registrosList.get(i)[5] + "");
		}

		return vo;
	}

	@Override
	public TpagareTasaInteres buscarTasaInteresPagare(String codigoAfiliado) throws Exception {

		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		TatComisionFenalcheque tempTatComisionFenalcheque = null;
		Date fechaHoy = new Date();

		String query = "SELECT ID_TAIN, VALOR,CODIGO_AFILIADO from TPAGARE_TASA_INTERES WHERE" + " CODIGO_AFILIADO =?1 "
				+ "AND TRUNC(FECHA_DESDE) <= TRUNC(SYSDATE) AND TRUNC(FECHA_HASTA) >= TRUNC(SYSDATE)";

		HashMap parametros = new HashMap();
		parametros.put("1", codigoAfiliado);
	//	System.out.println("query " + query + "\n" + "parametros: " + codigoAfiliado);
		List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, parametros);
		TpagareTasaInteres vo = null;

		for (int i = 0; i < registrosList.size(); i++) {
			vo = new TpagareTasaInteres();
			vo.setId_tain(registrosList.get(i)[0] + "");
			vo.setValor(registrosList.get(i)[1] + "");
			vo.setCodigoAfiliado(registrosList.get(i)[2] + "");
		}

		return vo;
	}

	@Override
	public Double ComisionTransferenciaxProducto(String id_prod) throws Exception {
		Statement statement = null;
		Double comision = 0.0;
		String query = "SELECT COMISION_TRANSFERENCIA FROM FENA.TPRODUCTOS_DE_CREDITO WHERE ID_PRODUCTO= ?1";

		HashMap parametros = new HashMap();
		parametros.put("1", id_prod);

		//System.out.println("query " + query + "\n" + "parametros: " + id_prod);

		List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, parametros);

		for (int i = 0; i < registrosList.size(); i++) {
			comision = Double.parseDouble(registrosList.get(i) + "");
		}

		return comision;
	}

	@Override
	public TatOtrasPlaza consultarOtrasPlazas() throws Exception {
		// Validamos que no exista una campa�a con el mismo nombre
		String query = "select o  from TatOtrasPlaza o where o.idOtpl= :id";
		HashMap parametros = new HashMap();
		parametros.put("id", "1");

		TatOtrasPlaza entity = null;
		List<TatOtrasPlaza> TatOtrasPlazas = sbFacadeFena.executeQuery(query, parametros);
		if (TatOtrasPlazas != null && TatOtrasPlazas.size() > 0) {
			entity = TatOtrasPlazas.get(0);
		}

		return entity;
	}

	@Override
	public TpagareFechasVencimiento buscarFechasVencimientoPagare() throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		String query = "SELECT to_char(FECHA_VENCIMIENTO,'dd/MM/yyyy') as fec FROM TPAGARE_FECHAS_VENCIMIENTO WHERE TRUNC(FECHA_DESDE)<=TRUNC(SYSDATE)"
				+ " AND TRUNC(FECHA_HASTA) >=TRUNC(SYSDATE)";

	//	System.out.println("query " + query + "\n");
		List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, null);
		TpagareFechasVencimiento vo = null;

		for (int i = 0; i < registrosList.size(); i++) {

			vo = new TpagareFechasVencimiento();

			Date fec = df.parse((registrosList.get(i) + "").replace(" 00:00:00.0", ""));
			vo.setFechaVencimiento(fec);

		}

		return vo;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public TpagareMaestroLiquidacion registrarMaestro(TpagareMaestroLiquidacion registro) throws Exception {

		// System.out.println(registro.toString());

		TpagareMaestroLiquidacion entity = (TpagareMaestroLiquidacion) sbFacadeFena.insertEntity(registro);

		entity.setIdMali(maximoId());
		return entity;

	}

	@Override
	public TpagareDetalleLiquidacion registrarDetalle(TpagareDetalleLiquidacion registro) throws Exception {
		// TODO Auto-generated method stub
		TpagareDetalleLiquidacion entity = (TpagareDetalleLiquidacion) sbFacadeFena.insertEntity(registro);

		return entity;
	}
	
	
	@Override
	public TatTempLiquidacion registrarTemporalReporteUAO(TatTempLiquidacion registro) throws Exception {
		// TODO Auto-generated method stub
		TatTempLiquidacion entity = (TatTempLiquidacion) sbFacadeFena.insertEntity(registro);

		return entity;
	}
	

	public String maximoId() throws Exception {

		String retorna = "";
		String query = "select max(ID_MALI) from TPAGARE_MAESTRO_LIQUIDACION  ";

		List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, null);

		if (registrosList.size() > 0) {
			retorna = registrosList.get(0) + "";
		}

		return retorna;

	}

	@Override
	public TpagareMaestroLiquidacion buscarNumeroAprobacion(String numeroAprobacion) throws Exception {

		TpagareMaestroLiquidacion tempTpagareMaestroLiquidacion = null;

		String query = "SELECT ID_MALI,NUMERO_APROBACION FROM TPAGARE_MAESTRO_LIQUIDACION TpagareMaestroLiquidacion WHERE NUMERO_APROBACION=?1";
		HashMap parametros = new HashMap();
		parametros.put("1", numeroAprobacion);
		//System.out.println("query " + query + "\n" + "parametros: " + numeroAprobacion);
		List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, parametros);
		TpagareMaestroLiquidacion vo = null;

		for (int i = 0; i < registrosList.size(); i++) {

			vo = new TpagareMaestroLiquidacion();

			vo.setIdMali(registrosList.get(i)[0] + "");
			vo.setNumeroAprobacion(registrosList.get(i)[1] + "");

			

		}
		return vo;

	}
	
	
	@Override
    public List<TsolicUniversidad> getAllTsolicUniversidad() throws Exception {
    	
    	TsolicUniversidad tsolicUniversidadEntity = null;
    	List<TsolicUniversidad> listTsolicUniversidad = new ArrayList<TsolicUniversidad>();
    	
    	String query = "SELECT CODIGO, NOMBRE FROM FDC01.TSOLIC_UNIVERSIDADES WHERE ACTIVO='S'";
    	
    	
    	HashMap parametros = new HashMap();
    	
  
    	List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, parametros);
   

    for (int i = 0; i < registrosList.size(); i++) {
    	tsolicUniversidadEntity= new TsolicUniversidad();    	
    	tsolicUniversidadEntity.setCodigo((new BigDecimal(registrosList.get(i)[0]+ "") ));
    	
    	tsolicUniversidadEntity.setNombre(registrosList.get(i)[1] + "");
    	listTsolicUniversidad.add(tsolicUniversidadEntity);
	}
    	
    	return listTsolicUniversidad;
    }
	
	public TsolicUniversidad consultarTsolicUniversidadPorId(BigDecimal cod) throws Exception {

		TsolicUniversidad usuario = (TsolicUniversidad) sbFacadeFena.findByPrimaryKey(TsolicUniversidad.class, cod);
		// sbFacadeConsolaLocal.refresh(TbmUsuarios.class);
	
		return usuario;
	}
	
	@Override
	public TsolicLogPreliquidacion registrarTsolicLogPreliquidacion(TsolicLogPreliquidacion registro) throws Exception {
		// TODO Auto-generated method stub
		TsolicLogPreliquidacion entity = (TsolicLogPreliquidacion) sbFacadeFena.insertEntity(registro);

		return entity;
	}
	
	
	
	
	@Override
	public TsolicLogPreliquidacion consultarTsolicLogPreliquidacion(BigDecimal cod) throws Exception {
		// TODO Auto-generated method stub
		TsolicLogPreliquidacion entity = (TsolicLogPreliquidacion) sbFacadeFena.findByPrimaryKey(TsolicLogPreliquidacion.class, cod);

		return entity;
	}
	
	
	@Override
	public TsolicLogPreliquidacion modificarTsolicLogPreliquidacion(TsolicLogPreliquidacion registro) throws Exception {
		// TODO Auto-generated method stub
		TsolicLogPreliquidacion entity = (TsolicLogPreliquidacion) sbFacadeFena.updateEntity(registro);

		return entity;
	}
	
	
	
	
	@Override	
    public boolean validarReenvioMensaje(String numeroCelular) throws Exception {
    	
		boolean respuesta =true;
		sbFacadeFena.clear();
    	TsolicUniversidad tsolicUniversidadEntity = null;
    	List<TsolicUniversidad> listTsolicUniversidad = new ArrayList<TsolicUniversidad>();
    	
    	String query = "SELECT \r\n" + 
    			"((TO_CHAR(SYSDATE,'HH24')*60) + TO_CHAR(SYSDATE,'MI') )-\r\n" + 
    			"(EXTRACT(hour  FROM FECHA)*60 +EXTRACT(minute  FROM FECHA) ),\r\n" + 
    			"(select valor from tsolic_parametros_cre_li where id="+Parametros.MINUTOS_REENVIO_MENSAJE+")\r\n" + 
    			"FROM FDC01.tsolic_log_preliquidacion WHERE ID=(SELECT max(id) FROM FDC01.tsolic_log_preliquidacion where celular='"+numeroCelular+"')";
    	
    	
    	HashMap parametros = new HashMap();
    	
  
    	List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, parametros);
   

    	
    	int minutosTrasncurrios=0;
    	int minutosLimite=0;
    	if (registrosList.size()>0) {
			
    		minutosTrasncurrios=Integer.parseInt(registrosList.get(0)[0]+ "");
    		minutosLimite=Integer.parseInt(registrosList.get(0)[1]+ "");
    		
    	
    		if (minutosTrasncurrios>=0) {

        	
    		if (minutosTrasncurrios<minutosLimite) {
    			
				respuesta=false;
			}
    		
				
			}
    		
    		
    		
		}
    	
    	
    	
    	
 
    	return respuesta;
    }
	
	
	
	public TsolicParametrosCreLi consultarTsolicParametrosCreLiPorId(BigDecimal cod) throws Exception {

		TsolicParametrosCreLi entity = (TsolicParametrosCreLi) sbFacadeFena.findByPrimaryKey(TsolicParametrosCreLi.class, cod);
		// sbFacadeConsolaLocal.refresh(TbmUsuarios.class);
	
		return entity;
	}
	
	
	
	
	@Override
    public String validarLiquidacionUniversidad(String numeroCelular) throws Exception {
    	
		String respuesta =null;
		
    	TsolicUniversidad tsolicUniversidadEntity = null;
    	List<TsolicUniversidad> listTsolicUniversidad = new ArrayList<TsolicUniversidad>();
    	
    	String query = "select DISTINCT codigo_institucion,id from \r\n" + 
    			"FDC01.tsolic_log_preliquidacion where celular='"+numeroCelular+"' and   fecha > SYSTIMESTAMP-(select valor from TSOLIC_PARAMETROS_CRE_LI where id="+Parametros.DIAS_LIQUIDACION+")";
    	
    	
    	HashMap parametros = new HashMap();
    	
  
    	List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, parametros);
   

    	
    	
    	if (registrosList.size()>0) {
			
    		respuesta=(registrosList.get(0)[0]+ "");
    		
    		
		}
    	
    	
    	
    	
 
    	return respuesta;
    }
	
	

	
	@Override
    public boolean validarCreacionSolicitud(String numeroCelular) throws Exception {
    	
		boolean respuesta =true;
		
    	TsolicUniversidad tsolicUniversidadEntity = null;
    	List<TsolicUniversidad> listTsolicUniversidad = new ArrayList<TsolicUniversidad>();
    	
    	String query = "select ID_SOLICITUD, FECHA_CREACION from FDC01.tsolic_solicitud where FECHA_CREACION>  SYSTIMESTAMP-(select valor from TSOLIC_PARAMETROS_CRE_LI where id="+Parametros.DIAS_CREACION_SOLICITUDES+")\r\n" + 
    			"	and producto=66 and celular_dc='"+numeroCelular+"'";
    	
    	
    	HashMap parametros = new HashMap();
    	
  
    	List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, parametros);
   

    	
    	if (registrosList.size()>0) {
			
    		respuesta=false;
    		
    		
		}
    	
    	
    	
    	
 
    	return respuesta;
    }
	
	public TsolicSolicitud consultarTsolicSolicitudPorId(BigDecimal cod) throws Exception {

		TsolicSolicitud entity = (TsolicSolicitud) sbFacadeFena.findByPrimaryKey(TsolicSolicitud.class, cod);
		// sbFacadeConsolaLocal.refresh(TbmUsuarios.class);
	
		return entity;
	}
	
	
	
	@Override
	public TsolicSolicitud modificarTsolicSolicitud(TsolicSolicitud registro) throws Exception {
		// TODO Auto-generated method stub
		TsolicSolicitud entity = (TsolicSolicitud) sbFacadeFena.updateEntity(registro);

		return entity;
	}
	
	



	@Override
	public LogSendLiquidacion registrarLogSendLiquidacion(LogSendLiquidacion registro) throws Exception {
		// TODO Auto-generated method stub
		LogSendLiquidacion entity = (LogSendLiquidacion) sbFacadeFena.insertEntity(registro);

		return entity;
	}


	@Override
	public DatosLiquidacion consultaDatosLiquidacion(String idSolicitud) throws Exception {
		// TODO Auto-generated method stub
		String query = "SELECT tg.tipdoc ,tg.email FROM FDC01.TSOLIC_SOLICITUD ts , FDC01.TSOLIC_GIRADOR tg \r\n" + 
				"WHERE ts.GIRADOR =tg.cedula\r\n" + 
				"AND ts.ID_SOLICITUD ='"+idSolicitud+"'";

		HashMap parametros = new HashMap();
		List<Object[]> registrosList = sbFacadeFena.executeNativeQuery(query, null);
		DatosLiquidacion vo = null;
		if (registrosList.size() > 0) {
			vo = new DatosLiquidacion();
			vo.setTipoDoc(registrosList.get(0)[0] + "");
			vo.setCorreo(registrosList.get(0)[1] + "");
		}
		return vo;
	}
	

}
