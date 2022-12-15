/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.dao.ReporteVentaDao;
import co.com.svl.modelo.ReporteVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JHOJAN L
 */
@Service
public class ReporteVentaServiceImpl implements ReporteVentaService {

    @Autowired
    private ReporteVentaDao reporteVentaDao;

    /**
     *
     * @param reporteVenta
     */
    @Transactional
    @Override
    public void guardar(ReporteVenta reporteVenta) {
        reporteVentaDao.save(reporteVenta);
    }

    /**
     *
     * @param reporteVenta
     */
    @Transactional
    @Override
    public void eliminar(ReporteVenta reporteVenta) {
        reporteVentaDao.delete(reporteVenta);
    }

}
