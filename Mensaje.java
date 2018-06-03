package es.upm.fis2018.gm11_6.core;

public class Mensaje {
	private String idMensaje;
	private String contenido;
	private Usuario remitente;
	
	public Mensaje (String idM, String cont, Usuario remitenteC) {
		this.idMensaje = idM;
		this.contenido = cont;
		this.remitente = remitenteC;		
	}

	
	
//	
//	//GETTERS AND SETTERS
//	public String getIdMensaje() {
//		return idMensaje;
//	}
//	public void setIdMensaje(String idMensaje) {
//		this.idMensaje = idMensaje;
//	}
//	public String getContenido() {
//		return contenido;
//	}
//	public void setContenido(String contenido) {
//		this.contenido = contenido;
//	}
//	public Usuario getRemitente() {
//		return remitente;
//	}
//	public void setRemitente(Usuario remitente) {
//		this.remitente = remitente;
//	}	
//	public void guardarEnDataBase(String idMensaje, String contenido,Usuario remitente ){
//		List<String> entrada = Arrays.asList(idMensaje, contenido,remitente.toString);
//		Path file = Paths.get("the-file-name.txt");
//		Files.write(file, lines, Charset.forName("UTF-8"));
}
