package es.upm.fis2018.gm11_6.core;

import java.util.ArrayList;

public class BaseDatos {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<String> correosUPM = new ArrayList<String>();
	private ArrayList<String> correosUPMLibres = new ArrayList<String>();
	private ArrayList<Conversacion> conversaciones = new ArrayList<Conversacion>();
	private int numeroConversaciones = 0;
	int numeroUsuarios = 0;

	public BaseDatos() {

	}

	// ---- REGISTROS ----
	public void registrarUsuario(String nombre, String apellidos, String alias, String correo, String pass) {
		if (this.existeCorreoUPM(correo)) {
			int id = this.numeroUsuarios;
			usuarios.add(new Usuario(nombre, apellidos, alias, correo, pass, id));
			this.numeroUsuarios++;
			this.registrarCorreo(correo);
		} else {
			System.out.println("ERROR - CORREO NO ENCONTRADO COMO CORREO VALIDO DE LA UPM");
		}

	}

	public void registrarUsuario(Usuario user) {
		usuarios.add(user);
		this.correosUPM.add(user.getCorreoUPM());
		this.numeroUsuarios++;
	}

	// BUSCA EL USER POR CORREO
	public Usuario buscarUsuarioPorCorreo(String correoB) {
		for (int i = 0; i < this.usuarios.size(); i++) {
			if (this.usuarios.get(i).getCorreoUPM().equals(correoB)) {
				return this.usuarios.get(i);
			}
		}
		return null;
	}

	// Buscar si existe correo de la upm dentro de la base de datos (para crear una
	// cuenta)
	public boolean existeCorreoUPM(String correoN) {
		for (int i = 0; i < this.correosUPMLibres.size(); i++) {
			if (this.correosUPMLibres.get(i).equals(correoN)) {
				return true;
			}
		}
		return false;
	}

	// Registra el correo como correo Registrado en vez de ser un correo Libre
	public void registrarCorreo(String correoR) {
		encontrarCorreo: for (int i = 0; i < this.correosUPMLibres.size(); i++) {
			if (this.correosUPMLibres.get(i).equals(correoR)) {
				this.correosUPMLibres.remove(i);
				this.correosUPM.add(correoR);
				break encontrarCorreo;
			}
		}
	}

	public void listarBaseDatos() {
		System.out.println("Correos Registrados: ");
		System.out.print("[");
		for (int i = 0; i < this.correosUPM.size(); i++) {
			System.out.print(this.correosUPM.get(i) + ", ");
		}
		System.out.print("]");
		System.out.println();
		System.out.println("Correos Libres: ");
		System.out.print("[");
		for (int i = 0; i < this.correosUPMLibres.size(); i++) {
			System.out.print(this.correosUPMLibres.get(i) + ", ");
		}
		System.out.print("]");
		System.out.println();
		System.out.println("Usuarios registrados: ");
		System.out.print("[");
		for (int i = 0; i < this.usuarios.size(); i++) {
			System.out.print(this.usuarios.get(i).getNombre() + " " + this.usuarios.get(i).getApellidos() + ", ");
		}
		System.out.print("]");
		System.out.println();
		System.out.println("Conversaciones registradas: ");
		for (int i = 0; i < this.conversaciones.size(); i++) {
			System.out.println("[" + this.conversaciones.get(i).getIdConversacion() + "]: Emisor("
					+ this.conversaciones.get(i).getEmisor().getCorreoUPM() + ") - Receptor("
					+ this.conversaciones.get(i).getReceptor().getCorreoUPM() + ")");
		}
		System.out.println();
	}

	// CONVERSACIONES

	public void anyadirConversacion(Conversacion conv) {
		this.conversaciones.add(conv);
		this.numeroConversaciones++;
		conv.getEmisor().getConversacionesPart().add(conv);
		conv.getReceptor().getConversacionesPart().add(conv);
	}

	// busca una conversacion por el id
	public Conversacion encontrarConversacion(int id) {
		for (int i = 0; i < this.conversaciones.size(); i++) {
			if (id == this.conversaciones.get(i).getIdConversacion()) {
				return this.conversaciones.get(i);
			}
		}
		return null;
	}

	public boolean borrarConversacion(Conversacion conversacionEnc, Usuario userConv, Usuario userConv2) {
		for (int i = 0; i < this.conversaciones.size(); i++) {
			if (conversacionEnc.equals(this.conversaciones.get(i))) {
				this.conversaciones.remove(i);
				for (int j = 0; j < userConv.getConversacionesPart().size(); j++) {
					if (userConv.getConversacionesPart().get(j).equals(conversacionEnc)) {
						userConv.getConversacionesPart().remove(j);
						for (int x = 0; x < userConv2.getConversacionesPart().size(); x++) {
							if (userConv2.getConversacionesPart().get(x).equals(conversacionEnc)) {
								userConv.getConversacionesPart().remove(x);
								return true;
							}
						}
					}

				}
			}
		}

		return false;
	}

	public int getNumeroConversaciones() {
		return numeroConversaciones;
	}

	public void setNumeroConversaciones(int numeroConversaciones) {
		this.numeroConversaciones = numeroConversaciones;
	}

	public ArrayList<Conversacion> getConversaciones() {
		return conversaciones;
	}

	public void setConversaciones(ArrayList<Conversacion> conversaciones) {
		this.conversaciones = conversaciones;
	}

	// GETTERS AND SETTERS
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> nusuarios) {
		usuarios = nusuarios;
	}

	public int getNumeroUsuarios() {
		return numeroUsuarios;
	}

	public void setNumeroUsuarios(int numeroUsuarios) {
		this.numeroUsuarios = numeroUsuarios;
	}

	public ArrayList<String> getCorreosUPM() {
		return correosUPM;
	}

	public void setCorreosUPM(ArrayList<String> correosUPM) {
		this.correosUPM = correosUPM;
	}

	public ArrayList<String> getCorreosUPMLibres() {
		return correosUPMLibres;
	}

	public void setCorreosUPMLibres(ArrayList<String> correosUPMLibres) {
		this.correosUPMLibres = correosUPMLibres;
	}

}