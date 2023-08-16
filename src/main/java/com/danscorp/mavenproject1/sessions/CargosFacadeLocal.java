/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danscorp.mavenproject1.sessions;

import com.danscorp.mavenproject1.Cargos;
import java.util.List;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Local
public interface CargosFacadeLocal {

    void create(Cargos cargos);

    void edit(Cargos cargos);

    void remove(Cargos cargos);

    Cargos find(Object id);

    List<Cargos> findAll();

    List<Cargos> findRange(int[] range);

    int count();
    
}
