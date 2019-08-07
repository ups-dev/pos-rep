/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.view.controllers;

import ec.edu.ups.org.common.data.entities.OrgEstructura;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.util.jasper.JasperUtils;
import ec.edu.ups.util.jasper.ReportParamBuilder;
import ec.edu.ups.util.jasper.ReportType;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author ups
 */
@Named(value = "posReporteController")
@ViewScoped
public class PosReporteController implements Serializable {

    @Inject
    PosRepResultadoController posRepResultadoController;

    private OrgEstructura orgEstructura;

 
    /**
     * Generar reporte
     *
     * @param reportType Tipo de archivo
     * @param fileExtension Extensión del archivo
     * @param nombreArchivo Nombre del archivo con el que saldrá el reporte
     * @param nombreReporte Nombre del archivo compilado del reporte
     * @param params Parámetros de reporte
     * @return 
     */
      
     public StreamedContent generarStreamedReporte(ReportType reportType, String fileExtension, String nombreArchivo,
    String nombreReporte, ReportParamBuilder params) {
        Connection connection = null;

        try {
            //Obtiene conexión a datasource de Base de Datos
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(PosRepConstants.DATASOURCE_NAME);
            connection = dataSource.getConnection();

            if (fileExtension.equals(".xlsx")) {
                SimpleXlsxReportConfiguration simpleXlsxReportConfiguration = new SimpleXlsxReportConfiguration();
                simpleXlsxReportConfiguration.setIgnoreCellBorder(false);
                simpleXlsxReportConfiguration.setOnePagePerSheet(false);
                simpleXlsxReportConfiguration.setWhitePageBackground(false);
                simpleXlsxReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
                simpleXlsxReportConfiguration.setRemoveEmptySpaceBetweenColumns(true);
                simpleXlsxReportConfiguration.setIgnorePageMargins(false); //ant:true                                
                params.setReportExportConfiguration(simpleXlsxReportConfiguration);
            }

            //Obtiene archivo de reporte
            URL url = Faces.getResource(nombreReporte);

            //Generación de reporte
            byte[] archivoReporte = JasperUtils.generateReport(new File(url.toURI()), reportType,
                    params,
                    connection);
            String nombreFinal = nombreArchivo
                    + DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()).replace("/", "_") + fileExtension;

            if ((archivoReporte.length < PosRepConstants.REPORTE_VACIO_PDF && fileExtension.equalsIgnoreCase(".pdf"))
                    || (archivoReporte.length < PosRepConstants.REPORTE_VACIO_XLSX && fileExtension.equalsIgnoreCase(".xlsx"))) {
                Messages.addGlobalWarn("No se han obtenido resultados para " + nombreFinal);
                Faces.validationFailed();
            } else {
                return new DefaultStreamedContent(
                        new ByteArrayInputStream(archivoReporte),
                        Faces.getMimeType(nombreReporte),
                        nombreFinal,
                        archivoReporte.length
                );
            }
        } catch (Exception ex) {
            Messages.addGlobalError("Error al generar el reporte. \n " + ex.getMessage());
            Faces.validationFailed();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                }
            }
        }

        return null;
    }
    
    /**
     * Identifica la entidad Estructura que fue seleccionada
     *
     * @return Estructura identificada
     */
    public OrgEstructura identificarEstructura() {
        orgEstructura = new OrgEstructura();

        if (posRepResultadoController.getOrgEstructuraSede() != null) {
            if (posRepResultadoController.getOrgEstructuraCampus() != null) {
                if (posRepResultadoController.getOrgEstructuraCarrera() != null) {
                    orgEstructura = posRepResultadoController.getOrgEstructuraCarrera();
                } else {
                    orgEstructura = posRepResultadoController.getOrgEstructuraCampus();
                }
            } else {
                orgEstructura = posRepResultadoController.getOrgEstructuraSede();
            }
        } else {
            orgEstructura.setEstCodigo(PosRepConstants.TODAS_SEDES);
        }        
        return orgEstructura;
    }        
}
