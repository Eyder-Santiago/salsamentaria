/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.com.svl.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JhojanDS
 * @email jhojanlopez327@gmail.com
 */
@Embeddable
public class ProductoVentaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_venta")
    private long codigoVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private long codigoProducto;

    /**
     *
     */
    public ProductoVentaPK() {
    }

    /**
     *
     * @param codigoVenta
     */
    public ProductoVentaPK(long codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    /**
     *
     * @param codigoVenta
     * @param codigoProducto
     */
    public ProductoVentaPK(long codigoVenta, long codigoProducto) {
        this.codigoVenta = codigoVenta;
        this.codigoProducto = codigoProducto;
    }

    /**
     *
     * @return
     */
    public long getCodigoVenta() {
        return codigoVenta;
    }

    /**
     *
     * @param codigoVenta
     */
    public void setCodigoVenta(long codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    /**
     *
     * @return
     */
    public long getCodigoProducto() {
        return codigoProducto;
    }

    /**
     *
     * @param codigoProducto
     */
    public void setCodigoProducto(long codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoVenta;
        hash += (int) codigoProducto;
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        boolean resultado = true;
        if (!(object instanceof ProductoVentaPK)) {
            resultado = false;
        }
        ProductoVentaPK other = (ProductoVentaPK) object;
        if (this.codigoVenta != other.codigoVenta) {
            resultado = false;
        }
        if (this.codigoProducto != other.codigoProducto) {
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
        return "ProductoVentaPK{" + "codigoVenta=" + codigoVenta + ", codigoProducto=" + codigoProducto + '}';
    }

   

}
