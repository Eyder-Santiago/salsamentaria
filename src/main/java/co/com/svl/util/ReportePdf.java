/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.util;

import co.com.svl.modelo.Reporte;
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
public class ReportePdf {

    private Document documento = new Document(PageSize.A4);
    private Reporte reporte;

    public ReportePdf(Reporte reporte) {
        super();
        this.reporte = reporte;
    }

    public void exportar(HttpServletResponse response) throws IOException {
        PdfWriter.getInstance(documento, response.getOutputStream());

        Font fuenteTituloReporte = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuenteTituloReporte.setColor(Color.RED);
        fuenteTituloReporte.setSize(18);

        Font fuenteTituloVentas = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuenteTituloVentas.setColor(Color.BLACK);
        fuenteTituloVentas.setSize(18);

        var tituloReporte = new Paragraph("Reporte Salsamentaria L&M"
                + "\n\n", fuenteTituloReporte);
        tituloReporte.setAlignment(Paragraph.ALIGN_CENTER);
        var informacionReporte = new Paragraph();

        var tituloVentas = new Paragraph("Lista de facturas"
                + "\n", fuenteTituloVentas);
        tituloVentas.setAlignment(Paragraph.ALIGN_LEFT);
        var informacionCentro = new Paragraph();
        var informacionFinal = new Paragraph();

        PdfPTable tabla = new PdfPTable(5);

        documento.open();

        datosReporte(informacionReporte);

        tabla.setWidthPercentage(90);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[]{6f, 1.7f, 1.7f, 2.3f, 2.1f});
        tabla.setWidthPercentage(100);

        Image img = Image.getInstance("src/main/resources/static/img/logo.png");
        img.scaleAbsolute(120, 100);
        img.setAlignment(Paragraph.ALIGN_CENTER);

        documento.add(tituloReporte);
        documento.add(img);
        documento.add(informacionReporte);
        documento.add(tituloVentas);

        cabeceraTabla(tabla);

        for (int i = 0; i < reporte.getReporteVentaList().size(); i++) {
            informacionCentro.clear();
            informacionFinal.clear();

            datosTabla(reporte.getReporteVentaList().get(i).getVenta(), tabla, informacionCentro, informacionFinal);
            tabla.deleteBodyRows();
            cabeceraTabla(tabla);
        }

        documento.close();

    }

    private void datosReporte(Paragraph informacionReporte) {
        informacionReporte.add(
                 "\n\n\nFecha de generacion: " + reporte.getFechaGeneracion().toString()
                + "\nFecha de inicio: " + reporte.getDesde() + ",   Fecha final: " + reporte.getHasta() + "\n"
                + "\n\nCantidad de ventas: " + (reporte.getReporteVentaList().size())
                + "\n Precio de venta total: $" + reporte.getPrecioTotalVentas()
                + "\n Costo total: $" + reporte.getCostoTotalVentas()
                + "\n Ganancia total: $" + reporte.getGananciaTotalVentas() + "\n\n\n\n"
        );

        informacionReporte.setAlignment(Paragraph.ALIGN_JUSTIFIED);

    }

    private void datosTabla(Venta venta, PdfPTable tabla, Paragraph informacionCentro, Paragraph informacionFinal) {

        var pv = venta.getProductoVentaList();

        informacionCentro.add("\n Número de factura: " + venta.getCodigo());
        informacionCentro.add("\n Fecha:  " + venta.getFecha() + " / " + venta.getHora());

        if (venta.getCodigoEmpleado() == null) {
            log.info("vendedor: " + venta.getCodigoAdministrador().getNombre());
            informacionCentro.add("\n Vendedor: " + venta.getCodigoAdministrador().getNombre());

        } else {
            log.info("vendedor: " + venta.getCodigoEmpleado().getNombre());
            informacionCentro.add("\n Vendedor: " + venta.getCodigoEmpleado().getNombre());

        }

        for (int i = 0; i < pv.size(); i++) {
            tabla.addCell("" + pv.get(i).getProducto().getNombre());
            tabla.addCell("$" + pv.get(i).getPrecioVenta());
            tabla.addCell("$" + pv.get(i).getCostoVenta());
            tabla.addCell("" + pv.get(i).getCantidadVendida());
            tabla.addCell("$" + pv.get(i).getSubtotal());
        }
        informacionFinal.add("\n Total venta: $" + venta.getTotalVenta() + ""
                + "\n Ganancia de venta: $" + venta.getGananciaVenta()
                +"\n\n Valor de pago: $" + venta.getValorPago()
                +"\n Cambio: $" + venta.getCambio()+"\n\n"
                + "______________________________________________________________________________\n\n");
       

        documento.add(informacionCentro);
        documento.add(tabla);
        documento.add(informacionFinal);

    }

    private void cabeceraTabla(PdfPTable tabla) {

        PdfPCell celda = new PdfPCell();

        celda.setPadding(4);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.black);

        celda.setPhrase(new Phrase("Item", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Precio", fuente));
        tabla.addCell(celda);
        
        celda.setPhrase(new Phrase("Costo", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Cantidad", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Subtotal", fuente));
        tabla.addCell(celda);

        log.info("agregando headers: tam tabla= " + tabla.getRow(0));

    }
}
