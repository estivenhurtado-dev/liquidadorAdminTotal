package com.fenalcovalle.estandar.modelo.ejb.entities.fenalco;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries( { @NamedQuery(name = "TbmPropiedadesUsuario.findAll",
                             query = "select o from TbmPropiedadesUsuario o") })
@Table(name = "fdc01.TBM_PROPIEDADES_USUARIO")
public class TbmPropiedadesUsuario implements Serializable {
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
    @Id
    @Column(name = "ID_PROPIEDAD", nullable = false)
    private BigDecimal idPropiedad;
    @OneToMany(mappedBy = "tbmPropiedadesUsuario")
    private List<TbmValorPropiedad> tbmValorPropiedadList1;

    public TbmPropiedadesUsuario() {
    }

    public TbmPropiedadesUsuario(String activo, String comentario, String descripcion, Timestamp fechaCreacion,
                                 Timestamp fechaUltimaModificacion, BigDecimal idPropiedad) {
        this.activo = activo;
        this.comentario = comentario;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.idPropiedad = idPropiedad;
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

    public BigDecimal getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(BigDecimal idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public List<TbmValorPropiedad> getTbmValorPropiedadList1() {
        return tbmValorPropiedadList1;
    }

    public void setTbmValorPropiedadList1(List<TbmValorPropiedad> tbmValorPropiedadList1) {
        this.tbmValorPropiedadList1 = tbmValorPropiedadList1;
    }

    public TbmValorPropiedad addTbmValorPropiedad(TbmValorPropiedad tbmValorPropiedad) {
        getTbmValorPropiedadList1().add(tbmValorPropiedad);
        tbmValorPropiedad.setTbmPropiedadesUsuario(this);
        return tbmValorPropiedad;
    }

    public TbmValorPropiedad removeTbmValorPropiedad(TbmValorPropiedad tbmValorPropiedad) {
        getTbmValorPropiedadList1().remove(tbmValorPropiedad);
        tbmValorPropiedad.setTbmPropiedadesUsuario(null);
        return tbmValorPropiedad;
    }
}
