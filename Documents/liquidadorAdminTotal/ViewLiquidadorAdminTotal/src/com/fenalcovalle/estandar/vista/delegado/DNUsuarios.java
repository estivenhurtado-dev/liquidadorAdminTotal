package com.fenalcovalle.estandar.vista.delegado;

import java.math.BigDecimal;

import com.fenalcovalle.estandar.modelo.ejb.entities.fenalco.TbmUsuarios;
import com.fenalcovalle.estandar.modelo.ejb.session.SBUsuarioLiquidadorAdminTotalLocal;
import com.fenalcovalle.estandar.modelo.utilidades.Parametros;
import com.fenalcovalle.estandar.vista.utilidades.ServiceLocator;



public class DNUsuarios {
    private SBUsuarioLiquidadorAdminTotalLocal sbUsuarioLocal;
    private String nombreSessionBean;


    public DNUsuarios() throws Exception{
            sbUsuarioLocal= ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI + 
            		"SBUsuarioLiquidadorAdminTotal" + Parametros.PREFIJO_ADICIONAL_JNDI_BM+
            		"SBUsuarioLiquidadorAdminTotalLocal",SBUsuarioLiquidadorAdminTotalLocal.class);
    }
    
    
    public TbmUsuarios consultarUsuarioPorId(BigDecimal idUsuario) throws Exception{
        return sbUsuarioLocal.consultarUsuarioPorId(idUsuario);
    }
    
    
    
    
}
