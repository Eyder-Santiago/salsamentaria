/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.controlador;

import co.com.svl.modelo.Producto;
import co.com.svl.servicio.ProductoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JHOJAN L
 */
@Slf4j
@RestController
@RequestMapping()
public class ControladorRestProductos {
//este controlador rest se encargara de devolverme ya sea todos los productos o un producto 
    //el cual lo devovera al frontend mediante un json
    @Autowired
    private ProductoService productoService;

    /**
     * @author JHOJAN L
     * @return
     */
    @GetMapping(path = "/productos")
    public List<Producto> obtenerProductos() {//se convierte automaticaente en JSON    
        return productoService.listarProductos();
    }

    /**
     * @author JHOJAN L
     * @param codigo
     * @return productoService.encontrarProductoPorCodigo(codigo)
     */
    @GetMapping(path = "/producto{codigo}")
    public Producto obtenerProducto(Long codigo) {//se convierte automaticaente en JSON    
        return productoService.encontrarProductoPorCodigo(codigo);
    }

//    @PostMapping(value = "/editarProductoInventario")
//    public ResponseEntity<Producto>(@RequestBody Producto producto) {//se convierte automaticaente en JSON    
//        productoService.guardar(producto);
//        return new ResponseEntity<>(producto,HttpStatus.OK);
//    }
}
