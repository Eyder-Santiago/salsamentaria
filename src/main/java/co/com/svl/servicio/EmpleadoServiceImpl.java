/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.dao.EmpleadoDao;
import co.com.svl.modelo.Empleado;
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
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoDao empleadoDao;

    /**
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listarEmpleados() {

        return (List<Empleado>) empleadoDao.findAll();
    }

    /**
     *
     * @param empleado
     */
    @Override
    @Transactional
    public void guardar(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    /**
     *
     * @param empleado
     */
    @Override
    @Transactional
    public void eliminar(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    /**
     *
     * @param empleado
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Empleado encontrarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param correo
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Empleado encontrarEmpleadoPorCorreo(String correo) {
        return empleadoDao.findEmpleadoByCorreo(correo);
    }

//    @Override
//    @Transactional(readOnly=true)
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Empleado empleado = empleadoDao.findEmpleadoByCorreo(username);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
