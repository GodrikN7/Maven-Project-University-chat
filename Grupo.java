package es.upm.fis2018.gm11_6.core;

public class Grupo {
	private Usuario admin;
	private String idGrupo;
	private int numeroMiembros;
	// posible añadir lista de miembros dentro de un grupo (araylist)
	
	public Grupo (Usuario userAdmin, String idG) {
		this.admin 			= userAdmin;
		this.idGrupo 		= idG;
		this.numeroMiembros = 1;
	}
	public void anyadirMiembro () {
		this.numeroMiembros ++;
	}
	
	
	
	
	// GETTERS AND SETTERS
	public Usuario getAdmin() {
		return admin;
	}
	public void setAdmin(Usuario admin) {
		this.admin = admin;
	}
	public String getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	public int getNumeroMiembros() {
		return numeroMiembros;
	}
	public void setNumeroMiembros(int numeroMiembros) {
		this.numeroMiembros = numeroMiembros;
	}	
}
