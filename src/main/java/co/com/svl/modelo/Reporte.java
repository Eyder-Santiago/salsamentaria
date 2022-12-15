/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JHOJAN L
 */
@Entity
@Table(name = "reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r"),
    @NamedQuery(name = "Reporte.findByCodigo", query = "SELECT r FROM Reporte r WHERE r.codigo = :codigo"),
  })
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_generacion")
    @Temporal(TemporalType.DATE)
    private Date fechaGeneracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @Column(name = "precio_total_ventas")
    private long precioTotalVentas;
    @Column(name = "costo_total_ventas")
    private long costoTotalVentas;
    @Column(name = "ganancia_total_ventas")
    private long gananciaTotalVentas;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reporte")
    private List<ReporteVenta> reporteVentaList;

    /**
     *
     */
    public Reporte() {
    }

    /**
     *
     * @param codigo
     */
    public Reporte(Long codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param fechaGeneracion
     * @param desde
     * @param hasta
     */
    public Reporte(Date fechaGeneracion, Date desde, Date hasta) {
        this.fechaGeneracion = fechaGeneracion;
        this.desde = desde;
        this.hasta = hasta;
    }

    /**
     *
     * @param fechaGeneracion
     * @param desde
     * @param hasta
     * @param precioTotalVentas
     * @param costoTotalVentas
     * @param gananciaTotalVentas
     */
    public Reporte(Date fechaGeneracion, Date desde, Date hasta, long precioTotalVentas, long costoTotalVentas, long gananciaTotalVentas) {
        this.fechaGeneracion = fechaGeneracion;
        this.desde = desde;
        this.hasta = hasta;
        this.precioTotalVentas = precioTotalVentas;
        this.costoTotalVentas = costoTotalVentas;
        this.gananciaTotalVentas = gananciaTotalVentas;
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
    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    /**
     *
     * @param fechaGeneracion
     */
    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    /**
     *
     * @return
     */
    public Date getDesde() {
        return desde;
    }

    /**
     *
     * @param desde
     */
    public void setDesde(Date desde) {
        this.desde = desde;
    }

    /**
     *
     * @return
     */
    public Date getHasta() {
        return hasta;
    }

    /**
     *
     * @param hasta
     */
    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    /**
     *
     * @return
     */
    public long getPrecioTotalVentas() {
        return precioTotalVentas;
    }

    /**
     *
     * @param precioTotalVentas
     */
    public void setPrecioTotalVentas(long precioTotalVentas) {
        this.precioTotalVentas = precioTotalVentas;
    }

    /**
     *
     * @return
     */
    public long getCostoTotalVentas() {
        return costoTotalVentas;
    }

    /**
     *
     * @param costoTotalVentas
     */
    public void setCostoTotalVentas(long costoTotalVentas) {
        this.costoTotalVentas = costoTotalVentas;
    }

    /**
     *
     * @return
     */
    public long getGananciaTotalVentas() {
        return gananciaTotalVentas;
    }

    /**
     *
     * @param gananciaTotalVentas
     */
    public void setGananciaTotalVentas(long gananciaTotalVentas) {
        this.gananciaTotalVentas = gananciaTotalVentas;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<ReporteVenta> getReporteVentaList() {
        return reporteVentaList;
    }

    /**
     *
     * @param reporteVentaList
     */
    public void setReporteVentaList(List<ReporteVenta> reporteVentaList) {
        this.reporteVentaList = reporteVentaList;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
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
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
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
        return "Reporte{" + "codigo=" + codigo + ", fechaGeneracion=" + fechaGeneracion + ", desde=" + desde + ", hasta=" + hasta + ", precioTotalVentas=" + precioTotalVentas + ", costoTotalVentas=" + costoTotalVentas +", gananciaTotalVentas=" + gananciaTotalVentas + '}';
    }

    

}
