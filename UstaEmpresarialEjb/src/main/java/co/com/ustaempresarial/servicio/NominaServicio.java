package co.com.ustaempresarial.servicio;

import co.com.ustaempresarial.fachada.NominaFachada;
import modeloNomina.HojaVida;

import javax.ejb.*;
import java.util.List;


@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class NominaServicio {

    @EJB
    NominaFachada fachada;

    public HojaVida crearHojaVida(HojaVida hojaVida) throws Exception {
        return fachada.crearHojaVida(hojaVida);
    }

    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception {
        return fachada.modificarHojaVida(hojaVida);
    }

    public boolean eliminarHojaVida(int codigo) throws Exception {
        return fachada.eliminarHojaVida(codigo);
    }

    public List<HojaVida> listarHojasVida() throws Exception {
        return fachada.listarHojasVida();
    }

}
