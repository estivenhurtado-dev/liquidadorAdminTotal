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

import com.fenalcovalle.estandar.modelo.ejb.entities.fenalco.TbmUsuarios;

@Entity
@NamedQueries( { @NamedQuery(name = "TbmValorPropiedad.findAll", query = "select o from TbmValorPropiedad o") })
@Table(name = "TBM_VALOR_PROPIEDAD")
@IdClass(TbmValorPropiedadPK.class)
public class TbmValorPropiedad implements Serializable {
    @Column(name = "FECHA_CREACION", nullable = false)
    private Timestamp fechaCreacion;
    @Id
    @Column(name = "ID_PROPIEDAD", nullable = false, insertable = false, updatable = false)
    private BigDecimal idPropiedad;
    @Id
    @Column(name = "ID_USUARIO", nullable = false, insertable = false, updatable = false)
    private BigDecimal idUsuario;
    @Column(nullable = false, length = 100)
    private String valor;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private TbmUsuarios tbmUsuarios;
    @ManyToOne
    @JoinColumn(name = "ID_PROPIEDAD")
    private TbmPropiedadesUsuario tbmPropiedadesUsuario;

    public TbmValorPropiedad() {
    }

    public TbmValorPropiedad(Timestamp fechaCreacion, TbmPropiedadesUsuario tbmPropiedadesUsuario,
                             TbmUsuarios tbmUsuarios, String valor) {
        this.fechaCreacion = fechaCreacion;
        this.tbmPropiedadesUsuario = tbmPropiedadesUsuario;
        this.tbmUsuarios = tbmUsuarios;
        this.valor = valor;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TbmUsuarios getTbmUsuarios() {
        return tbmUsuarios;
    }

    public void setTbmUsuarios(TbmUsuarios tbmUsuarios) {
        this.tbmUsuarios = tbmUsuarios;
        if (tbmUsuarios != null) {
            this.idUsuario = tbmUsuarios.getIdUsuario();
        }
    }

    public TbmPropiedadesUsuario getTbmPropiedadesUsuario() {
        return tbmPropiedadesUsuario;
    }

    public void setTbmPropiedadesUsuario(TbmPropiedadesUsuario tbmPropiedadesUsuario) {
        this.tbmPropiedadesUsuario = tbmPropiedadesUsuario;
        if (tbmPropiedadesUsuario != null) {
            this.idPropiedad = tbmPropiedadesUsuario.getIdPropiedad();
        }
        
    }

	@Override
	public String toString() {
		return "TbmValorPropiedad [fechaCreacion=" + fechaCreacion
				+ ", idPropiedad=" + idPropiedad + ", idUsuario=" + idUsuario
				+ ", valor=" + valor + ", tbmUsuarios=" + tbmUsuarios
				+ ", tbmPropiedadesUsuario=" + tbmPropiedadesUsuario + "]";
	}
    
    
    
    
    
    
    
    
    
    
    
    
}
