/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.modelo.Producto;
import java.util.List;

/**
 *
 * @author JhojanDS
 */
public interface ProductoService{
    
    /**
     *
     * @return
     */
    public List<Producto> listarProductos();
    
    /**
     *
     * @param producto
     */
    public void guardar(Producto producto);
    
    /**
     *
     * @param producto
     */
    public void eliminar(Producto producto);
    
    /**
     *
     * @param codigo
     * @return
     */
    public Producto encontrarProductoPorCodigo(Long codigo);
    
    /**
     *
     * @param busqueda
     * @return
     */
    public List<Producto> encontrarProductoPorNombreOrDescripcion(String busqueda);
    
}
