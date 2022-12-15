/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.dao;

import co.com.svl.modelo.Administrador;
import co.com.svl.modelo.Empleado;
import co.com.svl.modelo.Venta;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JhojanDS
 */
public interface VentaDao extends JpaRepository<Venta, Long> {

    //al tener un named querie en la clase venta llamado de la misma forma 
    //se realizara dicho select

    /**
     * @author JhojanDS
     * @param fecha
     * @return
     */
    public List<Venta> findByFecha(Date fecha);
   
    /**
     * @author JhojanDS
     * @param administrador
     * @return
     */
    @Query("SELECT v FROM Venta v WHERE v.codigoAdministrador = :codigoAdministrador"
            + " AND v.codigoEmpleado is NULL")
    public List<Venta> findByAdministrador(@Param("codigoAdministrador") Administrador administrador);
    
    /**
     * @author JhojanDS
     * @param empleado
     * @return
     */
    @Query("SELECT v FROM Venta v WHERE v.codigoEmpleado = :codigoEmpleado")
    public List<Venta> findByEmpleado(@Param("codigoEmpleado") Empleado empleado);
    
    /** 
     * @author JhojanDS
     * @param fechaDesde
     * @param fechaHasta
     * @return
     */
    @Query("SELECT v FROM Venta v WHERE v.fecha BETWEEN ?1 AND ?2")
    public List<Venta> findByRangoFecha(@Param("fechaDesde") Date fechaDesde,
            @Param("fechaHasta") Date fechaHasta);
    
}
