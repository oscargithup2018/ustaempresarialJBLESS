package co.com.ustaempresarial.servicio;

import co.com.ustaempresarial.fachada.AutenticacionFachada;
import co.com.ustaempresarial.seguridad.modelo.Usuario;

import javax.ejb.*;


@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class SeguridadServicio {

    @EJB
    AutenticacionFachada autenticacionBean;

    public SeguridadServicio() {
        super();
    }

    public Usuario consultarUsuario(String us, String clave) throws Exception {
        return autenticacionBean.consultarUsuario(us, clave);
    }
}
