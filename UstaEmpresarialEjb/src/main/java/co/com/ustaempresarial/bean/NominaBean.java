package co.com.ustaempresarial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import co.com.ustaempresarial.fachada.NominaFachada;
import co.com.UstaEmpresarial.nomina.modelo.Cargo;
import co.com.UstaEmpresarial.nomina.modelo.Nomina;
import co.com.UstaEmpresarial.nomina.modelo.Dependencia;
import co.com.UstaEmpresarial.nomina.modelo.HojaVida;
import co.com.UstaEmpresarial.nomina.modelo.Contrato;
import co.com.UstaEmpresarial.nomina.modelo.Concepto;
import co.com.UstaEmpresarial.nomina.modelo.Periodo;


@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)

public class NominaBean implements NominaFachada {

    @PersistenceContext(unitName = "nomina")
    private EntityManager em;

    public NominaBean() {

        super();

    }
    @Override
    public List<Cargo> listarCargos() throws Exception {

        List<Cargo> cargos;

        Query q = em.createNamedQuery(Cargo.LISTAR_CARGO);
        cargos = q.getResultList();

        return cargos;

    }

    @Override
    public void crearCargo(Cargo cargo) throws Exception {

        if ( cargo != null ) {
            em.persist(cargo);
            em.flush();
        }
    }

    //@Override
    public void editarCargo(Cargo cargos) throws Exception {
        if ( cargos != null ) {
            if ( cargos.getCodigo() > 0 ) {
                em.merge(cargos);
                em.flush();
            }
        }
    }
    
    @Override
    public boolean eliminarCargo(Cargo cargos) throws Exception {
        if ( cargos.getCodigo() > 0 ) {
            em.remove(cargos);
            return true;
        }
        return false;
    }
    @Override
    public List<Concepto> listarConceptos() throws Exception {

        List<Concepto> conceptos;

        Query q = em.createNamedQuery(Concepto.LISTAR_CONCEPTO);
        conceptos = q.getResultList();

        return conceptos;

    }

    @Override
    public void crearConcepto(Concepto conceptos) throws Exception {

        if ( conceptos != null ) {
            em.persist(conceptos);
            em.flush();
        }
    }

    //@Override
    public void editarConcepto(Concepto conceptos) throws Exception {
        if ( conceptos != null ) {
            if ( conceptos.getCodigo() > 0 ) {
                em.merge(conceptos);
                em.flush();
            }
        }
    }
   
    
    
   

}