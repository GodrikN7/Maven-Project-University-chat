
package es.upm.fis2018.gm11_6.core;

import java.util.ArrayList;
import java.lang.String;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : GM21 6
//  @ File Name : Agendade contactos.java
//  @ Date : 23/05/2018
//  @ Author :
//
//

public class Agenda {
	private String nombre;
	private ArrayList<String> listaCategoria = new ArrayList<String>();
	private ArrayList<Usuario> listaContactos = new ArrayList<Usuario>();

	Agenda(String nombre) {
		this.nombre = nombre;
	}

	public Agenda(String nombre, ArrayList<Usuario> listaContactos, ArrayList<String> listaCategoria) {
		this.nombre = nombre;
		this.listaContactos = listaContactos;
		this.listaCategoria = listaCategoria;
	}

	public void addContacto(Usuario contacto) {
		this.listaContactos.add(contacto); // usuario a contactos
	}

	public void mostrarContactos() {
		// recorrer lista usuarios (contactos) y mostrarlos
		for (int i = 0; i < this.listaContactos.size(); i++) {
			System.out.println(this.listaContactos.get(i).mostrarDatos());
		}
	}

	public String mostrarCategorias() {
		String categorias;
		if (this.listaCategoria.isEmpty()) {
			categorias = "Sin categoria/s";
		} else {
			categorias = "[";
			for (int i = 0; i < this.listaCategoria.size(); i++) {
				categorias =  categorias + this.listaCategoria.get(i) + " ";
			}
			categorias = categorias + "]";
		}
		return categorias;		
	}
	
	public boolean borrarCategoria(String bCategoria) {
		for (int i = 0; i < this.listaCategoria.size(); i++) {
			if (bCategoria.equals(this.listaCategoria.get(i))){
				this.listaCategoria.remove(i);
				return true;
			}
		}
		return false;
	}
	
	// GETTERS AND SETTERS
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getCategoria() {
		return this.listaCategoria;
	}

	public void setCategoria(ArrayList<String> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public ArrayList<Usuario> getContactos() {
		return listaContactos;
	}

	public void setContactos(ArrayList<Usuario> listaContactos) {
		this.listaContactos = listaContactos;
	}

}