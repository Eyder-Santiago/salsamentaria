/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JhojanDS
 * @email jhojanlopez327@gmail.com
 */
@Entity
@Table(name = "producto_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoVenta.findAll", query = "SELECT p FROM ProductoVenta p"),
    @NamedQuery(name = "ProductoVenta.findByCodigoVenta", query = "SELECT p FROM ProductoVenta p WHERE p.productoVentaPK.codigoVenta = :codigoVenta"),
    @NamedQuery(name = "ProductoVenta.findByCodigoProducto", query = "SELECT p FROM ProductoVenta p WHERE p.productoVentaPK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "ProductoVenta.findByCantidadVendida", query = "SELECT p FROM ProductoVenta p WHERE p.cantidadVendida = :cantidadVendida")})
public class ProductoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoVentaPK productoVentaPK;
    @Column(name = "precio_venta")
    private long precioVenta;
    @Column(name = "costo_venta")
    private long costoVenta;
    @NotNull
    @Column(name = "cantidad_vendida")
    private double cantidadVendida;
    @Column(name = "subtotal")
    private long subtotal;
    @Column(name = "ganancia")
    private long ganancia;
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "codigo_venta", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Venta venta;

    /**
     *
     */
    public ProductoVenta() {
    }

    /**
     *
     * @param productoVentaPK
     */
    public ProductoVenta(ProductoVentaPK productoVentaPK) {
        this.productoVentaPK = productoVentaPK;
    }

    /**
     *
     * @param productoVentaPK
     * @param cantidadVendida
     */
    public ProductoVenta(ProductoVentaPK productoVentaPK, long cantidadVendida) {
        this.productoVentaPK = productoVentaPK;
        this.cantidadVendida = cantidadVendida;
    }

    /**
     *
     * @param codigoVenta
     * @param codigoProducto
     */
    public ProductoVenta(long codigoVenta, long codigoProducto) {
        this.productoVentaPK = new ProductoVentaPK(codigoVenta, codigoProducto);
    }

    /**
     *
     * @return
     */
    public ProductoVentaPK getProductoVentaPK() {
        return productoVentaPK;
    }

    /**
     *
     * @param productoVentaPK
     */
    public void setProductoVentaPK(ProductoVentaPK productoVentaPK) {
        this.productoVentaPK = productoVentaPK;
    }

    /**
     *
     * @return
     */
    public long getPrecioVenta() {
        return precioVenta;
    }

    /**
     *
     * @param precioVenta
     */
    public void setPrecioVenta(long precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     *
     * @return
     */
    public long getCostoVenta() {
        return costoVenta;
    }

    /**
     *
     * @param costoVenta
     */
    public void setCostoVenta(long costoVenta) {
        this.costoVenta = costoVenta;
    }

    /**
     *
     * @return
     */
    public double getCantidadVendida() {
        return cantidadVendida;
    }

    /**
     *
     * @param cantidadVendida
     */
    public void setCantidadVendida(double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    /**
     *
     * @return
     */
    public long getSubtotal() {
        return subtotal;
    }

    /**
     *
     * @param subtotal
     */
    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }

    /**
     *
     * @return
     */
    public long getGanancia() {
        return ganancia;
    }

    /**
     *
     * @param ganancia
     */
    public void setGanancia(long ganancia) {
        this.ganancia = ganancia;
    }

    /**
     *
     * @return
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     *
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     *
     * @return
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     *
     * @param venta
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoVentaPK != null ? productoVentaPK.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        boolean resultado = true;
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoVenta)) {
            resultado = false;
        }
        ProductoVenta other = (ProductoVenta) object;
        if ((this.productoVentaPK == null && other.productoVentaPK != null) || (this.productoVentaPK != null && !this.productoVentaPK.equals(other.productoVentaPK))) {
            resultado = false;
        }
        return resultado;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ProductoVenta{" + "productoVentaPK=" + productoVentaPK + ", precioVenta=" + precioVenta + ", costoVenta=" + costoVenta + ", cantidadVendida=" + cantidadVendida + ", subtotal=" + subtotal + ", ganancia=" + ganancia +'}';
    }

    

}
