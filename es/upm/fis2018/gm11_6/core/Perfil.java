package es.upm.fis2018.gm11_6.core;

public class Perfil {
	private String estado;
	private String descripcion;
	private String imagen;
	
	public Perfil () {
		this.estado 		= "estado";
		this.descripcion 	= "descripcion";
		this.imagen 		= "#";
	}
	public void modificarPerfil (String est, String des, String img) {
		this.estado = est;
		this.descripcion = des;
		this.imagen = img;		
	}
	
	
	// GETTERS AND SETTERS
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
