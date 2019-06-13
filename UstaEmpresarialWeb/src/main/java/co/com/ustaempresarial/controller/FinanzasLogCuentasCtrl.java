package co.com.ustaempresarial.controller;

import co.com.ustaempresarial.finanzas.modelo.LogCuenta;
import co.com.ustaempresarial.finanzas.modelo.PlanContable;
import co.com.ustaempresarial.servicio.FinanzasServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@ManagedBean(name="LogCuentasFinanzas")
@SessionScoped
public class FinanzasLogCuentasCtrl implements Serializable {

    private static final long serialVersionUID = 1L;

//    private Integer codigo;
//    private Integer codigoPadre;
//    private String descripcion;
//    private String nombre;
//    private Integer tipo;
    private List<LogCuenta> logCuentas;
    private int buscarCodPlanContable;
    private Properties properties;

    @Temporal(TemporalType.DATE)
    private Date vigencia;

    @EJB
    private FinanzasServicio servicio;

    public FinanzasLogCuentasCtrl() throws Exception {
        super();
        properties = new Properties();
        properties.load(LoginControl.class.getResourceAsStream("mensajes.properties"));
    }

    @PostConstruct
    public void cargarPlanContablePage() {
        try {
            logCuentas = new ArrayList<LogCuenta>();
            logCuentas = servicio.listarLogCuentas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public List<LogCuenta> getLogCuentas() {
		return logCuentas;
	}

	public void setLogCuentas(List<LogCuenta> logCuentas) {
		this.logCuentas = logCuentas;
	}

	public int getBuscarCodPlanContable() {
		return buscarCodPlanContable;
	}

	public void setBuscarCodPlanContable(int buscarCodPlanContable) {
		this.buscarCodPlanContable = buscarCodPlanContable;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public FinanzasServicio getServicio() {
		return servicio;
	}

	public void setServicio(FinanzasServicio servicio) {
		this.servicio = servicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
