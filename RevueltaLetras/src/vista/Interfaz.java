package vista;

import java.util.Random;
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
		
	}

	/**
	 * Método que da la bienvenida al usuario y esplica las reglas del juego. Además, pide al usuario varios valores, como
	 * su nombre, la dificultad del juego y el idioma de las frases del tablero.
	 * @return v, que contiene tres elementos de tipo String esenciales para crear el tablero y el jugador.
	 */
	public String[] inicioJuego() {
		
		String nombre = "", dificultad, idioma;
		String[] v = new String[3];
		
		System.out.println("\n +---------------------------------+");
		System.out.println(" | BIENVENIDO A REVUELTA DE LETRAS |");
		System.out.println(" +---------------------------------+");
		
//		sleep(1800);
		
		System.out.println("\nEn este juego deberás ordenar las letras de cada frase para formar las frases correctas.\n");
		System.out.println("Tendrás un tablero de 6 filas y 15 columnas.\nCada fila representa una frase y las columnas representan el caracter o letra de cada frase.\n");
		
//		sleep(1800);
		
		System.out.println("Deberás elegir la fila y columna del caracter que quieras sustituir\ny la fila y columna del caracter por el que lo quieres intercambiar.\n");
		System.out.println("Se trata de intercambiar caracteres para formar la frase.\n");
		
//		sleep(1800);
		
		System.out.println("Según la dificultad que elijas, habrá un número específico de caracteres fijos (que no podrán ser sustituidos ni movidos) y el resto estarán desordenados.\n");
		System.out.println("También tendrás un contador de jugadas cada vez que cambies una letra. Puedes hacer tantos cambios como quieras.\n");
		
//		sleep(1800);
//		
		System.out.println("Además, dependiendo de la dificultad elegida, dispondrás de un número de pistas que podrás utilizar en caso de necesitarlas.\n");
		System.out.println("A mayor dificultad, mayor número de pistas disponibles.\n");
		
//		sleep(1800);
		
		System.out.println("IMPORTANTE:\n\tLos caracteres se desordenan entre frases, por lo que el caracter que quieras intercambiar podría estar en otra frase.");
		System.out.println("\tHay frases que pueden aparecer al revés, de derecha a izquierda. En este caso, los caracteres fijos esmpezarán desde la derecha y no desde la izquierda.\n");
		
//		sleep(1800);
		
		System.out.println("IMPORTANTE 2:\n\tDependiendo de la dificultad habrá una probabilidad de que se desordene una letra aleatoriamente.");
		System.out.println("\tEso significa que una letra colocada correctamente, puede intercambiarse por otra que no sea la correcta.");
		System.out.println("\tAl cambiarse, puede colocarse en un nuevo lugar, que puede ser un lugar correcto o no.");
		System.out.println("\tAdemás, cuanto mayor sea la dificultad, mayor será la probabilidad de que esto ocurra.\n");
		
//		sleep(1800);
		
		System.out.println("\n+-------------------------------------------------------------------------+\n");
		System.out.println("Antes de comenzar, dime tu nombre por favor:");
		boolean valido = false;
		
		while (!valido) {
			nombre = sc.nextLine();
			
			if (nombre.length() >= 1 && nombre.charAt(0) != ' ')
				valido = true;
			else
				System.out.println("Revisa el nombre que has introducido.\nNo se permiten nombres vacíos y tampoco puede empezar por un espacio.\nVuelve a introducir un nombre:");
		}
		
		System.out.println("Ahora elige la dificultad que quieras jugar.\n");
		dificultad = chooseDificultad();
		
		System.out.println("\nTambién puedes elegir el idioma en el que quieres las frases.\n");
		idioma = chooseIdioma();
		
		v[0] = nombre;
		v[1] = dificultad;
		v[2] = idioma;
		
		return v;
	}
	
	/**
	 * Método que sirve para pausar la ejecución del programa durante un tiempo determinado.
	 * @param num, indica el número (en milisegundos) que se pausará la ejecución.
	 */
	private void sleep(int num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método privado que muestra al usuario las diferentes dificultades y las diferencias entre cada una,
	 * además de pedir al usuario la dificultad que desea elegir para jugar.
	 * @return dificultad, que contiene una de las tres posibles dificultades del juego.
	 */
	private String chooseDificultad() {
		
		String dificultad = "";
		String num = "";
		boolean detener = false;
		
		System.out.println("FÁCIL:\n" + 
							"\t- Los 8 primeros caracteres fijos para cada frase, el resto están desordenados.\n" +
							"\t- Con esta dificultad obtienes 2 pistas que puedes usar en cualquier momento.\n" +
							"\t- Puede que haya 1 o ninguna frase al revés.\n" +
							"\t- El programa tiene una probabilidad baja de intercambiar dos caracteres aleatoriamente.\n");
		
		System.out.println("MEDIA:\n" + 
							"\t- Los 4 primeros caracteres fijos para cada frase, el resto están desordenados.\n" +
							"\t- Con esta dificultad obtienes 4 pistas que puedes usar en cualquier momento.\n" +
							"\t- Habrá 1 o 2 frases al revés.\n" +
							"\t- El programa tiene una probabilidad media de intercambiar dos caracteres aleatoriamente.\n");
		
		System.out.println("DIFÍCIL:\n" + 
							"\t- El primer carácter fijo para cada frase, el resto están desordenados.\n" +
							"\t- Con esta dificultad obtienes 8 pistas que puedes usar en cualquier momento.\n" +
							"\t- Habrá de 2 a 4 frases al revés.\n" +
							"\t- El programa tiene una probabilidad alta de intercambiar dos caracteres aleatoriamente.\n");
		
		System.out.println("¿Qué dificultad te gustaría jugar? Escribe 1 (para Fácil), 2 (para Media) o 3 (para Díficil):");
		
		while (!detener) {
			
			num = sc.nextLine();
			
			if (num.length() == 1 && (num.charAt(0) >= 49 && num.charAt(0) <= 51)) {
				
				detener = true;
				
			} else {
				
				System.out.println("Debes elegir 1 (Fácil), 2 (Media) o 3 (Difícil). Vuelva a introducir el número:");
				
			}
		}
		
		if (num.equals("1"))
			
			dificultad = "Fácil";
		
		else if (num.equals("2"))
			
			dificultad = "Media";
		
		else
			
			dificultad = "Difícil";
		
		
		return dificultad;
	}
	
	/**
	 * Método privado que da la oportunidad al usuario de cambiar el idioma de las frases que se muestran en el tablero,
	 * ofreciendo dos posibilidades, Español o Inglés.
	 * @return idioma, que contiene uno de los dos posibles idiomas del tablero.
	 */
	private String chooseIdioma() {
		
		String idioma = "";
		String num = "";
		boolean detener = false;
		
		System.out.println("Puedes elegir entre Español o Inglés, las frases se mostrarán en el idioma elegido.");
		System.out.println("Elije el idioma introduciendo 1 (para Español) o 2 (para Inglés). Debes introducir un número:");
		
		while (!detener) {
			
			num = sc.nextLine();
			
			if (num.length() == 1 && (num.charAt(0) == 49 || num.charAt(0) == 50)) {
				
				detener = true;
				
			} else {
				
				System.out.println("Debes elegir 1 (Español) o 2 (Inglés). Vuelva a introducir el número:");
				
			}
			
		}
		
		if (num.equals("1"))
			
			idioma = "ESP";
		
		else
			
			idioma = "ENG";
		
		return idioma;
	}

	/**
	 * Método que recoge las posiciones (filas y columnas) de los dos caracteres que desea sustituir.
	 * @return nums, que contiene las cuatro posiciones necesarias para llevar a cabo una jugada.
	 */
	public int[] getPosiciones() {
		
		int[] nums = new int[4];
		boolean detener = false;
		String[] pos = new String[4];
		int digito;
		int num = 0;
		
		System.out.println("Debes introducir las filas y columnas de la casilla que quieres sustituir y de la casilla por la que la quieres sustituir.\nSólo se admiten valores numéricos de 0 a 14.\n");
		
		while (!detener) {
			
			System.out.println("Introduce la fila del caracter que quieres mover:");
			pos[0] = sc.nextLine();
			System.out.println("Ahora introduce la columna de ese mismo caracter:");
			pos[1] = sc.nextLine();
			System.out.println("Introduce la fila del caracter por el que quieres intercambiar:");
			pos[2] = sc.nextLine();
			System.out.println("Ahora introduce la columna de ese mismo caracter por el que quieres intercambiar:");
			pos[3] = sc.nextLine();
			
			if (isCorrectNumber(pos[0]) && isCorrectNumber(pos[1]) && isCorrectNumber(pos[2]) && isCorrectNumber(pos[3])) {
				for (int i = 0; i < pos.length; i++) {
					
					num = 0;
					
					for (int j = 0; j < pos[i].length(); j++) {
						
						digito = pos[i].charAt(j) - '0';
						num = num * 10 + digito;
					}
					
					nums[i] = num;
				}
				
				detener = true;
			} else {
				
				System.out.println(" \n+---------------------------------------------------------------------------------------------+");
				System.out.println(" | Alguno de los valores no son correctos.                                                     |");
				System.out.println(" | Recuerda que sólo se admiten valores numéricos comprendidos entre 0 y 14 (ambos inclusive). |");
				System.out.println(" | Vuelva a introducir los valores.                                                            |");
				System.out.println(" +---------------------------------------------------------------------------------------------+\n");
			}
		}
		
		return nums;
	}
	
	/**
	 * Método privado que comprueba si el usuario ha insertado un valor compuesto únicamente por valores numéricos de uno o dos dígitos,
	 * creando el número como tipo entero en caso de tratarse de un número.
	 * @param n, es la cadena de caracteres que se recoge en el método anterior, conteniendo el valor de una fila o columna.
	 * @return esCorrecto, devuelve verdadero o falso en función de si el parámetro está compuesto únicamente por valores numéricos.
	 */
	private boolean isCorrectNumber(String n) {
		
		int cont = 0;
		boolean esCorrecto = false;
		
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) >= 48 && n.charAt(i) <= 57) {
				cont += 1;
			}
		}
		
		int num = 0, digito;
		
		if (n.length() >= 1 && cont == n.length()) {
			
			for (int i = 0; i < n.length(); i++) {
				
				digito = n.charAt(i) - '0';
				num = num * 10 + digito;
			}
			
			if (num >= 0 && num <= 14) {
				esCorrecto = true;
			}
			
		}
			
			
		return esCorrecto;
	}

	/**
	 * Método que muestra el estado actual del tablero tras cada actualización.
	 * @param tablero, que contiene un String con la información del tablero actual.
	 */
	public void mostrarTablero(String tablero) {
		
		System.out.println(tablero);
		
	}

	/**
	 * Método que informa al jugador sobre alguno de los valores introducidos, mostrándose únicamente en caso de tratarse de un valor erróneo.
	 */
	public void informarSobreJugada() {
		
		System.out.println("\n+----------------------------------------------------------------------------------------------------+");
		System.out.println("| Alguna de las posiciones que has insertado no es la correcta.                                      |");
		System.out.println("| Recuerda que hay caracteres fijos que no pueden moverse, siempre serán los primeros de cada frase. |");
		System.out.println("| Cuidado con las frases al revés, pues sus caracteres fijos estarán en el lado contrario.           |");
		System.out.println("+----------------------------------------------------------------------------------------------------+\n");
	}

	/**
	 * Método que muestra al usuario el total de pistas que le quedan por usar y que pregunta al usuario si le gustaría usar una de ellas.
	 * @param pistasRestantes, contiene el total de pistas sin usar del usuario.
	 * @return quierePista, devuelve si el usuario quiere o no usar una de sus pistas.
	 */
	public boolean preguntarPista(int pistasRestantes) {
		
		boolean detener = false;
		boolean quierePista = false;
		String pista;
		
		System.out.println("Tienes " + pistasRestantes + " pistas restantes por usar. ¿Te gustaría usar una pista? Escribe 1 para pedir pista o 2 para ignorar:");
		pista = sc.nextLine();
		
		while (!detener && !quierePista) {
			
			if (pista.length() == 1 && (pista.charAt(0) == '1' || pista.charAt(0) == '2')) {
				
				if (pista.charAt(0) == '1') {
					
					quierePista = true;
					detener = true;
					
				} else
					
					detener = true;
				
			} else {
				
				System.out.println("Has introducido un valor no admitido. Debes introducir 1 (quieres una pista) o 2 (no quieres pista)");
				pista = sc.nextLine();
			}
		}
		
		if (quierePista && pistasRestantes - 1 == 0) {
			
			System.out.println("\n +---------------------------------------------+");
			System.out.println(" |  ¡ATENCIÓN!                                 |");
			System.out.println(" | ************                                |");
			System.out.println(" | ACABAS DE USAR TU ÚLTIMA PISTA.             |");
			System.out.println(" | YA NO PODRÁS USAR MÁS DURANTE ESTA PARTIDA. |");
			System.out.println(" +---------------------------------------------+\n");
		}
		
		return quierePista;
	}
	
	public void consumirScanner() {
		sc.nextLine();
	}
	
	/**
	 * Método que muestra una cadena con la pista que ha pedido el usuario.
	 * @param pista, contiene el resultado de pedir una pista, una cadena de texto que contiene la información necesaria.
	 */
	public void mostrarPista(String pista) {
		
		System.out.println(pista);
	}

	/**
	 * Método que informa al jugador de que ha ganado la partida y, por lo tanto, ha finalizado el juego.
	 * También pregunta al usuario si desea o no jugar otra vez.
	 * @return seguirJugando, que contiene la respuesta del usuario a la pregunta de si quiere volver a jugar.
	 */
	public boolean informarPartidaGanada() {
		
		System.out.println("\n +-----------------------------------------------------------------+");
		System.out.println(" |                                                                 |");
		System.out.println(" | ¡ENHORABUENA! Has conseguido el 100% y has ganado esta partida. |");
		System.out.println(" |            Espero que hayas disfrutado con mi juego.            |");
		System.out.println(" |                                                                 |");
		System.out.println(" +-----------------------------------------------------------------+\n");
		
		System.out.println("¿Te gustaría volver a jugar? Escribe 1 para continuar o 2 para salir.");
		
		String n = "";
		boolean seguirJugando = false;
		boolean detener = false;
		
		while (!detener) {
			
			n = sc.nextLine();
			
			if (n.length() == 1 && (n.charAt(0) == '1' || n.charAt(0) == '2')) {
				
				if (n.charAt(0) == '1')
					seguirJugando = true;
				
				detener = true;
			
			} else {
				
				System.out.println("Has introducido un valor no permitido.\nDebe ser un valor numérico de un solo dígito (1 para continuar o 2 para salir).\nVuelve a intentarlo:");
			}
			
		}
		
		return seguirJugando;
	}

	/**
	 * Método que llama a los métodos para elegir idioma y dificultad para reiniciar el juego con otros valores o con los mismos.
	 * @param infoInicio, vector que servirá para contener las elecciones del usuario.
	 * @return infoInicio, contiene la información que ha proporcionado el usuario para la creación de un tablero.
	 */
	public String[] reinicioJuego(String[] infoInicio) {
		
		infoInicio[1] = chooseDificultad();
		infoInicio[2] = chooseIdioma();
		
		return infoInicio;
	}
	
	/**
	 * Método que informa al usuario de que el juego ha finalizdo y se ha detenido su ejecución, en función de si el usuario desea o no continuar jugando.
	 */
	public void gameOver() {
		
		System.out.println("\n +------------------------------------------+");
		System.out.println(" |                                          |");
		System.out.println(" |          EL JUEGO HA FINALIZADO          |");
		System.out.println(" |         MUCHAS GRACIAS POR JUGAR         |");
		System.out.println(" |                                          |");
		System.out.println(" +------------------------------------------+\n");
		
	}

	/**
	 * Método que pregunta al usuario si desea ver alguno de los rankings disponibles. En caso afirmativo, deberá elegir alguna de las opciones.
	 * @param num, que guarda un número que indica si es la primera vez que se pregunta sobre el ranking o no.
	 * @return choice, que guarda el valor introducido por el usuario.
	 */
	public int preguntarRanking(int num) {
		
		if (num == 1) {
			System.out.println("Ahora que has ganado, tu nombre y número de jugadas han sido guardadas en un Ranking según la dificultad.");
			System.out.println("¿Te gustaría ver alguno de los Rankings?");
		} else {
			System.out.println("¿Te gustaría ver otro ranking?");
		}
		
		System.out.println("Introduce uno de los siguientes números:\n" +
							"\t0. Para la dificultad 'Fácil'\n" +
							"\t1. Para la dificultad 'Media'\n" +
							"\t2. Para la dificultad 'Difícil'\n" +
							"\t3. Para no visualizar nada");
		
		String n = sc.nextLine();
		int choice;
		
		while (n.length() != 1 && (n.charAt(0) < '0' && n.charAt(0) > '3')) {
			
			System.out.println("El valor introducido no está permitido. Vuelve a insertarlo.\nRecuerda que solo se admite un número de un solo dígito y comprendido entre 0 y 3 (ambos inclusive).\nPrueba a introducirlo de nuevo:");
			
			n = sc.nextLine();
		}
		
		if (n.equals("0"))
			choice = 0;
		else if (n.equals("1"))
			choice = 1;
		else if (n.equals("2"))
			choice = 2;
		else
			choice = 3;
	
		
		return choice;
	}
	
	/**
	 * Método que muestra el ranking que haya sido elegido por el usuario.
	 * @param ranking, guarda en formato String el ranking de la dificultad seleccionada, ordenado de menor a mayor número de jugadas.
	 */
	public void mostrarRanking(String ranking) {
		
		System.out.println(ranking);
	}
	
	/**
	 * Método que informa al usuario de que una letra ha sido movida de lugar de forma aleatoria.
	 * Utiliza una vector con diferentes frases que pueden mostrarse para que no sea repetitivo y se muestre una diferente aleatoriamente.
	 */
	public void informarMovimientoRandom() {
		
		Random r = new Random();
		String str = "", linea = "";
		
		String[] opciones = {"La máquina ha decidido ser un poco pilla y te ha cambiado una letra de lugar.",
								"Mmmm... no me está gustando cómo juegas, así que he decidido mover una letra de lugar.",
								"Creo que eres demasiado bueno, por esa razón he cambiado una de las letras de lugar.",
								"Ups... se me ha ido la mano y he movido una letra sin querer. ¡Qué torpeza la mía!",
								"Uy, parece que una letra ha decidido mudarse de sitio. Yo no tuve nada que ver... ¿o sí?",
								"¡Sorpresa! Me ha dado por reordenar una letrita de nada, por puro capricho.",
								"¡Oh, no! Una letra se ha rebelado y ha cambiado de lugar. Qué traviesa...",
								"Adivina, adivinanza: ¿quién ha movido una letra sin pedir permiso?",
								"He modificado una de las frases. Y volveré a hacerlo. Advertido quedas.",
								"Qué lástima, te iba tan bien... hasta que decidí intervenir para modificar tu tablero.",
								"Tanto orden es demasiado aburrido. Yo prefiero el caos. Una de las letras ha cambiado.",
								"Creí que necesitabas un reto más digno de tu inteligencia, por eso he reubicado una letra.",
								"¡Zas! Truco de magia: una letra desaparece y reaparece en otro sitio.",
								"Perdona por la impertinencia, pero hoy mis circuitos están revueltos y he movido una letra sin querer.",
								"Algo en la oscuridad me ha susurrado... 'mueve una letra'. Y he obedecido."};

		int opcion = r.nextInt(opciones.length);
		
		linea += " ";
		
		for (int i = 0; i < opciones[opcion].length() + 4; i++) {
			linea += "*";
		}
		
		linea += "\n";
		str += "\n" + linea + "   " + opciones[opcion] + "\n\n" + linea + "\n";
		
		System.out.println(str);
		
	}
}
