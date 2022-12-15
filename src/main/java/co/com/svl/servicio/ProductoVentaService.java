/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.modelo.ProductoVenta;

/**
 *
 * @author JhojanDS
 */
public interface ProductoVentaService{
    
    /**
     *
     * @param productoVenta
     */
    public void guardar(ProductoVenta productoVenta);
    
    /**
     *
     * @param productoVenta
     */
    public void eliminar(ProductoVenta productoVenta);
    
    
}
