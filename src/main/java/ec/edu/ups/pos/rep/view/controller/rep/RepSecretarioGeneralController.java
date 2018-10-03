/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.view.controller.rep;

import ec.edu.ups.pos.rep.data.entities.rep.RepSecretarioGeneral;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepSecretarioGeneralFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author UPS
 */
@Named(value = "repSecretarioGeneralController")
@ViewScoped
public class RepSecretarioGeneralController extends AbstractController<RepSecretarioGeneral> {
    
    
    
  @Inject
    private RepSecretarioGeneralFacade repSecretarioGeneralFacade;
   
    private List<RepSecretarioGeneral> listadoSecretariaGeneral; 
    private RepSecretarioGeneral secretarioSeleccionado;
  
     public RepSecretarioGeneralController() {
        super(RepSecretarioGeneral.class);
    }
     
    public void obtenerListSecretariaCert(){
         
         listadoSecretariaGeneral = repSecretarioGeneralFacade.obtieneSecretarioGeneral();
         System.out.println("Cargando Lista Secretaria General");
         
         
    } 

    public List<RepSecretarioGeneral> getListadoSecretariaGeneral() {
        return listadoSecretariaGeneral;
    }

    public void setListadoSecretariaGeneral(List<RepSecretarioGeneral> listadoSecretariaGeneral) {
        this.listadoSecretariaGeneral = listadoSecretariaGeneral;
    }

    public RepSecretarioGeneral getSecretarioSeleccionado() {
        return secretarioSeleccionado;
    }

    public void setSecretarioSeleccionado(RepSecretarioGeneral secretarioSeleccionado) {
        this.secretarioSeleccionado = secretarioSeleccionado;
    }
      
}

