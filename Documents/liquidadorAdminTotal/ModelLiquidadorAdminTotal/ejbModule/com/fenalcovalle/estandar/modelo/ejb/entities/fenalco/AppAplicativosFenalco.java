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
@NamedQueries( { @NamedQuery(name = "AppAplicativosFenalco.findAll",
                             query = "select o from AppAplicativosFenalco o") })
@Table(name = "APP_APLICATIVOS_FENALCO")
public class AppAplicativosFenalco implements Serializable {
    @Column(name = "FECHA_PUBLICACION")
    private Timestamp fechaPublicacion;
    @Id
    @Column(name = "ID_APP", nullable = false)
    private BigDecimal idApp;
    @Column(nullable = false, length = 500)
    private String nombre;
    @Column(length = 300)
    private String path;
    @Column(length = 300)
    private String server;

    public AppAplicativosFenalco() {
    }

    public AppAplicativosFenalco(Timestamp fechaPublicacion, BigDecimal idApp, String nombre, String path,
                                 String server) {
        this.fechaPublicacion = fechaPublicacion;
        this.idApp = idApp;
        this.nombre = nombre;
        this.path = path;
        this.server = server;
    }

    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public BigDecimal getIdApp() {
        return idApp;
    }

    public void setIdApp(BigDecimal idApp) {
        this.idApp = idApp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

  
}
