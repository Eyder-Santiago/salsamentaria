
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.modelo;

import java.text.DecimalFormat;

/**
 *
 * @author JhojanDS
 * @email jhojanlopez327@gmail.com
 */
public class ProductoListado extends Producto {
    //producto el cual estara en una lista de la venta, la cual tendra una cantidad a vender y subtotal
    //heredando todos los atributos de un producto

    private long gananciaProducto;
    private double cantidadVenta;
    private double subTotal;

    /**
     *
     */
    public ProductoListado() {
        super();
    }

    /**
     *
     * @param cantidadVenta
     * @param codigo
     * @param nombre
     * @param precio
     * @param costo
     * @param unidadMedida
     */
    public ProductoListado(double cantidadVenta, Long codigo, String nombre,
            long precio, long costo, short unidadMedida) {

        super(codigo, nombre, precio , costo, unidadMedida);
        this.cantidadVenta = cantidadVenta;

    }

    public ProductoListado(Long codigo) {
        super(codigo);
    }
    
    

    /**
     *
     * @return
     */
    public double getCantidadVenta() {
        return cantidadVenta;
    }

    /**
     *
     * @param cantidadVenta
     */
    public void setCantidadVenta(double cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    /**
     *
     * @return
     */
    public double getSubTotal() {
        var df = new DecimalFormat("#.00");
        this.subTotal = (this.getPrecio() * this.getCantidadVenta());
        return Double.parseDouble(df.format(this.subTotal).replace(",", "."));
    }

    /**
     *
     * @param subTotal
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     *
     * @return
     */
    public long getGananciaProducto() {
        this.gananciaProducto = (long) (this.cantidadVenta*(this.getPrecio() - this.getCosto()));
        return gananciaProducto;
    }

    /**
     *
     * @param gananciaVenta
     */
    public void setGananciaProducto(long gananciaVenta) {
        this.gananciaProducto = gananciaVenta;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ProductoListado{" + " Codigo= " + this.getCodigo() + ", nombre= " + this.getNombre()
                + ", costo= " + this.getCosto()+ ", precio= " + this.getPrecio() +" ,U/M= "+this.getUnidadMedida() + 
                ", cantidadVenta=" + cantidadVenta +", ganancia="+ this.getGananciaProducto() +", subTotal="+ this.getSubTotal() + '}';
    }

}
