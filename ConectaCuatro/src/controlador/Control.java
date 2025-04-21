package controlador;

import modelo.Tablero;
import vista.Interfaz;

/**
 * Clase que almacena la ejecución principal del programa.
 * Se encarga de establecer la conexión entre los paquetes de vista y modelo.
 * @author Mario Delgado Ruiz.
 */
public class Control {

	/**
	 * Constructor vacío y por defecto de la clase.
	 */
	public Control() {
		// Constructor por defecto debido a que esta clase se usa únicamente para ejecutar el bucle principal del programa
	}
	
	/**
	 * Inicia la ejecución del programa.
	 * Mantiene la ejecución y flujo principal del programa.
	 * Mantiene y controla la conexión entre las clases Interfaz y Tablero, funcionando como intermediario.
	 */
	public void start() {
		
		Tablero logica = new Tablero();
		Interfaz interfaz = new Interfaz();
		
		boolean hayGanador = false;
		boolean empate = false;
		boolean resetGame = false;
		String tablero, victorias, jugadorActual, turno;
		String[] asignaciones;
		int size, col, jugar, numJugadores, oldNumJugadores;
		
		interfaz.darBienvenida();
		
		numJugadores = interfaz.getNumJugadores(true);
		size = interfaz.getSizeTablero(true);
		
		logica.setTableroSize(size);
		
		String[] playersInfo = interfaz.elegirJugadores(numJugadores);
		
		asignaciones = logica.asignarJugadores(playersInfo, numJugadores);
		
		interfaz.mostrarAsignaciones(asignaciones);
		
		tablero = logica.toString();
		
		interfaz.mostrarTablero(tablero);
		
		do {
			
			turno = logica.mostrarTurnoDe();
			interfaz.mostrarTurnoDe(turno);
			
			jugadorActual = logica.getJugadorActual();
			
			if (numJugadores == 1 && jugadorActual.equals("MÁQUINA")) { // Juega la máquina
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				jugar = logica.maquinaJuega();
				
			} else { // Juega uno de los dos jugadores (sin uso de la máquina)
				
				col = interfaz.getColumna(jugadorActual);
				
				jugar = logica.jugar(col);
			}
			
			if (jugar == -1) {
				
				interfaz.informar(jugar, "");
				
			} else {
				
				interfaz.limpiarConsola();
				tablero = logica.toString();
				interfaz.mostrarTablero(tablero);
				
				if (jugar == 0) {
				
					empate = logica.continuarJuego();
					
					if (empate)
						interfaz.informar(jugar, "");
					
				} else if (jugar == 1) {
					
					interfaz.informar(jugar, jugadorActual);
					
					victorias = logica.getVictorias();
					interfaz.mostrarVictorias(victorias);
					
					hayGanador = true;
				}
			}
			
			if(hayGanador || empate) {
				
				resetGame = interfaz.empezarDeNuevo();
				
				if (!resetGame) {
					
					oldNumJugadores = numJugadores;
					numJugadores = interfaz.getNumJugadores(false);
					playersInfo = interfaz.reasignarNombres(numJugadores, oldNumJugadores);
					size = interfaz.getSizeTablero(false);
					
					if (size != 0)
						logica.setTableroSize(size);
					
					logica.resetTablero(numJugadores, oldNumJugadores);
					
					if (playersInfo != null) {
						
						asignaciones = logica.asignarJugadores(playersInfo, numJugadores);
						interfaz.mostrarAsignaciones(asignaciones);
					}
					
					tablero = logica.toString();
					interfaz.mostrarTablero(tablero);
					hayGanador = false;
					empate = false;
					
				} else {
					
					victorias = logica.getVictorias();
					interfaz.informar(2, victorias);
				
				}
			}
			
		} while (!resetGame);
		
	}
}
