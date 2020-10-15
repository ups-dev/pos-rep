/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.rep;

import ec.edu.ups.pos.rep.data.entities.rep.RepNumeroCertificado;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.util.exceptions.UPSDataEditException;
import ec.edu.ups.util.jpa.search.param.CacheStoreModeParam;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author UPS
 */
@Stateless
public class RepNumeroCertificadoFacade extends AbstractFacade<RepNumeroCertificado> {

    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepNumeroCertificadoFacade() {
        super(RepNumeroCertificado.class);
    }

    @Override
    public void createRecord(RepNumeroCertificado entity) {
        try {
            entity.setNceCodigo(findSequence());
            getEntityManager().persist(entity);
            getEntityManager().flush();
        } catch (PersistenceException ex) {
            wrapException(DataAction.INSERT, ex);
        }
    }

    @Override
    public void editRecord(RepNumeroCertificado entity) {
        try {
            RepNumeroCertificado repNumeroCertificado = find(entity.getNceCodigo());
            //Permite validar si el registro existe
            if (repNumeroCertificado == null) {
                throw new UPSDataEditException();
            }
            super.editRecord(entity);
        } catch (PersistenceException pe) {
            wrapException(AbstractFacade.DataAction.UPDATE, pe);
        }
    }

    public RepNumeroCertificado consultaSecuenciaCertificado(Long estCodigo, Long pelCodigo, Long ticCodigo) {
      
        Query q = getEntityManager().createNativeQuery(" select * from rep.rep_numero_certificado nce "
                                                    + " where nce.est_codigo = ?1 "
                                                    + " and   nce.pel_codigo = ?2 "
                                                    + " and   nce.tic_codigo = ?3 "
                                                    + " and   nce.aud_eliminado = 'N' ", RepNumeroCertificado.class)
                                                    .setParameter(1, estCodigo)
                                                    .setParameter(2, pelCodigo)
                                                    .setParameter(3, ticCodigo);

        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);

        List<RepNumeroCertificado> result = q.getResultList();

        return result.isEmpty() ? null : result.get(0);

    }
    
    public RepNumeroCertificado consultaSecuenciaCertificadoAnio(Long estCodigo, Long pelCodigo, Long ticCodigo, Long anio) {
      
        Query q = getEntityManager().createNativeQuery(" select * from rep.rep_numero_certificado nce " 
                                                      + " where nce.est_codigo = ?1 " 
                                                      + " and   nce.tic_codigo = ?2 " 
                                                      + " and   nce.nce_anio   = ?3 " 
                                                      + " and   nce.aud_eliminado = 'N' ", RepNumeroCertificado.class)
                                                    .setParameter(1, estCodigo)
                                                    .setParameter(2, ticCodigo)
                                                    .setParameter(3, anio);

        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);

        List<RepNumeroCertificado> result = q.getResultList();

        return result.isEmpty() ? null : result.get(0);

    }

}
