/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danscorp.mavenproject1.sessions;

import com.danscorp.mavenproject1.Departamentos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Stateless
public class DepartamentosFacade extends AbstractFacade<Departamentos> implements DepartamentosFacadeLocal {

    @PersistenceContext(unitName = "com.danscorp_mavenproject1_war_1.0-SNAPSHOTPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentosFacade() {
        super(Departamentos.class);
    }
    
}
