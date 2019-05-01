package co.com.ustaempresarial.fachada;

import co.com.ustaempresarial.seguridad.modelo.Usuario;

import javax.ejb.Remote;


@Remote
public interface AutenticacionFachada{

	/**
	 * metodo que busca si un usuario que esta registrado en el sistema
	 * @param us
	 * @param clave
	 * @return
	 * @throws Exception
	 */
	public Usuario consultarUsuario(String us, String clave) throws Exception;
	

}
