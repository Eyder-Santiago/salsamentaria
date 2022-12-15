/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.modelo;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "administrador")
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByCodigo", query = "SELECT a FROM Administrador a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Administrador.findByActivo", query = "SELECT a FROM Administrador a WHERE a.activo = :activo"),
    @NamedQuery(name = "Administrador.findByNombre", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Administrador.findByCorreo", query = "SELECT a FROM Administrador a WHERE a.correo = :correo"),
    @NamedQuery(name = "Administrador.findByContrasena", query = "SELECT a FROM Administrador a WHERE a.contrasena = :contrasena"),
    @NamedQuery(name = "Administrador.findByNombreNegocio", query = "SELECT a FROM Administrador a WHERE a.nombreNegocio = :nombreNegocio"),
    @NamedQuery(name = "Administrador.findByNitNegocio", query = "SELECT a FROM Administrador a WHERE a.nitNegocio = :nitNegocio"),
    @NamedQuery(name = "Administrador.findByDireccion", query = "SELECT a FROM Administrador a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Administrador.findByTelefono", query = "SELECT a FROM Administrador a WHERE a.telefono = :telefono")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private short codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_negocio")
    private String nombreNegocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit_negocio")
    private long nitNegocio;
    @Size(max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private BigInteger telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoAdministrador", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoAdministrador", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoAdministrador", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    /**
     *
     */
    public Administrador() {
    }

    /**
     *
     * @param codigo
     */
    public Administrador(Short codigo) {
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
    public short getActivo() {
        return activo;
    }

    /**
     *
     * @param activo
     */
    public void setActivo(short activo) {
        this.activo = activo;
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
    public String getNombreNegocio() {
        return nombreNegocio;
    }

    /**
     *
     * @param nombreNegocio
     */
    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    /**
     *
     * @return
     */
    public long getNitNegocio() {
        return nitNegocio;
    }

    /**
     *
     * @param nitNegocio
     */
    public void setNitNegocio(long nitNegocio) {
        this.nitNegocio = nitNegocio;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public BigInteger getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public List<Venta> getVentaList() {
        return ventaList;
    }

    /**
     *
     * @param ventaList
     */
    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    /**
     *
     * @return
     */
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    /**
     *
     * @param empleadoList
     */
    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    /**
     *
     * @return
     */
    public List<Producto> getProductoList() {
        return productoList;
    }

    /**
     *
     * @param productoList
     */
    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Administrador{" + "codigo=" + codigo + ", activo=" + activo + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + ", nombreNegocio=" + nombreNegocio + ", nitNegocio=" + nitNegocio + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}