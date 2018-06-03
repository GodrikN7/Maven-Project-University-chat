package es.upm.fis2018.gm11_6.core;

import java.util.ArrayList;


public class BaseDatos{
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<String> correosUPM = new ArrayList<String>();
    private ArrayList<String> correosUPMLibres = new ArrayList<String>();
    int numeroUsuarios = 0;
    

	public BaseDatos(){

    }
	
	
	// ---- REGISTROS ----
    public void registrarUsuario(String nombre, String apellidos, String alias, String correo, String pass ){
    	if (this.existeCorreoUPM(correo)) {
    		int id = this.numeroUsuarios;
            usuarios.add(new Usuario(nombre, apellidos, alias, correo, pass, id));
            this.numeroUsuarios++;
            this.registrarCorreo(correo);            
    	} else {
    		System.out.println("ERROR - CORREO NO ENCONTRADO COMO CORREO VALIDO DE LA UPM");
    	}
        
    }
    public void registrarUsuario(Usuario user){
        usuarios.add(user);
        this.correosUPM.add(user.getCorreoUPM());
        this.numeroUsuarios++;
    }
    // BUSCA EL USER POR CORREO
    public Usuario buscarUsuarioPorCorreo (String correoB) {
    	for (int i = 0; i < this.usuarios.size(); i++) {
    		if(this.usuarios.get(i).getCorreoUPM().equals(correoB)) {
    			return this.usuarios.get(i);
    		}
    	}
    	return null;
    }
    
    // Buscar si existe correo de la upm dentro de la base de datos (para crear una cuenta)
    public boolean existeCorreoUPM (String correoN) {
    	for (int i = 0 ; i < this.correosUPMLibres.size(); i++) {
    		if (this.correosUPMLibres.get(i).equals(correoN)) {
    			return true;
    		}
    	}
    	return false;
    }
    //Registra el correo como correo Registrado en vez de ser un correo Libre
    public void registrarCorreo (String correoR) {
    	encontrarCorreo:
    		for (int i = 0 ; i < this.correosUPMLibres.size(); i++) {
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
    	for (int i = 0 ; i < this.correosUPM.size(); i++) {
    		System.out.print(this.correosUPM.get(i) + ", ");
    	}
    	System.out.print("]");
    	System.out.println();
    	System.out.println("Correos Libres: ");
    	System.out.print("[");
    	for (int i = 0 ; i < this.correosUPMLibres.size(); i++) {
    		System.out.print(this.correosUPMLibres.get(i) + ", ");
    	}
    	System.out.print("]");
    	System.out.println();
    	System.out.println("Usuarios registrados: ");
    	System.out.print("[");
    	for (int i = 0 ; i < this.usuarios.size(); i++) {
    		System.out.print(this.usuarios.get(i).getNombre() + " " + this.usuarios.get(i).getApellidos() + ", ");
    	}
    	System.out.print("]");
    	System.out.println();
    }
    
    //GETTERS AND SETTERS
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