/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.util;

import co.com.svl.modelo.Venta;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Juan Turriago
 */
@Slf4j
public class VentaPdf {

    private final Venta venta;

    /**
     *
     * @param venta
     */
    public VentaPdf(Venta venta) {
        super();
        this.venta = venta;
    }

    /**
     *
     * @param response
     * @throws IOException
     */
    public void exportar(HttpServletResponse response) throws IOException {
        try (Document documento = new Document(PageSize.NOTE)) {
            PdfWriter.getInstance(documento, response.getOutputStream());
            
            Paragraph informacionIzquierda = new Paragraph();
            Paragraph informacionCentro = new Paragraph();
            Paragraph informacionTotal = new Paragraph();
            Paragraph informacionFinal = new Paragraph();
            
            PdfPTable tabla = new PdfPTable(4);
            
            documento.open();
            
            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            fuenteTitulo.setColor(Color.RED);
            fuenteTitulo.setSize(18);
            
            
            
            Font fuenteInformacion = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            fuenteTitulo.setColor(Color.RED);
            fuenteTitulo.setSize(18);
            
            tabla.setWidthPercentage(90);
            tabla.setSpacingBefore(15);
            tabla.setWidths(new float[]{3.5f, 1.3f, 1.7f, 1.9f});
            tabla.setWidthPercentage(100);
         
            
            cabeceraTabla(tabla);
            datosTabla(tabla, informacionCentro, informacionIzquierda, informacionTotal, informacionFinal);
            
            Image jpg = Image.getInstance("src/main/resources/static/img/logo.png");
            jpg.scaleAbsolute(120, 100);
            jpg.setAlignment(Paragraph.ALIGN_CENTER);
            
            documento.add(jpg);
            
            documento.add(informacionCentro);
            documento.add(informacionIzquierda);
            documento.add(tabla);
            documento.add(informacionTotal);
            documento.add(informacionFinal);
        }

    }

    private void cabeceraTabla(PdfPTable tabla) {

        PdfPCell celda = new PdfPCell();

//        celda.setBackgroundColor(Color.RED);
        celda.setPadding(4);
        celda.setBorderColorBottom(Color.WHITE);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.black);

        celda.setPhrase(new Phrase("Item", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Cantidad", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Valor", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Subtotal", fuente));
        tabla.addCell(celda);

        log.info("agregando headers: tam tabla= " + tabla.getRow(0));

    }

    private void datosTabla(PdfPTable tabla, Paragraph informacionCentro, Paragraph informacionIzquierda, Paragraph informacionTotal, Paragraph informacionFinal) {

        var pv = venta.getProductoVentaList();
        //cod 19 cod 1
//        pv.get(0).

//        log.info("\n------------------------obtenemos datos negocio--------------------------");
//        log.info("\n nombre negocio: " + venta.getCodigoAdministrador().getNombreNegocio()
//                + "\n nit: " + venta.getCodigoAdministrador().getNitNegocio()
//                + "\n direccion: " + venta.getCodigoAdministrador().getDireccion()
//                + "\n telefono: " + venta.getCodigoAdministrador().getTelefono());
//
//        log.info("\n------------------------obtenemos vendedor--------------------------");
//        if (venta.getCodigoEmpleado() == null) {
//            log.info("vendedor: " + venta.getCodigoAdministrador().getNombre());
//        } else {
//            log.info("vendedor: " + venta.getCodigoEmpleado().getNombre());
//        }
//
//        log.info("\n------------------------obtenemos datos de productos--------------------------");
//        log.info("\n Codigo" + pv.get(0).getProducto().getCodigo()
//                + "\n nombre=" + pv.get(0).getProducto().getNombre()
//                + "\n precio venta=" + pv.get(0).getPrecioVenta()//por unidad
//                + "\n costo venta=" + pv.get(0).getCostoVenta()//por unidad
//                + "\n cantidad=" + pv.get(0).getCantidadVendida()//cantidad
//                + "\n subtotal=" + pv.get(0).getSubtotal()
//                + "\n ganancia=" + pv.get(0).getGanancia());
        informacionCentro.add(venta.getCodigoAdministrador().getNombreNegocio());
        informacionCentro.setAlignment(Paragraph.ALIGN_CENTER);

        informacionCentro.add("\n ");
        informacionCentro.setAlignment(Paragraph.ALIGN_CENTER);

        informacionCentro.add("\n NIT: " + venta.getCodigoAdministrador().getNitNegocio());
        informacionCentro.setAlignment(Paragraph.ALIGN_CENTER);

        informacionCentro.add("\n Dirección: " + venta.getCodigoAdministrador().getDireccion());
        informacionCentro.setAlignment(Paragraph.ALIGN_CENTER);

        informacionCentro.add("\n Teléfono: " + venta.getCodigoAdministrador().getTelefono());
        informacionCentro.setAlignment(Paragraph.ALIGN_CENTER);

        if (venta.getCodigoEmpleado() == null) {

            log.info("vendedor: " + venta.getCodigoAdministrador().getNombre());

            informacionCentro.add("\n Vendedor: " + venta.getCodigoAdministrador().getNombre());
            informacionCentro.setAlignment(Paragraph.ALIGN_CENTER);

            informacionCentro.add("\n ");
            informacionCentro.setAlignment(Paragraph.ALIGN_CENTER);

        } else {
            log.info("vendedor: " + venta.getCodigoEmpleado().getNombre());

            informacionCentro.add("\n Vendedor: " + venta.getCodigoEmpleado().getNombre());
            informacionCentro.setAlignment(Paragraph.ALIGN_CENTER);

            informacionCentro.add("\n ");
            informacionCentro.setAlignment(Paragraph.ALIGN_CENTER);
        }

        informacionIzquierda.add("\n Número de factura: " + venta.getCodigo());
        informacionIzquierda.setAlignment(Paragraph.ALIGN_LEFT);

        informacionIzquierda.add("\n Fecha:  " + venta.getFecha() + " / " + venta.getHora());
        informacionIzquierda.setAlignment(Paragraph.ALIGN_LEFT);

        for (int i=0; i<pv.size();i++) {
            tabla.addCell("" + pv.get(i).getProducto().getNombre());
            tabla.addCell("" + pv.get(i).getCantidadVendida());
            tabla.addCell("$" + pv.get(i).getPrecioVenta());
            tabla.addCell("$" + pv.get(i).getSubtotal());
        }
        

       
        informacionTotal.add("\n Total : $" + venta.getTotalVenta());
        informacionTotal.setAlignment(Paragraph.ALIGN_LEFT);
        
        informacionTotal.add("\n\n Valor de pago: $" + venta.getValorPago());
        informacionTotal.setAlignment(Paragraph.ALIGN_LEFT);

        informacionTotal.add("\n Cambio: $" + venta.getCambio());
        informacionTotal.setAlignment(Paragraph.ALIGN_LEFT);
        
        informacionFinal.add("\n ");
        informacionFinal.setAlignment(Paragraph.ALIGN_CENTER);

        informacionFinal.add("\n ¡Muchas gracias por su compra!");
        informacionFinal.setAlignment(Paragraph.ALIGN_CENTER);

        informacionFinal.add("\n Sistema de venta Lympus");
        informacionFinal.setAlignment(Paragraph.ALIGN_CENTER);

        informacionFinal.add("\n Universidad del Valle");
        informacionFinal.setAlignment(Paragraph.ALIGN_CENTER);
    }

}
