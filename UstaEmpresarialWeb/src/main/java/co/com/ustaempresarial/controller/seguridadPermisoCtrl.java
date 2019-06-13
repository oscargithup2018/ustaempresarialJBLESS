package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.servicio.SeguridadSevicio;


@ManagedBean(name = "seguridad")
@SessionScoped
public class seguridadPermisoCtrl implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer codigo;

	private String descripcion;

	private Boolean estado;
 
	private List<Permiso> permisos;
	private String nombre;
	
	private Permiso permisoSeguridad;
	
private SeguridadSevicio servicio;

public seguridadPermisoCtrl() {
	super();
	permisoSeguridad= new Permiso();
	permisos= new ArrayList<Permiso>();
}

@PostConstruct
public void cargarPermisoPage() {
	try {
		permisos=servicio.listarPermiso();	
	} catch (Exception e) {
		e.printStackTrace();
	}
    
}


public void crearPermisoSeguridad() {
	try {
		
		permisoSeguridad.setCodigo(codigo);
		permisoSeguridad.setDescripcion(descripcion);
		permisoSeguridad.setEstado(estado);
		permisoSeguridad.setNombre(nombre);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void modificarPermisoSeguridad() {
    try {

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void eliminarPermisoSeguridad() {
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

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Boolean getEstado() {
	return estado;
}

public void setEstado(Boolean estado) {
	this.estado = estado;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public SeguridadSevicio getServicio() {
	return servicio;
}

public void setServicio(SeguridadSevicio servicio) {
	this.servicio = servicio;
}


	   
	   
	   

}
