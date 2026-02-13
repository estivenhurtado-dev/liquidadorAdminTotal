package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session;

import javax.ejb.Local;

import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAfiliado;

@Local
public interface SBConsultasAS400Local {

	
	
	
	public VOAfiliado consultarAfiliadoCupo(String aficodscc, String aficon, String afinumsuc) throws Exception; 
	
}
