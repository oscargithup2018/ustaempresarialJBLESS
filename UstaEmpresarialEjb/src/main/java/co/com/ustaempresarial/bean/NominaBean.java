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
	public HojaVida crearHojaVida(HojaVida hojaVida) throws Exception {
		if (hojaVida.getDocumento() != null && !hojaVida.getDocumento().equals("")) {
			em.persist(hojaVida);
		}
		return null;
	}

	@Override
	public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception {
		HojaVida hojaVida1 = new HojaVida();
		hojaVida1 = buscarPorIdHojaVida(hojaVida.getDocumento());
		if (hojaVida1.getDocumento() > 0) {
			em.merge(hojaVida);
		} else {
			hojaVida1 = null;
		}
		return hojaVida1;
	}

	@Override
	public boolean eliminarHojaVida(int codigoHojaVida) throws Exception {
		HojaVida hojaVida = buscarPorIdHojaVida(codigoHojaVida);
		boolean flag = false;
		if (hojaVida.getDocumento() > 0) {
			em.remove(hojaVida);
			flag = true;
		}
		return flag;
	}

	@Override
	public List<HojaVida> listarHojasVida() throws Exception {
		List<HojaVida> hojaVidas = new ArrayList<>();
		Query query = em.createNamedQuery(HojaVida.FILL_ALL);
		return null;
	}

	private HojaVida buscarPorIdHojaVida(int idHojaVida) throws Exception {
		HojaVida hojaVida = new HojaVida();
		hojaVida = em.find(HojaVida.class, idHojaVida);
		return hojaVida;
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

		if (cargo != null) {
			em.persist(cargo);
			em.flush();
		}
	}

	// @Override
	public void editarCargo(Cargo cargos) throws Exception {
		if (cargos != null) {
			if (cargos.getCodigo() > 0) {
				em.merge(cargos);
				em.flush();
			}
		}
	}

	@Override
	public boolean eliminarCargo(Cargo cargos) throws Exception {
		if (cargos.getCodigo() > 0) {
			em.remove(cargos);
			return true;
		}
		return false;
	}

	@Override
	public List<Dependencia> traerDependencia() throws Exception {
		List<Dependencia> dependencias = new ArrayList<Dependencia>();
		Query query = em.createNamedQuery(Dependencia.FIND_ALL);
		dependencias = query.getResultList();
		return dependencias;
	}

	@Override
	public void crearDependencia(Dependencia dep) throws Exception {
		if (dep.getNombre() != null && !dep.getNombre().equals("")) {
			em.persist(dep);
		}
	}

	private Dependencia buscarPorId(int codigoDependencia) throws Exception {
		Dependencia p = new Dependencia();
		p = em.find(Dependencia.class, codigoDependencia);
		return p;
	}

	@Override
	public void editarDependencia(Dependencia depen) throws Exception {
		Dependencia dep = new Dependencia();
		dep = buscarPorId(depen.getCodigo());
		if (dep.getCodigo() > 0) {
			em.merge(depen);
		} else {
			dep = null;
		}

		
	}

	@Override
	public boolean borrarDependencia(int codigo) throws Exception {
		Dependencia dependencias = buscarPorId(codigo);
		boolean flag = false;
		if (dependencias.getCodigo() > 0) {
			em.remove(dependencias);
			flag = true;
		}
		return flag;

	}

	public void crearContrato(Contrato contrato) throws Exception {

		if (contrato.getCodigo() != null && !contrato.getCodigo().equals("")) {
			em.persist(contrato);
		}
		// TODO Auto-generated method stub

	}

	public Contrato modificarContrato(Contrato contrato) throws Exception {
		Contrato dep = new Contrato();
		dep = buscarPorCodigo(contrato.getCodigo());
		if (dep.getCodigo() > 0) {
			em.merge(contrato);
		} else {
			dep = null;
		}

		return dep;
	}

	public boolean eliminarContrato(int codigo) throws Exception {
		Contrato contrato = buscarPorCodigo(codigo);
		boolean flag = false;
		if (contrato.getCodigo() > 0) {
			em.remove(contrato);
			flag = true;
		}
		return flag;
	}

	public List<Contrato> listaContratoDependecia() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contrato> listaContratoCargo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contrato> listaContratoAll() throws Exception {
		List<Contrato> dependencias = new ArrayList<>();
		Query query = em.createNamedQuery(Contrato.FIND_ALL);
		dependencias = query.getResultList();
		return dependencias;
	}

	private Contrato buscarPorCodigo(int codigoContrato) throws Exception {
		Contrato p = new Contrato();
		p = em.find(Contrato.class, codigoContrato);
		return p;
	}

	
	public List<Concepto> traerConcepto() throws Exception {
		List<Concepto> conceptos = new ArrayList<Concepto>();
		Query query = em.createNamedQuery(Concepto.FIND_ALL);
		conceptos = query.getResultList();
		return conceptos;
	}

	@Override
	public void crearConcepto(Concepto con) throws Exception {
		if (con.getNombre() != null && !con.getNombre().equals("")) {
			em.persist(con);
		}
	}
	public void crearPeriodo(Periodo per) throws Exception {
		if (per.getCodigo() != null && !per.getCodigo().equals("")) {
			em.persist(per);
		}
	}


	public Concepto editarConcepto(Concepto concep) throws Exception {
		Concepto con = new Concepto();
		con = buscarPorIdConcepto(concep.getCodigo());
		if (con.getCodigo() > 0) {
			em.merge(concep);
		} else {
			con = null;
		}

		return con;
	}

	@Override
	public boolean borrarConcepto(int codigo) throws Exception {
		Concepto conceptos = buscarPorIdConcepto(codigo);
		boolean flag = false;
		if (conceptos.getCodigo() > 0) {
			em.remove(conceptos);
			flag = true;
		}
		return flag;
	}
	
	private Concepto buscarPorIdConcepto(int codigoConcepto) throws Exception {
		Concepto c = new Concepto();
		c = em.find(Concepto.class, codigoConcepto);
		return c;
	}
	
	public List<Periodo> traerPeriodo() throws Exception {
		List<Periodo> periodos = new ArrayList<Periodo>();
		Query query = em.createNamedQuery(Periodo.FIND_ALL);
		periodos = query.getResultList();
		return periodos;
	}

	
	
	
	public void editarPeriodo(Periodo per) throws Exception {
		if (per != null) {
			if (per.getCodigo() > 0) {
				em.merge(per);
				em.flush();
			}
		}
	
	}

	
	public boolean borrarPeriodo(int codigo) throws Exception {
		Periodo periodos = buscarPorCodigoPeriodo(codigo);
		boolean flag = false;
		if (periodos.getCodigo() > 0) {
			em.remove(periodos);
			flag = true;
		}
		return flag;
	}
	
	private Periodo buscarPorCodigoPeriodo(int codigoPeriodo) throws Exception {
		Periodo p = new Periodo();
		p = em.find(Periodo.class, codigoPeriodo);
		return p;
	}

}