/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.dao.ReporteDao;
import co.com.svl.modelo.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JHOJAN L
 */
@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private ReporteDao reporteDao;

    /**
     *
     * @param reporte
     */
    @Override
    @Transactional
    public void guardar(Reporte reporte) {
        reporteDao.save(reporte);
    }

    /**
     *
     * @param reporte
     */
    @Override
    @Transactional
    public void eliminar(Reporte reporte) {
        reporteDao.delete(reporte);
    }

    /**
     *
     * @param codigo
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Reporte encontrarPorCodigo(Long codigo) {
        return reporteDao.findById(codigo).orElse(null);
    }

}
