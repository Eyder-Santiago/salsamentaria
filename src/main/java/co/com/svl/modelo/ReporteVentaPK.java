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
 * @author JHOJAN L
 */
@Embeddable
public class ReporteVentaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_reporte")
    private long codigoReporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_venta")
    private long codigoVenta;

    /**
     *
     */
    public ReporteVentaPK() {
    }

    /**
     *
     * @param codigoReporte
     */
    public ReporteVentaPK(long codigoReporte) {
        this.codigoReporte = codigoReporte;
    }

    /**
     *
     * @param codigoReporte
     * @param codigoVenta
     */
    public ReporteVentaPK(long codigoReporte, long codigoVenta) {
        this.codigoReporte = codigoReporte;
        this.codigoVenta = codigoVenta;
    }
    
    /**
     *
     * @return
     */
    public long getCodigoReporte() {
        return codigoReporte;
    }

    /**
     *
     * @param codigoReporte
     */
    public void setCodigoReporte(long codigoReporte) {
        this.codigoReporte = codigoReporte;
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
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoReporte;
        hash += (int) codigoVenta;
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
        if (!(object instanceof ReporteVentaPK)) {
            return false;
        }
        ReporteVentaPK other = (ReporteVentaPK) object;
        if (this.codigoReporte != other.codigoReporte) {
            return false;
        }
        if (this.codigoVenta != other.codigoVenta) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "co.com.svl.modelo.ReporteVentaPK[ codigoReporte=" + codigoReporte + ", codigoVenta=" + codigoVenta + " ]";
    }
    
}
