/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.com.svl.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByCodigo", query = "SELECT p FROM Producto p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByCosto", query = "SELECT p FROM Producto p WHERE p.costo = :costo"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByUnidadMedida", query = "SELECT p FROM Producto p WHERE p.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private long costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private long precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidad_medida")
    private short unidadMedida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @JsonIgnore//ES USADO PARA QUE NO SE CONVIERTA A JSON
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch=FetchType.LAZY)
    private List<ProductoVenta> productoVentaList;
    @JsonIgnore
    @JoinColumn(name = "codigo_administrador", referencedColumnName = "codigo")
    @ManyToOne(optional = false,  fetch=FetchType.LAZY)
    private Administrador codigoAdministrador;

    /**
     *
     */
    public Producto() {
    }

    public Producto(Long codigo) {
        this.codigo = codigo;
    }

    public Producto(Long codigo, double cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }
    
    

    /**
     *
     * @param codigo
     * @param nombre
     * @param precio
     * @param costo
     * @param unidadMedida
     */
    public Producto(Long codigo, String nombre, long precio,long costo, short unidadMedida) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
        this.unidadMedida = unidadMedida;
    }

    /**
     *
     * @return
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(Long codigo) {
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
    public long getCosto() {
        return costo;
    }

    /**
     *
     * @param costo
     */
    public void setCosto(long costo) {
        this.costo = costo;
    }

    /**
     *
     * @return
     */
    public long getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(long precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public short getUnidadMedida() {
        return unidadMedida;
    }

    /**
     *
     * @param unidadMedida
     */
    public void setUnidadMedida(short unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    /**
     *
     * @return
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public List<ProductoVenta> getProductoVentaList() {
        return productoVentaList;
    }

    /**
     *
     * @param productoVentaList
     */
    public void setProductoVentaList(List<ProductoVenta> productoVentaList) {
        this.productoVentaList = productoVentaList;
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
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", costo=" + costo + ", precio=" + precio + ", unidadMedida=" + unidadMedida + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", productoVentaList=" + productoVentaList + ", codigoAdministrador=" + codigoAdministrador + '}';
    }

    
    

}