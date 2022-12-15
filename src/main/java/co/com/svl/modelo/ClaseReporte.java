/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.modelo;

import java.util.List;

/**
 *
 * @author JHOJAN L
 */
public class ClaseReporte {
    private List<Venta> ventas;
    private long precioVentas;
    private long costoVentas;
    private long ganancia;

    /**
     *
     */
    public ClaseReporte() {
    }

    /**
     *
     * @param ventas
     * @param precioVenta
     * @param costoVenta
     * @param ganancia
     */
    public ClaseReporte(List<Venta> ventas, long precioVenta, long costoVenta, long ganancia) {
        this.ventas = ventas;
        this.precioVentas = precioVenta;
        this.costoVentas = costoVenta;
        this.ganancia = ganancia;
    }

    /**
     *
     * @return
     */
    public List<Venta> getVentas() {
        return ventas;
    }

    /**
     *
     * @param ventas
     */
    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     *
     * @return
     */
    public long getPrecioVenta() {
        return precioVentas;
    }

    /**
     *
     * @param precioVenta
     */
    public void setPrecioVenta(long precioVenta) {
        this.precioVentas = precioVenta;
    }

    /**
     *
     * @return
     */
    public long getCostoVenta() {
        return costoVentas;
    }

    /**
     *
     * @param costoVenta
     */
    public void setCostoVenta(long costoVenta) {
        this.costoVentas = costoVenta;
    }

    /**
     *
     * @return
     */
    public long getGanancia() {
        return ganancia;
    }

    /**
     *
     * @param ganancia
     */
    public void setGanancia(long ganancia) {
        this.ganancia = ganancia;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Reporte{" + "ventas=" + ventas + ", precioVentas=" + precioVentas + ", costoVentas=" + costoVentas + ", ganancia=" + ganancia + '}';
    }
    
    
    
}
