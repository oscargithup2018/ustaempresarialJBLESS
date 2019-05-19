package co.com.ustaempresarial.fachada;

import co.com.UstaEmpresarial.nomina.modelo.*;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface NominaFachada {

    // ==================================================================================================================
    // -------------------------------------------------HOJA DE VIDA-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Permite crear una nueva hoja de vida
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public HojaVida crearHojaVida(HojaVida hojaVida) throws Exception;

    /**
     * Modifica la información de una hoja de vida
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception;

    /**
     * Elimina la hoja de vida correspondiente al codigo
     *
     * @param codigoHojaVida
     * @return
     * @throws Exception
     */
    public boolean eliminarHojaVida(int codigoHojaVida) throws Exception;

    /**
     * Muestra el listado de las hojas de vida del personal registrado
     *
     * @return Listado de las hojas de vida registradas
     * @throws Exception
     */
    public List<HojaVida> listarHojasVida() throws Exception;
    // ==================================================================================================================
    // -------------------------------------------------CARGO-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea un nuevo cargo en la base de datos
     *
     * @param cargos Objeto cargo
     * @throws Exception
     */
    public void crearCargo(Cargo cargos) throws Exception;

    /**
     * Edita un cargo existente en la base de datos
     *
     * @param cargos Objetos cargo a editar
     * @throws Exception
     */
    public void editarCargo(Cargo cargos) throws Exception;

    /**
     * Elimina un cargo de la base de datos
     *
     * @param cargo Objeto cargo a eliminar
     * @return true si se eliminó, false si no
     * @throws Exception
     */
    public boolean eliminarCargo(Cargo cargo) throws Exception;

    /**
     * Lista todos los cargos en la base de datos
     *
     * @return lista de entidades de la tabla cargo
     * @throws Exception
     */
    public List<Cargo> listarCargos() throws Exception;

    // ==================================================================================================================
    // -------------------------------------------------DEPENDENCIA-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Método que crea una dependencia
     *
     * @param depen Tipo de objeto a crear
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public void crearDependencia(Dependencia depen) throws Exception;

    /**
     * Metodo encargado de actualizar la dependencia
     *
     * @param depen dependencia
     * @return dependencia actualizada
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public void editarDependencia(Dependencia depen) throws Exception;

    /**
     * Borra la dependencia seleccionada
     *
     * @param codigo Código de la dependencia
     * @return true: borra si el código de la dependencia está en contrato
     * @throws Exception Exception Capturar errores posibles sobre ejecución
     */
    public boolean borrarDependencia(int codigo) throws Exception;

    /**
     * Se listan las dependencias correspondientes
     *
     * @return List<dependencia>: Lista de dependencias
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public List<Dependencia> listarDependencias() throws Exception;

    // ==================================================================================================================
    // -------------------------------------------------CONTRATO-----------------------------------------------------
    // ==================================================================================================================

    /**
     * crea un contrato
     *
     * @param contrato
     * @return true or false
     * @throws Exception
     */
    public void crearContrato(Contrato contrato) throws Exception;

    /**
     * modifica un contrato
     *
     * @param contrato
     * @return true or false
     * @throws Exception
     */
    public Contrato editarContrato(Contrato contrato) throws Exception;

    /**
     * eliminarContrato
     *
     * @param codigo
     * @return true or false
     * @throws Exception
     */
    public boolean eliminarContrato(int codigo) throws Exception;

    /**
     * lista los contratos por -dependencias-hojavida
     *
     * @return lista
     * @throws Exception
     */
    public List<Contrato> listaContratoDependecia() throws Exception;

    /**
     * listarContratoCargo lista los contratos por cargo
     *
     * @return lista
     * @throws Exception
     */
    public List<Contrato> listaContratoCargo() throws Exception;

    /**
     * listarContratoAll lista todo el contrato
     *
     * @return lista
     * @throws Exception
     */
    public List<Contrato> listaContratoTodo() throws Exception;

    // ==================================================================================================================
    // -------------------------------------------------CONCEPTO-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea un nuevo cargo en la base de datos
     *
     * @param conceptos Objeto concepto
     * @throws Exception
     */
    public void crearConcepto(Concepto conceptos) throws Exception;

    /**
     * Edita un cargo existente en la base de datos
     *
     * @param concep editar
     * @throws Exception
     */
    public Concepto editarConcepto(Concepto concep) throws Exception;

    /**
     * Elimina un cargo de la base de datos
     *
     * @param codigo a eliminar
     * @return true si se eliminó, false si no
     * @throws Exception
     */
    public boolean borrarConcepto(int codigo) throws Exception;

    /**
     * Lista todos los conceptos en la base de datos
     *
     * @return lista de entidades de la tabla cargo
     * @throws Exception
     */
    public List<Concepto> listarConceptos() throws Exception;

    // ==================================================================================================================
    // -------------------------------------------------PERIODO-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Método que crea un Periodo
     *
     * @param per Tipo de objeto a crear
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public boolean crearPeriodo(Periodo per) throws Exception;

    /**
     * Metodo encargado de actualizar los periodos
     *
     * @param per periodo
     * @return periodo actualizado
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public boolean editarPeriodo(Periodo per) throws Exception;

    /**
     * Borra el periodo seleccionado
     *
     * @param codigo Código del periodo
     * @return true: donde si borra y false donde hay error de ejecución
     * @throws Exception Exception Capturar errores posibles sobre ejecución
     */
    public boolean borrarPeriodo(int codigo) throws Exception;


    /**
     * Lista todos los periodos existentes
     *
     * @return List periodos
     * @throws Exception
     */
    public List<Periodo> listarPeriodos() throws Exception;

    //==================================================================================================================
    //-------------------------------------------------NOMINA-----------------------------------------------------
    //==================================================================================================================

    /**
     * Genera los concepts de nomina por contrato para cada periodo
     *
     * @param nomina
     * @throws Exception
     */
    public void liquidarNomina(Nomina nomina) throws Exception;

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
     * @param id
     * @return
     * @throws Exception
     */

    public boolean conceptosLiquidadosNomina(int id) throws Exception;

    /**
     * sueldo*diastrabajados
     *
     * @param id
     * @return
     * @throws Exception
     */

    public boolean conceptosPagadosNomina(int id) throws Exception;
}