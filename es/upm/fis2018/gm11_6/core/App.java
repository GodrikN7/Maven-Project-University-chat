package es.upm.fis2018.gm11_6.core;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//USUARIOS PRUEBA
    	Usuario u0 = new Usuario("Jaime","apellido","Jaimito","jaime@upm.es","1234",0);
    	Usuario u1 = new Usuario("Raul","apellido","Rulo","raul@upm.es","1234",1);
    	Usuario u2 = new Usuario("Rick","Sanchez","Morty","rick@upm.es","1234",2);
    	
    	//AGENDAS USUARIOS PRUEBA
    	Agenda a0 = new Agenda("agenda0");
    	Agenda a1 = new Agenda("agenda1");
    	Agenda a2 = new Agenda("agenda2");
    	
    	//CONVERSACIONES DE PRUEBA
    	Conversacion c0 = new Conversacion(0 ,u0, u1);
    	Conversacion c1 = new Conversacion(1 ,u0, u2);
    	Conversacion c2 = new Conversacion(2 ,u2, u1);   
    	
    	//RELLENO DE MENSAJES EN CONVERSACIONES
    	c2.anyadirMensaje("Que pasaaaa ruloooo", u2);
    	c2.anyadirMensaje("Qué nota sacaste en FIS?", u2);
    	c2.anyadirMensaje("Bueno...", u1);
    	c2.anyadirMensaje("He sacado un 5 raspao", u1);
    	c2.anyadirMensaje("QUE HAS APROBADO COLEGUIIII!", u2);
    	
    	//VARIABLES
    	BaseDatos bd = new BaseDatos();
    	
    	//RELLENO DE AGENDAS
    	a2.addContacto(u0);
    	a2.addContacto(u1);
    	
    	//RELLENO DE USUARIOS
    	u0.anyadirAgenda(a0);
    	u0.anyadirAgenda(a1);
    	u2.anyadirAgenda(a2);    	
    
    	//RELLENO DE PRUEBA BD
        bd.registrarUsuario(u0);
        bd.registrarUsuario(u1);
        bd.registrarUsuario(u2);
        
        //CORREOS UPM PRUEBA
        bd.getCorreosUPMLibres().add("correolibre1@upm.es");
        bd.getCorreosUPMLibres().add("correolibre2@upm.es");
        bd.getCorreosUPMLibres().add("correolibre3@upm.es");
        
        //RELLENO DE CONVERSACIONES
        bd.anyadirConversacion(c0);
        bd.anyadirConversacion(c1);
        bd.anyadirConversacion(c2); 
        
        
        
             
        
        InterfazUsuario menu = new InterfazUsuario(bd);
        
        menu.principal();
        
        
    }
}