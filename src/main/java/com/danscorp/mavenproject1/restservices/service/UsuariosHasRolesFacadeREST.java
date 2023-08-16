/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danscorp.mavenproject1.restservices.service;

import com.danscorp.mavenproject1.UsuariosHasRoles;
import com.danscorp.mavenproject1.UsuariosHasRolesPK;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Stateless
@jakarta.ws.rs.Path("usuarioshasroles")
public class UsuariosHasRolesFacadeREST extends AbstractFacade<UsuariosHasRoles> {

    @PersistenceContext(unitName = "com.danscorp_mavenproject1_war_1.0-SNAPSHOTPU2")
    private EntityManager em;

    private UsuariosHasRolesPK getPrimaryKey(jakarta.ws.rs.core.PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;usuariosId=usuariosIdValue;rolesId=rolesIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.danscorp.mavenproject1.UsuariosHasRolesPK key = new com.danscorp.mavenproject1.UsuariosHasRolesPK();
        jakarta.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> usuariosId = map.get("usuariosId");
        if (usuariosId != null && !usuariosId.isEmpty()) {
            key.setUsuariosId(Integer.parseInt(usuariosId.get(0)));
        }
        java.util.List<String> rolesId = map.get("rolesId");
        if (rolesId != null && !rolesId.isEmpty()) {
            key.setRolesId(Integer.parseInt(rolesId.get(0)));
        }
        return key;
    }

    public UsuariosHasRolesFacadeREST() {
        super(UsuariosHasRoles.class);
    }

    @jakarta.ws.rs.POST
    @Override
    @jakarta.ws.rs.Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void create(UsuariosHasRoles entity) {
        super.create(entity);
    }

    @jakarta.ws.rs.PUT
    @jakarta.ws.rs.Path("{id}")
    @jakarta.ws.rs.Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void edit(@jakarta.ws.rs.PathParam("id") jakarta.ws.rs.core.PathSegment id, UsuariosHasRoles entity) {
        super.edit(entity);
    }

    @jakarta.ws.rs.DELETE
    @jakarta.ws.rs.Path("{id}")
    public void remove(@jakarta.ws.rs.PathParam("id") jakarta.ws.rs.core.PathSegment id) {
        com.danscorp.mavenproject1.UsuariosHasRolesPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @jakarta.ws.rs.GET
    @jakarta.ws.rs.Path("{id}")
    @jakarta.ws.rs.Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public UsuariosHasRoles find(@jakarta.ws.rs.PathParam("id") jakarta.ws.rs.core.PathSegment id) {
        com.danscorp.mavenproject1.UsuariosHasRolesPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @jakarta.ws.rs.GET
    @Override
    @jakarta.ws.rs.Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<UsuariosHasRoles> findAll() {
        return super.findAll();
    }

    @jakarta.ws.rs.GET
    @jakarta.ws.rs.Path("{from}/{to}")
    @jakarta.ws.rs.Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<UsuariosHasRoles> findRange(@jakarta.ws.rs.PathParam("from") Integer from, @jakarta.ws.rs.PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @jakarta.ws.rs.GET
    @jakarta.ws.rs.Path("count")
    @jakarta.ws.rs.Produces(jakarta.ws.rs.core.MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
