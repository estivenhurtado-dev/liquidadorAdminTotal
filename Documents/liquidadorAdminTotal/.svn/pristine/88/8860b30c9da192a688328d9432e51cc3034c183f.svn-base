package com.fenalcovalle.estandar.modelo.ejb.entities.fenalco;




import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@NamedQueries( { @NamedQuery(name = "TbmRoles.findAll", query = "select o from TbmRoles o"),
                 @NamedQuery(name = "TbmRoles.findByActivo", query = "select o from TbmRoles o where o.activo='S'") })
@Table(name = "TBM_ROLES")
public class TbmRoles implements Serializable {
    @Column(nullable = false, length = 1)
    private String activo;
    @Column(length = 150)
    private String comentario;
    @Column(nullable = false, length = 50)
    private String descripcion;
    @Column(name = "FECHA_CREACION", nullable = false)
    private Timestamp fechaCreacion;
    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false)
    private Timestamp fechaUltimaModificacion;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBM_ROLES_SEQ")
    @SequenceGenerator(name = "TBM_ROLES_SEQ", sequenceName = "TBM_ROLES_SEQ", allocationSize = 1)
    @Id
    @Column(name = "ID_ROL", nullable = false)
    private BigDecimal idRol;
    /*@OneToMany(mappedBy = "tbmRoles")
    private List<TbmCamposRol> tbmCamposRolList;
    @OneToMany(mappedBy = "tbmRoles1")
    private List<TbmRestriccionesAcceso> tbmRestriccionesAccesoList;
    @OneToMany(mappedBy = "tbmRoles2")
    private List<TbmOpcionesRol> tbmOpcionesRolList;
    @OneToMany(mappedBy = "tbmRoles3")
    private List<TbmRolesUsuario> tbmRolesUsuarioList1;
    @OneToMany(mappedBy = "tbmRoles4")
    private List<TbmAccionesRol> tbmAccionesRolList2; */


    @Transient
    private boolean seleccionado;

    public TbmRoles() {
    }

    public TbmRoles(String activo, String comentario, String descripcion, Timestamp fechaCreacion,
                    Timestamp fechaUltimaModificacion, BigDecimal idRol) {
        this.activo = activo;
        this.comentario = comentario;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.idRol = idRol;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public BigDecimal getIdRol() {
        return idRol;
    }

    public void setIdRol(BigDecimal idRol) {
        this.idRol = idRol;
    }

    /* public List<TbmCamposRol> getTbmCamposRolList() {
        return tbmCamposRolList;
    }

    public void setTbmCamposRolList(List<TbmCamposRol> tbmCamposRolList) {
        this.tbmCamposRolList = tbmCamposRolList;
    }

    public TbmCamposRol addTbmCamposRol(TbmCamposRol tbmCamposRol) {
        getTbmCamposRolList().add(tbmCamposRol);
        tbmCamposRol.setTbmRoles(this);
        return tbmCamposRol;
    }

    public TbmCamposRol removeTbmCamposRol(TbmCamposRol tbmCamposRol) {
        getTbmCamposRolList().remove(tbmCamposRol);
        tbmCamposRol.setTbmRoles(null);
        return tbmCamposRol;
    }

    public List<TbmRestriccionesAcceso> getTbmRestriccionesAccesoList() {
        return tbmRestriccionesAccesoList;
    }

    public void setTbmRestriccionesAccesoList(List<TbmRestriccionesAcceso> tbmRestriccionesAccesoList) {
        this.tbmRestriccionesAccesoList = tbmRestriccionesAccesoList;
    }

    public TbmRestriccionesAcceso addTbmRestriccionesAcceso(TbmRestriccionesAcceso tbmRestriccionesAcceso) {
        getTbmRestriccionesAccesoList().add(tbmRestriccionesAcceso);
        tbmRestriccionesAcceso.setTbmRoles1(this);
        return tbmRestriccionesAcceso;
    }

    public TbmRestriccionesAcceso removeTbmRestriccionesAcceso(TbmRestriccionesAcceso tbmRestriccionesAcceso) {
        getTbmRestriccionesAccesoList().remove(tbmRestriccionesAcceso);
        tbmRestriccionesAcceso.setTbmRoles1(null);
        return tbmRestriccionesAcceso;
    }

    public List<TbmOpcionesRol> getTbmOpcionesRolList() {
        return tbmOpcionesRolList;
    }

    public void setTbmOpcionesRolList(List<TbmOpcionesRol> tbmOpcionesRolList) {
        this.tbmOpcionesRolList = tbmOpcionesRolList;
    }

    public TbmOpcionesRol addTbmOpcionesRol(TbmOpcionesRol tbmOpcionesRol) {
        getTbmOpcionesRolList().add(tbmOpcionesRol);
        tbmOpcionesRol.setTbmRoles2(this);
        return tbmOpcionesRol;
    }

    public TbmOpcionesRol removeTbmOpcionesRol(TbmOpcionesRol tbmOpcionesRol) {
        getTbmOpcionesRolList().remove(tbmOpcionesRol);
        tbmOpcionesRol.setTbmRoles2(null);
        return tbmOpcionesRol;
    }

    public List<TbmRolesUsuario> getTbmRolesUsuarioList1() {
        return tbmRolesUsuarioList1;
    }

    public void setTbmRolesUsuarioList1(List<TbmRolesUsuario> tbmRolesUsuarioList1) {
        this.tbmRolesUsuarioList1 = tbmRolesUsuarioList1;
    } */

    /* public TbmRolesUsuario addTbmRolesUsuario(TbmRolesUsuario tbmRolesUsuario) {
        getTbmRolesUsuarioList1().add(tbmRolesUsuario);
        tbmRolesUsuario.setTbmRoles3(this);
        return tbmRolesUsuario;
    }

    public TbmRolesUsuario removeTbmRolesUsuario(TbmRolesUsuario tbmRolesUsuario) {
        getTbmRolesUsuarioList1().remove(tbmRolesUsuario);
        tbmRolesUsuario.setTbmRoles3(null);
        return tbmRolesUsuario;
    }

    public List<TbmAccionesRol> getTbmAccionesRolList2() {
        return tbmAccionesRolList2;
    }

    public void setTbmAccionesRolList2(List<TbmAccionesRol> tbmAccionesRolList2) {
        this.tbmAccionesRolList2 = tbmAccionesRolList2;
    }

    public TbmAccionesRol addTbmAccionesRol(TbmAccionesRol tbmAccionesRol) {
        getTbmAccionesRolList2().add(tbmAccionesRol);
        tbmAccionesRol.setTbmRoles4(this);
        return tbmAccionesRol;
    }

    public TbmAccionesRol removeTbmAccionesRol(TbmAccionesRol tbmAccionesRol) {
        getTbmAccionesRolList2().remove(tbmAccionesRol);
        tbmAccionesRol.setTbmRoles4(null);
        return tbmAccionesRol;
    } */

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

}