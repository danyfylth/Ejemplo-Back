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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
    @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuarios.findByNumDocumento", query = "SELECT u FROM Usuarios u WHERE u.numDocumento = :numDocumento"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByDireccion", query = "SELECT u FROM Usuarios u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuarios.findBySueldoBasico", query = "SELECT u FROM Usuarios u WHERE u.sueldoBasico = :sueldoBasico"),
    @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "num_documento")
    private String numDocumento;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "sueldo_basico")
    private double sueldoBasico;
    @Column(name = "activo")
    private Short activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosId")
    @jakarta.json.bind.annotation.JsonbTransient
    private Collection<DetalleNomina> detalleNominaCollection;
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cargos cargoId;
    @JoinColumn(name = "ciudades_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ciudades ciudadesId;
    @JoinColumn(name = "tipos_documento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposDocumento tiposDocumentoId;
    @OneToMany(mappedBy = "idJefeInmediato")
    @jakarta.json.bind.annotation.JsonbTransient
    private Collection<Usuarios> usuariosCollection;
    @JoinColumn(name = "id_jefe_inmediato", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idJefeInmediato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    @jakarta.json.bind.annotation.JsonbTransient
    private Collection<UsuariosHasRoles> usuariosHasRolesCollection;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nombres, String apellidos, String numDocumento, String email, String password, String direccion, double sueldoBasico) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numDocumento = numDocumento;
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        this.sueldoBasico = sueldoBasico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public Collection<DetalleNomina> getDetalleNominaCollection() {
        return detalleNominaCollection;
    }

    public void setDetalleNominaCollection(Collection<DetalleNomina> detalleNominaCollection) {
        this.detalleNominaCollection = detalleNominaCollection;
    }

    public Cargos getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargos cargoId) {
        this.cargoId = cargoId;
    }

    public Ciudades getCiudadesId() {
        return ciudadesId;
    }

    public void setCiudadesId(Ciudades ciudadesId) {
        this.ciudadesId = ciudadesId;
    }

    public TiposDocumento getTiposDocumentoId() {
        return tiposDocumentoId;
    }

    public void setTiposDocumentoId(TiposDocumento tiposDocumentoId) {
        this.tiposDocumentoId = tiposDocumentoId;
    }

    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Usuarios getIdJefeInmediato() {
        return idJefeInmediato;
    }

    public void setIdJefeInmediato(Usuarios idJefeInmediato) {
        this.idJefeInmediato = idJefeInmediato;
    }

    public Collection<UsuariosHasRoles> getUsuariosHasRolesCollection() {
        return usuariosHasRolesCollection;
    }

    public void setUsuariosHasRolesCollection(Collection<UsuariosHasRoles> usuariosHasRolesCollection) {
        this.usuariosHasRolesCollection = usuariosHasRolesCollection;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.danscorp.mavenproject1.Usuarios[ id=" + id + " ]";
    }
    
}
