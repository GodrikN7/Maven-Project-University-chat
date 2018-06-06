package es.upm.fis2018.gm11_6.core;

import java.util.Date;

public class Mensaje {
	private String idMensaje;//no se usa
	private String contenido;
	private Usuario emisor;
	private Date date = new Date ();
	
	public Mensaje (String cont, Usuario emisorC) {
		this.idMensaje = "0";
		this.contenido = cont;
		this.emisor = emisorC;		
	}
	
	

    public Date getCreationDate ()
    {
        return date;
    }
	
	
	//GETTERS AND SETTERS
	public String getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Usuario getEmisor() {
		return emisor;
	}
	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}
}
