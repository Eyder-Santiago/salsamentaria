/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.dao;

import co.com.svl.modelo.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author JhojanDS
 */
public interface ProductoDao extends JpaRepository<Producto, Long>{
    
    /**
     * @author JhojanDS
     * @param busqueda
     * @return
     */
    @Query("SELECT p FROM Producto p WHERE lower(p.nombre) LIKE %?1%"
            + " OR lower(p.descripcion) LIKE %?1%" ) //lower() permite que la busqueda no sea esctricto en mayusculas
    public List<Producto> findProductoByNombreOrByDescripcion(String busqueda);
    
   
}
