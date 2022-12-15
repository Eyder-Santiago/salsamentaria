/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.dao.ProductoDao;
import co.com.svl.modelo.Producto;
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
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    /**
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProductos() {
        return (List<Producto>) productoDao.findAll();
    }

    /**
     *
     * @param producto
     */
    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoDao.save(producto);

    }

    /**
     *
     * @param producto
     */
    @Override
    @Transactional  
    public void eliminar(Producto producto) {
        productoDao.delete(producto);
    }

    /**
     *
     * @param codigo
     * @return
     */
    @Override
    @Transactional
    public Producto encontrarProductoPorCodigo(Long codigo) {
        return productoDao.findById(codigo).orElse(null);
    }

    /**
     *
     * @param busqueda
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Producto> encontrarProductoPorNombreOrDescripcion(String busqueda) {
        return productoDao.findProductoByNombreOrByDescripcion(busqueda);
    }

}
