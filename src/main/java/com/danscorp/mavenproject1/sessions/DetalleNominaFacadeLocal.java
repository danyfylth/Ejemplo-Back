/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danscorp.mavenproject1.sessions;

import com.danscorp.mavenproject1.DetalleNomina;
import java.util.List;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Local
public interface DetalleNominaFacadeLocal {

    void create(DetalleNomina detalleNomina);

    void edit(DetalleNomina detalleNomina);

    void remove(DetalleNomina detalleNomina);

    DetalleNomina find(Object id);

    List<DetalleNomina> findAll();

    List<DetalleNomina> findRange(int[] range);

    int count();
    
}
