package com.fenalcovalle.estandar.modelo.utilidades;

import javax.faces.context.FacesContext;

/*
 * SE DEFINEN IDS DE REGISROS DE BASE DE DATOS
 * HACERLO CON LA SIGUIENTE NOTACION
 * public static final TIPO_DATO NOMBRE_PARAMETRO=VALOR;
 * */
public class Parametros {
	public String CONTEXTO_APP;
	
	//Variable para controlar los ambientes de ejecucion
    public static boolean AMBIENTE_SERVIDOR =true;
    public static final String ACTIVO="S";
    public static final String INACTIVO="N";
    //DEFINE SI SE ENVIAN O NO NOTIFICACIONES AL MOMENTO DE PRESENTARSE UNA EXCEPCION
    public static final boolean ENVIAR_NOTIFICACIONES=false;
    
    //JNDI SESSION BEANS
    public static final String PREFIJO_JNDI = "java:global/EARLiquidadorAdminTotal/ModelLiquidadorAdminTotal/";
    public static final String PREFIJO_ADICIONAL_JNDI = "!com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.session.";
    public static final String PREFIJO_ADICIONAL_JNDI_BM = "!com.fenalcovalle.estandar.modelo.ejb.session.";
    public static final String JNDI_CONEXION = "jdbc/liquidadorAdminTotalFenaDS";
    public static final String JNDI_CONEXIONOPEN = "jdbc/liquidadorAdminTotalOpenDS";
     
    //PARAMETROS GENERACION REPORTES
    public static final String LLAVE_PARAM_REPORT = "parametrosM";
    public static final String LLAVE_FORMATO = "formato";
    public static final String FORMATO_EXCEL = "xls";
    public static final String FORMATO_PDF = "pdf";
    public static final String RUTA_JASPER="/WEB-INF/reportes/";
    public static final String RUTA_PDF="/WEB-INF/pdf/";
    public static final String RUTA_IMG="/resources/images/";
    public static final String RUTA_LIQUIDACIONES = "/documentos_app/liquidaciones/";	
    //ID SECCIONES
    public static final long SECCION_FIRST=1L;
    public static final long SECCION_SECOND=2L;
    public static final long SECCION_THIRD=3L;
    public static final long SECCION_EXITOSA=4L;
    public static final long SECCION_CRITICA=5L;
    public static final long SECCION_RESOLUCION=6L;
    
    
    
    
    
    
    
    //Parametros Credito En Linea
    
    
    public static final String URL_SERVICIO_SMS ="1";
    public static final String USUARIO_SERVICIO_SMS="2";
    public static final String CONTRASENA_SERVICIO_SMS="3";
    public static final String ESTRUCTURA_MENSAJE_SMS="4";
    public static final String DIAS_CREACION_SOLICITUDES="5";
    public static final String DIAS_LIQUIDACION="6";
    public static final String MINUTOS_REENVIO_MENSAJE="7";
    
    
	    
    public String getCONTEXTO_APP() {
        if (CONTEXTO_APP == null || CONTEXTO_APP.equals("")) {
            CONTEXTO_APP =
                    FacesContext.getCurrentInstance() != null ? (FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")) :
                    "";
        }
        return CONTEXTO_APP;
    }

    public void setCONTEXTO_APP(String CONTEXTO_APP) {
        this.CONTEXTO_APP = CONTEXTO_APP;
    }
    
 // PARAMETROS DECEVAL

 	public static final String USUARIO_SERVICIO_AUTH = "INTEGRATION-PAGARES-FENALCOVALLE";
 	public static final String CONTRASENA_SERVICIO_AUTH = "FENAL2021*";

 	public static final String BASE_URL="http://10.75.10.37:8085/";
// 	public static final String BASE_URL="http://localhost:8085/";
 	public static final String URL_SERVICIO_AUTH = BASE_URL+"fenalcovalle-api-pagares/oauth/token";

 	public static final String USUARIO_SERVICIO = "webservices";
 	public static final String CONTRASENA_SERVICIO = "wsIntegFena2021";
 	public static final String GRANT_TYPE = "password";
 	
 	public static final String URL_CREACION_PAGARE = BASE_URL+"fenalcovalle-api-pagares/endpoints/generarPagaraPersonaNatural";
 	
 	public static final String URL_CONSULTA_PAGARE = BASE_URL+"fenalcovalle-api-pagares/endpoints/consultaPagare/";
 	
 	public static final String URL_FIRMA_PAGARE = BASE_URL+"fenalcovalle-api-pagares/endpoints/firmarPagare/";
 	

 	public static final String URL_REENVIO_OTP = BASE_URL+"fenalcovalle-api-pagares/endpoints/reenvioOtp/";
 	
 	public static final String EXCEPTION_MESSAGE ="EXCEPTION_MESSAGE";
 	public static final String MESSAGE ="MESSAGE";

 // PARAMETROS LOG LIQUIDACION
	
	
	
 	public static final String NOTIFICACION_TEMPLATE_LIQUIDACION ="222786";
 	 public static final String NOTIFICACION_KEY                ="ENVIO_PRELIQUIDACION";
 	
 	
 	 public static final String ARCHIVO          ="ARCHIVO";
 	  public static final String NOMBRE_ARCHIVO   ="NOMBRE_ARCHIVO";
 	  
 	  
 		public static final String NOTIFICACION_USUARIO_SERVICIO_AUTH = "INTEGRATION-NOTIFICACIONES-FENALCOVALLE";
 		public static final String NOTIFICACION_CONTRASENA_SERVICIO_AUTH = "FENAL2021*";

// 		public static final String NOTIFICACION_BASE_URL="http://localhost:8084/";
 		public static final String NOTIFICACION_BASE_URL="http://10.75.10.37:8084/";
 		public static final String NOTIFICACION_URL_SERVICIO_AUTH = NOTIFICACION_BASE_URL+"fenalcovalle-api-notificaciones/oauth/token";

 		public static final String NOTIFICACION_USUARIO_SERVICIO = "webservices";
 		public static final String NOTIFICACION_CONTRASENA_SERVICIO = "wsIntegFena2021";
 		public static final String NOTIFICACION_GRANT_TYPE = "password";
 		public static final String NOTIFICACION_URL_CORREO_TEMPLATE = NOTIFICACION_BASE_URL+"fenalcovalle-api-notificaciones/endpoints/sendMailTemplate/";
 		
 	  
 	
 
    
    
    
    
}
