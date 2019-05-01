package co.com.ustaempresarial.bean;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.ustaempresarial.fachada.AutenticacionFachada;
import co.com.ustaempresarial.seguridad.modelo.Usuario;


@Stateless
@LocalBean
public class AutenticacionBean implements AutenticacionFachada{

	@PersistenceContext(unitName="facturacion")
	private EntityManager em;
	
	public AutenticacionBean() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.facturacion.fachada.AutenticacionFachada#consultarUsuario(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario consultarUsuario(String us, String clave) throws Exception {
		Usuario loginUsuario = new Usuario();
		 Query q = em.createNamedQuery(Usuario.TRAER_USUARIO);
		 q.setParameter("usua", us);
		 q.setParameter("pass", clave);
		
		try {
			loginUsuario = (Usuario) q.getSingleResult();
		} catch (NoResultException  e) {
			loginUsuario = null;
		}
	
		return loginUsuario;
	}

//	@Override
//	public List<OpcionesMenuUsuario> consultaPermisosOpcionesUser()
//			throws Exception {
//		return null;
//	}
//
//	@Override
//	public Funcionario consultarUsuario(String usuario) throws Exception {
//		List<Funcionario> listLog = new ArrayList<Funcionario>();
//		Funcionario user = new Funcionario();
//		Query q = em.createNamedQuery(Funcionario.USUARIO_PERMITIDO);
//		q.setParameter("user", usuario);
//		listLog = q.getResultList();
//		
//		if(listLog.size()>0){
//			for(Funcionario o : listLog){
//				user = new Funcionario();
//				user.setClave(o.getClave());
//				user.setEstadodel(o.getEstadodel());
//				user.setId(o.getId());
//				user.setIddependencia(o.getIddependencia());
//				user.setIdperfil(o.getIdperfil());
//				user.setIdpregunta(o.getIdpregunta());
//				user.setRespuesta(o.getRespuesta());
//				user.setUsuario(o.getUsuario());
//			}
//		}
//		
//		em.clear();
//		return user;
//	}

}
