/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danscorp.mavenproject1.sessions;

import com.danscorp.mavenproject1.Ciudades;
import java.util.List;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Local
public interface CiudadesFacadeLocal {

    void create(Ciudades ciudades);

    void edit(Ciudades ciudades);

    void remove(Ciudades ciudades);

    Ciudades find(Object id);

    List<Ciudades> findAll();

    List<Ciudades> findRange(int[] range);

    int count();
    
}
