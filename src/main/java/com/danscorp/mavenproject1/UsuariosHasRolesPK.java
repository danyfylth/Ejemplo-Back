/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danscorp.mavenproject1;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author Daniel
 */
@Embeddable
public class UsuariosHasRolesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "usuarios_id")
    private int usuariosId;
    @Basic(optional = false)
    @Column(name = "roles_id")
    private int rolesId;

    public UsuariosHasRolesPK() {
    }

    public UsuariosHasRolesPK(int usuariosId, int rolesId) {
        this.usuariosId = usuariosId;
        this.rolesId = rolesId;
    }

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }

    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuariosId;
        hash += (int) rolesId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosHasRolesPK)) {
            return false;
        }
        UsuariosHasRolesPK other = (UsuariosHasRolesPK) object;
        if (this.usuariosId != other.usuariosId) {
            return false;
        }
        if (this.rolesId != other.rolesId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.danscorp.mavenproject1.UsuariosHasRolesPK[ usuariosId=" + usuariosId + ", rolesId=" + rolesId + " ]";
    }
    
}
