/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.modelo.Empleado;
import java.util.List;

/**
 *
 * @author JhojanDS
 */
public interface EmpleadoService {

    /**
     *
     * @return
     */
    public List<Empleado> listarEmpleados();

    /**
     *
     * @param empleado
     */
    public void guardar(Empleado empleado);

    /**
     *
     * @param empleado
     */
    public void eliminar(Empleado empleado);

    /**
     *
     * @param empleado
     * @return
     */
    public Empleado encontrarEmpleado(Empleado empleado);

    /**
     *
     * @param correo
     * @return
     */
    public Empleado encontrarEmpleadoPorCorreo(String correo);

}
