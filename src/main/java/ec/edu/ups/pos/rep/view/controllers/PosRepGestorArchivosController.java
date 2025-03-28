package ec.edu.ups.pos.rep.view.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepReportesSistemaFacade;

@Named("posRepGestorArchivosController")
@ViewScoped
public class PosRepGestorArchivosController extends AbstractController<RepReportesSistema> {

	private RepReportesSistema newReporteSistema;

	private List<String> systemOptions;

	private List<String> moduleOptions;

	private final List<String> formatOptions;

	private List<Map<String, Object>> systemApplications;

	@Inject
	private RepReportesSistemaFacade repReportesSistemaFacade;

	public PosRepGestorArchivosController() {

		super(RepReportesSistema.class);

		this.formatOptions = new ArrayList<>();
		this.formatOptions.add("PDF");
		this.formatOptions.add("PDF - EXCEL");
		this.formatOptions.add("EXCEL");
		this.newReporteSistema = new RepReportesSistema();

	}

	public RepReportesSistema getNewReporteSistema() {
		return this.newReporteSistema;
	}

	public void setNewReporteSistema(RepReportesSistema newReporteSistema) {
		this.newReporteSistema = newReporteSistema;
	}

	public List<String> getSystemOptions() {
		return this.systemOptions;
	}

	public List<String> getModuleOptions() {
		return this.moduleOptions;
	}

	public List<String> getFormatOptions() {
		return this.formatOptions;
	}

	public void setSystemOptions(List<String> systemOptions) {
		this.systemOptions = systemOptions;
	}

	public void setModuleOptions(List<String> moduleOptions) {
		this.moduleOptions = moduleOptions;
	}

	public void setSystemApplications(List<Map<String, Object>> systemApplications) {
		this.systemApplications = systemApplications;
	}

	@Override
	public RepReportesSistema prepareCreate(ActionEvent event) {
		this.systemOptions = new ArrayList<>();
		this.newReporteSistema = new RepReportesSistema();
		setSystemApplications(this.repReportesSistemaFacade.getSystem());
		for (Map<String, Object> dic : this.systemApplications) {
			String res_sistema = dic.get("res_sistema").toString();
			this.systemOptions.add(res_sistema);
		}
		setModuleOptions(this.repReportesSistemaFacade.getModules());
		PrimeFaces.current().ajax().update("PosRepCreateForm:posRepOpcionesSistemas");
		PrimeFaces.current().ajax().update("PosRepCreateForm:posRepOpcionesModulos");
		return super.prepareCreate(event);
	}

	public boolean isRenderedForExcel() {
		String formato = this.newReporteSistema.getResFormato();
		return ("EXCEL".equalsIgnoreCase(formato) || "PDF - EXCEL".equalsIgnoreCase(formato))
				&& this.newReporteSistema.getResArchivoJasperExcel() == null;
	}

	public boolean isRenderedForPdf() {
		String formato = this.newReporteSistema.getResFormato();
		return ("PDF".equalsIgnoreCase(formato) || "PDF - EXCEL".equalsIgnoreCase(formato))
				&& this.newReporteSistema.getResArchivoJasperPd() == null;
	}

	public void deleteFileExcel() {
		this.newReporteSistema.setResArchivoExcel(null);
		this.newReporteSistema.setResArchivoJasperExcel(null);
		PrimeFaces.current().ajax().update("PosRepCreateForm:jasperUploadPanelExcel");
		PrimeFaces.current().ajax().update("PosRepCreateForm:panelDataTableExcel");
		PrimeFaces.current().ajax().update("PosRepEditForm:jasperUploadPanelExcel");
		PrimeFaces.current().ajax().update("PosRepEditForm:panelDataTableExcel");
	}

	public void deleteFilePdf() {
		this.newReporteSistema.setResArchivo(null);
		this.newReporteSistema.setResArchivoJasperPd(null);
		PrimeFaces.current().ajax().update("PosRepCreateForm:jasperUploadPanelPdf");
		PrimeFaces.current().ajax().update("PosRepCreateForm:panelDataTablePdf");
		PrimeFaces.current().ajax().update("PosRepCreateForm:dataTablePdf");
		PrimeFaces.current().ajax().update("PosRepEditForm:panelDataTablePdf");
		PrimeFaces.current().ajax().update("PosRepEditForm:dataTablePdf");

	}

	public void cleanFiles() {
		if (this.newReporteSistema.getResArchivoExcel() != null) {
			deleteFileExcel();
		}
		if (this.newReporteSistema.getResArchivo() != null) {
			deleteFilePdf();
		}
	}

	public String findApplication(String resSystem) {
		for (Map<String, Object> dic : this.systemApplications) {
			if (resSystem.equalsIgnoreCase((String) dic.get("res_sistema"))) {
				Object application = dic.get("res_aplicacion");
				return (application != null) ? application.toString() : null;
			}
		}
		return null;
	}

	public void handleFileUpload(FileUploadEvent event) throws IOException {
		UploadedFile file = event.getFile();

		if (this.newReporteSistema.getResFormato().equalsIgnoreCase("EXCEL") || (file.getFileName().endsWith("X.jasper")
				&& this.newReporteSistema.getResFormato().equalsIgnoreCase("PDF - EXCEL"))) {
			this.newReporteSistema.setResArchivoExcel(file.getFileName());
			this.newReporteSistema.setResArchivoJasperExcel(file.getContent());
			PrimeFaces.current().ajax().update("PosRepCreateForm:jasperUploadPanelExcel");
			PrimeFaces.current().ajax().update("PosRepCreateForm:panelDataTableExcel");
			PrimeFaces.current().ajax().update("PosRepEditForm:jasperUploadPanelExcel");
			PrimeFaces.current().ajax().update("PosRepEditForm:panelDataTableExcel");
		}
		else if (this.newReporteSistema.getResFormato().equalsIgnoreCase("PDF")
				|| (file.getFileName().endsWith(".jasper")
						&& this.newReporteSistema.getResFormato().equalsIgnoreCase("PDF - EXCEL"))) {
			this.newReporteSistema.setResArchivo(file.getFileName());
			this.newReporteSistema.setResArchivoJasperPd(file.getContent());
			PrimeFaces.current().ajax().update("PosRepCreateForm:jasperUploadPanelPdf");
			PrimeFaces.current().ajax().update("PosRepCreateForm:panelDataTablePdf");
			PrimeFaces.current().ajax().update("PosRepEditForm:jasperUploadPanelPdf");
			PrimeFaces.current().ajax().update("PosRepEditForm:panelDataTablePdf");
		}
	}

	@Override
	public void saveNew(ActionEvent event) {
		this.newReporteSistema.setResAplicacion(findApplication(this.newReporteSistema.getResSistema()));
		this.setSelectedToEdit(this.newReporteSistema);
		super.saveNew(event);
		if (!Faces.isValidationFailed()) {
			PrimeFaces.current().ajax().update("PosReportesForm:messages");
			PrimeFaces.current().ajax().update("PosReportesForm:PosReportesSistemaDataTable");
		}
	}

	@Override
	public String prepareEdit(ActionEvent event) {
		setNewReporteSistema(getSelected());
		this.systemOptions = new ArrayList<>();
		setSystemApplications(this.repReportesSistemaFacade.getSystem());
		for (Map<String, Object> dic : this.systemApplications) {
			String res_sistema = dic.get("res_sistema").toString();
			this.systemOptions.add(res_sistema);
		}
		setModuleOptions(this.repReportesSistemaFacade.getModules());
		PrimeFaces.current().ajax().update("PosRepEditForm:posRepOpcionesSistemas");
		return super.prepareEdit(event);
	}

	@Override
	public void save(ActionEvent event) {
		setSelectedToEdit(this.newReporteSistema);
		super.save(event);
		if (!Faces.isValidationFailed()) {
			PrimeFaces.current().ajax().update("PosReportesForm:messages");
			PrimeFaces.current().ajax().update("PosReportesForm:PosReportesSistemaDataTable");
		}
	}

	@Override
	public void delete(ActionEvent event) {
		super.delete(event);
		if (!Faces.isValidationFailed()) {
			PrimeFaces.current().ajax().update("PosReportesForm:messages");
			PrimeFaces.current().ajax().update("PosReportesForm:PosReportesSistemaDataTable");
		}
	}

	public StreamedContent getArchivoJasper(String tipo) {
		try {
			if ("pdf".equalsIgnoreCase(tipo)) {
				if (this.getSelected() != null && this.getSelected().getResArchivoJasperPd() != null) {
					InputStream stream = new ByteArrayInputStream(this.getSelected().getResArchivoJasperPd());
					return DefaultStreamedContent.builder()
						.name(this.getSelected().getResReporte() + ".jasper")
						.contentType("application/x-java-serialized-object")
						.stream(() -> stream)
						.build();
				}
			}
			else {
				if (this.getSelected() != null && this.getSelected().getResArchivoJasperExcel() != null) {
					InputStream stream = new ByteArrayInputStream(this.getSelected().getResArchivoJasperExcel());
					return DefaultStreamedContent.builder()
						.name(this.getSelected().getResReporte() + "_X.jasper")
						.contentType("application/octet-stream")
						.stream(() -> stream)
						.build();
				}

			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

}
