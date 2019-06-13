package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import co.com.ustaempresarial.finanzas.modelo.Concepto;
import co.com.ustaempresarial.servicio.FinanzasServicio;

@ManagedBean(name = "conceptoFinanzas")
@SessionScoped
public class FinanzasConceptoCtrl implements Serializable {
	private Integer codigo;
	private String nombre;
	private String descripcion;
	private boolean tipo;
	private boolean estado;
	private int codigoPlanContable;
	private List<Concepto> conceptos;
	private Concepto conceptoContable;

	@EJB
	private FinanzasServicio servicio;

	public FinanzasConceptoCtrl() {
		super();
		conceptos = new ArrayList<Concepto>();
		conceptoContable = new Concepto();
	}

	@PostConstruct
	public void cargarConceptoPage() {
		try {
			conceptos = servicio.listarConcepto();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void crearConceptoContable() {
		try {
			if (codigo != 0 && nombre != null) {
				conceptoContable.setCodigo(codigo);
				conceptoContable.setNombre(nombre);
				conceptoContable.setDescripcion(descripcion);
				conceptoContable.setTipo(tipo);
				conceptoContable.setEstado(estado);
				conceptoContable.setPlanContableCodigo(codigoPlanContable);
				servicio.crearConcepto(conceptoContable);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarConceptoContable() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarConceptoContable() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descricion) {
		this.descripcion = descripcion;
	}

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public int getCodigoPlanContable() {
		return codigoPlanContable;
	}

	public void setCodigoPlanContable(int codigoPlanContable) {
		this.codigoPlanContable = codigoPlanContable;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
