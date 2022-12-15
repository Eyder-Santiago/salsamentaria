/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.dao.ProductoVentaDao;
import co.com.svl.modelo.ProductoVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JhojanDS
 * @email jhojanlopez327@gmail.com
 */
@Service
public class ProductoVentaServiceImpl implements ProductoVentaService {

    @Autowired
    private ProductoVentaDao productoVentaDao;

    @Override
    @Transactional
    public void guardar(ProductoVenta productoVenta) {
    productoVentaDao.save(productoVenta);
    }

    @Override
    @Transactional
    public void eliminar(ProductoVenta productoVenta) {
    productoVentaDao.delete(productoVenta);
    }

}
