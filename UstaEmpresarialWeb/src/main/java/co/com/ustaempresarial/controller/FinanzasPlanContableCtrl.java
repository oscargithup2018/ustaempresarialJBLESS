package co.com.ustaempresarial.controller;

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

@ManagedBean(name = "planContableFinananzas")
@SessionScoped
@ViewScoped
public class FinanzasPlanContableCtrl implements Serializable {

    private static final long serialVersionUID = 1L;
    private Properties properties;
    private List<PlanContable> planContables;
    private int buscarCodPlanContable;
    private PlanContable planContable;

    @EJB
    private FinanzasServicio servicio;

    public FinanzasPlanContableCtrl() throws Exception {
        super();
        planContable = new PlanContable();
        planContables = new ArrayList<>();
        properties = new Properties();
        properties.load(LoginControl.class.getResourceAsStream("mensajes.properties"));
    }

    @PostConstruct
    public void init() throws Exception {
        try {
            planContables = servicio.listarPlanContable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearPlanContable() {
        try {
            if (this.planContable.getCodigo() != null && this.planContable.getCodigoPadre() != null && this.planContable.getDescripcion() != null && this.planContable.getNombre() != null && this.planContable.getTipo() != null && this.planContable.getVigencia() != null) {
                if(servicio.crearPlanContable(this.planContable)){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"", properties.getProperty("exitoGuardado")));
                }
                planContables =  servicio.listarPlanContable();
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

    public List<PlanContable> getPlanContables() {
        return planContables;
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

    public PlanContable getPlanContable() {
        return planContable;
    }

    public void setPlanContable(PlanContable planContable) {
        this.planContable = planContable;
    }
}
