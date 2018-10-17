/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.view.controller.rep;

import ec.edu.ups.pos.rep.data.entities.rep.RepNumeroCertificado;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepNumeroCertificadoFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import javax.inject.Inject;

/**
 *
 * @author UPS
 */
public class RepNumeroCertificadoController extends AbstractController<RepNumeroCertificado> {
    
    @Inject
    private RepNumeroCertificadoFacade repNumeroCertificadoFacade;
     
     
    public RepNumeroCertificadoController() {
        super(RepNumeroCertificado.class);
    }
    
    public Integer obtieneSecuenciaCertificado(Long estCodigo, Long pelCodigo, Long ticCodigo){
           
    RepNumeroCertificado secuencia = repNumeroCertificadoFacade.consultaSecuenciaCertificado(estCodigo, pelCodigo, ticCodigo);
    
        if (secuencia == null) {

            RepNumeroCertificado numCertificado = new RepNumeroCertificado();

            numCertificado.setNceNumeroCertificado(1);
            numCertificado.setPelCodigo(pelCodigo);
            numCertificado.setEstCodigo(estCodigo);
            numCertificado.setTicCodigo(ticCodigo);
            repNumeroCertificadoFacade.createRecord(numCertificado);
            return Integer.valueOf(String.valueOf(numCertificado.getNceNumeroCertificado()));
                    
        }else{
             long secCert = secuencia.getNceNumeroCertificado();
             
             secuencia.setNceNumeroCertificado(secCert + 1);
             repNumeroCertificadoFacade.editRecord(secuencia);
             return Integer.valueOf(String.valueOf(secuencia.getNceNumeroCertificado()));
        }     
           
      // return null;
    }     
   
}

