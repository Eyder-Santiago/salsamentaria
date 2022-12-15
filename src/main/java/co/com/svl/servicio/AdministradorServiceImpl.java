/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.servicio;

import co.com.svl.dao.AdministradorDao;
import co.com.svl.modelo.Administrador;
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
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorDao administradorDao;

    /**
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Administrador> listarAdministradores() {
        return (List<Administrador>) administradorDao.findAll();
    }

    /**
     *
     * @param administrador
     */
    @Override
    @Transactional
    public void guardar(Administrador administrador) {
        administradorDao.save(administrador);
    }

    /**
     *
     * @param administrador
     */
    @Override
    @Transactional
    public void eliminar(Administrador administrador) {
        administradorDao.delete(administrador);
    }

    /**
     *
     * @param administrador
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Administrador encontrarAdministrador(Short codigo) {
     return administradorDao.findById(codigo).orElse(null);
    }

    /**
     *
     * @param correo
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Administrador encontrarAdministradorPorCorreo(String correo) {
        return administradorDao.findAdministradorByCorreo(correo);
    }
}
