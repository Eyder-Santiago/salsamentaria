/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.com.svl.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JhojanDS
 * @email jhojanlopez327@gmail.com
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByCodigo", query = "SELECT e FROM Empleado e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByCorreo", query = "SELECT e FROM Empleado e WHERE e.correo = :correo"),
    @NamedQuery(name = "Empleado.findByContrasena", query = "SELECT e FROM Empleado e WHERE e.contrasena = :contrasena")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Short codigo;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "contrasena")
    private String contrasena;
    @OneToMany(mappedBy = "codigoEmpleado")
    private List<Venta> ventaList;
    @JoinColumn(name = "codigo_administrador", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Administrador codigoAdministrador;

    /**
     *
     */
    public Empleado() {
    }

    /**
     *
     * @param codigo
     */
    public Empleado(Short codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public Short getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(Short codigo) {
        this.codigo = codigo;
    }
    
    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     *
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     *
     * @return
     */
    public Administrador getCodigoAdministrador() {
        return codigoAdministrador;
    }

    /**
     *
     * @param codigoAdministrador
     */
    public void setCodigoAdministrador(Administrador codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + ", codigoAdministrador=" + codigoAdministrador + '}';
    }

  
}
