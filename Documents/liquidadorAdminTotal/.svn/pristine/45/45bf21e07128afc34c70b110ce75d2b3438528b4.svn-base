package com.fenalcovalle.estandar.modelo.ejb.entities.fenalco;

import java.io.Serializable;

import java.math.BigDecimal;

public class TbmValorPropiedadPK implements Serializable {
    public BigDecimal idPropiedad;
    public BigDecimal idUsuario;

    public TbmValorPropiedadPK() {
    }

    public TbmValorPropiedadPK(BigDecimal idPropiedad, BigDecimal idUsuario) {
        this.idPropiedad = idPropiedad;
        this.idUsuario = idUsuario;
    }

    public boolean equals(Object other) {
        if (other instanceof TbmValorPropiedadPK) {
            final TbmValorPropiedadPK otherTbmValorPropiedadPK = (TbmValorPropiedadPK)other;
            final boolean areEqual =
                (otherTbmValorPropiedadPK.idPropiedad.equals(idPropiedad) && otherTbmValorPropiedadPK.idUsuario.equals(idUsuario));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public BigDecimal getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(BigDecimal idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }
}
