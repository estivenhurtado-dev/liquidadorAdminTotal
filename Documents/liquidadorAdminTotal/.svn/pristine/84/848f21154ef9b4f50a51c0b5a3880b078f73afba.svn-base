package com.fenalcovalle.estandar.modelo.ejb.entities.fenalco;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fenalcovalle.estandar.modelo.ejb.entities.fenalco.TbmRoles;


@Entity
@NamedQueries( { @NamedQuery(name = "TbmRolesUsuario.findAll", query = "select o from TbmRolesUsuario o"),
                 @NamedQuery(name = "TbmRolesUsuario.findRolesByUsuario",
                             query = "select o.tbmRoles3 from TbmRolesUsuario o where o.tbmUsuarios2.idUsuario=:idUsuario"),
                 @NamedQuery(name = "TbmRolesUsuario.findByUsuario",
                             query = "select o from TbmRolesUsuario o where o.tbmUsuarios2.idUsuario=:idUsuario"),
                 @NamedQuery(name = "TbmRolesUsuario.findByRol", query = "select o from TbmRolesUsuario o where o.tbmRoles3.idRol=:idRol") })
@Table(name = "TBM_ROLES_USUARIO")
@IdClass(TbmRolesUsuarioPK.class)
public class TbmRolesUsuario implements Serializable {
    @Column(name = "FECHA_CREACION", nullable = false)
    private Timestamp fechaCreacion;
    @Id
    @Column(name = "ID_ROL", nullable = false, insertable = false, updatable = false)
    private BigDecimal idRol;
    @Id
    @Column(name = "ID_USUARIO", nullable = false, insertable = false, updatable = false)
    private BigDecimal idUsuario;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private TbmUsuarios tbmUsuarios2;
    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    private TbmRoles tbmRoles3;

    public TbmRolesUsuario() {
    }

    public TbmRolesUsuario(Timestamp fechaCreacion, TbmRoles tbmRoles3, TbmUsuarios tbmUsuarios2) {
        this.fechaCreacion = fechaCreacion;
        this.tbmRoles3 = tbmRoles3;
        this.tbmUsuarios2 = tbmUsuarios2;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getIdRol() {
        return idRol;
    }

    public void setIdRol(BigDecimal idRol) {
        this.idRol = idRol;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TbmUsuarios getTbmUsuarios2() {
        return tbmUsuarios2;
    }

    public void setTbmUsuarios2(TbmUsuarios tbmUsuarios2) {
        this.tbmUsuarios2 = tbmUsuarios2;
        if (tbmUsuarios2 != null) {
            this.idUsuario = tbmUsuarios2.getIdUsuario();
        }
    }

    public TbmRoles getTbmRoles3() {
        return tbmRoles3;
    }

    public void setTbmRoles3(TbmRoles tbmRoles3) {
        this.tbmRoles3 = tbmRoles3;
        if (tbmRoles3 != null) {
            this.idRol = tbmRoles3.getIdRol();
        }
    }
}
