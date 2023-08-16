/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danscorp.mavenproject1.restservices.service;

import com.danscorp.mavenproject1.DetalleNomina;
import com.danscorp.mavenproject1.Nomina;
import com.danscorp.mavenproject1.Usuarios;
import jakarta.ejb.EJB;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.QueryParam;

/**
 *
 * @author Daniel
 */
@jakarta.ejb.Stateless
@jakarta.ws.rs.Path("detallenomina")
public class DetalleNominaFacadeREST extends AbstractFacade<DetalleNomina> {

    @PersistenceContext(unitName = "com.danscorp_mavenproject1_war_1.0-SNAPSHOTPU2")
    private EntityManager em;
    
    @EJB
    private UsuariosFacadeREST usuarioEJB;
    
    @EJB
    private NominaFacadeREST nominaEJB;
    
    public DetalleNominaFacadeREST() {
        super(DetalleNomina.class);
    }

//    @jakarta.ws.rs.POST
//    @Override
//    @jakarta.ws.rs.Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
//    public void create(DetalleNomina entity) {
//        super.create(entity);
//    }

    @jakarta.ws.rs.PUT
    @jakarta.ws.rs.Path("{id}")
    @jakarta.ws.rs.Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void edit(@jakarta.ws.rs.PathParam("id") Integer id, DetalleNomina entity) {
        super.edit(entity);
    }

    @jakarta.ws.rs.DELETE
    @jakarta.ws.rs.Path("{id}")
    public void remove(@jakarta.ws.rs.PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @jakarta.ws.rs.GET
    @jakarta.ws.rs.Path("{id}")
    @jakarta.ws.rs.Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public DetalleNomina find(@jakarta.ws.rs.PathParam("id") Integer id) {
        return super.find(id);
    }

    @jakarta.ws.rs.GET
    @Override
    @jakarta.ws.rs.Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<DetalleNomina> findAll() {
        return super.findAll();
    }

    @jakarta.ws.rs.GET
    @jakarta.ws.rs.Path("{from}/{to}")
    @jakarta.ws.rs.Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<DetalleNomina> findRange(@jakarta.ws.rs.PathParam("from") Integer from, @jakarta.ws.rs.PathParam("to") Integer to) {
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
    
    // Existe estas formas de implementar la lógica:
    // Clases diferentes con la lógica
    // En el mismoREST
    // Crear la lógica en las entidades
    
    private double calcularSueldoDevengado(double sueldoBasico, int diasLaborados){
        return sueldoBasico / 30 * diasLaborados;
    }
    
    private double obtenerValorAuxTransporte(double salarioBasico, int diasLaborados){
        double auxTransporte = 0;
        
        if (salarioBasico <= 737717 * 2) {
            auxTransporte = 83140 / 30 * diasLaborados;
        }
        
        return auxTransporte;
    }
    
    private double obtenerFondoSolidario(double totalDevengado, double sueldoBasico){
        
        double fondoSolidaridad = 0;
        
        if (sueldoBasico >= 737717 * 4) {
            fondoSolidaridad = totalDevengado * 0.01;
        }
        
        return fondoSolidaridad;
        
    }
    
    @jakarta.ws.rs.POST
    @jakarta.ws.rs.Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void create(@QueryParam("idUsuario") Integer idUsuario,
                       @QueryParam("diasLaborados") int diasLaborados,
                       @QueryParam("idNomina") Integer idNomina) {
        
        try {

            DetalleNomina newDetalleNomina = new DetalleNomina();

            // Consultar Usuario por ID
            Usuarios empleado = usuarioEJB.find(idUsuario);

            // Consultar la Nomina por su ID
            Nomina nomina = nominaEJB.find(idNomina);
            
            // Dias Laborados
            newDetalleNomina.setDiasLaborados(diasLaborados);
            
            // sueldo_devengado = sueldo_basico / 30 * dias_laborados
            newDetalleNomina.setSueldoDevengado(calcularSueldoDevengado(empleado.getSueldoBasico(), diasLaborados));

            // Auxilio Transporte
            newDetalleNomina.setAuxilioTransporte(obtenerValorAuxTransporte(empleado.getSueldoBasico(), diasLaborados));

            // Valor Horas Extras = sueldo_devengado * 10%
            newDetalleNomina.setValorHorasExtras(newDetalleNomina.getSueldoDevengado() * 0.1);

            // total devengado = sueldo devengado + auxtransporte + horas extras
            newDetalleNomina.setTotalDevengado(
                    newDetalleNomina.getSueldoDevengado()
                    + newDetalleNomina.getAuxilioTransporte()
                    + newDetalleNomina.getValorHorasExtras()
            );

            // descuento salud = (total devengado - auxTransporte) * 4%
            newDetalleNomina.setDescuentoSalud(
                    (newDetalleNomina.getTotalDevengado() - newDetalleNomina.getAuxilioTransporte()) * 0.4
            );

            // descuento pension = (total devengado - auxTransporte) * 4%
            newDetalleNomina.setDescuentoPension(
                    (newDetalleNomina.getTotalDevengado() - newDetalleNomina.getAuxilioTransporte()) * 0.4
            );

            //otros descuentos = 300000
            newDetalleNomina.setOtrosDescuentos(300000.0);

            // Fondo de Solidaridad
            newDetalleNomina.setDescuentoFondoSolidaridad(
                    obtenerFondoSolidario(newDetalleNomina.getTotalDevengado(), empleado.getSueldoBasico())
            );

            // Total descuento = descuentoSalud + descuentoPension + DescuentoAdicional + fondoSolidaridad
            newDetalleNomina.setTotalDescuento(
                    newDetalleNomina.getDescuentoSalud()
                    + newDetalleNomina.getDescuentoPension()
                    + newDetalleNomina.getOtrosDescuentos()
                    + newDetalleNomina.getDescuentoFondoSolidaridad()
            );

            // Neto a pagar = total devengado - total descuento
            newDetalleNomina.setNetoPagar(
                    newDetalleNomina.getTotalDevengado() - newDetalleNomina.getTotalDescuento()
            );

            newDetalleNomina.setUsuariosId(empleado);
            newDetalleNomina.setNominaId(nomina);
            //newDetalleNomina.setNominaId(new Nomina(idNomina));

            super.create(newDetalleNomina);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }   
   
}
