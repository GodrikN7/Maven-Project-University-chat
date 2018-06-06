package es.upm.fis2018.gm11_6.core;

import java.util.Scanner;

public class InterfazUsuario {
	Scanner sc = new Scanner(System.in);
	BaseDatos bd;

	public InterfazUsuario(BaseDatos bd1) {
		this.bd = bd1;
	}

	public void principal() {
		int eleccion;
		do {
			System.out.println("---------------- MENU ----------------");
			System.out.println("[0] - Registro");
			System.out.println("[1] - Log in");
			System.out.println("[2] - Listar usuarios");
			System.out.println("[3] - Listar BD");
			System.out.println("[4] - SALIR");
			eleccion = sc.nextInt();
			switch (eleccion) {
			case 0:
				this.registrarUser();
				break;
			case 1:
				this.logear();
				break;
			case 2:
				this.listaUsuarios();
				break;
			case 3:
				bd.listarBaseDatos();
			}

		} while (eleccion != 4);
	}

	//
	public void logear() {
		int intentos = 0;
		Usuario usuarioEnc;
		String correo = "";
		String pass = "";

		System.out.print("correo:");
		correo = sc.next();
		usuarioEnc = bd.buscarUsuarioPorCorreo(correo); // busca users en la bd mediante el correo
		if (usuarioEnc == null) {
			System.out.println("CORREO '" + correo + "' NO ENCONTRADO");
		} else {
			do {
				System.out.println();
				System.out.print("password: ");
				pass = sc.next();
				System.out.println();
				intentos++;
			} while (!usuarioEnc.verificarLogin(correo, pass) && intentos < 3);
			if (usuarioEnc.verificarLogin(correo, pass)) {
				System.out
						.println("Logeado correctamente, " + usuarioEnc.getNombre() + " " + usuarioEnc.getApellidos());
				this.logeado(usuarioEnc);
			}
			if (intentos >= 3) {
				System.out.println("---- DEMASIADOS INTENTOS ----");
				System.exit(0);
			}
		}
	}

	public void registrarUser() {
		String nombre;
		String apellidos;
		String alias;
		String correo;
		String pass;
		System.out.print("nombre: ");
		nombre = sc.next();
		System.out.println();
		System.out.print("apellido: ");
		apellidos = sc.next();
		System.out.println();
		System.out.print("alias: ");
		alias = sc.next();
		System.out.println();
		System.out.print("correo: ");
		correo = sc.next();
		System.out.println();
		System.out.print("pass: ");
		pass = sc.next();
		System.out.println();
		bd.registrarUsuario(nombre, apellidos, alias, correo, pass);
	}

	public void listaUsuarios() {
		System.out.println("---------- LISTADO USUARIOS ----------");
		for (int i = 0; i < bd.getUsuarios().size(); i++) {
			System.out.println("[" + bd.getUsuarios().get(i).getIdUsuario() + "] - "
					+ bd.getUsuarios().get(i).getApellidos() + ", " + bd.getUsuarios().get(i).getNombre() + ". ALIAS: "
					+ bd.getUsuarios().get(i).getAlias());
		}
	}

	public void logeado(Usuario userLog) {
		int eleccion2;
		do {
			System.out.println("---------- Menu Usuario [" + userLog.getAlias() + "] ----------");
			System.out.println("[0] - Menu agendas");
			System.out.println("[1] - Menu conversacion");
			System.out.println("[2] - Listar usuarios");
			System.out.println("[3] - DESCONECTARSE");
			eleccion2 = sc.nextInt();
			switch (eleccion2) {
			case 0:
				this.menuAgendas(userLog);
				break;
			case 1:
				this.menuConversacion(userLog);
				break;
			}
		} while (eleccion2 != 3);

	}
	//MENU AGENDAS
	public void menuAgendas(Usuario userLog) {

		int eleccionAgendas;
		String nAgenda;
		do {
			System.out.println("------ Menu Agendas [" + userLog.getAlias() + "] ------");
			System.out.println("[0] - Mostrar Agendas");
			System.out.println("[1] - Crear Agenda");
			System.out.println("[2] - Editar Agendas"); // buscarlas por nombre
			System.out.println("[3] - Ver agenda favorita"); // buscar usuario por nombre
			System.out.println("[4] - DESCONECTARSE");
			eleccionAgendas = sc.nextInt();
			switch (eleccionAgendas) {
			case 0:
				for (int i = 0; i < userLog.getAgendasUsuario().size(); i++) {
					System.out.println("Agenda " + i + ": " + userLog.getAgendasUsuario().get(i).getNombre());
					if (userLog.getAgendasUsuario().get(i).getContactos().size() > 0) {
						System.out.println(
								"------ Contactos de [" + userLog.getAgendasUsuario().get(i).getNombre() + "] ------");
						userLog.getAgendasUsuario().get(i).mostrarContactos();
					}
				}
				break;
			case 1:
				System.out.println("Introduce el nombre de la agenda: ");
				nAgenda = sc.next();
				if (userLog.buscarAgendaPorNombre(nAgenda) != null) {
					System.out.println("Agenda ya existente");
				} else
					userLog.getAgendasUsuario().add(new Agenda(nAgenda));
				break;
			case 2:
				Agenda agendaEnc;
				for (int i = 0; i < userLog.getAgendasUsuario().size(); i++) {
					System.out.println(userLog.getAgendasUsuario().get(i).getNombre());
				}
				System.out.println("Nombre de la agenda a editar: ");
				nAgenda = sc.next();
				agendaEnc = userLog.buscarAgendaPorNombre(nAgenda);
				if (agendaEnc == null) {
					System.out.println("Agenda no encontrada");
				} else {
					System.out.println("Agenda encontrada");
					this.menuEditorAgenda(agendaEnc, userLog);
				}
				break;
			case 3:
				if (userLog.getAgendaFavorita() != " ") {
					Agenda agendaFav = userLog.buscarAgendaPorNombre(userLog.getAgendaFavorita());
					System.out.println("Agenda [" + agendaFav.getNombre() + "]");
					System.out
							.println("Categorias de [" + agendaFav.getNombre() + "]:" + agendaFav.mostrarCategorias());
					System.out.println("Contactos de [" + agendaFav.getNombre() + "]");
					agendaFav.mostrarContactos();
				} else
					System.out.println("No hay agenda favorita");
				break;
			}
		} while (eleccionAgendas != 4);

	}

	public void menuEditorAgenda(Agenda agendaEnc, Usuario userLog) {
		int eleccionEditorAgenda;
		do {
			System.out.println("------ Editor de agenda: [" + agendaEnc.getNombre() + "] ------");
			System.out.println("[0] - Cambiar nombre");
			System.out.println(
					"[1] - Marcar como favorita - Agenda favorita actual: [" + userLog.getAgendaFavorita() + "]");
			System.out.println("[2] - Añadir contacto"); // buscarlas por nombre
			System.out.println("[3] - Editar categorias - Categorias actuales: " + agendaEnc.mostrarCategorias());
			System.out.println("[4] - Salir del editor");
			eleccionEditorAgenda = sc.nextInt();
			switch (eleccionEditorAgenda) {
			case 0:
				String nombreAgenda;
				System.out.println("Nuevo nombre: ");
				nombreAgenda = sc.next();
				agendaEnc.setNombre(nombreAgenda);
				break;
			case 1:
				userLog.setAgendaFavorita(agendaEnc.getNombre());
				break;
			case 2:
				String correoContacto;
				Usuario nuevoContacto;
				System.out.println("Escribe el correo del contacto que quieres agregar: ");
				correoContacto = sc.next();
				nuevoContacto = bd.buscarUsuarioPorCorreo(correoContacto);
				if (nuevoContacto != null) {
					agendaEnc.getContactos().add(nuevoContacto);
				} else
					System.out.println("Usuario no encontrado");
				break;
			case 3:
				this.menuCategorias(agendaEnc);
				break;
			}
		} while (eleccionEditorAgenda != 4);
	}

	public void menuCategorias(Agenda agendaEnc) {
		int eleccionCategoria;
		do {
			System.out.println("---- Editor de categorias: [" + agendaEnc.getNombre() + "] ----");
			System.out.println("[0] - Añadir Categoria");
			System.out.println("[1] - Borrar categoria");
			System.out.println("[2] - Salir de editor de categorias");
			eleccionCategoria = sc.nextInt();
			switch (eleccionCategoria) {
			case 0:
				String nCategoria;
				System.out.println("Nombre de la nueva categoria: ");
				nCategoria = sc.next();
				agendaEnc.getCategoria().add(nCategoria);
				break;
			case 1:
				String bCategoria;
				System.out.println("Nombre de categoria a eliminar: ");
				bCategoria = sc.next();
				if (agendaEnc.borrarCategoria(bCategoria)) {
					System.out.println("Categoria [" + bCategoria + "] eliminada exitosamente.");
				} else
					System.out.println("ERROR - Categoria [" + bCategoria + "] no encontrada");
				break;
			}

		} while (eleccionCategoria != 2);
	}
	//CONVERSACIONES
	public void menuConversacion (Usuario userLog) {
		int eleccionMenuConversacion;
		do {
			System.out.println("---- Menu Conversacion: [" + userLog.getAlias() + "] ----");
			System.out.println("[0] - Empezar conversacion");
			System.out.println("[1] - Ver conversaciones iniciadas");
			System.out.println("[2] - Borrar conversacion -- WIP");
			System.out.println("[3] - Entrar en conversacion");
			System.out.println("[4] - Salir de menu conversacion");
			eleccionMenuConversacion = sc.nextInt();
			switch (eleccionMenuConversacion) {
			case 0:
				String correoReceptor;
				Usuario contactoRec;
				Conversacion nuevaConversacion;
				System.out.println("Escribe el correo del contacto con el que quieres conversar: ");
				correoReceptor = sc.next();
				contactoRec = bd.buscarUsuarioPorCorreo(correoReceptor);
				if (contactoRec != null) {
					nuevaConversacion = new Conversacion(bd.getNumeroConversaciones(), userLog, contactoRec);
					bd.anyadirConversacion(nuevaConversacion);
					System.out.println("Conversacion iniciada con '" + contactoRec.getCorreoUPM() + "'");
				} else
					System.out.println("Usuario no encontrado");
				break;
			case 1:
				if (userLog.getConversacionesPart().size() > 0) {
					userLog.mostrarConversaciones();
				} else System.out.println("No tienes conversaciones activas");				
				break;
			case 2:
//				if (userLog.getConversacionesPart().size() > 0) {
//					int iBorrarC;
//					userLog.mostrarConversaciones();
//					System.out.println("Conversacion a borrar: ");
//					iBorrarC = sc.nextInt();
//				} else System.out.println("No tienes conversaciones activas");				
				break;
			case 3:
				if (userLog.getConversacionesPart().size() > 0) {
					int entrarId;
					Conversacion conversacionEnc;
					userLog.mostrarConversaciones();
					System.out.println("Id de conversacion a entrar: ");
					entrarId = sc.nextInt();
					conversacionEnc = bd.encontrarConversacion(entrarId);
					if (conversacionEnc != null) {
						if (userLog.entrarConversacion(bd.getConversaciones().get(entrarId))) {
							this.conversacionEncontrada(userLog, conversacionEnc);
						} else System.out.println("Esa conversacion asociada a ese id no te pertenece.");
					} else System.out.println("Conversacion no encontrada");
					
				} else System.out.println("No tienes conversaciones activas");
				break;
			}

		} while (eleccionMenuConversacion != 4);		
	}
	public void conversacionEncontrada (Usuario userLog, Conversacion conversacionEnc) {
		int eleccionConvEnc;
		do {
			System.out.println("---- Conversacion: [" + conversacionEnc.getEmisor().getCorreoUPM() + " - " + conversacionEnc.getReceptor().getCorreoUPM() +  "] ----");
			System.out.println("[0] - Mostrar Mensajes");
			System.out.println("[1] - Borrar mensaje -- WIP");
			System.out.println("[2] - Salir de conversacion");
			eleccionConvEnc = sc.nextInt();
			switch (eleccionConvEnc) {
			case 0:
				if (!conversacionEnc.getListaMensajes().isEmpty()) {
					conversacionEnc.mostrarMensajes();
				} else System.out.println("No hay mensajes en esta conversacion");
				break;
			case 1:
				
				break;
			}

		} while (eleccionConvEnc != 2);
	}
}