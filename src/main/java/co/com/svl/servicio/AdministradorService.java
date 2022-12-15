/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.modelo.Administrador;
import java.util.List;

/**
 *
 * @author JhojanDS
 */
public interface AdministradorService{
    
    /**
     *
     * @return
     */
    public List<Administrador> listarAdministradores();
    
    /**
     *
     * @param administrador
     */
    public void guardar(Administrador administrador);
    
    /**
     *
     * @param administrador
     */
    public void eliminar(Administrador administrador);
    
    /**
     *
     * @param administrador
     * @return
     */
    public Administrador encontrarAdministrador(Short codigo);
    
    /**
     *
     * @param correo
     * @return
     */
    public Administrador encontrarAdministradorPorCorreo(String correo);
    
}
