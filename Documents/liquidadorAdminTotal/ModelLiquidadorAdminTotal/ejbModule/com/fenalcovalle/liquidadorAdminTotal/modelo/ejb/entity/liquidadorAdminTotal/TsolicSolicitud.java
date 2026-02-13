package com.fenalcovalle.liquidadorAdminTotal.modelo.ejb.entity.liquidadorAdminTotal;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the TSOLIC_SOLICITUD database table.
 * 
 */
@Entity
@Table(name="TSOLIC_SOLICITUD")
@NamedQuery(name="TsolicSolicitud.findAll", query="SELECT t FROM TsolicSolicitud t")
public class TsolicSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SOLICITUD")
	private BigDecimal idSolicitud;

	private BigDecimal afiliado;

	@Column(name="ANIO_CURSADO")
	private String anioCursado;

	@Column(name="APELLIDOS_EST")
	private String apellidosEst;

	private String atributo1;

	private String atributo10;

	private String atributo2;

	private String atributo3;

	private String atributo4;

	private String atributo5;

	private String atributo6;

	private String atributo7;

	private String atributo8;

	private String atributo9;

	private String banco;

	private String campo1;

	private String campo10;

	private String campo11;

	private String campo12;

	private String campo13;

	private String campo14;

	private String campo15;

	private String campo16;

	private String campo17;

	private String campo18;

	private String campo19;

	private String campo2;

	private String campo20;

	private String campo3;

	private String campo4;

	private String campo5;

	private String campo6;

	private String campo7;

	private String campo8;

	private String campo9;

	@Column(name="CANTIDAD_DE_CUOTAS")
	private BigDecimal cantidadDeCuotas;

	@Column(name="CAPITAL_PJ")
	private String capitalPj;

	@Column(name="CARGO_QUIEN_CONFIRMA_RL")
	private String cargoQuienConfirmaRl;

	@Column(name="CELULAR_DC")
	private String celularDc;

	@Column(name="CELULAR_EST")
	private String celularEst;

	@Column(name="CIUDAD_EST")
	private String ciudadEst;

	@Column(name="CIUDAD_IPS_NAC")
	private String ciudadIpsNac;

	@Column(name="CODIGO_DEPARTAMENTO_IPS_NAC")
	private String codigoDepartamentoIpsNac;

	@Column(name="CODIGO_ESTUDIANTE")
	private String codigoEstudiante;

	@Column(name="CORREO_DC")
	private String correoDc;

	@Column(name="CORREO_EST")
	private String correoEst;

	@Column(name="CUENTA_BANCARIA")
	private BigDecimal cuentaBancaria;

	@Column(name="CUPO_APROBADO")
	private BigDecimal cupoAprobado;

	@Column(name="CUPO_ASIGNADO")
	private BigDecimal cupoAsignado;

	@Column(name="CUPO_DISPONIBLE")
	private BigDecimal cupoDisponible;

	@Column(name="CUPO_SUGERIDO")
	private BigDecimal cupoSugerido;

	@Column(name="DEPARTEMENTO_EST")
	private String departementoEst;

	@Column(name="ESTADO_CARGUE_AS400")
	private BigDecimal estadoCargueAs400;

	@Column(name="ESTU_BARRIO")
	private String estuBarrio;

	@Column(name="ESTU_CARGO_ACTUAL")
	private String estuCargoActual;

	@Column(name="ESTU_CIU_NACIMIENTO")
	private String estuCiuNacimiento;

	@Column(name="ESTU_CIUDAD")
	private String estuCiudad;

	@Column(name="ESTU_CIUDAD_DOCUMENTO")
	private String estuCiudadDocumento;

	@Column(name="ESTU_CODIGO")
	private String estuCodigo;

	@Column(name="ESTU_CORREO")
	private String estuCorreo;

	@Column(name="ESTU_DIRECCION_EMPRESA")
	private String estuDireccionEmpresa;

	@Column(name="ESTU_DIRECCION_RESIDENCIA")
	private String estuDireccionResidencia;

	@Column(name="ESTU_EMPRESA")
	private String estuEmpresa;

	@Column(name="ESTU_FACULTAD")
	private String estuFacultad;

	@Temporal(TemporalType.DATE)
	@Column(name="ESTU_FEC_NACIMIENTO")
	private Date estuFecNacimiento;

	@Column(name="ESTU_NODOCUMENTO")
	private String estuNodocumento;

	@Column(name="ESTU_OCUPACION")
	private String estuOcupacion;

	@Column(name="ESTU_PRIMER_APELLIDO")
	private String estuPrimerApellido;

	@Column(name="ESTU_PRIMER_NOMBRE")
	private String estuPrimerNombre;

	@Column(name="ESTU_SEGUNDO_APELLIDO")
	private String estuSegundoApellido;

	@Column(name="ESTU_SEGUNDO_NOMBRE")
	private String estuSegundoNombre;

	@Column(name="ESTU_SEMESTRE")
	private String estuSemestre;

	@Column(name="ESTU_TELEFONO")
	private String estuTelefono;

	@Column(name="ESTU_TELEFONO_EMPRESA")
	private String estuTelefonoEmpresa;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ULTIMA_MODIFICACION")
	private Timestamp fechaUltimaModificacion;

	@Column(name="FIRMA_DECEVAL")
	private String firmaDeceval;

	private BigDecimal girador;

	@Column(name="HABEAS_DATA")
	private String habeasData;

	@Column(name="ID_CARGUE_OPEN")
	private BigDecimal idCargueOpen;

	@Column(name="ID_ESTADO")
	private BigDecimal idEstado;

	@Column(name="ID_FORMULARIO")
	private BigDecimal idFormulario;

	@Column(name="ID_SUCURSAL")
	private BigDecimal idSucursal;

	private BigDecimal identificacion;

	@Column(name="MATRICULA_VEHI")
	private String matriculaVehi;

	@Column(name="NOMBRE_CARRERA")
	private String nombreCarrera;

	@Column(name="NOMBRE_DC")
	private String nombreDc;

	@Column(name="NOMBRE_QUIEN_CONFIRMA_RL")
	private String nombreQuienConfirmaRl;

	@Column(name="NOMBRES_EST")
	private String nombresEst;

	@Column(name="NUMERO_APROBACION")
	private BigDecimal numeroAprobacion;

	@Column(name="NUMERO_CHEQUE")
	private BigDecimal numeroCheque;

	@Column(name="NUMERO_DOCUMENTO_EST")
	private String numeroDocumentoEst;

	@Column(name="NUMERO_EMPLEADOS_PJ")
	private String numeroEmpleadosPj;

	@Column(name="NUMERO_FACTURA")
	private String numeroFactura;

	@Column(name="NUMERO_PREAPROBACION")
	private BigDecimal numeroPreaprobacion;

	private String observaciones;

	@Column(name="OBSERVACIONES_IPS")
	private String observacionesIps;

	@Column(name="OBSERVACIONES_RL")
	private String observacionesRl;

	@Column(name="OBSERVACIONES_RLN")
	private String observacionesRln;

	@Column(name="OBSERVACIONES_VEHI")
	private String observacionesVehi;

	@Temporal(TemporalType.DATE)
	@Column(name="PLAZO_FACTURA")
	private Date plazoFactura;

	private BigDecimal producto;

	@Column(name="PROTECCION_DATOS_PERSONALES")
	private String proteccionDatosPersonales;

	@Column(name="RELACION_LABORAL_PJ")
	private String relacionLaboralPj;

	private String semestre;

	@Column(name="SERVICIO_SOLICITADO")
	private BigDecimal servicioSolicitado;

	@Column(name="TIPO_CUENTA_BANCARIA")
	private String tipoCuentaBancaria;

	@Column(name="TIPO_DOC_EST")
	private BigDecimal tipoDocEst;

	@Column(name="TIPO_EMPRESA_PJ")
	private String tipoEmpresaPj;

	@Column(name="TIPO_SOCIEDAD_PJ")
	private String tipoSociedadPj;

	@Column(name="UNIVERSIDAD_EST")
	private String universidadEst;

	private BigDecimal valor;

	@Column(name="VALOR_SOLICITUD")
	private BigDecimal valorSolicitud;

	private String visador;

	public TsolicSolicitud() {
	}

	
	
	
	public BigDecimal getIdSolicitud() {
		return idSolicitud;
	}




	public void setIdSolicitud(BigDecimal idSolicitud) {
		this.idSolicitud = idSolicitud;
	}




	public BigDecimal getAfiliado() {
		return this.afiliado;
	}

	public void setAfiliado(BigDecimal afiliado) {
		this.afiliado = afiliado;
	}

	public String getAnioCursado() {
		return this.anioCursado;
	}

	public void setAnioCursado(String anioCursado) {
		this.anioCursado = anioCursado;
	}

	public String getApellidosEst() {
		return this.apellidosEst;
	}

	public void setApellidosEst(String apellidosEst) {
		this.apellidosEst = apellidosEst;
	}

	public String getAtributo1() {
		return this.atributo1;
	}

	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	public String getAtributo10() {
		return this.atributo10;
	}

	public void setAtributo10(String atributo10) {
		this.atributo10 = atributo10;
	}

	public String getAtributo2() {
		return this.atributo2;
	}

	public void setAtributo2(String atributo2) {
		this.atributo2 = atributo2;
	}

	public String getAtributo3() {
		return this.atributo3;
	}

	public void setAtributo3(String atributo3) {
		this.atributo3 = atributo3;
	}

	public String getAtributo4() {
		return this.atributo4;
	}

	public void setAtributo4(String atributo4) {
		this.atributo4 = atributo4;
	}

	public String getAtributo5() {
		return this.atributo5;
	}

	public void setAtributo5(String atributo5) {
		this.atributo5 = atributo5;
	}

	public String getAtributo6() {
		return this.atributo6;
	}

	public void setAtributo6(String atributo6) {
		this.atributo6 = atributo6;
	}

	public String getAtributo7() {
		return this.atributo7;
	}

	public void setAtributo7(String atributo7) {
		this.atributo7 = atributo7;
	}

	public String getAtributo8() {
		return this.atributo8;
	}

	public void setAtributo8(String atributo8) {
		this.atributo8 = atributo8;
	}

	public String getAtributo9() {
		return this.atributo9;
	}

	public void setAtributo9(String atributo9) {
		this.atributo9 = atributo9;
	}

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCampo1() {
		return this.campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public String getCampo10() {
		return this.campo10;
	}

	public void setCampo10(String campo10) {
		this.campo10 = campo10;
	}

	public String getCampo11() {
		return this.campo11;
	}

	public void setCampo11(String campo11) {
		this.campo11 = campo11;
	}

	public String getCampo12() {
		return this.campo12;
	}

	public void setCampo12(String campo12) {
		this.campo12 = campo12;
	}

	public String getCampo13() {
		return this.campo13;
	}

	public void setCampo13(String campo13) {
		this.campo13 = campo13;
	}

	public String getCampo14() {
		return this.campo14;
	}

	public void setCampo14(String campo14) {
		this.campo14 = campo14;
	}

	public String getCampo15() {
		return this.campo15;
	}

	public void setCampo15(String campo15) {
		this.campo15 = campo15;
	}

	public String getCampo16() {
		return this.campo16;
	}

	public void setCampo16(String campo16) {
		this.campo16 = campo16;
	}

	public String getCampo17() {
		return this.campo17;
	}

	public void setCampo17(String campo17) {
		this.campo17 = campo17;
	}

	public String getCampo18() {
		return this.campo18;
	}

	public void setCampo18(String campo18) {
		this.campo18 = campo18;
	}

	public String getCampo19() {
		return this.campo19;
	}

	public void setCampo19(String campo19) {
		this.campo19 = campo19;
	}

	public String getCampo2() {
		return this.campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	public String getCampo20() {
		return this.campo20;
	}

	public void setCampo20(String campo20) {
		this.campo20 = campo20;
	}

	public String getCampo3() {
		return this.campo3;
	}

	public void setCampo3(String campo3) {
		this.campo3 = campo3;
	}

	public String getCampo4() {
		return this.campo4;
	}

	public void setCampo4(String campo4) {
		this.campo4 = campo4;
	}

	public String getCampo5() {
		return this.campo5;
	}

	public void setCampo5(String campo5) {
		this.campo5 = campo5;
	}

	public String getCampo6() {
		return this.campo6;
	}

	public void setCampo6(String campo6) {
		this.campo6 = campo6;
	}

	public String getCampo7() {
		return this.campo7;
	}

	public void setCampo7(String campo7) {
		this.campo7 = campo7;
	}

	public String getCampo8() {
		return this.campo8;
	}

	public void setCampo8(String campo8) {
		this.campo8 = campo8;
	}

	public String getCampo9() {
		return this.campo9;
	}

	public void setCampo9(String campo9) {
		this.campo9 = campo9;
	}

	public BigDecimal getCantidadDeCuotas() {
		return this.cantidadDeCuotas;
	}

	public void setCantidadDeCuotas(BigDecimal cantidadDeCuotas) {
		this.cantidadDeCuotas = cantidadDeCuotas;
	}

	public String getCapitalPj() {
		return this.capitalPj;
	}

	public void setCapitalPj(String capitalPj) {
		this.capitalPj = capitalPj;
	}

	public String getCargoQuienConfirmaRl() {
		return this.cargoQuienConfirmaRl;
	}

	public void setCargoQuienConfirmaRl(String cargoQuienConfirmaRl) {
		this.cargoQuienConfirmaRl = cargoQuienConfirmaRl;
	}

	public String getCelularDc() {
		return this.celularDc;
	}

	public void setCelularDc(String celularDc) {
		this.celularDc = celularDc;
	}

	public String getCelularEst() {
		return this.celularEst;
	}

	public void setCelularEst(String celularEst) {
		this.celularEst = celularEst;
	}

	public String getCiudadEst() {
		return this.ciudadEst;
	}

	public void setCiudadEst(String ciudadEst) {
		this.ciudadEst = ciudadEst;
	}

	public String getCiudadIpsNac() {
		return this.ciudadIpsNac;
	}

	public void setCiudadIpsNac(String ciudadIpsNac) {
		this.ciudadIpsNac = ciudadIpsNac;
	}

	public String getCodigoDepartamentoIpsNac() {
		return this.codigoDepartamentoIpsNac;
	}

	public void setCodigoDepartamentoIpsNac(String codigoDepartamentoIpsNac) {
		this.codigoDepartamentoIpsNac = codigoDepartamentoIpsNac;
	}

	public String getCodigoEstudiante() {
		return this.codigoEstudiante;
	}

	public void setCodigoEstudiante(String codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	public String getCorreoDc() {
		return this.correoDc;
	}

	public void setCorreoDc(String correoDc) {
		this.correoDc = correoDc;
	}

	public String getCorreoEst() {
		return this.correoEst;
	}

	public void setCorreoEst(String correoEst) {
		this.correoEst = correoEst;
	}

	public BigDecimal getCuentaBancaria() {
		return this.cuentaBancaria;
	}

	public void setCuentaBancaria(BigDecimal cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public BigDecimal getCupoAprobado() {
		return this.cupoAprobado;
	}

	public void setCupoAprobado(BigDecimal cupoAprobado) {
		this.cupoAprobado = cupoAprobado;
	}

	public BigDecimal getCupoAsignado() {
		return this.cupoAsignado;
	}

	public void setCupoAsignado(BigDecimal cupoAsignado) {
		this.cupoAsignado = cupoAsignado;
	}

	public BigDecimal getCupoDisponible() {
		return this.cupoDisponible;
	}

	public void setCupoDisponible(BigDecimal cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}

	public BigDecimal getCupoSugerido() {
		return this.cupoSugerido;
	}

	public void setCupoSugerido(BigDecimal cupoSugerido) {
		this.cupoSugerido = cupoSugerido;
	}

	public String getDepartementoEst() {
		return this.departementoEst;
	}

	public void setDepartementoEst(String departementoEst) {
		this.departementoEst = departementoEst;
	}

	public BigDecimal getEstadoCargueAs400() {
		return this.estadoCargueAs400;
	}

	public void setEstadoCargueAs400(BigDecimal estadoCargueAs400) {
		this.estadoCargueAs400 = estadoCargueAs400;
	}

	public String getEstuBarrio() {
		return this.estuBarrio;
	}

	public void setEstuBarrio(String estuBarrio) {
		this.estuBarrio = estuBarrio;
	}

	public String getEstuCargoActual() {
		return this.estuCargoActual;
	}

	public void setEstuCargoActual(String estuCargoActual) {
		this.estuCargoActual = estuCargoActual;
	}

	public String getEstuCiuNacimiento() {
		return this.estuCiuNacimiento;
	}

	public void setEstuCiuNacimiento(String estuCiuNacimiento) {
		this.estuCiuNacimiento = estuCiuNacimiento;
	}

	public String getEstuCiudad() {
		return this.estuCiudad;
	}

	public void setEstuCiudad(String estuCiudad) {
		this.estuCiudad = estuCiudad;
	}

	public String getEstuCiudadDocumento() {
		return this.estuCiudadDocumento;
	}

	public void setEstuCiudadDocumento(String estuCiudadDocumento) {
		this.estuCiudadDocumento = estuCiudadDocumento;
	}

	public String getEstuCodigo() {
		return this.estuCodigo;
	}

	public void setEstuCodigo(String estuCodigo) {
		this.estuCodigo = estuCodigo;
	}

	public String getEstuCorreo() {
		return this.estuCorreo;
	}

	public void setEstuCorreo(String estuCorreo) {
		this.estuCorreo = estuCorreo;
	}

	public String getEstuDireccionEmpresa() {
		return this.estuDireccionEmpresa;
	}

	public void setEstuDireccionEmpresa(String estuDireccionEmpresa) {
		this.estuDireccionEmpresa = estuDireccionEmpresa;
	}

	public String getEstuDireccionResidencia() {
		return this.estuDireccionResidencia;
	}

	public void setEstuDireccionResidencia(String estuDireccionResidencia) {
		this.estuDireccionResidencia = estuDireccionResidencia;
	}

	public String getEstuEmpresa() {
		return this.estuEmpresa;
	}

	public void setEstuEmpresa(String estuEmpresa) {
		this.estuEmpresa = estuEmpresa;
	}

	public String getEstuFacultad() {
		return this.estuFacultad;
	}

	public void setEstuFacultad(String estuFacultad) {
		this.estuFacultad = estuFacultad;
	}

	public Date getEstuFecNacimiento() {
		return this.estuFecNacimiento;
	}

	public void setEstuFecNacimiento(Date estuFecNacimiento) {
		this.estuFecNacimiento = estuFecNacimiento;
	}

	public String getEstuNodocumento() {
		return this.estuNodocumento;
	}

	public void setEstuNodocumento(String estuNodocumento) {
		this.estuNodocumento = estuNodocumento;
	}

	public String getEstuOcupacion() {
		return this.estuOcupacion;
	}

	public void setEstuOcupacion(String estuOcupacion) {
		this.estuOcupacion = estuOcupacion;
	}

	public String getEstuPrimerApellido() {
		return this.estuPrimerApellido;
	}

	public void setEstuPrimerApellido(String estuPrimerApellido) {
		this.estuPrimerApellido = estuPrimerApellido;
	}

	public String getEstuPrimerNombre() {
		return this.estuPrimerNombre;
	}

	public void setEstuPrimerNombre(String estuPrimerNombre) {
		this.estuPrimerNombre = estuPrimerNombre;
	}

	public String getEstuSegundoApellido() {
		return this.estuSegundoApellido;
	}

	public void setEstuSegundoApellido(String estuSegundoApellido) {
		this.estuSegundoApellido = estuSegundoApellido;
	}

	public String getEstuSegundoNombre() {
		return this.estuSegundoNombre;
	}

	public void setEstuSegundoNombre(String estuSegundoNombre) {
		this.estuSegundoNombre = estuSegundoNombre;
	}

	public String getEstuSemestre() {
		return this.estuSemestre;
	}

	public void setEstuSemestre(String estuSemestre) {
		this.estuSemestre = estuSemestre;
	}

	public String getEstuTelefono() {
		return this.estuTelefono;
	}

	public void setEstuTelefono(String estuTelefono) {
		this.estuTelefono = estuTelefono;
	}

	public String getEstuTelefonoEmpresa() {
		return this.estuTelefonoEmpresa;
	}

	public void setEstuTelefonoEmpresa(String estuTelefonoEmpresa) {
		this.estuTelefonoEmpresa = estuTelefonoEmpresa;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaUltimaModificacion() {
		return this.fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(Timestamp fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getFirmaDeceval() {
		return this.firmaDeceval;
	}

	public void setFirmaDeceval(String firmaDeceval) {
		this.firmaDeceval = firmaDeceval;
	}

	public BigDecimal getGirador() {
		return this.girador;
	}

	public void setGirador(BigDecimal girador) {
		this.girador = girador;
	}

	public String getHabeasData() {
		return this.habeasData;
	}

	public void setHabeasData(String habeasData) {
		this.habeasData = habeasData;
	}

	public BigDecimal getIdCargueOpen() {
		return this.idCargueOpen;
	}

	public void setIdCargueOpen(BigDecimal idCargueOpen) {
		this.idCargueOpen = idCargueOpen;
	}

	public BigDecimal getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(BigDecimal idEstado) {
		this.idEstado = idEstado;
	}

	public BigDecimal getIdFormulario() {
		return this.idFormulario;
	}

	public void setIdFormulario(BigDecimal idFormulario) {
		this.idFormulario = idFormulario;
	}

	public BigDecimal getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(BigDecimal idSucursal) {
		this.idSucursal = idSucursal;
	}

	public BigDecimal getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(BigDecimal identificacion) {
		this.identificacion = identificacion;
	}

	public String getMatriculaVehi() {
		return this.matriculaVehi;
	}

	public void setMatriculaVehi(String matriculaVehi) {
		this.matriculaVehi = matriculaVehi;
	}

	public String getNombreCarrera() {
		return this.nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public String getNombreDc() {
		return this.nombreDc;
	}

	public void setNombreDc(String nombreDc) {
		this.nombreDc = nombreDc;
	}

	public String getNombreQuienConfirmaRl() {
		return this.nombreQuienConfirmaRl;
	}

	public void setNombreQuienConfirmaRl(String nombreQuienConfirmaRl) {
		this.nombreQuienConfirmaRl = nombreQuienConfirmaRl;
	}

	public String getNombresEst() {
		return this.nombresEst;
	}

	public void setNombresEst(String nombresEst) {
		this.nombresEst = nombresEst;
	}

	public BigDecimal getNumeroAprobacion() {
		return this.numeroAprobacion;
	}

	public void setNumeroAprobacion(BigDecimal numeroAprobacion) {
		this.numeroAprobacion = numeroAprobacion;
	}

	public BigDecimal getNumeroCheque() {
		return this.numeroCheque;
	}

	public void setNumeroCheque(BigDecimal numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public String getNumeroDocumentoEst() {
		return this.numeroDocumentoEst;
	}

	public void setNumeroDocumentoEst(String numeroDocumentoEst) {
		this.numeroDocumentoEst = numeroDocumentoEst;
	}

	public String getNumeroEmpleadosPj() {
		return this.numeroEmpleadosPj;
	}

	public void setNumeroEmpleadosPj(String numeroEmpleadosPj) {
		this.numeroEmpleadosPj = numeroEmpleadosPj;
	}

	public String getNumeroFactura() {
		return this.numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public BigDecimal getNumeroPreaprobacion() {
		return this.numeroPreaprobacion;
	}

	public void setNumeroPreaprobacion(BigDecimal numeroPreaprobacion) {
		this.numeroPreaprobacion = numeroPreaprobacion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObservacionesIps() {
		return this.observacionesIps;
	}

	public void setObservacionesIps(String observacionesIps) {
		this.observacionesIps = observacionesIps;
	}

	public String getObservacionesRl() {
		return this.observacionesRl;
	}

	public void setObservacionesRl(String observacionesRl) {
		this.observacionesRl = observacionesRl;
	}

	public String getObservacionesRln() {
		return this.observacionesRln;
	}

	public void setObservacionesRln(String observacionesRln) {
		this.observacionesRln = observacionesRln;
	}

	public String getObservacionesVehi() {
		return this.observacionesVehi;
	}

	public void setObservacionesVehi(String observacionesVehi) {
		this.observacionesVehi = observacionesVehi;
	}

	public Date getPlazoFactura() {
		return this.plazoFactura;
	}

	public void setPlazoFactura(Date plazoFactura) {
		this.plazoFactura = plazoFactura;
	}

	public BigDecimal getProducto() {
		return this.producto;
	}

	public void setProducto(BigDecimal producto) {
		this.producto = producto;
	}

	public String getProteccionDatosPersonales() {
		return this.proteccionDatosPersonales;
	}

	public void setProteccionDatosPersonales(String proteccionDatosPersonales) {
		this.proteccionDatosPersonales = proteccionDatosPersonales;
	}

	public String getRelacionLaboralPj() {
		return this.relacionLaboralPj;
	}

	public void setRelacionLaboralPj(String relacionLaboralPj) {
		this.relacionLaboralPj = relacionLaboralPj;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public BigDecimal getServicioSolicitado() {
		return this.servicioSolicitado;
	}

	public void setServicioSolicitado(BigDecimal servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}

	public String getTipoCuentaBancaria() {
		return this.tipoCuentaBancaria;
	}

	public void setTipoCuentaBancaria(String tipoCuentaBancaria) {
		this.tipoCuentaBancaria = tipoCuentaBancaria;
	}

	public BigDecimal getTipoDocEst() {
		return this.tipoDocEst;
	}

	public void setTipoDocEst(BigDecimal tipoDocEst) {
		this.tipoDocEst = tipoDocEst;
	}

	public String getTipoEmpresaPj() {
		return this.tipoEmpresaPj;
	}

	public void setTipoEmpresaPj(String tipoEmpresaPj) {
		this.tipoEmpresaPj = tipoEmpresaPj;
	}

	public String getTipoSociedadPj() {
		return this.tipoSociedadPj;
	}

	public void setTipoSociedadPj(String tipoSociedadPj) {
		this.tipoSociedadPj = tipoSociedadPj;
	}

	public String getUniversidadEst() {
		return this.universidadEst;
	}

	public void setUniversidadEst(String universidadEst) {
		this.universidadEst = universidadEst;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorSolicitud() {
		return this.valorSolicitud;
	}

	public void setValorSolicitud(BigDecimal valorSolicitud) {
		this.valorSolicitud = valorSolicitud;
	}

	public String getVisador() {
		return this.visador;
	}

	public void setVisador(String visador) {
		this.visador = visador;
	}

}