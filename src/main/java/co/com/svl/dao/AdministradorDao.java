/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.dao;

import co.com.svl.modelo.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JhojanDS
 */
public interface AdministradorDao extends JpaRepository<Administrador, Short> {

    /**
     * @author JhojanDS
     * @param correo
     * @return
     */
    @Query("SELECT a FROM Administrador a WHERE a.correo = :correo")
    public Administrador findAdministradorByCorreo(@Param("correo") String correo);

}
