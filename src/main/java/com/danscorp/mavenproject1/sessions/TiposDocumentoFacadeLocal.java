/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danscorp.mavenproject1.sessions;

import com.danscorp.mavenproject1.TiposDocumento;
import java.util.List;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Local
public interface TiposDocumentoFacadeLocal {

    void create(TiposDocumento tiposDocumento);

    void edit(TiposDocumento tiposDocumento);

    void remove(TiposDocumento tiposDocumento);

    TiposDocumento find(Object id);

    List<TiposDocumento> findAll();

    List<TiposDocumento> findRange(int[] range);

    int count();
    
}
