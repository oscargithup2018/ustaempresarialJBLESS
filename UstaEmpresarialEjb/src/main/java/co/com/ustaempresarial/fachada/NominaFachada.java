package co.com.ustaempresarial.fachada;

import modeloNomina.HojaVida;
import modeloNomina.Nomina;

import javax.ejb.Remote;
import java.util.List;


@Remote
public interface NominaFachada {
    //--------------------------------------Clase Nomina-----------------------------------

    /**
     * obtenerNominas
     *
     * @return
     * @throws Exception
     */
    public List<Nomina> obtenerNominas() throws Exception;

    /**
     * crearNomina
     *
     * @param nomina
     * @throws Exception
     */
    public void crearNomina(Nomina nomina) throws Exception;

    /**
     * editarNomina
     *
     * @param nomina
     * @return
     * @throws Exception
     */
    public Nomina editarNomina(Nomina nomina) throws Exception;

    /**
     * borrarNomina
     *
     * @param codigo
     * @return
     * @throws Exception
     */
    public boolean borrarNomina(int codigo) throws Exception;

    /**
     * buscarNominaPorNombre
     *
     * @param nombre
     * @return
     * @throws Exception
     */

    public List<Nomina> buscarNominaPorNombre(String nombre) throws Exception;

    //--------------------------------------Clase Nomina-----------------------------------

    /**
     * Permite crear una nueva hoja de vida
     * @param hojaVida
     * @return
     * @throws Exception
     */
    public HojaVida crearHojaVida(HojaVida hojaVida) throws Exception;

    /**
     * Modifica la información de una hoja de vida
     * @param hojaVida
     * @return
     * @throws Exception
     */
    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception;

    /**
     * Elimina la hoja de vida correspondiente al codigo
     * @param codigoHojaVida
     * @return
     * @throws Exception
     */
    public boolean eliminarHojaVida(int codigoHojaVida) throws Exception;

    /**
     * Muestra el listado de las hojas de vida del personal registrado
     * @return
     * @throws Exception
     */
    public List<HojaVida> listarHojasVida() throws Exception;
}
