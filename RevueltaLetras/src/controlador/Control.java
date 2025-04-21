package controlador;

import modelo.Tablero;
import vista.Interfaz;

/**
 * Clase que almacena la ejecución principal del programa.
 * Se encarga de establecer la conexión entre los paquetes de vista y modelo.
 * @author Mario Delgado Ruiz.
 */
public class Control {

	private Tablero logica;
	private Interfaz vista;
	
	/**
	 * Constructor donde se inicializa una instancia de la clase Interfaz.
	 * Como la clase control funciona únicamente como método de conexión y van a ser necesarias las instancias de cada clase,
	 * tiene más sentido que se incluyan como atributos de la clase.
	 */
	public Control() {
		vista = new Interfaz();
		// el atributo logica no se inicializa en el constructor porque necesita información recogida desde la vista
	}
	
	/**
	 * Inicia la ejecución del programa.
	 * Mantiene la ejecución y flujo principal del programa.
	 * Mantiene y controla la conexión entre las clases Interfaz y Tablero, funcionando como intermediario.
	 */
	public void start() {
		
		String[] infoInicio = new String[3];
		boolean continuar = true;
		boolean intercambio = true;
		boolean pedirPista, haGanado, seguirJugando, movAleatorio;
		int pistasRestantes, verRanking;
		int[] posiciones;
		String tablero, pista, ranking;
		
		infoInicio = vista.inicioJuego();
		
		logica = new Tablero(infoInicio[0], infoInicio[1], infoInicio[2]);
//		logica.setPorcentajePrueba(99);
		do {
			
			tablero = logica.toString();
			vista.mostrarTablero(tablero);
			
			pistasRestantes = logica.getPistasJugador();
			
			if (intercambio && pistasRestantes > 0) {
				pedirPista = vista.preguntarPista(pistasRestantes);
				
				if (pedirPista) {
					
					pista = logica.pedirPista();
					vista.mostrarPista(pista);
				}
			}
			
			posiciones = vista.getPosiciones();
			intercambio = logica.intercambiarCaracter(posiciones);
			
			if (!intercambio) {
				
				vista.informarSobreJugada();
				
			} else {
				
//				movAleatorio = logica.moverLetraAleatoria();
				
//				if(movAleatorio)
//					vista.informarMovimientoRandom();
				
				haGanado = logica.comprobarGanador();
//				logica.aumentarUnPorc();
				
				if (haGanado) {
					
					tablero = logica.toString();
					vista.mostrarTablero(tablero);
					
					seguirJugando = vista.informarPartidaGanada();
					
					verRanking = vista.preguntarRanking(1);
					
					while (verRanking != 3) {
					
						ranking = logica.pedirRanking(verRanking);
						vista.mostrarRanking(ranking);
						verRanking = vista.preguntarRanking(2);
						vista.consumirScanner();
					}
					
					if (seguirJugando) {
						
						infoInicio = vista.reinicioJuego(infoInicio);
						logica.resetTablero(infoInicio[1], infoInicio[2]);
//						logica.setPorcentajePrueba(99);
					} else {
						
						vista.gameOver();
						continuar = false;
					}
				}
			}
			
			
			
		} while (continuar);
		
	}
}
