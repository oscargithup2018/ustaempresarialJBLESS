package co.com.ustaempresarial.bean;

import co.com.ustaempresarial.fachada.NominaFachada;
import modeloNomina.HojaVida;
import modeloNomina.Nomina;

import java.util.List;

public class NominaBean implements NominaFachada {
    //--------------------------------------Clase Nomina-----------------------------------
    @Override
    public List<Nomina> obtenerNominas() throws Exception {
        return null;
    }

    @Override
    public void crearNomina(Nomina nomina) throws Exception {

    }

    @Override
    public Nomina editarNomina(Nomina nomina) throws Exception {
        return null;
    }

    @Override
    public boolean borrarNomina(int codigo) throws Exception {
        return false;
    }

    @Override
    public List<Nomina> buscarNominaPorNombre(String nombre) throws Exception {
        return null;
    }

    //--------------------------------------Clase Nomina-----------------------------------
    @Override
    public HojaVida crearHojaVida(HojaVida hojaVida) throws Exception {
        return null;
    }

    @Override
    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception {
        return null;
    }

    @Override
    public boolean eliminarHojaVida(int codigoHojaVida) throws Exception {
        return false;
    }

    @Override
    public List<HojaVida> listarHojasVida() throws Exception {
        return null;
    }
}
