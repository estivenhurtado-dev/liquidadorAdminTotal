package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.fenalcovalle.estandar.modelo.ejb.session.SBFacadeLiquidadorAdminTotalAS400Local;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAfiliado;

/**
 * Session Bean implementation class SBConsultasAS400
 */
@Stateless
@LocalBean
public class SBConsultasAS400 implements SBConsultasAS400Local {

	/**
	 * Default constructor.
	 */
	public SBConsultasAS400() {

	}

	@EJB
	SBFacadeLiquidadorAdminTotalAS400Local sbFacadeAs400;

	@Override
	public VOAfiliado consultarAfiliadoCupo(String aficodscc, String aficon, String afinumsuc) throws Exception {

		String query = "SELECT Afidate1.AFINOMCOM, " + "      Afidate1.SECCOD FROM SIPCDTA0.AFIDATE1 Afidate1 "
				+ " WHERE AFICODSCC = ?1 AND " + " AFICON    = ?2 " + " AND AFINUMSUC = ?3 AND afifecret = 00000000";

		HashMap parametros = new HashMap();
		parametros.put("1", aficodscc);
		parametros.put("2", aficon);
		parametros.put("3", afinumsuc);

		//System.out.println("query " + query + "\n" 
		//		+ "parametros: 1: " + aficodscc 
		//		+ "\n" + " 2: " + aficon + "\n"
		//		+ " 3: " + afinumsuc);

		List<Object[]> registrosList = sbFacadeAs400.executeNativeQuery(query, parametros);

		VOAfiliado vo = null;

		for (int i = 0; i < registrosList.size(); i++) {

			vo = new VOAfiliado();

			vo.setNombre(registrosList.get(i)[0] + "");
			vo.setSector(registrosList.get(i)[1] + "");

		}

		return vo;

	}

}
