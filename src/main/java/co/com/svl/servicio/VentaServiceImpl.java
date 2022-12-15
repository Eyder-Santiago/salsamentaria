/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.dao.VentaDao;
import co.com.svl.modelo.Administrador;
import co.com.svl.modelo.Empleado;
import co.com.svl.modelo.Venta;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JhojanDS
 * @email jhojanlopez327@gmail.com
 */
@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaDao ventaDao;

    /**
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Venta> listarVentas() {
        return (List<Venta>) ventaDao.findAll();
    }

    /**
     *
     * @param venta
     */
    @Override
    @Transactional
    public void guardar(Venta venta) {
        ventaDao.save(venta);
    }

    /**
     *
     * @param venta
     */
    @Override
    @Transactional
    public void eliminar(Venta venta) {
        ventaDao.delete(venta);
    }

    /**
     *
     * @param codigo
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Venta encontrarVentaPorCodigo(Long codigo) {
        return ventaDao.findById(codigo).orElse(null);

    }

    /**
     *
     * @param fecha
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Venta> encontrarVentaPorFecha(Date fecha) {
        return (List<Venta>) ventaDao.findByFecha(fecha);
    }

    /**
     *
     * @param administrador
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Venta> encontrarVentaPorAdministrador(Administrador administrador) {
        return (List<Venta>) ventaDao.findByAdministrador(administrador);
    }

    /**
     *
     * @param empleado
     * @return
     */
    @Override
    public List<Venta> encontrarVentaPorEmpleado(Empleado empleado) {
        return (List<Venta>) ventaDao.findByEmpleado(empleado);

    }

    /**
     *
     * @param fechaDesde
     * @param fechaHasta
     * @return
     */
    @Override
    public List<Venta> encontrarVentaPorRangoFecha(Date fechaDesde, Date fechaHasta) {
        return (List<Venta>) ventaDao.findByRangoFecha(fechaDesde, fechaHasta);
    }

}
