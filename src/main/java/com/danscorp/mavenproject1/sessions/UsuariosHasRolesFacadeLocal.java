/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danscorp.mavenproject1.sessions;

import com.danscorp.mavenproject1.UsuariosHasRoles;
import java.util.List;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Local
public interface UsuariosHasRolesFacadeLocal {

    void create(UsuariosHasRoles usuariosHasRoles);

    void edit(UsuariosHasRoles usuariosHasRoles);

    void remove(UsuariosHasRoles usuariosHasRoles);

    UsuariosHasRoles find(Object id);

    List<UsuariosHasRoles> findAll();

    List<UsuariosHasRoles> findRange(int[] range);

    int count();
    
}
