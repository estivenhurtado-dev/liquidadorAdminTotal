package com.fenalcovalle.estandar.modelo.ejb.session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.fenalcovalle.estandar.modelo.ejb.entities.fenalco.TbmUsuarios;

import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TsolicUniversidad;;

@Stateless(name = "SBUsuarioLiquidadorAdminTotal", mappedName = "SBUsuarioLiquidadorAdminTotal")
public class SBUsuarioLiquidadorAdminTotal implements SBUsuarioLiquidadorAdminTotalLocal {
	@EJB
	SBFacadeConsolaLiquidarorAdminTotalLocal sbFacadeConsolaLocal;

	public SBUsuarioLiquidadorAdminTotal() {
	}

	public TbmUsuarios consultarUsuarioPorId(BigDecimal idUsuario) throws Exception {

		TbmUsuarios usuario = (TbmUsuarios) sbFacadeConsolaLocal.findByPrimaryKey(TbmUsuarios.class, idUsuario);
		// sbFacadeConsolaLocal.refresh(TbmUsuarios.class);
		if (usuario != null) {
			usuario.getTbmRolesUsuarioList();
			usuario.getTbmValorPropiedadList();
		}

		return usuario;
	}

	

}
