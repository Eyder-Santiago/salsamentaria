/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.dao;

import co.com.svl.modelo.ReporteVenta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JhojanDS
 */
public interface ReporteVentaDao  extends JpaRepository<ReporteVenta, Long>{
    
}
