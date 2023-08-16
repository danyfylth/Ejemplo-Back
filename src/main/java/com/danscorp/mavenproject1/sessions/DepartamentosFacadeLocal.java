/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danscorp.mavenproject1.sessions;

import com.danscorp.mavenproject1.Departamentos;
import java.util.List;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Local
public interface DepartamentosFacadeLocal {

    void create(Departamentos departamentos);

    void edit(Departamentos departamentos);

    void remove(Departamentos departamentos);

    Departamentos find(Object id);

    List<Departamentos> findAll();

    List<Departamentos> findRange(int[] range);

    int count();
    
}
