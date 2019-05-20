package co.com.ustaempresarial.servicio;

import co.com.UstaEmpresarial.nomina.modelo.*;
import co.com.ustaempresarial.fachada.NominaFachada;

import javax.ejb.EJB;
import java.util.List;

public class NominaServicio {
    @EJB
    NominaFachada nominaFachada;

    //==================================================================================================================
    //-------------------------------------------------HOJA DE VIDA-----------------------------------------------------
    //==================================================================================================================
    /**
     * Permite crear una nueva hoja de vida
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public HojaVida crearHojaVida(HojaVida hojaVida) throws Exception {
        return nominaFachada.crearHojaVida(hojaVida);
    }
    /**
     * Modifica la información de una hoja de vida
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception {
        return nominaFachada.modificarHojaVida(hojaVida);
    }
    /**
     * Elimina la hoja de vida correspondiente al codigo
     *
     * @param codigoHojaVida
     * @return
     * @throws Exception
     */
    public boolean eliminarHojaVida(int codigoHojaVida) throws Exception {
        return nominaFachada.eliminarHojaVida(codigoHojaVida);
    }
    /**
     * Muestra el listado de las hojas de vida del personal registrado
     *
     * @return Listado de las hojas de vida registradas
     * @throws Exception
     */
    public List<HojaVida> listarHojasVida() throws Exception {
        return nominaFachada.listarHojasVida();
    }

    //==================================================================================================================
    //-------------------------------------------------CARGO-----------------------------------------------------
    //==================================================================================================================
    /**
     * Crea un nuevo cargo en la base de datos
     *
     * @param cargos Objeto cargo
     * @throws Exception
     */
    public List<Cargo> listarCargos() throws Exception {
        return nominaFachada.listarCargos();
    }
    /**
     * Elimina un cargo de la base de datos
     *
     * @param cargo Objeto cargo a eliminar
     * @return true si se eliminó, false si no
     * @throws Exception  
     */
    public void crearCargo(Cargo cargo) throws Exception {
        nominaFachada.crearCargo(cargo);
    }

    /**
     * Edita un cargo existente en la base de datos
     *
     * @param cargos Objetos cargo a editar
     * @throws Exception
     */
    public void editarCargo(Cargo cargo) throws Exception {
        nominaFachada.editarCargo(cargo);
    }
    /**
     * Lista todos los cargos en la base de datos
     *
     * @return lista de entidades de la tabla cargo
     * @throws Exception
     */
    public boolean eliminarCargo(Cargo cargo) throws Exception {
        return nominaFachada.eliminarCargo(cargo);
    }

    //==================================================================================================================
    //-------------------------------------------------DEPENDENCIA-----------------------------------------------------
    //==================================================================================================================
    /**
     * Método que crea una dependencia
     *
     * @param depen Tipo de objeto a crear
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public void crearDependencia(Dependencia depen) throws Exception {
        nominaFachada.crearDependencia(depen);
    }
    /**
     * Metodo encargado de actualizar la dependencia
     *
     * @param depen dependencia
     * @return dependencia actualizada
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public void editarDependencia(Dependencia depen) throws Exception {
        nominaFachada.editarDependencia(depen);
    }
    /**
     * Borra la dependencia seleccionada
     *
     * @param codigo Código de la dependencia
     * @return true: borra si el código de la dependencia está en contrato
     * @throws Exception Exception Capturar errores posibles sobre ejecución
     */
    public boolean borrarDependencia(int codigo) throws Exception {
        return nominaFachada.borrarDependencia(codigo);
    }
    /**
     * Se listan las dependencias correspondientes
     *
     * @return List<dependencia>: Lista de dependencias
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public List<Dependencia> traerDependencia() throws Exception {
        return nominaFachada.listarDependencias();
    }

    //==================================================================================================================
    //-------------------------------------------------CONTRATO-----------------------------------------------------
    //==================================================================================================================
    /**
     * modifica un contrato
     *
     * @param contrato
     * @return true or false
     * @throws Exception
     */
    public Contrato modificarContrato(Contrato contrato) throws Exception {
        return nominaFachada.editarContrato(contrato);
    }
    /**
     * eliminarContrato
     *
     * @param codigo
     * @return true or false
     * @throws Exception
     */
    public boolean eliminarContrato(int codigo) throws Exception {
        return nominaFachada.eliminarContrato(codigo);
    }
    /**
     * lista los contratos por -dependencias-hojavida
     *
     * @return lista las dependencias
     * @throws Exception
     */
    public List<Contrato> listaContratoDependecia() throws Exception {
        return nominaFachada.listaContratoDependecia();
    }
    /**
     * listarContratoCargo lista los contratos por cargo
     *
     * @return lista los cargos
     * @throws Exception
     */
    public List<Contrato> listaContratoCargo() throws Exception {
        return nominaFachada.listaContratoCargo();
    }
    /**
     * listarContratoAll lista todo el contrato
     *
     * @return lista con todos los datos 
     * @throws Exception
     */
    public List<Contrato> listaContratoAll() throws Exception {
        return nominaFachada.listaContratoTodo();
    }
    //==================================================================================================================
    //-------------------------------------------------CONCEPTO-----------------------------------------------------
    //==================================================================================================================
    /**
     * Edita un cargo existente en la base de datos
     *
     * @param concep editar
     * @throws Exception
     */
    public Concepto editarConcepto(Concepto concep) throws Exception {
        return nominaFachada.editarConcepto(concep);

    }
    /**
     * Elimina un cargo de la base de datos
     *
     * @param codigo a eliminar
     * @return true si se eliminó, false si no
     * @throws Exception
     */
    public boolean borrarConcepto(int codigo) throws Exception {
        return nominaFachada.borrarConcepto(codigo);
    }
    /**
     * Lista todos los conceptos en la base de datos
     *
     * @return lista de entidades de la tabla cargo
     * @throws Exception
     */
    public List<Concepto> traerConcepto() throws Exception {
        return nominaFachada.listarConceptos();
    }

    //==================================================================================================================
    //-------------------------------------------------PERIODO-----------------------------------------------------
    //==================================================================================================================
    /**
     * Metodo encargado de actualizar los periodos
     *
     * @param per periodo
     * @return periodo actualizado
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public boolean editarPeriodo(Periodo per) throws Exception {
        return nominaFachada.editarPeriodo(per);
    }

    /**
     * Borra el periodo seleccionado
     *
     * @param codigo Código del periodo
     * @return true: donde si borra y false donde hay error de ejecución
     * @throws Exception Exception Capturar errores posibles sobre ejecución
     */
    public boolean eliminarPeriodo(int codigo) throws Exception {
        return nominaFachada.borrarPeriodo(codigo);
    }
    /**
     * Lista todos los periodos existentes
     *
     * @return List periodos
     * @throws Exception
     */
    public List<Periodo> listaPeriodo() throws Exception {
        return nominaFachada.listarPeriodos();
    }

    //==================================================================================================================
    //-------------------------------------------------NOMINA-----------------------------------------------------
    //==================================================================================================================
    /**
     * Genera los concepts de nomina por contrato para cada periodo
     *
     * @param nomina
     * @throws Exception
     */
    public void liquidarNomina(Nomina nomina) throws Exception {
        nominaFachada.liquidarNomina(nomina);
    }
    /**
     * editarNomina
     *
     * @param nomina
     * @return
     * @throws Exception
     */
    public Nomina editarNomina(Nomina nomina) throws Exception {
        return nominaFachada.editarNomina(nomina);
    }

    /**
     * borrarNomina
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean conceptosLiquidadosNomina(int id) throws Exception {
        return nominaFachada.conceptosLiquidadosNomina(id);
    }

    /**
     * sueldo*diastrabajados
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean conceptosPagadosNomina(int id) throws Exception {
        return nominaFachada.conceptosPagadosNomina(id);
    }
}
