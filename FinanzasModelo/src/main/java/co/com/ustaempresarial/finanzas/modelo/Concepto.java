package co.com.ustaempresarial.finanzas.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the concepto database table.
 * 
 */
@Entity
@Table(name="\"concepto\"", schema="\"finanzas\"", catalog = "\"usta_empresarial\"")
public class Concepto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String LISTARCONCEPTO = "Concepto.LISTARCONCEPTO";
	public static final String LISTARCONCEPTOBYNAME = "Concepto.LISTARCONCEPTOBYNAME";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	private String descripcion;

	private Boolean estado;

	private String nombre;

	@Column(name="plan_contable_codigo")
	private Integer planContableCodigo;

	private Boolean tipo;

	public Concepto() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descrpcion) {
		this.descripcion = descrpcion;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPlanContableCodigo() {
		return this.planContableCodigo;
	}

	public void setPlanContableCodigo(Integer planContableCodigo) {
		this.planContableCodigo = planContableCodigo;
	}

	public Boolean getTipo() {
		return this.tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

}
