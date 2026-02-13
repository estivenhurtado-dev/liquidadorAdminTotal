package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.fenalcovalle.estandar.modelo.ejb.session.SBFacadeLiquidadorAdminTotalAS400Local;
import com.fenalcovalle.estandar.modelo.ejb.session.SBFacadeLiquidadorAdminTotalOpenLocal;
import com.fenalcovalle.estandar.modelo.utilidades.UtilidadesModel;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TconsultaReporte;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareTasaInteres;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VBasicosClienteCodeudor;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VBasicosVoucher;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAfiliado;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAprobacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VODetalleAprobacion;

/**
 * Session Bean implementation class SBConsultasOpen
 */
@Stateless
@LocalBean
public class SBConsultasOpen implements SBConsultasOpenLocal {

	/**
	 * Default constructor.
	 */
	@EJB
	SBFacadeLiquidadorAdminTotalOpenLocal sbFacadeOpen;

	public SBConsultasOpen() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public VOAprobacion consultarAprobacion(String numeroAprobacion, String codigoAfiliado) throws Exception {

		String query = "select " + "trunc(v.CEDULA_CLIENTE),"
				+ "v.NOMBRE1_CLIENTE ||' '|| v.NOMBRE2_CLIENTE ||' '|| v.APELLIDO1_CLIENTE ||' '||v.APELLIDO2_CLIENTE as NOMBRE1_CLIENTE,"
				+ "v.NOMBRE2_CLIENTE," + "v.APELLIDO1_CLIENTE," + "v.APELLIDO2_CLIENTE," + "v.NUMERO_APROBACION,"
				+ "trunc(v.CODIGO_AFILIADO)," + "v.NOMBRE_AFILIADO," + "v.NUMERO_CUOTAS," + "v.VALOR_TOTAL,"
				+ "trim(trunc(v.NUMERO_CREDITO)) as NUMERO_CREDITO," + "v.FECHA_HORA_TRANSACCION,"
				+ "vc.direecion_cliente," +
				// "trunc(vc.telefono1_cliente) as telefono1_cliente," +
				"'0' as telefono1_cliente,"
				+ "vc.nombre1_codeudor ||' '|| vc.nombre2_codeudor||' '||vc.apellido1_codeudor ||' '|| vc.apellido2_codeudor as nombre1_codeudor,"
				+ "vc.nombre2_codeudor ," + "vc.apellido1_codeudor," + "vc.apellido2_codeudor,"
				+ "trunc(vc.cedula_codeudor) as cedula_codeudor,"
				+ "trunc(vc.telefono1_codeudor) as telefono1_codeudor, " + "vc.direccion_codeudor "
				+ " from V_BASICOS_VOUCHER v, v_basicos_cliente_codeudor vc "
				+ "where v.numero_credito = vc.numero_credito " + " and to_number(v.numero_aprobacion)=to_number(?1)"
				+ " and LPAD(v.CODIGO_AFILIADO,11,0)=LPAD(?2,11,0)";

		HashMap parametros = new HashMap();
		parametros.put("1", numeroAprobacion);

		parametros.put("2", codigoAfiliado);
		// System.out.println("query " + query + "\n" + "parametros: " +
		// numeroAprobacion +

		// "\n" + "parametros2 : " + codigoAfiliado);
		List<Object[]> registrosList = sbFacadeOpen.executeNativeQuery(query, parametros);
		VOAprobacion vo = null;

		for (int i = 0; i < registrosList.size(); i++) {
			vo = new VOAprobacion();
			vo.setCedulaGirador(registrosList.get(i)[0] + "");
			vo.setNombreGirador(registrosList.get(i)[1] + "");
			vo.setCodigoAfiliado(registrosList.get(i)[6] + "");
			vo.setEstablecimiento(registrosList.get(i)[7] + "");
			vo.setDireccion(registrosList.get(i)[12] + "");
			vo.setTelefono1(registrosList.get(i)[13] + "");
			vo.setFecha(registrosList.get(i)[11] + "");
			
			vo.setValorTotal(registrosList.get(i)[9] + "");
			vo.setNumeroCuotas(registrosList.get(i)[8] + "");

			if (registrosList.get(i)[18] != null) {
				vo.setCedulaCodeudor(registrosList.get(i)[18] + "");

			} else {
				vo.setCedulaCodeudor(registrosList.get(i)[0] + "");
			}

			if (registrosList.get(i)[14] != null) {

				vo.setNombreCodeudor(registrosList.get(i)[14] + "");
			} else {
				vo.setNombreCodeudor("");

			}

			if (registrosList.get(i)[20] != null) {

				vo.setDireccionCodeudor(registrosList.get(i)[20] + "");
			} else {
				vo.setDireccionCodeudor("");
			}

			if (registrosList.get(i)[19] != null) {
				vo.setTelefonoCodeudor1(registrosList.get(i)[19] + "");

			} else {
				vo.setTelefonoCodeudor1("");
			}

		}

		return vo;

	}

	@Override
	public List<VODetalleAprobacion> consultarDetalleAprobacion(String numeroAprobacion, String codigoAfiliado)
			throws Exception {
		List<VODetalleAprobacion> detalleAprobacion = new ArrayList<VODetalleAprobacion>();

		String query = "SELECT  NUMERO_APROBACION,VALOR_TOTAL,FECHA_HORA_TRANSACCION,NUMERO_CUOTAS "
				+ " FROM V_BASICOS_VOUCHER " + " WHERE to_number(numero_aprobacion)=to_number( ?1 )"
				+ " and LPAD(CODIGO_AFILIADO,11,0)=LPAD(?2,11,0)";

		HashMap parametros = new HashMap();
		parametros.put("1", numeroAprobacion);

		parametros.put("2", codigoAfiliado);
		// System.out.println("query " + query + "\n" + "parametros: " +
		// numeroAprobacion +

		// "\n" + "parametros2 : " + codigoAfiliado);
		List<Object[]> registrosList = sbFacadeOpen.executeNativeQuery(query, parametros);
		VODetalleAprobacion vo = null;

		for (int i = 0; i < registrosList.size(); i++) {
			vo = new VODetalleAprobacion();

			vo.setNoPagare(registrosList.get(i)[0] + "");
			vo.setValor(registrosList.get(i)[1] + "");
			vo.setFecha(registrosList.get(i)[2] + "");
			vo.setNoCuota(registrosList.get(i)[3] + "");

			detalleAprobacion.add(vo);
		}

		return detalleAprobacion;

	}

	@Override
	public VBasicosVoucher buscarAprobacionOpen(String numeroAprobacion, String afiliado, String cuotas,
			String valotTotal, String cedula) throws Exception {
		VBasicosVoucher tempVBasicosVoucher = null;
		ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		try {

			String query = "SELECT trunc(CODIGO_AFILIADO) as CODIGO_AFILIADO, NUMERO_CUOTAS,VALOR_TOTAL, "
					+ " trunc(NUMERO_APROBACION) as NUMERO_APROBACION ,  trunc(NUMERO_CREDITO) as NUMERO_CREDITO "
					+ " FROM V_BASICOS_VOUCHER@OPEN_CARD  WHERE  trunc(NUMERO_APROBACION)=TRUNC('" + numeroAprobacion
					+ "')  " + "  AND CODIGO_AFILIADO=LPAD('" + afiliado + "',11,'0')  AND NUMERO_CUOTAS=  '" + cuotas
					+ "'  " + " AND VALOR_TOTAL=  '" + valotTotal + "'   AND TRUNC(CEDULA_CLIENTE)='" + cedula + "'";

			// System.out.println(query);
			conn = UtilidadesModel.getConnection("jdbc/liquidadorAdminTotalFenaDS");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				tempVBasicosVoucher = new VBasicosVoucher();

				tempVBasicosVoucher.setNumeroAprobacion(rs.getString("NUMERO_APROBACION"));
				tempVBasicosVoucher.setCodigoAfiliado(rs.getString("CODIGO_AFILIADO"));

				tempVBasicosVoucher.setNumeroCuotas(rs.getString("NUMERO_CUOTAS"));
				tempVBasicosVoucher.setValorTotal(rs.getString("VALOR_TOTAL"));
				tempVBasicosVoucher.setNumeroCredito(rs.getString("NUMERO_CREDITO"));

			}
			rs.close();
			stmt.close();
			conn.close();
			rs = null;
			stmt = null;
			conn = null;
		} catch (Exception e) {
			System.out.println("erro5:" + e);
			rs.close();
			stmt.close();
			conn.close();
			rs = null;
			stmt = null;
			conn = null;
		}
		return tempVBasicosVoucher;

	}

	@Override
	public VOAfiliado consultarAfiliado(String codigoAfiliado) throws Exception {

		String query = "SELECT E.NOMBRE as NOMBRE, TI.PRODUCTO as PRODUCTO "
				+ "FROM NU_ESTABLECIMIENTOS E, NU_TRADUCTOR_TRANSACCIONES TT," + " NU_TRANSACCIONES_LINEAS TI "
				+ "WHERE TI.TRANSACCION_INTERNA=TT.TRANSACCION_INTERNA AND"
				+ " TT.ESTABLECIMIENTO=E.ESTABLECIMIENTO AND TT.ESTABLECIMIENTO" + " = LPAD(?1,11,0) "
				+ "GROUP BY E.NOMBRE ,TT.ESTABLECIMIENTO , TI.PRODUCTO ";

		System.out.println("query " + query);
		HashMap parametros = new HashMap();
		parametros.put("1", codigoAfiliado);
		System.out.println("query " + query + "\n" + "parametros: " + codigoAfiliado);

		List<Object[]> registrosList = sbFacadeOpen.executeNativeQuery(query, parametros);

		VOAfiliado vo = null;

		for (int i = 0; i < registrosList.size(); i++) {

			vo = new VOAfiliado();

			vo.setNombre(registrosList.get(i)[0] + "");
			vo.setSector(registrosList.get(i)[1] + "");

		}

		return vo;

	}

}
