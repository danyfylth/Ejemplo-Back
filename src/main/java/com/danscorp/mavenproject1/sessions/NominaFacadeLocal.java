/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danscorp.mavenproject1.sessions;

import com.danscorp.mavenproject1.Nomina;
import java.util.List;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Local
public interface NominaFacadeLocal {

    void create(Nomina nomina);

    void edit(Nomina nomina);

    void remove(Nomina nomina);

    Nomina find(Object id);

    List<Nomina> findAll();

    List<Nomina> findRange(int[] range);

    int count();
    
}
