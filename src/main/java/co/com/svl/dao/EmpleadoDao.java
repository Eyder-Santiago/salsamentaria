    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.dao;

import co.com.svl.modelo.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JhojanDS
 */
public interface EmpleadoDao extends CrudRepository<Empleado, Long> {
    
    /**
     * @author JhojanDS
     * @param correo
     * @return
     */
    @Query("SELECT e FROM Empleado e WHERE e.correo = :correo")
    public Empleado findEmpleadoByCorreo(@Param("correo") String correo);
    
}
