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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author JhojanDS
 * @email jhojanlopez327@gmail.com
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByCodigo", query = "SELECT v FROM Venta v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Venta.findByHora", query = "SELECT v FROM Venta v WHERE v.hora = :hora"),
    @NamedQuery(name = "Venta.findByGananciaVenta", query = "SELECT v FROM Venta v WHERE v.gananciaVenta = :gananciaVenta"),
    @NamedQuery(name = "Venta.findByTotalVenta", query = "SELECT v FROM Venta v WHERE v.totalVenta = :totalVenta")
})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ganancia_venta")
    private Long gananciaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_venta")
    private Long totalVenta;
    @Column(name = "valor_pago")
    private Long valorPago;
    @Column(name = "cambio")
    private Long cambio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<ProductoVenta> productoVentaList;
    @JoinColumn(name = "codigo_administrador", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Administrador codigoAdministrador;
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo")
    @ManyToOne
    private Cliente codigoCliente;
    @JoinColumn(name = "codigo_empleado", referencedColumnName = "codigo")
    @ManyToOne
    private Empleado codigoEmpleado;

    /**
     *
     */
    public Venta() {
    }

    /**
     *
     * @param codigo
     */
    public Venta(Long codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param codigo
     * @param fecha
     * @param hora
     * @param gananciaVenta
     * @param totalVenta
     * @param valorPago
     * @param cambio
     */
    public Venta(Long codigo, Date fecha, Date hora, long gananciaVenta, long totalVenta, long valorPago, long cambio) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.gananciaVenta = gananciaVenta;
        this.totalVenta = totalVenta;
        this.valorPago = valorPago;
        this.cambio = cambio;
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
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public Date getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(Date hora) {
        this.hora = hora;
    }

    /**
     *
     * @return
     */
    public double getGananciaVenta() {
        return gananciaVenta;
    }

    /**
     *
     * @param gananciaVenta
     */
    public void setGananciaVenta(long gananciaVenta) {
        this.gananciaVenta = gananciaVenta;
    }

    /**
     *
     * @return
     */
    public double getTotalVenta() {
        return totalVenta;
    }

    /**
     *
     * @param totalVenta
     */
    public void setTotalVenta(long totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Long getValorPago() {
        return valorPago;
    }

    public void setValorPago(Long valorPago) {
        this.valorPago = valorPago;
    }

    public Long getCambio() {
        return cambio;
    }

    public void setCambio(Long cambio) {
        this.cambio = cambio;
    }
    
    

    /**
     *
     * @return
     */
    @XmlTransient
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
    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    /**
     *
     * @param codigoCliente
     */
    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     *
     * @return
     */
    public Empleado getCodigoEmpleado() {
        return codigoEmpleado;
    }

    /**
     *
     * @param codigoEmpleado
     */
    public void setCodigoEmpleado(Empleado codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
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
        return "Venta{" + "codigo=" + codigo + ", fecha=" + fecha + ", hora=" + hora + ", gananciaVenta=" + gananciaVenta + ", valor pago= " + valorPago + ", cambio= " + cambio +
                ", totalVenta=" + totalVenta + ", codigoAdministrador=" + codigoAdministrador + ", codigoCliente=" + codigoCliente + ", codigoEmpleado=" + codigoEmpleado + '}';
    }

  
}
