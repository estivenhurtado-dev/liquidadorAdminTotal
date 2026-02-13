package com.fenalcovalle.estandar.modelo.ejb.entities.fenalco;

import java.io.Serializable;

import java.math.BigDecimal;


public class TbmRolesUsuarioPK implements Serializable {
    public BigDecimal idRol;
    public BigDecimal idUsuario;

    public TbmRolesUsuarioPK() {
    }

    public TbmRolesUsuarioPK(BigDecimal idRol, BigDecimal idUsuario) {
        this.idRol = idRol;
        this.idUsuario = idUsuario;
    }

    public boolean equals(Object other) {
        if (other instanceof TbmRolesUsuarioPK) {
            final TbmRolesUsuarioPK otherTbmRolesUsuarioPK = (TbmRolesUsuarioPK)other;
            final boolean areEqual =
                (otherTbmRolesUsuarioPK.idRol.equals(idRol) && otherTbmRolesUsuarioPK.idUsuario.equals(idUsuario));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
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
}
