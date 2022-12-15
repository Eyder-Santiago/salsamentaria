/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.modelo.Administrador;
import co.com.svl.modelo.Empleado;
import co.com.svl.modelo.Venta;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JhojanDS
 */
public interface VentaService {

    /**
     *
     * @return
     */
    public List<Venta> listarVentas();

    /**
     *
     * @param venta
     */
    public void guardar(Venta venta);

    /**
     *
     * @param venta
     */
    public void eliminar(Venta venta);

    /**
     *
     * @param codigo
     * @return
     */
    public Venta encontrarVentaPorCodigo(Long codigo);

    /**
     *
     * @param fecha
     * @return
     */
    public List<Venta> encontrarVentaPorFecha(Date fecha);

    /**
     *
     * @param administrador
     * @return
     */
    public List<Venta> encontrarVentaPorAdministrador(Administrador administrador);

    /**
     *
     * @param empleado
     * @return
     */
    public List<Venta> encontrarVentaPorEmpleado(Empleado empleado);

    /**
     *
     * @param fechaDesde
     * @param fechaHasta
     * @return
     */
    public List<Venta> encontrarVentaPorRangoFecha(Date fechaDesde ,Date fechaHasta);

}
