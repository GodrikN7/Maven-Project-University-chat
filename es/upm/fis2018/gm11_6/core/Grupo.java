package es.upm.fis2018.gm11_6.core;

import java.util.ArrayList;

public class Grupo {
	//Solo pueden acceder a esta clase los usuarios admin del Grupo
	private Usuario admin;
	private String idGrupo;
	private int numeroMiembros;
	private ArrayList<Usuario> listaMiembros = new ArrayList<Usuario>();

	public Grupo (Usuario userAdmin, String idG) {
		this.admin 			= userAdmin;
		this.idGrupo 		= idG;
		this.numeroMiembros = 1;
	 	this.listaMiembros.add(userAdmin);


	}
	public boolean addMiembro(Usuario nuevoMiembro) {
		for (int i = 0; i < this.listaMiembros.size(); i++) {
			if (nuevoMiembro.equals(this.listaMiembros.get(i))) {
				return false;
			}
		}
		this.listaMiembros.add(nuevoMiembro);
		this.numeroMiembros ++;
		return true;
	}
	public boolean borrarMiembro(Usuario borrarMiembro) {
		for (int i = 0; i < this.listaMiembros.size(); i++) {
			if (borrarMiembro.equals(this.listaMiembros.get(i))) {
				this.listaMiembros.remove(i);
				return true;
			}
		}
		return false;
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
	public ArrayList<Usuario> getListaMiembros() {
		return listaMiembros;
	}
	public void setListaMiembros(ArrayList<Usuario> listaMiembros) {
		this.listaMiembros = listaMiembros;
	}
	public int getNumeroMiembros() {
		return numeroMiembros;
	}
	public void setNumeroMiembros(int numeroMiembros) {
		this.numeroMiembros = numeroMiembros;
	}
}
