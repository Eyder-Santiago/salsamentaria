/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.svl.controlador;

import co.com.svl.modelo.Reporte;
import co.com.svl.servicio.ReporteService;
import co.com.svl.servicio.VentaService;
import co.com.svl.util.ReportePdf;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JHOJAN L
 */
@Slf4j
@RestController
@RequestMapping()
public class ControladorRestReporte {

    @Autowired
    private ReporteService reporteService;

    @Autowired
    private VentaService ventaService;

    /**
     * @author JHOJAN L
     * @param reporte
     * @param response
     * @throws DocumentException
     * @throws IOException
     */
    @GetMapping(path = "/reportePdf/{codigo}")
    public void exportarListadoVentasPDF(Reporte reporte, HttpServletResponse response) throws DocumentException, IOException {

        log.info("--------------------entre en contrrolador /reportePdf rest");

        if (reporte != null) {

            log.info("llego el reporte" + reporte.getCodigo());

        }

        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "content-Disposition";
        String valor = "attachment; filename=Reporte_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);
        var reporteGenerado = reporteService.encontrarPorCodigo(reporte.getCodigo());

        if (reporteGenerado != null) {
            
         log.info(reporte.toString());
         ReportePdf exporter = new ReportePdf(reporteGenerado);
         exporter.exportar(response);

        }
    }
}
