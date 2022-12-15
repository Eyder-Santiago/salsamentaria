/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.modelo.Reporte;

/**
 *
 * @author JHOJAN L
 */
public interface ReporteService {
    
    /**
     *
     * @param reporte
     */
    public void guardar(Reporte reporte);

    /**
     *
     * @param reprte
     */
    public void eliminar(Reporte reprte);

    /**
     *
     * @param codigo
     * @return
     */
    public Reporte encontrarPorCodigo(Long codigo);

}
