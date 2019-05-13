package co.com.ustaempresarial.fachada;

import java.util.List;

import javax.ejb.Remote;



import co.com.ustaempresarial.fachada.NominaFachada;
import co.com.UstaEmpresarial.nomina.modelo.Cargo;
import co.com.UstaEmpresarial.nomina.modelo.Concepto;
import co.com.UstaEmpresarial.nomina.modelo.Nomina;
@Remote
public interface NominaFachada{
	 /**
     * Lista todos los cargos en la base de datos
     * @return lista de entidades de la tabla cargo
     * @throws Exception
     */
    public List<Cargo> listarCargos() throws Exception;

    /**
     * Crea un nuevo cargo en la base de datos
     * @param cargodsgrEntity cargo a crear
     * @throws Exception
     */
    public void crearCargo(Cargo cargos) throws Exception;

    /**
     * Edita un cargo existente en la base de datos
     * @param cargodsgrEntity cargo a editar
     * @throws Exception
     */
    public void editarCargo(Cargo cargos) throws Exception;

    /**
     * Elimina un cargo de la base de datos
     * @param cargodsgrEntity cargo a eliminar
     * @return true si se eliminó, false si no
     * @throws Exception
     */
    public boolean eliminarCargo(Cargo cargo) throws Exception;
	
    
    /**
     * Lista todos los concepos en la base de datos
     * @return lista de entidades de la tabla cargo
     * @throws Exception
     */
    public List<Concepto> listarConceptos() throws Exception;

    /**
     * Crea un nuevo cargo en la base de datos
     * @param cargodsgrEntity cargo a crear
     * @throws Exception
     */
    public void crearConcepto(Concepto conceptos) throws Exception;

    /**
     * Edita un cargo existente en la base de datos
     * @param cargodsgrEntity cargo a editar
     * @throws Exception
     */
    public void editarConcepto(Concepto conceptos) throws Exception;

    /**
     * Elimina un cargo de la base de datos
     * @param cargodsgrEntity cargo a eliminar
     * @return true si se eliminó, false si no
     * @throws Exception
     */

	
    

}