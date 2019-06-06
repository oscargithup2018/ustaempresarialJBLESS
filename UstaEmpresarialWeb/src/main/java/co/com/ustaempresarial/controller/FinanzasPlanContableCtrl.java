package co.com.ustaempresarial.controller;

import co.com.ustaempresarial.finanzas.modelo.PlanContable;
import co.com.ustaempresarial.servicio.FinanzasServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "planContableFinananzas")
@SessionScoped
@ViewScoped
public class FinanzasPlanContableCtrl implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<PlanContable> planContables;
    private int buscarCodPlanContable;
    private PlanContable planContable;

    @EJB
    private FinanzasServicio servicio;

    public FinanzasPlanContableCtrl() {
        super();
        planContable = new PlanContable();
        planContables = new ArrayList<PlanContable>();
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
            servicio.crearPlanContable(this.planContable);
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
