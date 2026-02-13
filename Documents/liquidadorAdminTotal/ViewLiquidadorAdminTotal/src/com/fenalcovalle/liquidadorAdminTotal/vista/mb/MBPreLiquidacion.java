package com.fenalcovalle.liquidadorAdminTotal.vista.mb;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fenalcovalle.estandar.modelo.excepciones.BaseException;
import com.fenalcovalle.estandar.modelo.utilidades.Parametros;
import com.fenalcovalle.estandar.vista.mb.MBMensajes;
import com.fenalcovalle.estandar.vista.mb.MBUsuario;
import com.fenalcovalle.estandar.vista.utilidades.CargarArchivosPropiedadesUtil;
import com.fenalcovalle.estandar.vista.utilidades.GenerarReportes;
import com.fenalcovalle.estandar.vista.utilidades.ParametrosWeb;
import com.fenalcovalle.estandar.vista.utilidades.UtilidadesWeb;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TProductosFinanciero;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TatComisionFenalcheque;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TatOtrasPlaza;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TatTempLiquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareDetalleLiquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareFechasVencimiento;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareMaestroLiquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TpagareTasaInteres;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TsolicLogPreliquidacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TsolicParametrosCreLi;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.TsolicUniversidad;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAfiliado;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VOAprobacion;
import com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal.VODetalleAprobacion;
import com.fenalcovalle.liquidadorAdminTotal.vista.delegado.DNConsultasAS400;
import com.fenalcovalle.liquidadorAdminTotal.vista.delegado.DNConsultasFena;
import com.fenalcovalle.liquidadorAdminTotal.vista.delegado.DNConsultasOpencard;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sun.misc.BASE64Encoder;

@ManagedBean(name = "MBPreLiquidacion")
@SessionScoped
public class MBPreLiquidacion {

	DNConsultasFena dNConsultasFena;

	private String universidadSeleccionada;
	private ArrayList<SelectItem> listUniversidades;
	private String codigoUniversidad;
	private boolean listUniversidad;
	private boolean inputUniversidad;

	private String celular;
	private String nombreEstudiante;
	private String correo;
	TsolicUniversidad tsolicUniversidadEntity;
	private boolean panelPaso1;
	private boolean panelPaso2;
	private String codigoUniversidadActual;
	private String codigoOTP;
	private String codigoOTPGenerado;

	MBMensajes mensajes = new MBMensajes();

	DNConsultasOpencard dNConsultasOpencard;
	TProductosFinanciero ttProductosFinanciero;
	DNConsultasAS400 dNConsultasAS400;

	private String nombreApp = "Liquidador Administraci�n Total";
	private String codigoAfiliado;
	MBUsuario mBUsuario;

	private String fecha;
	private String fechaPrimeraCuota;

	private String cedulaGirador;
	private String nombre;
	private String semestre;
	private String programa;
	private String referencia;
	private String periodo;
	private String valorLiquidar;
	private String plazoMeses;

	private String valorCuotaMostrar;

	private String valorTotalFinanciar;

	private String estudioCredito;
	private VOAprobacion voAprobacion;

	private String numeroAprobacion;

	private boolean panelAprobacion;

	private MaestroCuotasVO maestroCuotasVO;

	private String tipoLiquidacionSeleccionado;

	private boolean codigoBarras;
	private String textoCodigoBarras;
	SimpleDateFormat df;

	VOAfiliado afiliadoConsultado;
	TpagareTasaInteres tempPagareTasaInteres;
	TatComisionFenalcheque tempComisionFenalcheque;

	private List<VODetalleAprobacion> listaDetalleAprobacion;

	TsolicUniversidad tsolicUniversidadEntityGlobal;
	TsolicLogPreliquidacion tsolicLogPreliquidacionGlobal;

	public MBPreLiquidacion() {
		panelPaso1 = true;
		panelPaso2 = false;

		try {

			df = new SimpleDateFormat("dd/MMM/yyyy", new Locale("en_EN"));

		} catch (Exception exception) {
			if (exception instanceof BaseException) {
				MBMensajes mensajes = (MBMensajes) UtilidadesWeb.getManagedBean("MBMensajes");
				mensajes.mostrarMensaje((BaseException) exception);
			} else {
				BaseException BaseException = new BaseException(exception, null, null);
				MBMensajes mensajes = (MBMensajes) UtilidadesWeb.getManagedBean("MBMensajes");
				mensajes.mostrarMensaje(BaseException);
			}
		}
	}

	public void irSolicitud() {

		if (valorCuotaMostrar != null) {

			if (valorCuotaMostrar.length() > 0) {

				navegarSolicitud();

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Debe generar la liquidaci�n para continuar ", "Debe generar la liquidaci�n para continuar "));
			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Debe generar la liquidaci�n para continuar ", "Debe generar la liquidaci�n para continuar "));
		}

	}

	public void navegarSolicitud() {

		try {
			// limpiarServicio();

			if (mBUsuario == null) {

				mBUsuario = (MBUsuario) UtilidadesWeb.getManagedBean("MBUsuario");

			}

			String valorSucursal = null;
			String nitAfiliado = null;

			String user = mBUsuario.getUsuario().getUserId();

			if (dNConsultasFena == null) {
				dNConsultasFena = new DNConsultasFena();
			}

			if (tsolicUniversidadEntityGlobal != null) {

				valorSucursal = tsolicUniversidadEntityGlobal.getIdSucursal() + "";
				nitAfiliado = tsolicUniversidadEntityGlobal.getNitAfiliado() + "";
			}

			CargarArchivosPropiedadesUtil prop = new CargarArchivosPropiedadesUtil();

			String baseDir = prop.getProperty("parametros.properties", "RUTA_SOLICITUDES");

			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();

			DecimalFormat df = new DecimalFormat("#");
			df.setMaximumFractionDigits(18);

//			valorLiquidar = 
//					valorLiquidarConsultar;

			// System.out.println("valor liquidar final"+valorLiquidar);
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);

			String idUsuario = "1854";
			// System.out.println("SESSION: " + session.getId());

			Object sesionkeyconsola = "token";
			// System.out.println(sesionkeyconsola.toString());

			String url3 = baseDir + "solicitudes/faces/jsp/" + "solicitudes/consultarParametrizacionA.jspx?" + "nit="
					+ nitAfiliado + "&" + "producto=66&" + "tipoSolicitante=" + "1" + "&" + "sucursal="
					+ valorSucursal.replace(".", "") + "&" + "tipoDocumento=" + "1" + "&" + "identificacion=0"
					// + cedulaGirador.replace(".", "")
					+ "&userconsola=" + idUsuario + "&sesionkeyconsola=" + sesionkeyconsola.toString()
					+ "&valorLiquidar=" + valorTotalFinanciar.replace(".", "") + "&numeroCuotas=" + plazoMeses
					+ "&valorCuota=" + valorCuotaMostrar.replace(".", "") + "&valorOriginal="
					+ valorLiquidar.replace(".", "") + "&nombreDC=" + nombreEstudiante.replace(" ", "+") + "&correoDC="
					+ correo + "&celularDC=" + procesarCelular(celular);
			
			/*
			 * System.out.println("URL2 " + url2); extContext.redirect(url2);
			 */
			System.out.println("URL3 " + url3);
			extContext.redirect(url3);

		} catch (Exception exception) {
			if (exception instanceof BaseException) {

				mensajes.mostrarMensaje((BaseException) exception);
			} else {
				BaseException BaseException = new BaseException(exception, null, null);
				mensajes.mostrarMensaje(BaseException);
			}
		}

	}

	public void crearLiquidacion() {

		try {

			if (codigoOTPGenerado.equalsIgnoreCase(codigoOTP) == true) {

				if (dNConsultasFena == null) {
					dNConsultasFena = new DNConsultasFena();
				}

				tsolicLogPreliquidacionGlobal.setCodigoConfirmado("S");
				dNConsultasFena.modificarTsolicLogPreliquidacion(tsolicLogPreliquidacionGlobal);

				FacesContext context = FacesContext.getCurrentInstance();
				ExternalContext extContext = context.getExternalContext();

				String url = "/jsp/liquidacionUniversidad.xhtml";
				System.out.println("url " + url);

				String url2 = extContext
						.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, url));

				extContext.redirect(url2);

				codigoAfiliado = codigoUniversidadActual;

				tsolicUniversidadEntityGlobal = dNConsultasFena
						.consultarTsolicUniversidadPorId(new BigDecimal(codigoUniversidadActual));

				consultar();

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"El codigo ingresado es incorrecto ", "El codigo ingresado es incorrecto"));

			}

		} catch (Exception exception) {

		}
	}

	public void reenviarCodigo() throws Exception {
		if (dNConsultasFena == null) {
			dNConsultasFena = new DNConsultasFena();
		}

		boolean reenvioCodigo = dNConsultasFena.validarReenvioMensaje(procesarCelular(celular));

		if (reenvioCodigo == true) {

			TsolicLogPreliquidacion tsolicLogPreliquidacionEntity = new TsolicLogPreliquidacion();
			codigoOTPGenerado = generarCodigoOTP() + "";
			tsolicLogPreliquidacionEntity.setCodigoOtp(codigoOTPGenerado + "");

			tsolicLogPreliquidacionEntity.setCelular(procesarCelular(celular) + "");
			tsolicLogPreliquidacionEntity.setCorreo(correo);
			tsolicLogPreliquidacionEntity.setNombreEstudiante(nombreEstudiante);

			if (tsolicUniversidadEntity != null) {
				tsolicLogPreliquidacionEntity.setCodigoInstitucion(tsolicUniversidadEntity.getCodigo() + "");

				codigoUniversidadActual = tsolicUniversidadEntity.getCodigo() + "";
			} else {
				tsolicLogPreliquidacionEntity.setCodigoInstitucion(universidadSeleccionada);
				codigoUniversidadActual = universidadSeleccionada;
			}
			tsolicLogPreliquidacionEntity.setCodigoConfirmado("N");

			String mensajesActivos = dNConsultasFena
					.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.MENSAJES_SMS_ACTIVOS)).getValor();
			boolean mensajeTXT = true;

			if (mensajesActivos.equalsIgnoreCase("S")) {

				Response response = null;
				try {

					String name = dNConsultasFena
							.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.USUARIO_SERVICIO_SMS))
							.getValor();
					String password = dNConsultasFena
							.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.CONTRASENA_SERVICIO_SMS))
							.getValor();
					String url = dNConsultasFena
							.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.URL_SERVICIO_SMS))
							.getValor();
					String mensaje = dNConsultasFena
							.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.ESTRUCTURA_MENSAJE_SMS))
							.getValor();
					mensaje = mensaje.replace("$codigoOTP", codigoOTPGenerado);
					String authString = name + ":" + password;
					String authStringEnc = new BASE64Encoder().encode(authString.getBytes());

					OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(60, TimeUnit.SECONDS)
						    .writeTimeout(60, TimeUnit.SECONDS)
						    .readTimeout(60, TimeUnit.SECONDS)
						    .build();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, "{\n    \"nrocelular\": \""
							+ procesarCelular(celular) + "\",\n    \"mensaje\": \"" + mensaje + " \"\n ,     \"codsolicitante\": \"1 \"\n   }");
					Request request = new Request.Builder().url(url).method("POST", body)
							.addHeader("Authorization", "Basic " + authStringEnc)
							.addHeader("Content-Type", "application/json").build();
					response = client.newCall(request).execute();

					tsolicLogPreliquidacionEntity.setRespuestaServicio(response.toString());

				} catch (Exception e) {
					// TODO: handle exception
					tsolicLogPreliquidacionEntity.setRespuestaServicio(e.toString());
					mensajeTXT = false;
					tsolicLogPreliquidacionGlobal = dNConsultasFena
							.registrarTsolicLogPreliquidacion(tsolicLogPreliquidacionEntity);
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"No fue posible enviar el mensaje de texto intente m�s tarde.",
									"No fue posible enviar el mensaje de texto intente m�s tarde. "));

				}
			}

			if (mensajeTXT == true) {

				tsolicLogPreliquidacionGlobal = dNConsultasFena
						.registrarTsolicLogPreliquidacion(tsolicLogPreliquidacionEntity);

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Se Envio nuevamente un codigo SMS al celular " + celular,
								"Se Envio nuevamente un codigo SMS al celular " + celular));
			}

		} else {

			TsolicParametrosCreLi tsolicParametrosCreLiEntity = dNConsultasFena
					.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.MINUTOS_REENVIO_MENSAJE));
			String minutosLimite = "0";
			if (tsolicParametrosCreLiEntity != null) {
				minutosLimite = tsolicParametrosCreLiEntity.getValor();
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Debe esperar " + minutosLimite + " minutos para reenviar un nuevo SMS",
							"Debe esperar " + minutosLimite + " minutos para reenviar un nuevo SMS"));

		}

	}

	public void cancelar() {
		panelPaso1 = true;
		panelPaso2 = false;

	}

	public void preliquidacion() throws Exception {
		if (dNConsultasFena == null) {
			dNConsultasFena = new DNConsultasFena();
		}

		boolean reenvioCodigo = dNConsultasFena.validarReenvioMensaje(procesarCelular(celular));

		if (reenvioCodigo == true) {

			boolean crearSolicitud = dNConsultasFena.validarCreacionSolicitud(procesarCelular(celular));

			if (crearSolicitud == true) {

				String codigoUniversidad = dNConsultasFena.validarLiquidacionUniversidad(procesarCelular(celular));

				if (tsolicUniversidadEntity != null) {

					codigoUniversidadActual = tsolicUniversidadEntity.getCodigo() + "";
				} else {

					codigoUniversidadActual = universidadSeleccionada;
				}

				if (codigoUniversidad == null || (codigoUniversidad.equalsIgnoreCase(codigoUniversidadActual))) {

					TsolicLogPreliquidacion tsolicLogPreliquidacionEntity = new TsolicLogPreliquidacion();
					codigoOTPGenerado = generarCodigoOTP() + "";
					tsolicLogPreliquidacionEntity.setCodigoOtp(codigoOTPGenerado);

					tsolicLogPreliquidacionEntity.setCelular(procesarCelular(celular) + "");
					tsolicLogPreliquidacionEntity.setCorreo(correo);
					tsolicLogPreliquidacionEntity.setNombreEstudiante(nombreEstudiante);

					if (tsolicUniversidadEntity != null) {
						tsolicLogPreliquidacionEntity.setCodigoInstitucion(tsolicUniversidadEntity.getCodigo() + "");
						// codigoUniversidadActual = tsolicUniversidadEntity.getCodigo() + "";
					} else {
						tsolicLogPreliquidacionEntity.setCodigoInstitucion(universidadSeleccionada);
						// codigoUniversidadActual = universidadSeleccionada;
					}
					tsolicLogPreliquidacionEntity.setCodigoConfirmado("N");

					String mensajesActivos = dNConsultasFena
							.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.MENSAJES_SMS_ACTIVOS))
							.getValor();
					boolean mensajeTXT = true;

					if (mensajesActivos.equalsIgnoreCase("S")) {

						Response response = null;
						try {

							String name = dNConsultasFena.consultarTsolicParametrosCreLiPorId(
									new BigDecimal(ParametrosWeb.USUARIO_SERVICIO_SMS)).getValor();
							String password = dNConsultasFena.consultarTsolicParametrosCreLiPorId(
									new BigDecimal(ParametrosWeb.CONTRASENA_SERVICIO_SMS)).getValor();
							String url = dNConsultasFena
									.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.URL_SERVICIO_SMS))
									.getValor();
							String mensaje = dNConsultasFena.consultarTsolicParametrosCreLiPorId(
									new BigDecimal(ParametrosWeb.ESTRUCTURA_MENSAJE_SMS)).getValor();

							mensaje = mensaje.replace("$codigoOTP", codigoOTPGenerado);
							String authString = name + ":" + password;
							String authStringEnc = new BASE64Encoder().encode(authString.getBytes());

							OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(60, TimeUnit.SECONDS)
								    .writeTimeout(60, TimeUnit.SECONDS)
								    .readTimeout(60, TimeUnit.SECONDS)
								    .build();
							MediaType mediaType = MediaType.parse("application/json");
							RequestBody body = RequestBody.create(mediaType, "{\n    \"nrocelular\": \""
								
							
							+ procesarCelular(celular) + "\",\n    \"mensaje\": \"" + mensaje + " \"\n ,     \"codsolicitante\": \"1 \"\n   }");
							Request request = new Request.Builder().url(url).method("POST", body)
									.addHeader("Authorization", "Basic " + authStringEnc)
									.addHeader("Content-Type", "application/json").build();
							response = client.newCall(request).execute();

							tsolicLogPreliquidacionEntity.setRespuestaServicio(response.toString());

						} catch (Exception e) {
							// TODO: handle exception

							tsolicLogPreliquidacionEntity.setRespuestaServicio(e.toString());
							mensajeTXT = false;
							tsolicLogPreliquidacionGlobal = dNConsultasFena
									.registrarTsolicLogPreliquidacion(tsolicLogPreliquidacionEntity);
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_ERROR,
											"No fue posible enviar el mensaje de texto intente m�s tarde.",
											"No fue posible enviar el mensaje de texto intente m�s tarde. "));

						}

					}

					if (mensajeTXT == true) {

						tsolicLogPreliquidacionGlobal = dNConsultasFena
								.registrarTsolicLogPreliquidacion(tsolicLogPreliquidacionEntity);

						panelPaso1 = false;
						panelPaso2 = true;
					}

				} else {

					TsolicParametrosCreLi tsolicParametrosCreLiEntity = dNConsultasFena
							.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.DIAS_LIQUIDACION));

					String diasLimite = "0";
					if (tsolicParametrosCreLiEntity != null) {
						diasLimite = tsolicParametrosCreLiEntity.getValor();
					}

					TsolicUniversidad tsolicUniversidadEntity = dNConsultasFena
							.consultarTsolicUniversidadPorId(new BigDecimal(codigoUniversidad));
					String universidad = "";
					if (tsolicUniversidadEntity != null) {
						universidad = tsolicUniversidadEntity.getNombre();
					}

					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Debido a que realizo una liquidaci�n en la universidad " + universidad
									+ " solo se permitir� liquidar en esta en los pr�ximos " + diasLimite + " d�as",
							"Debido a que realizo una liquidaci�n en la universidad " + universidad
									+ " solo se permitir� liquidar en esta en los pr�ximos " + diasLimite + " d�as"));
				}

			} else {

				TsolicParametrosCreLi tsolicParametrosCreLiEntity = dNConsultasFena
						.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.DIAS_CREACION_SOLICITUDES));

				String diasLimite = "0";
				if (tsolicParametrosCreLiEntity != null) {
					diasLimite = tsolicParametrosCreLiEntity.getValor();
				}

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Tiene una solicitud de cr�dito  en proceso en los pr�ximos " + diasLimite
										+ " d�as no puede crear mas",
								"Tiene una solicitud de cr�dito  en proceso en los pr�ximos " + diasLimite
										+ " d�as no puede crear mas"));

			}

		} else {

			TsolicParametrosCreLi tsolicParametrosCreLiEntity = dNConsultasFena
					.consultarTsolicParametrosCreLiPorId(new BigDecimal(ParametrosWeb.MINUTOS_REENVIO_MENSAJE));
			String minutosLimite = "0";
			if (tsolicParametrosCreLiEntity != null) {
				minutosLimite = tsolicParametrosCreLiEntity.getValor();
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Debe esperar " + minutosLimite
									+ " minutos para reenviar un nuevo SMS y poder continuar el proceso",
							"Debe esperar " + minutosLimite
									+ " minutos para reenviar un nuevo SMS y poder continuar el proceso"));

		}

	}

	public static String procesarCelular(String celularI) {

		celularI = celularI.replace(" ", "");
		celularI = celularI.replace("(", "");

		celularI = celularI.replace(")", "");

		return celularI.trim();
	}

	public int generarCodigoOTP() {

		int num1 = 100000;
		int num2 = 999999;
		int numAleatorio = (int) Math.floor(Math.random() * (num1 - num2) + num2);
		return numAleatorio;

	}

	public void pintarParametrosRequest() throws Exception {

		if (dNConsultasFena == null) {
			dNConsultasFena = new DNConsultasFena();
		}

		tsolicUniversidadEntity = null;

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		codigoUniversidad = request.getParameter("codigoUniversidad");

		boolean esnumero = true;

		try {

			Integer.parseInt(codigoUniversidad);

		} catch (Exception e) {
			// TODO: handle exception
			esnumero = false;
		}

		if (codigoUniversidad != null && esnumero == true) {
			tsolicUniversidadEntity = dNConsultasFena
					.consultarTsolicUniversidadPorId(new BigDecimal(codigoUniversidad));

			if (tsolicUniversidadEntity != null) {

				listUniversidad = false;
				inputUniversidad = true;
			} else {

				listUniversidad = true;
				inputUniversidad = false;
				cargarUniversidades();

			}

		} else {

			listUniversidad = true;
			inputUniversidad = false;
			cargarUniversidades();

		}

	}

	public void cargarUniversidades() throws Exception {

		if (dNConsultasFena == null) {
			dNConsultasFena = new DNConsultasFena();
		}
		List<TsolicUniversidad> listaUniversidadesSB = dNConsultasFena.getAllTsolicUniversidad();
		listUniversidades = new ArrayList<SelectItem>();
		for (int i = 0; i < listaUniversidadesSB.size(); i++) {
			listUniversidades.add(
					new SelectItem(listaUniversidadesSB.get(i).getCodigo(), listaUniversidadesSB.get(i).getNombre()));
		}

	}

	public void procesarCodigoBarras() {
		System.out.println("procesando codigo bar");

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		if (textoCodigoBarras != null) {
			if (textoCodigoBarras.length() > 0) {
				System.out.println("dato " + tipoLiquidacionSeleccionado);
				if (tipoLiquidacionSeleccionado != null) {

					if (tipoLiquidacionSeleccionado.equalsIgnoreCase("liqui1")) {
						if (textoCodigoBarras.length() == 54) {
							System.out.println("paso 54");
							String parte1 = textoCodigoBarras.substring(3, 16);

							String parte2 = textoCodigoBarras.substring(20, 30);

							String parte3 = textoCodigoBarras.substring(34, 44);

							String parte4 = textoCodigoBarras.substring(46, 54);
							valorLiquidar = Integer.parseInt(parte3) + "";
							referencia = Integer.parseInt(parte2) + "";
							String anio = parte4.substring(0, 4);
							String mes = parte4.substring(4, 6);
							String dia = parte4.substring(6, 8);

							SimpleDateFormat formatoFechaBarra = new SimpleDateFormat("dd/MM/yyyy");
							String fecha = dia + "/" + mes + "/" + anio;

							try {

								Date fechaCodigo = formatoFechaBarra.parse(fecha);

								Date hoy = new Date();

								if (fechaCodigo.compareTo(hoy) != 1) {

									mensajes.mostrarMensaje(
											"El codigo de barras escaneado presenta una vigencia antigua.", 2);

								}
							} catch (Exception e) {
								System.out.println("Error: Formateando Fecha Codigo de barras");
							}

						}
					} else if (tipoLiquidacionSeleccionado.equalsIgnoreCase("liqui2")) {
						if (textoCodigoBarras.length() == 52) {
							System.out.println("paso 52");
							String parte1 = textoCodigoBarras.substring(3, 16);

							String parte2 = textoCodigoBarras.substring(20, 30);

							String parte3 = textoCodigoBarras.substring(34, 42);

							String parte4 = textoCodigoBarras.substring(46, 54);
							valorLiquidar = Integer.parseInt(parte3) + "";
							referencia = Integer.parseInt(parte2) + "";

							String anio = parte4.substring(0, 4);
							String mes = parte4.substring(4, 6);
							String dia = parte4.substring(6, 8);
							SimpleDateFormat formatoFechaBarra = new SimpleDateFormat("dd/MM/yyyy");
							String fecha = dia + "/" + mes + "/" + anio;

							try {

								Date fechaCodigo = formatoFechaBarra.parse(fecha);

								Date hoy = new Date();

								if (fechaCodigo.compareTo(hoy) != 1) {

									mensajes.mostrarMensaje(
											"El codigo de barras escaneado presenta una vigencia antigua.", 2);

								}
							} catch (Exception e) {
								System.out.println("Error: Formateando Fecha Codigo de barras");
							}
						}
					}
				} else {
					mensajes.mostrarMensaje("Debe seleccionar un tipo de liquidaci�n.", 2);
				}

			}
		}

	}

	public void aprobarLiquidacion() throws Exception {
		// maestroCuotasVO

		if (dNConsultasFena == null) {
			dNConsultasFena = new DNConsultasFena();
		}

		if (mBUsuario == null) {

			mBUsuario = (MBUsuario) UtilidadesWeb.getManagedBean("MBUsuario");

		}
		TpagareMaestroLiquidacion consultaCodigo = dNConsultasFena.buscarNumeroAprobacion(numeroAprobacion);
		if (consultaCodigo != null) {
			mensajes.mostrarMensaje("El n�mero de aprobaci�n ya esta registrado.", 2);
		} else {

			if (voAprobacion.getValorTotal().equalsIgnoreCase(valorTotalFinanciar)
					&& voAprobacion.getNumeroCuotas().equalsIgnoreCase(plazoMeses)) {

				CargarArchivosPropiedadesUtil prop = new CargarArchivosPropiedadesUtil();

				String productoCredito = prop.getProperty("parametros.properties", "PRODUCTO_CREDITO_AT");

				List<Long> afiliadosMakroPg = new ArrayList<Long>();

				afiliadosMakroPg = prop.getListProperty("parametros.properties", "COD_AFILIADOS_MAKRO_PG", ",");

				String usuario = mBUsuario.getUsuario().getUserId();

				TpagareMaestroLiquidacion registrar = new TpagareMaestroLiquidacion();

				registrar.setNumeroAprobacion(numeroAprobacion);
				registrar.setTasaInteres(maestroCuotasVO.getValorIntereses());
				registrar.setTotalNegocio(maestroCuotasVO.getMonto());
				registrar.setFecha(new Date());

				registrar.setUsuario(usuario);
				registrar.setRsecod("3");
				registrar.setSeccional("0");
				registrar.setAfiliado(codigoAfiliado);
				registrar.setSucursal("0");
				registrar.setIdProd("3");
				if (afiliadosMakroPg.contains(new Long(codigoAfiliado))) {
					registrar.setAtributo1("0");

				} else {
					registrar.setAtributo1(semestre);
				}

				registrar.setAtributo2(plazoMeses);
				registrar.setAtributo3(maestroCuotasVO.getValorOtrasPlazas());
				registrar.setAtributo4(maestroCuotasVO.getValorComisionFCH());
				registrar.setAtributo5("0");
				registrar.setReferencia1(cedulaGirador.replace(".", ""));
				registrar.setReferencia2(nombre);
				registrar.setReferencia3(programa);
				registrar.setReferencia4("Pagare");
				registrar.setReferencia5(voAprobacion.getCedulaGirador());
				registrar.setReferencia6(voAprobacion.getNombreGirador());
				registrar.setReferencia7(referencia);
				registrar.setReferencia8(periodo);
				if (afiliadosMakroPg.contains(new Long(codigoAfiliado))) {
					registrar.setReferencia11(df.parse(fechaPrimeraCuota));

				} else {
					registrar.setReferencia11(maestroCuotasVO.getFechaVencimiento());
				}

				TpagareMaestroLiquidacion tempTpagareMaestroLiquidacion = dNConsultasFena.registrarMaestro(registrar);

				if (tempTpagareMaestroLiquidacion != null) {

					TpagareDetalleLiquidacion tempTpagareDetalleLiquidacion = null;
					for (int i = 0; i < maestroCuotasVO.getCuotas().size(); i++) {

						tempTpagareDetalleLiquidacion = new TpagareDetalleLiquidacion();
						tempTpagareDetalleLiquidacion.setIdMali(tempTpagareMaestroLiquidacion.getIdMali());
						tempTpagareDetalleLiquidacion.setNumCuota(maestroCuotasVO.getCuotas().get(i).getNoCuota() + "");
						tempTpagareDetalleLiquidacion
								.setValorCapital(maestroCuotasVO.getCuotas().get(i).getValorCapital() + "");
						tempTpagareDetalleLiquidacion
								.setValorInteres(maestroCuotasVO.getCuotas().get(i).getValorIntereses() + "");
						tempTpagareDetalleLiquidacion
								.setValorCuota(maestroCuotasVO.getCuotas().get(i).getTotalCuotas() + "");
						tempTpagareDetalleLiquidacion
								.setSaldoCapital(maestroCuotasVO.getCuotas().get(i).getSaldoCapital() + "");

						tempTpagareDetalleLiquidacion
								.setFechaVencimiento(maestroCuotasVO.getCuotas().get(i).getFechaVencimiento() + "");
						tempTpagareDetalleLiquidacion.setNumeroPagare(numeroAprobacion);
						tempTpagareDetalleLiquidacion
								.setValorCapital(maestroCuotasVO.getCuotas().get(i).getValorCapital() + "");
						tempTpagareDetalleLiquidacion
								.setAtributo1(maestroCuotasVO.getCuotas().get(i).getComisionFenalcheque() + "");
						tempTpagareDetalleLiquidacion
								.setAtributo2(maestroCuotasVO.getCuotas().get(i).getOtrasPlazas() + "");
						tempTpagareDetalleLiquidacion
								.setAtributo3(maestroCuotasVO.getCuotas().get(i).getPortesTelex() + "");
						tempTpagareDetalleLiquidacion.setAtributo4("0");
						tempTpagareDetalleLiquidacion
								.setAtributo5(maestroCuotasVO.getCuotas().get(i).getComisionTransferencia() + "");
						dNConsultasFena.registrarDetalle(tempTpagareDetalleLiquidacion);

					}

					TatTempLiquidacion tempTatTempLiquidacion = new TatTempLiquidacion();
					tempTatTempLiquidacion.setAfiliado(codigoAfiliado);
					tempTatTempLiquidacion.setIdMali(tempTpagareMaestroLiquidacion.getIdMali());

					dNConsultasFena.registrarTemporalReporteUAO(tempTatTempLiquidacion);
				}

				mensajes.mostrarMensaje("Se ha registrado con �xito la aprobaci�n N�: " + numeroAprobacion, 1);

			} else {
				mensajes.mostrarMensaje(
						"El n�mero de autorizaci�n, el valor, la cedula, las cuotas son inv�lidos o no corresponden a la negociaci�n - por favor verifique los datos ingresados",
						2);
			}

		}

	}

	public String consultar() throws Exception {

		if (dNConsultasFena == null) {
			dNConsultasFena = new DNConsultasFena();
		}

		if (dNConsultasAS400 == null) {
			dNConsultasAS400 = new DNConsultasAS400();
		}

		if (dNConsultasOpencard == null) {
			dNConsultasOpencard = new DNConsultasOpencard();
		}
		limpiar();
		panelAprobacion = false;
		if (codigoAfiliado.length() == 8) {

//			String aficodscc = codigoAfiliado.charAt(0) + "";
//			String aficon = codigoAfiliado.substring(1, 6);
//			String afinumsuc = codigoAfiliado.substring(6, 8);

//			afiliadoConsultado = dNConsultasAS400.consultarAfiliadoCupo(aficodscc, aficon, afinumsuc);
//			System.out.println("DATOS AS 400");
//
//			if (afiliadoConsultado != null) {
//				System.out.println(afiliadoConsultado.getNombre());
//				System.out.println(afiliadoConsultado.getSector());
//
//			}

			if (afiliadoConsultado == null) {

				afiliadoConsultado = dNConsultasOpencard.consultarAfiliado(codigoAfiliado);
				System.out.println("DATOS OPENCARD");
				if (afiliadoConsultado != null) {
					System.out.println(afiliadoConsultado.getNombre());
					System.out.println(afiliadoConsultado.getSector());

				}
			}

			if (afiliadoConsultado != null) {
				System.out.println("PASO VALIDACION");

				TatComisionFenalcheque tempComisionFenalcheque = dNConsultasFena
						.buscarComisionFenalCheque(codigoAfiliado);

				if (tempComisionFenalcheque != null) {

					if (tempComisionFenalcheque.getCodigoBarras().equalsIgnoreCase("S")) {
						codigoBarras = true;
					} else {
						codigoBarras = false;
					}

					tempPagareTasaInteres = dNConsultasFena.buscarTasaInteresPagare(codigoAfiliado);

					if (tempPagareTasaInteres != null) {

						String primeraCuota = incrementarMesFecha(new Date());

						Date fechaDia = new Date();

						fecha = df.format(fechaDia);

						fechaPrimeraCuota = primeraCuota;
						new Timestamp(df.parse(primeraCuota).getTime());

						// ttProductosFinanciero =
						// dNTProductosFinanciero.buscarporID(codigoAfiliado);

						// limpiar();

						// navegarLiquidaror();

					} else {
						mensajes.mostrarMensaje(
								"No hay parametrizacion de la TASA INTERES para el codigo: " + codigoAfiliado, 2);

					}

				} else {
					mensajes.mostrarMensaje(
							"No hay parametrizacion de la COMISION FENALCHEQUE para el codigo: " + codigoAfiliado, 2);
				}

			} else {
				mensajes.mostrarMensaje("No se encontr� afiliado con el c�digo ingresado.", 2);

			}

		} else {

			mensajes.mostrarMensaje("El c�digo del afiliado debe ser de 8 digitos.", 2);

		}

		return null;
	}

	public void navegarLiquidaror() {

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url2 = extContext.encodeActionURL(
					context.getApplication().getViewHandler().getActionURL(context, "/jsp/liquidadorAdminTotal.xhtml"));
			extContext.redirect(url2);
		} catch (Exception exception) {
			if (exception instanceof BaseException) {

				mensajes.mostrarMensaje((BaseException) exception);
			} else {
				BaseException BaseException = new BaseException(exception, null, null);
				mensajes.mostrarMensaje(BaseException);
			}
		}

	}

	public void consultarAprobacion() throws Exception {
		if (dNConsultasOpencard == null) {
			dNConsultasOpencard = new DNConsultasOpencard();
		}

		if (dNConsultasFena == null) {
			dNConsultasFena = new DNConsultasFena();
		}

		TpagareMaestroLiquidacion consultaCodigo = dNConsultasFena.buscarNumeroAprobacion(numeroAprobacion);
		if (consultaCodigo != null) {
			mensajes.mostrarMensaje("El n�mero de aprobaci�n ya esta registrado.", 2);

		} else {

			voAprobacion = dNConsultasOpencard.consultarAprobacion(numeroAprobacion, codigoAfiliado);

			if (voAprobacion != null) {

				if (voAprobacion.getCodigoAfiliado().equalsIgnoreCase(codigoAfiliado)) {
					listaDetalleAprobacion = dNConsultasOpencard.consultarDetalleAprobacion(numeroAprobacion,
							codigoAfiliado);
					panelAprobacion = true;

				} else {
					mensajes.mostrarMensaje("No existe esta aprobaci�n - o no pertenece al afiliado no "
							+ codigoAfiliado + " - " + afiliadoConsultado.getNombre() + ".", 2);

				}

			} else {
				mensajes.mostrarMensaje("No existe esta aprobaci�n - o no pertenece al afiliado no " + codigoAfiliado
						+ " - " + afiliadoConsultado.getNombre() + ".", 2);

			}
		}

	}

	public void regresarLiquidar() {

		try {
			voAprobacion = null;
			listaDetalleAprobacion = null;
			panelAprobacion = false;
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url2 = extContext.encodeActionURL(
					context.getApplication().getViewHandler().getActionURL(context, "/jsp/liquidadorAdminTotal.xhtml"));
			extContext.redirect(url2);
		} catch (Exception exception) {
			if (exception instanceof BaseException) {

				mensajes.mostrarMensaje((BaseException) exception);
			} else {
				BaseException BaseException = new BaseException(exception, null, null);
				mensajes.mostrarMensaje(BaseException);
			}
		}

	}

	public void navegarAprobacion() {

		if (valorCuotaMostrar != null) {

			try {
				FacesContext context = FacesContext.getCurrentInstance();
				ExternalContext extContext = context.getExternalContext();
				String url2 = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,
						"/jsp/liquidadorAdminTotalAprobacion.xhtml"));
				extContext.redirect(url2);
			} catch (Exception exception) {
				if (exception instanceof BaseException) {

					mensajes.mostrarMensaje((BaseException) exception);
				} else {
					BaseException BaseException = new BaseException(exception, null, null);
					mensajes.mostrarMensaje(BaseException);
				}
			}
		} else

		{

			mensajes.mostrarMensaje("Debe liquidar primero para poder pasar al paso de aprobaci�n.", 2);
		}
	}

	public void regresar() {
		panelPaso1 = true;
		panelPaso2 = false;

		universidadSeleccionada = null;
		nombreEstudiante = null;
		correo = null;
		celular = null;
		codigoOTP = null;

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url2 = extContext.encodeActionURL(
					context.getApplication().getViewHandler().getActionURL(context, "/jsp/preLiquidacion.xhtml"));
			extContext.redirect(url2);
		} catch (Exception exception) {
			if (exception instanceof BaseException) {

				mensajes.mostrarMensaje((BaseException) exception);
			} else {
				BaseException BaseException = new BaseException(exception, null, null);
				mensajes.mostrarMensaje(BaseException);
			}
		}

	}

	public void limpiar() {
		cedulaGirador = null;
		nombre = null;
		semestre = null;
		programa = null;
		referencia = null;
		periodo = null;
		valorLiquidar = null;
		plazoMeses = null;
		valorCuotaMostrar = null;
		tipoLiquidacionSeleccionado = null;
		textoCodigoBarras = null;

	}

	public String liquidar() throws Exception {

		CargarArchivosPropiedadesUtil prop = new CargarArchivosPropiedadesUtil();

		String productoCredito = prop.getProperty("parametros.properties", "PRODUCTO_CREDITO_AT");

		List<Long> afiliadosMakroPg = new ArrayList<Long>();

		afiliadosMakroPg = prop.getListProperty("parametros.properties", "COD_AFILIADOS_MAKRO_PG", ",");

		if (afiliadosMakroPg.contains(new Long(codigoAfiliado))) {

			if (valorLiquidar.length() > 0 && plazoMeses.length() > 0) {

				semestre = "0";

				valorLiquidar = valorLiquidar.replace(".", "");
				cedulaGirador = cedulaGirador.replace(".", "");

				maestroCuotasVO = generarTablaAmortizacion(new Timestamp(df.parse(fechaPrimeraCuota).getTime()),
						valorLiquidar, plazoMeses);

			} else {
				mensajes.mostrarMensaje("El valor a liquidar y plazo son obligatorios. ", 2);
			}
		} else {

			if (valorLiquidar.length() > 0 && plazoMeses.length() > 0) {

				valorLiquidar = valorLiquidar.replace(".", "");

				maestroCuotasVO = generarTablaAmortizacion(new Timestamp(df.parse(fechaPrimeraCuota).getTime()),
						valorLiquidar, plazoMeses);

			} else {
				mensajes.mostrarMensaje("El valor a liquidar y plazo son obligatorios. ", 2);
			}
		}

		return null;

	}

	public void setToBean() {
		System.out.println("paso");
		System.out.println(valorLiquidar);

	}

	public MaestroCuotasVO generarTablaAmortizacion(Timestamp fechaLiquidacion, String tempvalorLiquidar,
			String tempplazo) throws Exception {

		Double valorLiquidar = Double.parseDouble(tempvalorLiquidar);

		Double Comision = 0.0D;

		int plazo = Integer.parseInt(tempplazo);

		if (dNConsultasFena == null) {
			dNConsultasFena = new DNConsultasFena();
		}

		if (dNConsultasFena == null) {
			dNConsultasFena = new DNConsultasFena();
		}

		Double totalNegocio = 0.0;
		CuotasVO cuota1 = new CuotasVO();
		Double valorTotalIntereses = 0.0;
		Double valorTotalComisionFCH = 0.0;
		Double valorTotalOtrasPlazas = 0.0;
		Double valorAval = 0.0;
		Double valorLiq = valorLiquidar;
		Double valorComisionTransferencia = 0.0;

		MaestroCuotasVO resultado = new MaestroCuotasVO();

		String fecha = df.format(fechaLiquidacion);

		Double factorIva = 0.0;

		CargarArchivosPropiedadesUtil prop = new CargarArchivosPropiedadesUtil();

		String productoCredito = prop.getProperty("parametros.properties", "PRODUCTO_CREDITO_AT");
		factorIva = Double.parseDouble(prop.getProperty("parametros.properties", "FACTOR_IVA"));

		Double comisTransferencia = 0.0;

		comisTransferencia = dNConsultasFena.ComisionTransferenciaxProducto(productoCredito);

		System.out.println("4 / 1000 :" + comisTransferencia);

		Double comisionFCH = null;
		Double fondoSolidaridad = null;
		Double IdTcfc = null;
		Double comision = null;

		String tasaPreferencial = "";

		TatComisionFenalcheque tempComisionFenalcheque = dNConsultasFena.buscarComisionFenalCheque(codigoAfiliado);
		if (tempComisionFenalcheque != null) {
			comisionFCH = Double.parseDouble(tempComisionFenalcheque.getValor());
			fondoSolidaridad = Double.parseDouble(tempComisionFenalcheque.getFondoSolidaridad());

			IdTcfc = Double.parseDouble(tempComisionFenalcheque.getIdTcfc());
			tasaPreferencial = tempComisionFenalcheque.getTasaPreferencial();

			comision = Double.parseDouble(tempComisionFenalcheque.getComision());
		} else {
			mensajes.mostrarMensaje(
					"No hay parametrizacion de la COMISION FENALCHEQUE para el codigo: " + codigoAfiliado, 2);
		}

		TatOtrasPlaza tempTatOtrasPlaza = dNConsultasFena.consultarOtrasPlazas();

		Double porcentajeAdicion = null;
		Double iva = null;
		Double valorTope = null;
		Double portesTelex = null;

		if (tempTatOtrasPlaza != null) {

			porcentajeAdicion = Double.parseDouble(tempTatOtrasPlaza.getPorcentajeAdicion());

			iva = Double.parseDouble(tempTatOtrasPlaza.getIva());

			valorTope = Double.parseDouble(tempTatOtrasPlaza.getValorTope());

			portesTelex = Double.parseDouble(tempTatOtrasPlaza.getAdicionaPortesTelex());

		} else {

			mensajes.mostrarMensaje("No hay parametrizacion en TAT_OTRAS_PLAZAS", 2);

		}

		valorLiquidar = valorLiquidar + valorLiquidar * fondoSolidaridad.doubleValue() / 100.0;
		valorLiq = valorLiq + valorLiq * fondoSolidaridad.doubleValue() / 100.0;
		valorAval = valorLiq * comisionFCH.doubleValue() / 100.0;
		valorLiq = valorLiq + valorAval;
		valorComisionTransferencia = (double) Math.round((valorLiquidar * comisTransferencia / 100.0) / factorIva);
		Double valorComisXcuota = (double) Math.round(valorComisionTransferencia / plazo);

		resultado.setMonto(imprimirDouble(valorLiquidar.doubleValue(), null));

		Double interes = null;
		if (tasaPreferencial.equalsIgnoreCase("N")) {

			TpagareTasaInteres tempPagareTasaInteres = dNConsultasFena.buscarTasaInteresPagare(codigoAfiliado);

			if (tempPagareTasaInteres != null) {

				interes = Double.parseDouble(tempPagareTasaInteres.getValor());

			} else {
				mensajes.mostrarMensaje("No hay parametrizacion de la TASA INTERES para el codigo: " + codigoAfiliado,
						2);

			}

		}

		Date fechaVencimiento = null;

		resultado.setTasaInteres(interes.doubleValue());

		List<CuotasVO> cuotas = new ArrayList<CuotasVO>();

		Double valorIntereses = valorLiq * interes.doubleValue() / 100;
		Double valorCuota = calcularCuota(valorLiq.intValue(), interes.doubleValue() / 100, plazo);

		Double valorCuotaEnviar = (double) Math.round(valorCuota);
		DecimalFormat dec = new DecimalFormat("#");
		dec.setMaximumFractionDigits(18);
		String valorcuotaEnviarString = dec.format(valorCuotaEnviar);

		valorCuotaMostrar = ponerPuntos(valorcuotaEnviarString);

		BigDecimal x = (new BigDecimal(valorCuotaMostrar.replace(".", ""))).add(new BigDecimal("11900"));

		valorCuotaMostrar = ponerPuntos(x.toString());

		Double valorCapital = valorCuota - valorIntereses;

		TpagareFechasVencimiento tempTpagareFechasVencimiento = dNConsultasFena.buscarFechasVencimientoPagare();

		Date date = new java.util.Date();
		Timestamp hoy = new Timestamp(date.getTime());

		if (tempTpagareFechasVencimiento != null) {

			fechaVencimiento = tempTpagareFechasVencimiento.getFechaVencimiento();

			resultado.setFechaVencimiento(fechaVencimiento);

		} else {
			mensajes.mostrarMensaje("No hay fecha de vencimiento configurada", 2);
		}

		int dias = calcularDiasFechas(new Timestamp(System.currentTimeMillis()), new Date(fechaVencimiento.getTime()));

		double intereses = dias * (interes.doubleValue() / 100) / 30 * valorLiq;

		cuota1.setTotalCuotas(imprimirDouble((valorCapital + intereses + valorComisXcuota), null));
		cuota1.setValorIntereses(imprimirDouble(intereses, null));
		cuota1.setFechaVencimiento(df.format(fechaVencimiento));

		cuota1.setNoCuota(1);
		cuota1.setSaldoCapital(imprimirDouble((valorLiq - valorCapital), null));
		totalNegocio += Double.parseDouble(cuota1.getTotalCuotas());
		cuota1.setValorCapital(imprimirDouble(valorCapital, null));
		cuota1.setComisionTransferencia(imprimirDouble(valorComisXcuota, null));
		// Se adiciona la primera cuota a la lista de cuotas
		cuotas.add(0, cuota1);

		double totalComisXcuota = valorComisXcuota;
		/* Calculamos las cuotas restantes */
		for (int i = 1; i < plazo; i++) {

			valorIntereses = Double.parseDouble(cuotas.get(i - 1).getSaldoCapital()) * interes.doubleValue() / 100;
			CuotasVO cuo = new CuotasVO();
			cuo.setNoCuota(i + 1);
			cuo.setValorCapital(imprimirDouble((valorCuota - valorIntereses), null));
			cuo.setValorIntereses(imprimirDouble(valorIntereses, null));
			cuo.setTotalCuotas(imprimirDouble(valorCuota, null));
			totalNegocio += Double.parseDouble(cuo.getTotalCuotas());
			cuo.setSaldoCapital(imprimirDouble((Double.parseDouble(cuotas.get(i - 1).getSaldoCapital())
					- Double.parseDouble(cuo.getValorCapital())), null));

			// Calculamos la fecha de vencimiento aumentando en un mes la fecha
			// de vencimiento de la cuota anterior
			if (validarFechaAnterior(df.parse(cuotas.get(i - 1).getFechaVencimiento()))) {
				if (i != 1) {
					cuo.setFechaVencimiento(
							incrementarDosMesesFecha(df.parse(cuotas.get(i - 2).getFechaVencimiento())));
				} else {
					cuo.setFechaVencimiento(incrementarMesFecha(df.parse(cuotas.get(i - 1).getFechaVencimiento())));
				}
			} else {
				cuo.setFechaVencimiento(incrementarMesFecha(df.parse(cuotas.get(i - 1).getFechaVencimiento())));
			}
			// Si es la ultima cuota se redondea a cero el saldo a capital
			if (i == (plazo - 1)) {
				cuo.setSaldoCapital("0");
			}
			cuotas.add(i, cuo);
		}

		// Se le aplica la comision de fenalcheque al valor de cada cuota
		double tempFCH = 0.0;
		// tempFCH=Math.round(valorComisionTransferencia/plazo);
		tempFCH = Math.round(valorAval / plazo);
		for (CuotasVO c : cuotas) {
			totalComisXcuota += totalComisXcuota;

			// tempFCH = (Double.parseDouble(c.getTotalCuotas()) *
			// (comisionFCH.doubleValue() / 100) * iva.doubleValue());
			c.setTotalCuotas(imprimirDouble(Double.parseDouble(c.getTotalCuotas()), null));

			// Le asignamos el valor de la comision fch a cada cuota
			c.setComisionFenalcheque(imprimirDouble(tempFCH, null));
			// asignamos la comision de transferencia//
			c.setComisionTransferencia(imprimirDouble(valorComisXcuota, null));

			// Le asignamos 0 a portes y telex
			c.setOtrasPlazas("0");
			c.setPortesTelex("0");

			valorTotalComisionFCH += tempFCH;
			valorTotalIntereses += Double.parseDouble(c.getValorIntereses());
		}

		// Asignamos los valores al objeto que se enviara como resultado
		resultado.setCuotas(cuotas);

		resultado.setValorComisionFCH(imprimirDouble(valorTotalComisionFCH, null));
		resultado.setValorIntereses(imprimirDouble(valorTotalIntereses, null));
		resultado.setValorOtrasPlazas(imprimirDouble(valorTotalOtrasPlazas, null));
		resultado.setValorComisionTransferencia(imprimirDouble(valorComisionTransferencia, null));

		resultado.setValorAval(imprimirDouble(valorAval, null));

		estudioCredito = imprimirDouble(((valorLiquidar / comision) - valorLiquidar), null);
		resultado.setValorComisionFCH(estudioCredito);
		valorTotalFinanciar = imprimirDouble(((valorLiquidar / comision)), null);

		return resultado;

	}

	public String imprimirDouble(double valor, String patron) {

		return Math.round(valor) + "";
	}

	private int calcularDiasFechas(Timestamp fechaInicial, Date fechaFinal) {
		return (int) (((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000) + 1);
	}

	public String incrementarDosMesesFecha(Date fecha) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(fecha);
		int mesActual = gc.get(GregorianCalendar.MONTH);
		if (mesActual == GregorianCalendar.NOVEMBER) {
			mesActual = GregorianCalendar.JANUARY;
			gc.set(GregorianCalendar.YEAR, gc.get(GregorianCalendar.YEAR) + 1);
		} else if (mesActual == GregorianCalendar.DECEMBER && gc.get(GregorianCalendar.DATE) > 28) {
			mesActual += 2;
			if (esBisiesto(gc.get(GregorianCalendar.YEAR) + "")) {
				gc.set(GregorianCalendar.DATE, 29);
			} else {
				gc.set(GregorianCalendar.DATE, 28);
			}
		} else {
			mesActual += 2;
		}
		gc.set(GregorianCalendar.MONTH, mesActual);
		// SimpleDateFormat df = new SimpleDateFormat(
		// "dd/MMM/yyyy", new Locale("en_EN"));
		return df.format(gc.getTime());
	}

	public boolean validarFechaAnterior(Date fecha) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(fecha);
		int mesActual = gc.get(GregorianCalendar.MONTH);
		if (mesActual == GregorianCalendar.FEBRUARY) {
			return true;
		} else {
			return false;
		}
	}

	private double calcularCuota(int valor, double interes, int meses) {

		return valor * ((interes * Math.pow((1 + interes), meses)) / (Math.pow((1 + interes), meses) - 1));
	}

	public String formateaDouble(double numero) {
		BigDecimal trans = new BigDecimal(numero);
		return trans.toString();
	}

	public String incrementarMesFecha(Date fecha) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(fecha);
		int mesActual = gc.get(GregorianCalendar.MONTH);
		int diaActual = gc.get(GregorianCalendar.DATE);
		if (mesActual == GregorianCalendar.DECEMBER) {
			mesActual = GregorianCalendar.JANUARY;
			gc.set(GregorianCalendar.YEAR, gc.get(GregorianCalendar.YEAR) + 1);
		} else if (mesActual == GregorianCalendar.JANUARY && gc.get(GregorianCalendar.DATE) > 28) {
			mesActual++;
			if (esBisiesto(gc.get(GregorianCalendar.YEAR) + "")) {
				gc.set(GregorianCalendar.DATE, 29);
			} else {
				gc.set(GregorianCalendar.DATE, 28);
			}
		} else if (diaActual == 31 && (mesActual == GregorianCalendar.MARCH || mesActual == GregorianCalendar.MAY
				|| mesActual == GregorianCalendar.AUGUST || mesActual == GregorianCalendar.OCTOBER)) {
			gc.set(GregorianCalendar.DATE, 30);
			mesActual++;
		} else {
			mesActual++;
		}
		gc.set(GregorianCalendar.MONTH, mesActual);
		// SimpleDateFormat df = new SimpleDateFormat(
		// "dd/MMM/yyyy", new Locale("en_EN"));
		return df.format(gc.getTime());
	}

	public boolean esBisiesto(String anio) {
		boolean BISIESTO;
		if (Integer.parseInt(anio) % 4 == 0) {
			if (Integer.parseInt(anio) % 100 == 0) {
				if (Integer.parseInt(anio) % 400 == 0) {
					BISIESTO = true;
				} else {
					BISIESTO = false;
				}
			} else {
				BISIESTO = true;
			}
		} else
			BISIESTO = false;

		return BISIESTO;
	}

	public String quitarpunto(String dato) {
		String dato2 = "";
		for (int i = 0; i < dato.length(); i++) {
			char b = dato.charAt(i);
			if (i == '.') {
				System.out.println("quito puntos");
			} else {
				dato2 += dato.charAt(i);
			}
		}
		return dato2;
	}

	@SuppressWarnings("unchecked")
	public void generarReportePreliquidacion() throws Exception {

		if (valorCuotaMostrar != null) {

			if (mBUsuario == null) {

				mBUsuario = (MBUsuario) UtilidadesWeb.getManagedBean("MBUsuario");

			}

			ParametrosWeb param = (ParametrosWeb) UtilidadesWeb.getManagedBean("Parametros");
			@SuppressWarnings("rawtypes")
			HashMap parametros = new HashMap();
			parametros.put("CELULAR", procesarCelular(celular));
			parametros.put("NOMBRE", nombreEstudiante);
			parametros.put("CORREO", correo);
			parametros.put("VALORCOMPRA", valorLiquidar);
			parametros.put("PLAZO", plazoMeses);
//			parametros.put("INTERES", tempPagareTasaInteres.getValor());
			parametros.put("TOTALFINANCIAR", ponerPuntos(valorTotalFinanciar));

			// BigDecimal x= (new BigDecimal(valorCuotaMostrar.replace(".", ""))).add(new
			// BigDecimal("11900"));

			parametros.put("VALORCUOTA", valorCuotaMostrar);

			parametros.put("ESTUDIO", estudioCredito);

			String usurRegistrar = "";

			if (mBUsuario == null) {

				mBUsuario = (MBUsuario) UtilidadesWeb.getManagedBean("MBUsuario");
			}

			usurRegistrar = mBUsuario.getUsuario().getUserId();

			parametros.put("OPERADOR", usurRegistrar);// BIEN*/

			GenerarReportes.generarReporte99(FacesContext.getCurrentInstance(), "1", Parametros.FORMATO_PDF, parametros,
					param.getCONTEXTO_APP(), Parametros.RUTA_JASPER, Parametros.RUTA_PDF, Parametros.RUTA_IMG);

		} else {

			mensajes.mostrarMensaje("Debe liquidar primero para descargar la liquidaci�n.", 2);
		}

	}

	@SuppressWarnings("unchecked")
	public void generarReporteliquidacion() throws Exception {

		TpagareMaestroLiquidacion consultaCodigo = dNConsultasFena.buscarNumeroAprobacion(numeroAprobacion);
		if (consultaCodigo != null) {

			if (mBUsuario == null) {

				mBUsuario = (MBUsuario) UtilidadesWeb.getManagedBean("MBUsuario");

			}

			ParametrosWeb param = (ParametrosWeb) UtilidadesWeb.getManagedBean("Parametros");
			@SuppressWarnings("rawtypes")
			HashMap parametros = new HashMap();
			parametros.put("NOAUTORIZACION", numeroAprobacion);

			String usurRegistrar = "";

			if (mBUsuario == null) {

				mBUsuario = (MBUsuario) UtilidadesWeb.getManagedBean("MBUsuario");
			}

			usurRegistrar = mBUsuario.getUsuario().getUserId();

			parametros.put("OPERADOR", usurRegistrar);// BIEN*/

			GenerarReportes.generarReporte8(FacesContext.getCurrentInstance(), "1", Parametros.FORMATO_PDF, parametros,
					param.getCONTEXTO_APP(), Parametros.RUTA_JASPER, Parametros.RUTA_PDF, Parametros.RUTA_IMG);
		} else {

			mensajes.mostrarMensaje("El n�mero de aprobaci�n no esta registrado.", 2);
		}

	}

	public String ponerPuntos(String numeroconpuntos) {
		int cont = 0;
		String cadenanueva = "";
		String cadenanueva2 = "";
		String cadenanueva3 = "";

		for (int x = numeroconpuntos.length() - 1; x >= 0; x--) {
			char b = numeroconpuntos.charAt(x);
			cont++;
			cadenanueva += numeroconpuntos.charAt(x);
			if (cont == 3) {
				cadenanueva += ".";
				cont = 0;
			}
		}

		for (int x = cadenanueva.length() - 1; x >= 0; x--) {
			char b = cadenanueva.charAt(x);
			cadenanueva2 += cadenanueva.charAt(x);
		}

		for (int i = 0; i < cadenanueva2.length(); i++) {
			char b = cadenanueva2.charAt(i);
			if (i == 0) {
				if (b == '.') {
					cadenanueva3 = quitarpuntoinicion(cadenanueva2);
					break;
				} else {
					cadenanueva3 = cadenanueva2;
					break;
				}
			} else {
				cadenanueva3 = cadenanueva2;
				break;
			}
		}
		return cadenanueva3;
	}

	public String quitarpuntoinicion(String dato) {
		String dato2 = "";
		for (int i = 0; i < dato.length(); i++) {
			char b = dato.charAt(i);
			if (i == 0) {
				if (b == '.') {
				}
			} else {
				dato2 += dato.charAt(i);
			}
		}
		return dato2;
	}

	public String getCodigoAfiliado() {
		return codigoAfiliado;
	}

	public void setCodigoAfiliado(String codigoAfiliado) {
		this.codigoAfiliado = codigoAfiliado;
	}

	public TProductosFinanciero getTtProductosFinanciero() {
		return ttProductosFinanciero;
	}

	public void setTtProductosFinanciero(TProductosFinanciero ttProductosFinanciero) {
		this.ttProductosFinanciero = ttProductosFinanciero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFechaPrimeraCuota() {
		return fechaPrimeraCuota;
	}

	public void setFechaPrimeraCuota(String fechaPrimeraCuota) {
		this.fechaPrimeraCuota = fechaPrimeraCuota;
	}

	public String getCedulaGirador() {
		return cedulaGirador;
	}

	public void setCedulaGirador(String cedulaGirador) {
		this.cedulaGirador = cedulaGirador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getValorLiquidar() {
		return valorLiquidar;
	}

	public void setValorLiquidar(String valorLiquidar) {
		this.valorLiquidar = valorLiquidar;
	}

	public String getPlazoMeses() {
		return plazoMeses;
	}

	public void setPlazoMeses(String plazoMeses) {
		this.plazoMeses = plazoMeses;
	}

	public String getNombreApp() {
		return nombreApp;
	}

	public void setNombreApp(String nombreApp) {
		this.nombreApp = nombreApp;
	}

	public VOAfiliado getAfiliadoConsultado() {
		return afiliadoConsultado;
	}

	public void setAfiliadoConsultado(VOAfiliado afiliadoConsultado) {
		this.afiliadoConsultado = afiliadoConsultado;
	}

	public TpagareTasaInteres getTempPagareTasaInteres() {
		return tempPagareTasaInteres;
	}

	public void setTempPagareTasaInteres(TpagareTasaInteres tempPagareTasaInteres) {
		this.tempPagareTasaInteres = tempPagareTasaInteres;
	}

	public TatComisionFenalcheque getTempComisionFenalcheque() {
		return tempComisionFenalcheque;
	}

	public void setTempComisionFenalcheque(TatComisionFenalcheque tempComisionFenalcheque) {
		this.tempComisionFenalcheque = tempComisionFenalcheque;
	}

	public String getValorCuotaMostrar() {
		return valorCuotaMostrar;
	}

	public void setValorCuotaMostrar(String valorCuotaMostrar) {
		this.valorCuotaMostrar = valorCuotaMostrar;
	}

	public String getValorTotalFinanciar() {
		return valorTotalFinanciar;
	}

	public void setValorTotalFinanciar(String valorTotalFinanciar) {
		this.valorTotalFinanciar = valorTotalFinanciar;
	}

	public String getEstudioCredito() {
		return estudioCredito;
	}

	public void setEstudioCredito(String estudioCredito) {
		this.estudioCredito = estudioCredito;
	}

	public VOAprobacion getVoAprobacion() {
		return voAprobacion;
	}

	public void setVoAprobacion(VOAprobacion voAprobacion) {
		this.voAprobacion = voAprobacion;
	}

	public String getNumeroAprobacion() {
		return numeroAprobacion;
	}

	public void setNumeroAprobacion(String numeroAprobacion) {
		this.numeroAprobacion = numeroAprobacion;
	}

	public boolean isPanelAprobacion() {
		return panelAprobacion;
	}

	public void setPanelAprobacion(boolean panelAprobacion) {
		this.panelAprobacion = panelAprobacion;
	}

	public List<VODetalleAprobacion> getListaDetalleAprobacion() {
		return listaDetalleAprobacion;
	}

	public void setListaDetalleAprobacion(List<VODetalleAprobacion> listaDetalleAprobacion) {
		this.listaDetalleAprobacion = listaDetalleAprobacion;
	}

	public MaestroCuotasVO getMaestroCuotasVO() {
		return maestroCuotasVO;
	}

	public void setMaestroCuotasVO(MaestroCuotasVO maestroCuotasVO) {
		this.maestroCuotasVO = maestroCuotasVO;
	}

	public String getTipoLiquidacionSeleccionado() {
		return tipoLiquidacionSeleccionado;
	}

	public void setTipoLiquidacionSeleccionado(String tipoLiquidacionSeleccionado) {
		this.tipoLiquidacionSeleccionado = tipoLiquidacionSeleccionado;
	}

	public boolean isCodigoBarras() {
		return codigoBarras;
	}

	public String getTextoCodigoBarras() {
		return textoCodigoBarras;
	}

	public void setTextoCodigoBarras(String textoCodigoBarras) {
		this.textoCodigoBarras = textoCodigoBarras;
	}

	public void setCodigoBarras(boolean codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public DNConsultasFena getdNConsultasFena() {
		return dNConsultasFena;
	}

	public void setdNConsultasFena(DNConsultasFena dNConsultasFena) {
		this.dNConsultasFena = dNConsultasFena;
	}

	public ArrayList<SelectItem> getListUniversidades() {
		return listUniversidades;
	}

	public void setListUniversidades(ArrayList<SelectItem> listUniversidades) {
		this.listUniversidades = listUniversidades;
	}

	public String getUniversidadSeleccionada() {
		return universidadSeleccionada;
	}

	public void setUniversidadSeleccionada(String universidadSeleccionada) {
		this.universidadSeleccionada = universidadSeleccionada;
	}

	public boolean isListUniversidad() {
		return listUniversidad;
	}

	public void setListUniversidad(boolean listUniversidad) {
		this.listUniversidad = listUniversidad;
	}

	public boolean isInputUniversidad() {
		return inputUniversidad;
	}

	public void setInputUniversidad(boolean inputUniversidad) {
		this.inputUniversidad = inputUniversidad;
	}

	public String getCodigoUniversidad() {
		return codigoUniversidad;
	}

	public void setCodigoUniversidad(String codigoUniversidad) {
		this.codigoUniversidad = codigoUniversidad;
	}

	public TsolicUniversidad getTsolicUniversidadEntity() {
		return tsolicUniversidadEntity;
	}

	public void setTsolicUniversidadEntity(TsolicUniversidad tsolicUniversidadEntity) {
		this.tsolicUniversidadEntity = tsolicUniversidadEntity;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isPanelPaso1() {
		return panelPaso1;
	}

	public void setPanelPaso1(boolean panelPaso1) {
		this.panelPaso1 = panelPaso1;
	}

	public boolean isPanelPaso2() {
		return panelPaso2;
	}

	public void setPanelPaso2(boolean panelPaso2) {
		this.panelPaso2 = panelPaso2;
	}

	public String getCodigoOTP() {
		return codigoOTP;
	}

	public void setCodigoOTP(String codigoOTP) {
		this.codigoOTP = codigoOTP;
	}

	public String getCodigoUniversidadActual() {
		return codigoUniversidadActual;
	}

	public void setCodigoUniversidadActual(String codigoUniversidadActual) {
		this.codigoUniversidadActual = codigoUniversidadActual;
	}

	public MBMensajes getMensajes() {
		return mensajes;
	}

	public void setMensajes(MBMensajes mensajes) {
		this.mensajes = mensajes;
	}

	public DNConsultasOpencard getdNConsultasOpencard() {
		return dNConsultasOpencard;
	}

	public void setdNConsultasOpencard(DNConsultasOpencard dNConsultasOpencard) {
		this.dNConsultasOpencard = dNConsultasOpencard;
	}

	public DNConsultasAS400 getdNConsultasAS400() {
		return dNConsultasAS400;
	}

	public void setdNConsultasAS400(DNConsultasAS400 dNConsultasAS400) {
		this.dNConsultasAS400 = dNConsultasAS400;
	}

	public MBUsuario getmBUsuario() {
		return mBUsuario;
	}

	public void setmBUsuario(MBUsuario mBUsuario) {
		this.mBUsuario = mBUsuario;
	}

	public SimpleDateFormat getDf() {
		return df;
	}

	public void setDf(SimpleDateFormat df) {
		this.df = df;
	}

	public TsolicUniversidad getTsolicUniversidadEntityGlobal() {
		return tsolicUniversidadEntityGlobal;
	}

	public void setTsolicUniversidadEntityGlobal(TsolicUniversidad tsolicUniversidadEntityGlobal) {
		this.tsolicUniversidadEntityGlobal = tsolicUniversidadEntityGlobal;
	}

}
