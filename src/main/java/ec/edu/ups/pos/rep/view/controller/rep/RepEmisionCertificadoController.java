/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.view.controller.rep;

import ec.edu.ups.pos.rep.data.entities.rep.RepEmisionCertificado;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepEmisionCertificadoFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import java.util.Date;
import javax.inject.Inject;
import org.omnifaces.util.Faces;

/**
 *
 * @author UPS
 */
public class RepEmisionCertificadoController extends AbstractController<RepEmisionCertificado> {
    
    @Inject
    private RepEmisionCertificadoFacade repEmisionCertificadoFacade;
     
     
    public RepEmisionCertificadoController() {
        super(RepEmisionCertificado.class);
    }
    
    public void registraEmisionCertificado(Long numCertificado,Long aluCodigo, Long estCodigo, Long pelCodigo, Long ticCodigo){
                 
        /* System.out.println("numCertificado"+numCertificado);
           System.out.println("aluCodigo"+aluCodigo);
           System.out.println("estCodigo"+estCodigo);
           System.out.println("pelCodigo"+pelCodigo);
           System.out.println("ticCodigo"+ticCodigo);
           System.out.println("Faces.getRemoteUser()"+Faces.getRemoteUser());
           System.out.println("fecha"+new Date());*/
           
          RepEmisionCertificado emisionCertificado = new RepEmisionCertificado();
         
            emisionCertificado.setEmcNumCertificado(numCertificado);
            emisionCertificado.setTicCodigo(ticCodigo);
            emisionCertificado.setAluCodigo(aluCodigo);
            emisionCertificado.setPelCodigo(pelCodigo);
            emisionCertificado.setEstCodigo(estCodigo);          
                      
            repEmisionCertificadoFacade.createRecord(emisionCertificado);
     
        }     
}
