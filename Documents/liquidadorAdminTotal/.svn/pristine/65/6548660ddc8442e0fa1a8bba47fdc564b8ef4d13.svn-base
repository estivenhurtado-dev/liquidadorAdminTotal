package com.fenalcovalle.estandar.modelo.ejb.entities.fenalco;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries( { @NamedQuery(name = "LeafUser.findAll", query = "select o from TbmUsuarios o"),
                 @NamedQuery(name = "LeafUser.findByPrimaryKey",
                             query = "select o from TbmUsuarios o where upper(o.userId)=:userId"),
                 @NamedQuery(name = "TbmUsuarios.findAll", query = "select o from TbmUsuarios o"),
                 @NamedQuery(name = "TbmUsuarios.findByUsuarioPassword",
                             query = "select o from TbmUsuarios o where lower(o.userId)=lower(:usuario) and lower(o.password)=lower(:password)"),
                 @NamedQuery(name = "TbmUsuarios.findByUsuario",
                             query = "select o from TbmUsuarios o where lower(o.userId)=:userId") })
@Table(name = "TBM_USUARIOS")
public class TbmUsuarios implements Serializable {
    @Column(nullable = false, length = 40)
    private String apellidos;
    @Column(name = "DOMINIO_LDAP", length = 100)
    private String dominioLdap;
    @Column(length = 40)
    private String email;
    @Column(name = "FECHA_CREACION", nullable = false)
    private Timestamp fechaCreacion;
    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false)
    private Timestamp fechaUltimaModificacion;
    @Column(name = "ID_ESTADO", nullable = false)
    private BigDecimal idEstado;
    @Column(name = "ID_TIPOUSUARIO")
    private BigDecimal idTipousuario;
    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private BigDecimal idUsuario;
    @Column(name = "INTENTOS_FALLIDOS", nullable = false)
    private BigDecimal intentosFallidos;
    @Column(name = "KEY_CONTROL", length = 100)
    private String keyControl;
    @Column(nullable = false, length = 40)
    private String nombres;
    @Column(length = 200)
    private String password;
    @Column(name = "URL_LDAP", length = 150)
    private String urlLdap;
    @Column(name = "USER_ID", nullable = false, length = 30)
    private String userId;
    @Temporal(TemporalType.DATE)
    @Column(name = "VIGENTE_HASTA")
    private Date vigenteHasta;
    @OneToMany(mappedBy = "tbmUsuarios")
    private List<TbmValorPropiedad> tbmValorPropiedadList;
    @OneToMany(mappedBy = "tbmUsuarios2")
    private List<TbmRolesUsuario> tbmRolesUsuarioList;

    public TbmUsuarios() {
    }

    public TbmUsuarios(String apellidos, String dominioLdap, String email, Timestamp fechaCreacion,
                       Timestamp fechaUltimaModificacion, BigDecimal idEstado, BigDecimal idTipousuario,
                       BigDecimal idUsuario, BigDecimal intentosFallidos, String keyControl, String nombres,
                       String password, String urlLdap, String userId, Date vigenteHasta) {
        this.apellidos = apellidos;
        this.dominioLdap = dominioLdap;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.idEstado = idEstado;
        this.idTipousuario = idTipousuario;
        this.idUsuario = idUsuario;
        this.intentosFallidos = intentosFallidos;
        this.keyControl = keyControl;
        this.nombres = nombres;
        this.password = password;
        this.urlLdap = urlLdap;
        this.userId = userId;
        this.vigenteHasta = vigenteHasta;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDominioLdap() {
        return dominioLdap;
    }

    public void setDominioLdap(String dominioLdap) {
        this.dominioLdap = dominioLdap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Timestamp fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public BigDecimal getIdTipousuario() {
        return idTipousuario;
    }

    public void setIdTipousuario(BigDecimal idTipousuario) {
        this.idTipousuario = idTipousuario;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(BigDecimal intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public String getKeyControl() {
        return keyControl;
    }

    public void setKeyControl(String keyControl) {
        this.keyControl = keyControl;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlLdap() {
        return urlLdap;
    }

    public void setUrlLdap(String urlLdap) {
        this.urlLdap = urlLdap;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getVigenteHasta() {
        return vigenteHasta;
    }

    public void setVigenteHasta(Date vigenteHasta) {
        this.vigenteHasta = vigenteHasta;
    }

    public List<TbmValorPropiedad> getTbmValorPropiedadList() {
        return tbmValorPropiedadList;
    }

    public void setTbmValorPropiedadList(List<TbmValorPropiedad> tbmValorPropiedadList) {
        this.tbmValorPropiedadList = tbmValorPropiedadList;
    }
    
    public List<TbmRolesUsuario> getTbmRolesUsuarioList() {
        return tbmRolesUsuarioList;
    }

    public void setTbmRolesUsuarioList(List<TbmRolesUsuario> tbmRolesUsuarioList) {
        this.tbmRolesUsuarioList = tbmRolesUsuarioList;
    }

    public TbmValorPropiedad addTbmValorPropiedad(TbmValorPropiedad tbmValorPropiedad) {
        getTbmValorPropiedadList().add(tbmValorPropiedad);
        tbmValorPropiedad.setTbmUsuarios(this);
        return tbmValorPropiedad;
    }

    public TbmValorPropiedad removeTbmValorPropiedad(TbmValorPropiedad tbmValorPropiedad) {
        getTbmValorPropiedadList().remove(tbmValorPropiedad);
        tbmValorPropiedad.setTbmUsuarios(null);
        return tbmValorPropiedad;
    }
}
