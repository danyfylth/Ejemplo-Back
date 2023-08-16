/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danscorp.mavenproject1.sessions;

import com.danscorp.mavenproject1.Paises;
import java.util.List;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Local
public interface PaisesFacadeLocal {

    void create(Paises paises);

    void edit(Paises paises);

    void remove(Paises paises);

    Paises find(Object id);

    List<Paises> findAll();

    List<Paises> findRange(int[] range);

    int count();
    
}
