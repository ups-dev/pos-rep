package ec.edu.ups.pos.rep.view.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.util.jasper.JasperUtils;
import ec.edu.ups.util.jasper.ReportParamBuilder;
import ec.edu.ups.util.jasper.ReportType;

@Named("posReporteController")
@ViewScoped
public class PosReporteController implements Serializable {

	@Inject
	PosRepResultadoController posRepResultadoController;

	private OrgEstructura orgEstructura;

	/**
	 * Generar reporte.
	 * @param reportType tipo de archivo
	 * @param fileExtension extensión del archivo
	 * @param nombreArchivo nombre del archivo con el que saldrá el reporte
	 * @param nombreReporte nombre del archivo compilado del reporte
	 * @param params parámetros de reporte
	 * @return .
	 */

	public StreamedContent generarStreamedReporte(ReportType reportType, String fileExtension, String nombreArchivo,
			String nombreReporte, ReportParamBuilder params) {
		Connection connection = null;

		try {
			// Obtiene conexión a datasource de Base de Datos
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup(PosRepConstants.DATASOURCE_NAME);
			connection = dataSource.getConnection();

			// Verificación de conexión
			if (connection == null || connection.isClosed()) {
				Messages.addGlobalError("Error: No se pudo establecer la conexión a la base de datos.");
				Faces.validationFailed();
				return null;
			}

			if (fileExtension.equals(".xlsx")) {
				// Configuración específica para el formato XLSX
				SimpleXlsxReportConfiguration simpleXlsxReportConfiguration = new SimpleXlsxReportConfiguration();
				simpleXlsxReportConfiguration.setIgnoreCellBorder(false);
				simpleXlsxReportConfiguration.setOnePagePerSheet(false);
				simpleXlsxReportConfiguration.setWhitePageBackground(false);
				simpleXlsxReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
				simpleXlsxReportConfiguration.setRemoveEmptySpaceBetweenColumns(true);
				simpleXlsxReportConfiguration.setIgnorePageMargins(false);
				params.setReportExportConfiguration(simpleXlsxReportConfiguration);

				// Verificación de disponibilidad de clases necesarias para XLSX
				try {
					Class.forName("net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter");
				}
				catch (ClassNotFoundException ex) {
					Messages.addGlobalError(
							"Error: No se encontró la clase JRXlsxExporter necesaria para generar el reporte en XLSX.");
					Faces.validationFailed();
					return null;
				}
			}
			else if (fileExtension.equalsIgnoreCase(".pdf")) {
				// Verificación de disponibilidad de clases necesarias para PDF
				try {
					Class.forName("net.sf.jasperreports.engine.export.JRPdfExporter");
				}
				catch (ClassNotFoundException ex) {
					Messages.addGlobalError(
							"Error: No se encontró la clase JRPdfExporter necesaria para generar el reporte en PDF.");
					Faces.validationFailed();
					return null;
				}
			}

			// Obtiene archivo de reporte
			URL url = Faces.getResource(nombreReporte);
			// System.out.println("Pase de escribir el archivo: " + url);

			// Generación de reporte
			assert url != null;
			byte[] archivoReporte = JasperUtils.generateReport(new File(url.toURI()), reportType, params, connection);
			String nombreFinal = nombreArchivo
					+ DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()).replace("/", "_") + fileExtension;

			// System.out.println("Pase de escribir el archivo: " + nombreFinal);

			// System.out.println("Tamaño archivo : " + archivoReporte.length);

			if ((archivoReporte.length < PosRepConstants.REPORTE_VACIO_PDF && fileExtension.equalsIgnoreCase(".pdf"))
					|| (archivoReporte.length < PosRepConstants.REPORTE_VACIO_XLSX
							&& fileExtension.equalsIgnoreCase(".xlsx"))) {
				// System.out.println("ENTRE A sin resultados " );

				Messages.addGlobalWarn("No se han obtenido resultados para " + nombreFinal);
				Faces.validationFailed();
			}
			else {

				return DefaultStreamedContent.builder()
					.stream(() -> new ByteArrayInputStream(archivoReporte))
					.contentType(Faces.getMimeType(nombreReporte))
					.name(nombreFinal)
					.contentLength((long) archivoReporte.length)
					.build();
			}
		}
		catch (Exception ex) {
			Messages.addGlobalError("Error al generar el reporte. \n " + ex.getMessage());
			Faces.validationFailed();
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				}
				catch (SQLException ex) {
					// Manejo de excepción al cerrar la conexión
				}
			}
		}

		return null;
	}

	/**
	 * Identifica la entidad estructura que fue seleccionada.
	 * @return estructura identificada.
	 */
	public OrgEstructura identificarEstructura() {
		this.orgEstructura = new OrgEstructura();
		if (this.posRepResultadoController.getOrgEstructuraSede() != null) {
			if (this.posRepResultadoController.getOrgEstructuraCampus() != null) {
				if (this.posRepResultadoController.getOrgEstructuraCarrera() != null) {
					this.orgEstructura = this.posRepResultadoController.getOrgEstructuraCarrera();
				}
				else {
					this.orgEstructura = this.posRepResultadoController.getOrgEstructuraCampus();
				}
			}
			else {
				this.orgEstructura = this.posRepResultadoController.getOrgEstructuraSede();
			}
		}
		else {
			this.orgEstructura.setEstCodigo(PosRepConstants.TODAS_SEDES);
		}
		return this.orgEstructura;
	}

}
