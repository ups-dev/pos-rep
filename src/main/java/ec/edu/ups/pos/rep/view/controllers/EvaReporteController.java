/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.view.controllers;

import ec.edu.ups.org.common.data.entities.OrgEstructura;
import ec.edu.ups.pos.rep.data.utils.EvaRepConstants;
import ec.edu.ups.util.jasper.JasperUtils;
import ec.edu.ups.util.jasper.ReportParamBuilder;
import ec.edu.ups.util.jasper.ReportType;
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

/**
 *
 * @author ups
 */
@Named(value = "evaReporteController")
@ViewScoped
public class EvaReporteController implements Serializable {

    @Inject
    EvaRepResultadoController evaRepResultadoController;

    private OrgEstructura orgEstructura;

 
    /**
     * Generar reporte
     *
     * @param reportType Tipo de archivo
     * @param fileExtension Extensión del archivo
     * @param nombreArchivo Nombre del archivo con el que saldrá el reporte
     * @param nombreReporte Nombre del archivo compilado del reporte
     * @param params Parámetros de reporte
     */
    public void generarReporte(ReportType reportType, String fileExtension, String nombreArchivo, String nombreReporte, ReportParamBuilder params) {
        try {
            //Obtiene conexión a datasource de Base de Datos
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(EvaRepConstants.DATASOURCE_NAME);
            Connection connection = dataSource.getConnection();

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
            System.out.println("nombreReporte " + nombreReporte);
            //Generación de reporte
            byte[] archivoReporte = JasperUtils.generateReport(new File(url.toURI()), reportType,
                    params,
                    connection);

            System.out.println("Reporte " + archivoReporte.length);
            if ((archivoReporte.length < EvaRepConstants.REPORTE_VACIO_PDF && fileExtension.equalsIgnoreCase(".pdf"))
                    || (archivoReporte.length < EvaRepConstants.REPORTE_VACIO_XLSX && fileExtension.equalsIgnoreCase(".xlsx"))) {
                Messages.addGlobalWarn("No se han obtenido resultados para " + nombreArchivo + DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()).replace("/", "_") + fileExtension);
                Faces.validationFailed();
            } else {

                Faces.sendFile(archivoReporte, nombreArchivo + DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()).replace("/", "_") + fileExtension, true);
                System.out.println("Reporte Generado");
            }
            connection.close();
        } catch (IOException ex) {
            Messages.addGlobalError("Error en carga de archivo de reporte. \n " + ex.getMessage());
            Faces.validationFailed();
            //Logger.getLogger(RepAsegPermisosRolesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Messages.addGlobalError("Error en archivo de reporte. \n" + ex.getMessage());
            Faces.validationFailed();
            //Logger.getLogger(RepAsegPermisosRolesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Messages.addGlobalError("Error en busquéda de archivo de reporte. \n" + ex.getMessage());
            Faces.validationFailed();
            //Logger.getLogger(RepAsegPermisosRolesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Messages.addGlobalError("Error en obteción de contexto. \n" + ex.getMessage());
            Faces.validationFailed();
            //Logger.getLogger(RepMenuSeccionRutaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Messages.addGlobalError("Error en conexión a base de datos. \n" + ex.getMessage());
            Faces.validationFailed();
            //Logger.getLogger(RepMenuSeccionRutaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Identifica la entidad Estructura que fue seleccionada
     *
     * @return Estructura identificada
     */
    public OrgEstructura identificarEstructura() {
        orgEstructura = new OrgEstructura();

        if (evaRepResultadoController.getOrgEstructuraSede() != null) {
            if (evaRepResultadoController.getOrgEstructuraCampus() != null) {
                if (evaRepResultadoController.getOrgEstructuraCarrera() != null) {
                    orgEstructura = evaRepResultadoController.getOrgEstructuraCarrera();
                } else {
                    orgEstructura = evaRepResultadoController.getOrgEstructuraCampus();
                }
            } else {
                orgEstructura = evaRepResultadoController.getOrgEstructuraSede();
            }
        } else {
            orgEstructura.setEstCodigo(EvaRepConstants.TODAS_SEDES);
        }        
        return orgEstructura;
    }        
}
