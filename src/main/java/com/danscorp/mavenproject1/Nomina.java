/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danscorp.mavenproject1;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "nomina")
@NamedQueries({
    @NamedQuery(name = "Nomina.findAll", query = "SELECT n FROM Nomina n"),
    @NamedQuery(name = "Nomina.findById", query = "SELECT n FROM Nomina n WHERE n.id = :id"),
    @NamedQuery(name = "Nomina.findByDescripcion", query = "SELECT n FROM Nomina n WHERE n.descripcion = :descripcion"),
    @NamedQuery(name = "Nomina.findByMes", query = "SELECT n FROM Nomina n WHERE n.mes = :mes")})
public class Nomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "mes")
    private int mes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nominaId")
    @jakarta.json.bind.annotation.JsonbTransient
    private Collection<DetalleNomina> detalleNominaCollection;

    public Nomina() {
    }

    public Nomina(Integer id) {
        this.id = id;
    }

    public Nomina(Integer id, String descripcion, int mes) {
        this.id = id;
        this.descripcion = descripcion;
        this.mes = mes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Collection<DetalleNomina> getDetalleNominaCollection() {
        return detalleNominaCollection;
    }

    public void setDetalleNominaCollection(Collection<DetalleNomina> detalleNominaCollection) {
        this.detalleNominaCollection = detalleNominaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nomina)) {
            return false;
        }
        Nomina other = (Nomina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.danscorp.mavenproject1.Nomina[ id=" + id + " ]";
    }
    
}
