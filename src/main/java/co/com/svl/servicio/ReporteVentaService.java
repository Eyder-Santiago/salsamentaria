/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.modelo.ReporteVenta;

/**
 *
 * @author JHOJAN L
 */
public interface ReporteVentaService {
    
    /**
     *
     * @param reporteVenta
     */
    public void guardar(ReporteVenta reporteVenta);

    /**
     *
     * @param reporteVenta
     */
    public void eliminar(ReporteVenta reporteVenta);
    
}
