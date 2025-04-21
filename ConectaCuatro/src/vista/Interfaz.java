package vista;

import java.util.Scanner;

/**
 * Clase que se encarga de establecer la comunicación con el usuario,
 * mostrando y pidiendo información al usuario.
 * @author Mario Delgado Ruiz.
 */
public class Interfaz {

	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructor vacío y por defecto de la clase.
	 */
	public Interfaz() {
		// Constructor por defecto porque esta clase no necesita de atributos, sirve únicamente como medio de comunicación con el usuario/s
	}
	
	/**
	 * Método que muestra el estado actual del tablero
	 * @param tablero, parámetro que contiene el tablero formado.
	 */
	public void mostrarTablero(String tablero) {
		
		System.out.println(tablero);
		
	}
	
	/**
	 * Método que da la bienvenida al usuario y presenta el funcionamiento del juego.
	 */
	public void darBienvenida() {
		
		System.out.println("\n-----------------------------------------");
		System.out.println("\n******* ¡BIENVENIDOS A CONECTA 4! *******\n");
		System.out.println("-----------------------------------------\n");
		
		/*
		 * Utiliza el método para pausar el código durante 1.5 segundos entre conjuntos de frases
		 * para presentar la información poco a poco y no de golpe.
		 */
		sleep(1800);
		
		System.out.println("Un juego de 1 vs. 1 donde sólo puede haber un ganador.\n"
				+ "O ninguno en caso de quedar en empate.\n");
		
		sleep(1800);
		
		System.out.println("Podrás jugar contra otro jugador desde el mismo ordenador o jugar contra la máquina.\n");
		
		sleep(1800);
		
		System.out.println("Se trata de un juego por turnos, colocando una ficha cada vez indicando únicamente la columna donde se desea colocar.\n");
		
		sleep(1800);
		
		System.out.println("Durante el juego verás un tablero con casillas vacías y casillas ocupadas por alguna ficha.");
		System.out.println("Los espacios vacíos está indicados por un guión colocado entre dos barras verticales, como esto: | - |");
		System.out.println("Las casillas ocupadas estarán indicadas por la ficha de alguno de los jugadores, ya sea una 'X' o una 'O'.");
		
		sleep(1800);
		
		System.out.println("Empecemos pues. ¡Buena suerte!\n");
		System.out.println("----------------------------------------------------------------\n");
	}
	
	/**
	 * Método que sirve para pausar la ejecución del programa durante un tiempo determinado.
	 * @param num, indica el número (en milisegundos) que se pausará la ejecución.
	 */
	private void sleep(int num) {
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que pregunta al usuario el modo de juego a elegir: juego contra la máquina o juego de dos jugadores en el mismo ordenador.
	 * @param primeraVez, guarda un valor booleano para indicar si es la primera vez o no que se usa este método.
	 * @return numJugadores, guarda el total de jugadores (usuarios) que jugarán durante la partida.
	 */
	public int getNumJugadores(boolean primeraVez) {
		
		String input = "";
		int numJugadores = 0;
		boolean valido = false;
		
		if (primeraVez)
			System.out.println("¿Quieres jugar contra la máquina o prefieres jugar contra otro jugador desde el mismo ordenador?\n");
		else
			System.out.println("¿Quieres cambiar tu oponente en esta partida? Puedes jugar contra la máquina o contra otro jugador desde el mismo ordenador.\n");
		
		System.out.println("Elige una de estas dos opciones:\n"
				+ "\t - (1) Contra la máquina\n"
				+ "\t - (2) Contra otro jugador.\n\n"
				+ "Debes introducir 1 o 2:");
		
		while (!valido) {
			
			input = sc.nextLine();
			
			if (input.length() == 1 && (input.charAt(0) == 49 || input.charAt(0) == 50)) {
				
				numJugadores = input.charAt(0) - '0';
				valido = true;
				
			} else {
				
				System.out.println("Revisa el valor introducido. Debes introducir un único dígito y una de las opciones disponibles (1 o 2). Vuelve a insertarlo:");
			}
		}
		
		return numJugadores;
	}

	/**
	 * Recoge el tamaño del tablero introducido por el usuario.
	 * @param primeraVez, permite elegir qué parte del código se ejecutará, en función de si es una primera partida o no.
	 * @return tablero, permite conocer el tamaño del tablero elegido por el usuario.
	 */
	public int getSizeTablero(boolean primeraVez) {
		
		String input = "";
		int tablero = 0;
		boolean valido = false;
		
		if (primeraVez) {
			System.out.println("¿Qué tamaño de tablero quieres para jugar?");
			System.out.println("Hay 3 tamaños diferentes para el tablero:\n" +
					"\t1 -> 6 x 7 (42 casillas)\n" +
					"\t2 -> 7 x 8 (56 casillas)\n" +
					"\t3 -> 8 x 9 (72 casillas)\n");
			System.out.println("¿Qué tamaño quieres: 6 x 7 (1), 7 x 8 (2), o 8 x 9 (3)? Elegid 1, 2 o 3:");
			
			while (!valido) {
				
				input = sc.nextLine();
				
				if (input.length() == 1 && (input.charAt(0) >= 49 && input.charAt(0) <= 51)) {
					
					tablero = input.charAt(0) - '0';
					valido = true;
					
				} else {
					
					System.out.println("Revisad el valor que habéis introducido. Debéis introducir un único dígito (1, 2 o 3). Volved a insertarlo:");
				}
			}
			
		} else {
			
			boolean validSize = false;
			System.out.println("¿Quieres cambiar el tamaño del tablero a otro? Elige 'S' para cambiar el tablero o 'N' para mantener el tablero actual:");
			
			// Se usa un bucle while y un input de tipo String para evitar errores o detención de la ejecución del programa
			while(!valido) {
				
				input = sc.nextLine();
				
				if (input.length() == 1 && (input.charAt(0) == 'S' || input.charAt(0) == 's')) {
					
					System.out.println("Hay 3 tamaños diferentes para el tablero:\n" +
							"\t1 -> 6 x 7 (42 casillas)\n" +
							"\t2 -> 7 x 8 (56 casillas)\n" +
							"\t3 -> 8 x 9 (72 casillas)\n");
					System.out.println("¿Qué tamaño quieres: 6 x 7 (1), 7 x 8 (2), o 8 x 9 (3)? Elige 1, 2 o 3:");
					
					while (!validSize) {
						
						input = sc.nextLine();
						
						if (input.length() == 1 && (input.charAt(0) >= 49 && input.charAt(0) <= 51)) {
						
							System.out.println("El tamaño del tablero ha sido modificado.\n");
							tablero = input.charAt(0) - '0';
							validSize = true;
							valido = true;
						
						} else {
							
							System.out.println("Revisa el valor que has introducido. Debes introducir un único dígito (1, 2 o 3). Vuelve a insertarlo:");
						}
					}
					
				} else if (input.length() == 1 && (input.charAt(0) == 'N' || input.charAt(0) == 'n')) {
					
					System.out.println("El tamaño del tablero se mantiene.");
					System.out.println("\n-----------------------------------");
					System.out.println("******* COMENCEMOS DE NUEVO *******");
					System.out.println("-----------------------------------\n");
					valido = true;
					tablero = 0;
					
				} else {
					
					System.out.println("Revisa el valor que has introducido. Debes introducir un único carácter o letra (S / N). Vuelve a insertarlo:");
					
				}
			}
		}
		
		return tablero;
	}

	/**
	 * Permite a los jugadores elegir el nombre que quieran tener durante la ejecución del programa.
	 * En función del número de jugadores, se pregunta un solo nombre o dos.
	 * @param numJugadores, guarda el total de jugadores (usuarios) que jugarán durante la partida.
	 * @return v, sirve para guardar en un array los nombres de ambos jugadores, contando como jugador a la máquina en caso necesario.
	 */
	public String[] elegirJugadores(int numJugadores) {
		
		String[] v = new String[2];
		String playerOne;
		String playerTwo;
		boolean valido = false;
		
		if(numJugadores == 1) {
			
			System.out.println("Vamos a recoger tu nombre para guardarlo durante la partida.\n");
			System.out.println("Elija un nombre de usuario:");
			
			while(!valido) {
				
				playerOne = sc.nextLine();
			
				if (playerOne.length() >= 1 && playerOne.charAt(0) != ' ' && (!playerOne.equals("Máquina") && !playerOne.equals("máquina"))) {
					
					v[0] = playerOne;
					valido = true;
					
				} else {
					System.out.println(" +------------------------------------------------------------------------------+");
					System.out.println(" | Revisa el nombre introducido.                                                |");
					System.out.println(" | Debe tener al menos un carácter y no debe comenzar con un espacio en blanco. |");
					System.out.println(" | El nombre 'Máquina' no está disponible, ya que es un nombre reservado.       |");
					System.out.println(" | Vuelve a introducirlo:                                                       |");
					System.out.println(" +------------------------------------------------------------------------------+");
				}
			}
			
			v[1] = "Máquina";
			
		} else {
			
			System.out.println("Vamos a recoger vuestros nombres para guardarlos durante la partida.\n");
			
			System.out.println("Primer jugador, elija un nombre:");
			
			while(!valido) {
				
				playerOne = sc.nextLine();
			
				if (playerOne.length() >= 1 && playerOne.charAt(0) != ' ') {
					
					v[0] = playerOne;
					valido = true;
					
				} else {
					
					System.out.println(" +------------------------------------------------------------------------------+");
					System.out.println(" | Primer Jugador, revisa el nombre introducido.                                |");
					System.out.println(" | Debe tener al menos un carácter y no debe comenzar con un espacio en blanco. |");
					System.out.println(" | Vuelve a introducirlo:                                                       |");
					System.out.println(" +------------------------------------------------------------------------------+");
				}
			}
			
			valido = false;
			System.out.println("Segundo jugador, elija un nombre:");
			
			while(!valido) {
				
				playerTwo = sc.nextLine();
			
				if (playerTwo.length() >= 1 && playerTwo.charAt(0) != ' ') {
					
					v[1] = playerTwo;
					valido = true;
					
				} else {
					
					System.out.println(" +------------------------------------------------------------------------------+");
					System.out.println(" | Segundo Jugador, revisa el nombre introducido.                               |");
					System.out.println(" | Debe tener al menos un carácter y no debe comenzar con un espacio en blanco. |");
					System.out.println(" | Vuelve a introducirlo:                                                       |");
					System.out.println(" +------------------------------------------------------------------------------+");
				}
			}
		}
		
		return v;
	}

	/**
	 * Muestra al usuario su nombre de jugador, la ficha que le ha tocado y si juega en primer o segundo lugar.
	 * @param asignaciones, contiene un array con las asignaciones de nombre y tipo de ficha con la que jugará cada jugador.
	 */
	public void mostrarAsignaciones(String[] asignaciones) {
		
		System.out.println("\n" + asignaciones[0] + "\n");
		System.out.println(asignaciones[1] + "\n");
		
	}

	/**
	 * Recoge el valor (columna) del tablero donde el usuario quiere introducir su ficha.
	 * @param jugadorActual, sirve para mostrar a los jugadores de quién es el turno para jugar.
	 * @return col, guarda la columna (valor) introducida por el usuario.
	 */
	public int getColumna(String jugadorActual) {
		
		System.out.println("\nJugador '" + jugadorActual + "', introduce la columna donde desea poner su ficha.\n");
		String input = "";
		int col = 0;
		boolean valido = false;
		
		while (!valido) {
			
			input = sc.nextLine();
			
			/*
			 *  El tablero varía en longitud de 7 a 9, por lo que permite introducir valores del 0 al 9.
			 *  En caso de ser incorrecto, por ejemplo introduciendo un valor 9 cuando la longitud del tablero es 7,
			 *  la lógica se encargará de manejarlo y actuar en consecuencia.
			 */
			if (input.length() == 1 && (input.charAt(0) >= 48 && input.charAt(0) <= 57)) {
				
				col = input.charAt(0) - '0';
				valido = true;
				
			} else {
				
				System.out.println("Revisa el valor que has introducido. Sólo se permite un solo dígito (0 a 9). Vuelve a introducirlo:");
			}
		}
		
		return col;
	}

	/**
	 * Informa al usuario sobre diferentes situaciones en función de los parámetros.
	 * @param valor, sirve para manejar el tipo de mensaje que verá el usuario en función de la situación.
	 * @param mensaje, guarda un mensaje específico para el jugador dependiendo del contexto dado.
	 */
	public void informar(int valor, String mensaje) {

		if (valor == -1) {
			
			System.out.println(" +-------------------------------------------------------------------------------------+");
			System.out.println(" | Has elegido una columna que no existe o esa columna ya está llena. Prueba de nuevo. |");
			System.out.println(" +-------------------------------------------------------------------------------------+");
		
		} else if (valor == 1) {
			
			String linea = "";
			
			if(mensaje.equals("MÁQUINA")) {
				
				for (int i = 0; i < 67 + mensaje.length(); i++) {
					linea += "-";
				}
				
				System.out.println("\n" + linea);
				
				System.out.println("\n****** ¡MALA SUERTE JUGADOR! ¡LA " + mensaje + " TE HA GANADO ESTA PARTIDA! ******\n");
				
			} else {
				
				for (int i = 0; i < 53 + mensaje.length(); i++) {
					linea += "-";
				}
				
				System.out.println("\n" + linea);
				
				System.out.println("\n****** ¡ENHORABUENA, " + mensaje + "! ¡HAS GANADO LA PARTIDA! ******\n");
			}
			
			System.out.println(linea + "\n");
		
		} else if ( valor == 0) {
			
			System.out.println("\n +----------------------------------------------------------+");
			System.out.println(" | ****** ¡HA HABIDO EMPATE! NADIE GANA ESTA PARTIDA ****** |");
			System.out.println(" +----------------------------------------------------------+\n");
		
		} else {
			
			System.out.println("\n +---------------------------------+");
			System.out.println(" | ****** GRACIAS POR JUGAR ****** |");
			System.out.println(" +---------------------------------+\n");
			
			System.out.println("+++++++ VICTORIAS TOTALES POR JUGADOR +++++++");
			mostrarVictorias(mensaje);
			
		}
	}

	/**
	 * Limpia la salida de la consola para que el tablero siempre se muestre en la parte superior.
	 * En el IDE de Eclipse no funciona, aunque sí en la consola de Windows.
	 * No realiza una limpieza como tal, sino que mueve todo el contenido de la consola hacia arriba, como imprimir varios saltos de línea.
	 */
	public void limpiarConsola() {
		
		System.out.print("\033[H\033[2J");  
	    System.out.flush();
		
	}

	/**
	 * Pregunta al usuario si desea volver a comenzar una nueva partida tras terminar la anterior.
	 * Recoge un valor del usuario que indica si el juego será reiniciado o no.
	 * @return parar, recoge el valor del usuario para reiniciar el juego o detener la ejecución del programa.
	 */
	public boolean empezarDeNuevo() {
		
		boolean parar = false;
		boolean valido = false;
		String choice;
		
		System.out.println("¿Quieres volver a jugar? (S) Sí / (N) No. Elige 'S' o 'N'");
		
		while (!valido) {
			
			choice = sc.nextLine();
			
			if (choice.length() == 1) {
				
				if (choice.charAt(0) == 'S' || choice.charAt(0) == 's') {
					
					parar = false;
					valido = true;
			
				} else if (choice.charAt(0) == 'N' || choice.charAt(0) == 'n') {
					
					parar = true;
					valido = true;
					
				} else {
					
					System.out.println("El valor introducido no está permitido. Revísalo y vuelve a introducir un valor permitido (S / N):");
				}
				
			} else {
				
				System.out.println("El valor introducido no está permitido. Revísalo y vuelve a introducir un valor permitido (S / N):");
			}
		}
		
		return parar;
	}

	/**
	 * Muestra las victorias de cada jugador junto a sus respectivos nombres.
	 * @param victorias, guarda la información de las victorias de cada jugador.
	 */
	public void mostrarVictorias(String victorias) {
		
		String linea = "";
		
		for (int i = 0; i < victorias.length(); i++) {
			linea += "-";
		}
		
		System.out.println("\n" + linea);
		System.out.println(victorias);
		System.out.println(linea + "\n");
		
	}
	
	/**
	 * Método que comprueba si es necesario o no preguntar de nuevo los nombres de los jugadores en caso de haber cambiado de modo de juego.
	 * @param numJugadores, guarda el número de jugadores (usuarios) de la partida actual.
	 * @param oldNumJugadores, guarda el número de jugadores (usuarios) de una partida anterior.
	 * @return asignaciones, sirve para guardar en un array los nombres de ambos jugadores, contando como jugador a la máquina en caso necesario.
	 */
	public String[] reasignarNombres(int numJugadores, int oldNumJugadores) {
		
		String[] asignaciones;
		
		/*
		 * En caso de que el número de jugadores no haya sido modificado, es decir, que ambos jugadores sigan siendo los mismos,
		 * no será necesario preguntar ni reasignar nuevos nombres, ya que se mantiene como está.
		 */
		if (numJugadores == oldNumJugadores) {
			
			asignaciones = null;
			
		} else {
			
			System.out.println("Veo que has cambiado de modo de juego.");
			
			if (numJugadores == 1) {
				
				System.out.println("Ahora vas a jugar contra la máquina, así que voy a pedirte que introduzcas tu nombre.");
				asignaciones = elegirJugadores(numJugadores);
				
			} else {
				
				System.out.println("Ahora sois dos jugadores y váis a jugar entre vosotros, así que voy a pediros que introduzcáis vuestros nombres.");
				asignaciones = elegirJugadores(numJugadores);	
			}
		}
		
		return asignaciones;
	}

	/**
	 * Método que muestra al usuario de quién es el turno actual, a quién le toca jugar.
	 * @param turno, guarda una cadena de caracteres que contiene el nombre del jugador al que le toca jugar.
	 */
	public void mostrarTurnoDe(String turno) {
		
		System.out.println(turno);
		
	}
}
