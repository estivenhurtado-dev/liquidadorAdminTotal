package com.fenalcovalle.estandar.vista.mb;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.fenalcovalle.estandar.modelo.ejb.entities.fenalco.TbmRolesUsuario;
import com.fenalcovalle.estandar.modelo.ejb.entities.fenalco.TbmUsuarios;
import com.fenalcovalle.estandar.modelo.ejb.entities.fenalco.TbmValorPropiedad;
import com.fenalcovalle.estandar.modelo.excepciones.BaseException;
import com.fenalcovalle.estandar.modelo.utilidades.Parametros;
import com.fenalcovalle.estandar.vista.delegado.DNUsuarios;


public class MBUsuario {

  
    private List<Long> roles;
    private TbmUsuarios usuario;

    public MBUsuario() {

    }

    public TbmUsuarios getUsuario() throws BaseException {
        DNUsuarios dnUsuario = null;
        try {
            if (Parametros.AMBIENTE_SERVIDOR) {
                if (usuario == null) {
                    HttpSession session =
                        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

                    //Obtenemos de la session el atributo del usuario
                    String idUsuario = (String)session.getAttribute("LLAVE_USER_CONSOLA");
                    System.out.println("este es "+idUsuario);
                    //Consultamos el usuario
                    dnUsuario = new DNUsuarios();
                    usuario = dnUsuario.consultarUsuarioPorId(new BigDecimal(idUsuario));
                }
            } else {
                if (usuario == null) {
         
              	   dnUsuario = new DNUsuarios();
                   usuario = dnUsuario.consultarUsuarioPorId(new BigDecimal(380));//454 CLINICA
                	/*
                    usuario = new TbmUsuarios();
                    usuario.setIdUsuario(new BigDecimal(1));
                    usuario.setUserId("admin");
                    TbmValorPropiedad vp= new TbmValorPropiedad();
                    vp.setIdPropiedad(new BigDecimal(1));
                    vp.setValor("800242106");
                    List<TbmValorPropiedad> valores= new ArrayList<TbmValorPropiedad>();
                    valores.add(vp);
                    TbmValorPropiedad vp2= new TbmValorPropiedad();
                    vp2.setIdPropiedad(new BigDecimal(3));
                    vp2.setValor("8097");
                    valores.add(vp2);
                    usuario.setTbmValorPropiedadList(valores);*/
                }
            }

            return usuario;
        } catch (Exception e) {
        	e.printStackTrace();
            throw new BaseException("error021", null);
        }
    }

    public List<Long> getUserRoles() throws BaseException {
        DNUsuarios dnUsuario = null;
        try {
            if (Parametros.AMBIENTE_SERVIDOR) {
                if (roles == null) {
                    if (usuario == null) {
                        HttpSession session =
                            (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

                        //Obtenemos de la session el atributo del usuario
                        String idUsuario = (String)session.getAttribute("LLAVE_USER_CONSOLA");

                        //Consultamos el usuario
                        dnUsuario = new DNUsuarios();
                        usuario = dnUsuario.consultarUsuarioPorId(new BigDecimal(idUsuario));
                    }

                    //Recorremos los roles del usuario
                    if (usuario.getTbmRolesUsuarioList() != null && usuario.getTbmRolesUsuarioList().size() > 0) {
                        roles = new ArrayList<Long>();
                        for (TbmRolesUsuario rol : usuario.getTbmRolesUsuarioList()) {
                            Long reg = rol.getTbmRoles3().getIdRol().longValue();
                            roles.add(reg);
                        }
                    }
                }
            } else {
                if (roles == null) {
                    roles = new ArrayList<Long>();
                    //roles.add(new Long(1));
                    roles.add(new Long(3));
                    //roles.add(new Long(61));
                    //roles.add(new Long(75));
                    //roles.add(new Long(76));
                    //roles.add(new Long(4));
                }
            }
            return roles;
        } catch (Exception e) {
            throw new BaseException("error021", null);
        }
    }
}