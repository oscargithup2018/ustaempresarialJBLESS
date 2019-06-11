package co.com.ustaempresarial.controller;

import co.com.ustaempresarial.finanzas.modelo.LibroDiario;
import co.com.ustaempresarial.finanzas.modelo.PlanContable;
import co.com.ustaempresarial.servicio.FinanzasServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@ManagedBean(name = "libroDiarioFinananzas")
@SessionScoped
public class FinanzasLbrDiarioCtrl implements Serializable {

    private static final long serialVersionUID = 1L;
    private Properties properties;
    private List<LibroDiario> libroDiarios;
    private int buscarCodPlanContable;
    private LibroDiario libroDiario;

    @EJB
    private FinanzasServicio servicio;

    public FinanzasLbrDiarioCtrl() throws Exception {
        super();
      
        properties = new Properties();
        properties.load(LoginControl.class.getResourceAsStream("mensajes.properties"));
    }

    @PostConstruct
    public void cargarLbrDiarioPage() throws Exception {
        try {
        	  libroDiario = new LibroDiario();
              libroDiarios = new ArrayList<>();
              libroDiarios = servicio.listarLibroDiario();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearLibroDiario() {
        try {
            if (this.libroDiario.getConceptoCod() != null && this.libroDiario.getPeriodoCod() != null && this.libroDiario.getEstado() != null && this.libroDiario.getAsiento() != null && this.libroDiario.getFecha() != null && this.libroDiario.getValor() != null) {
//               if(servicio.crearLibroDiario(this.libroDiario)){
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"", properties.getProperty("exitoGuardado")));
//                }
                libroDiarios =  servicio.listarLibroDiario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarPlanContable() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarPlanContable() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<LibroDiario> getLibroDiarios() {
        return libroDiarios;
    }

    public void setService(FinanzasServicio servicio) {
        this.servicio = servicio;
    }

    public int getBuscarCodPlanContable() {
        return buscarCodPlanContable;
    }

    public void setBuscarCodPlanContable(int buscarCodPlanContable) {
        this.buscarCodPlanContable = buscarCodPlanContable;
    }

    public PlanContable buscarPlanContable() throws Exception {
        PlanContable planContable = servicio.buscarPlanContable(this.buscarCodPlanContable);
        //como hacer para llenar los inputs con los datos que trae la consulta. ¿Seria limpiar las variables actuales?
        return planContable;
    }

    public LibroDiario getLibroDiario() {
        return libroDiario;
    }

    public void setLibroDiario(LibroDiario libroDiario) {
        this.libroDiario = libroDiario;
    }
}
