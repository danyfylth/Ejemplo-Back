/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danscorp.mavenproject1;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "usuarios_has_roles")
@NamedQueries({
    @NamedQuery(name = "UsuariosHasRoles.findAll", query = "SELECT u FROM UsuariosHasRoles u"),
    @NamedQuery(name = "UsuariosHasRoles.findByActivo", query = "SELECT u FROM UsuariosHasRoles u WHERE u.activo = :activo"),
    @NamedQuery(name = "UsuariosHasRoles.findByUsuariosId", query = "SELECT u FROM UsuariosHasRoles u WHERE u.usuariosHasRolesPK.usuariosId = :usuariosId"),
    @NamedQuery(name = "UsuariosHasRoles.findByRolesId", query = "SELECT u FROM UsuariosHasRoles u WHERE u.usuariosHasRolesPK.rolesId = :rolesId")})
public class UsuariosHasRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosHasRolesPK usuariosHasRolesPK;
    @Basic(optional = false)
    @Column(name = "activo")
    private short activo;
    @JoinColumn(name = "roles_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Roles roles;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public UsuariosHasRoles() {
    }

    public UsuariosHasRoles(UsuariosHasRolesPK usuariosHasRolesPK) {
        this.usuariosHasRolesPK = usuariosHasRolesPK;
    }

    public UsuariosHasRoles(UsuariosHasRolesPK usuariosHasRolesPK, short activo) {
        this.usuariosHasRolesPK = usuariosHasRolesPK;
        this.activo = activo;
    }

    public UsuariosHasRoles(int usuariosId, int rolesId) {
        this.usuariosHasRolesPK = new UsuariosHasRolesPK(usuariosId, rolesId);
    }

    public UsuariosHasRolesPK getUsuariosHasRolesPK() {
        return usuariosHasRolesPK;
    }

    public void setUsuariosHasRolesPK(UsuariosHasRolesPK usuariosHasRolesPK) {
        this.usuariosHasRolesPK = usuariosHasRolesPK;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosHasRolesPK != null ? usuariosHasRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosHasRoles)) {
            return false;
        }
        UsuariosHasRoles other = (UsuariosHasRoles) object;
        if ((this.usuariosHasRolesPK == null && other.usuariosHasRolesPK != null) || (this.usuariosHasRolesPK != null && !this.usuariosHasRolesPK.equals(other.usuariosHasRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.danscorp.mavenproject1.UsuariosHasRoles[ usuariosHasRolesPK=" + usuariosHasRolesPK + " ]";
    }
    
}
