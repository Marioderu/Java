package modelo;

import java.util.Random;

/**
 * Clase que posee los atributos y métodos relacionados con el funcionamiento y almacenamiento del tablero del juego.
 * @author Mario Delgado Ruiz.
 */
public class Tablero {

	private Random ran = new Random();
	private char[][] tablero;
	private Jugador playerOne;
	private Jugador playerTwo;
	private boolean playerOnePlays;
	private int casillasOcupadas;
	private int numJugadores;
	
	/**
	 * Constructor sin parámetros que crea dos jugadores por defecto y el número de casillas ocupadas a 0.
	 */
	public Tablero() {
		this.playerOne = new Jugador();
		this.playerTwo = new Jugador();
		this.casillasOcupadas = 0;
	}
	
	/**
	 * Crea un tablero predeterminado en función del tamaño pasado por parámetro.
	 * @param size, guarda el tamaño deseado para la creación del tablero.
	 */
	public void setTableroSize(int size) {
		
		if (size == 1)
			this.tablero = new char[6][7];
		else if (size == 2)
			this.tablero = new char[7][8];
		else
			this.tablero = new char[8][9];
		
		crearTablero();
	}
	
	/**
	 * Getter que devuelve el valor del atributo casillasOcupadas.
	 * @return casillasOcupadas, guarda el total de casillas ocupadas en el tablero.
	 */
	public int getCasillasOcupadas() {
		return casillasOcupadas;
	}

	/**
	 * Crea el tablero con los valores deseados para establecerlo como vacío.
	 */
	private void crearTablero() {
		
		for (int i = 0; i < this.tablero.length; i++) {
			
			for (int j = 0; j < this.tablero[i].length; j++) {
				
				this.tablero[i][j] = '-';
			}
		}
	}
	
	/**
	 * Método que comprueba si el juego debe continuar ejecutándose comprobando el número de casillas ocupadas en el tablero.
	 * Comprueba si existe una situación de empate.
	 * @return hayEmpate, guarda el valor de comprobación de empate.
	 */
	public boolean continuarJuego() {
		
		boolean hayEmpate = false;
		int totalCasillas = this.tablero.length * this.tablero[0].length;

		if (this.casillasOcupadas == totalCasillas)
			hayEmpate = true;
		
		return hayEmpate;
	}
	
	/**
	 * Método que ejecuta la jugada insertada por el jugador, basándose en el número de columna del tablero.
	 * Comprueba si el valor del jugador es admitido y si la columna tiene espacios vacíos.
	 * @param col, guarda el número de columna elegido por el jugador.
	 * @return resul, guarda el resultado de la ejecución del método, que puede tener diferentes valores en función del resultado obtenido.
	 */
	public int jugar(int col) {
		
		int c = col;
		int resul;
		char chip;
		
		// Evita que se evalúe el código en caso de que la variable 'col' sea mayor a la longitud del tablero o de que la columna esté llena
		if (c >= this.tablero[0].length || this.tablero[0][c] != '-') {
			
			resul = -1;
		
		} else {
			
			if (playerOnePlays) {
				
				chip = playerOne.getChip();
			
			} else {
				
				chip = playerTwo.getChip();
			}
			
			int i = 0;
			boolean chipFound = false;
			
			while (!chipFound && i < this.tablero.length) {
				
				if (this.tablero[i][c] != '-')
					chipFound = true;
				else
					i += 1;
			}
			
			if (i > 0 && i <= this.tablero.length) {
				
				i -= 1;
				
				this.tablero[i][c] = chip;
				
			} else  if (i == 0) {
				
				this.tablero[i][c] = chip;
			}
			
			this.casillasOcupadas += 1;
			boolean hayWinner = checkWinner(i, c, chip);
			
			if (hayWinner) {
				
				resul = 1;
				
				if (playerOnePlays)
					this.playerOne.sumarVictoria();
				else
					this.playerTwo.sumarVictoria();
			
			} else {
				
				resul = 0;
				playerOnePlays = !playerOnePlays;
			}
			
		}
		
		return resul;
	}
	
	/**
	 * Método que recorre el tablero en todas las direcciones para comprobar si hay un ganador tras encontrar cuatro fichas del mismo tipo seguidas.
	 * Reutiliza los mismos métodos usados para simular la jugada de la máquina, por lo que comprueba cada posibilidad siempre y cuando la posibilidad anterior no se haya cumplido.
	 * @param fila, guarda la fila del tablero donde ha caído la ficha que ha introducido el jugador.
	 * @param col, guarda la columna del tablero elegida por el jugador en su turno.
	 * @param chip, guarda la ficha que usa el jugador, referencia para buscar si hay un ganador.
	 * @return el resultado de buscar si hay un ganador o no lo hay todavía.
	 */
	private boolean checkWinner(int fila, int col, char chip) {
		
		int[] pos = new int[2];
		pos[0] = fila;
		pos[1] = col;
		int resul;
		
		resul = vertical(pos, this.tablero, chip, 4);
		
		if (resul == -1)
			resul = horizontal(pos, this.tablero, chip, 4);
		
		if (resul == -1)
			resul = diagonalArribaIzquierda(pos, this.tablero, chip, 4);
		
		if (resul == -1)
			resul = diagonalArribaDerecha(pos, this.tablero, chip, 4);
		
		if (resul == -1)
			return false;
		else
			return true;
	}
	
	/**
	 * Método que asigna un tipo de ficha a cada jugador y establece qué jugador comienza a jugar, ambos de manera aleatoria.
	 * @param info, guarda un vector unidimensional con dos elementos que contiene los dos nombres correspondientes a cada jugador.
	 * @param numJugadores, guarda el número de jugadores establecido por el usuario para la partida actual.
	 * @return asignaciones, guarda la información de cada jugador: nombre, tipo de ficha y quién juega en primer lugar, que se mostrará a los jugadores.
	 */
	public String[] asignarJugadores(String[] info, int numJugadores) {
		
		this.numJugadores = numJugadores;
		String j1 = nameToUpperCase(info[0]);
		String j2 = nameToUpperCase(info[1]);
		
		int num = ran.nextInt(2);
		
		this.playerOne.setNombre(j1);
		this.playerTwo.setNombre(j2);
		
		if (num == 0) {
			
			this.playerOne.setChip('X');
			this.playerTwo.setChip('O');
			this.playerOnePlays = true;
			
		} else {
			
			this.playerOne.setChip('O');
			this.playerTwo.setChip('X');
			this.playerOnePlays = false;
		}
		
		String frase1, frase2;
		String[] asignaciones;
		
		if (this.numJugadores == 1) {
			
			asignaciones = new String[2];
			
			if (this.playerOnePlays) {
				frase1 = playerOne.getNombre() + ", usarás las fichas con el símbolo '" + playerOne.getChip() + "' y serás el PRIMERO/A en jugar.";
				frase2 = "La máquina, cuyo nombre es '" + playerTwo.getNombre() + "', usará las fichas con el símbolo '" + playerTwo.getChip() + "' y será la ÚLTIMA en jugar.";
				
				asignaciones[0] = frase1;
				asignaciones[1] = frase2;
				
			} else {
				
				frase1 = playerOne.getNombre() + ", usarás las fichas con el símbolo '" + playerOne.getChip() + "' y serás el ÚLTIMO/A en jugar.";
				frase2 = "La máquina, cuyo nombre es '" + playerTwo.getNombre() + ", usará las fichas con el símbolo '" + playerTwo.getChip() + "' y será la PRIMERA en jugar.";
				
				asignaciones[0] = frase2;
				asignaciones[1] = frase1;
				
			}
			
		} else {
			
			asignaciones = new String[2];
			
			if (this.playerOnePlays) {
				frase1 = "El jugador 1, " + playerOne.getNombre() + ", usará las fichas con el símbolo '" + playerOne.getChip() + "' y será el PRIMERO/A en jugar.";
				frase2 = "El jugador 2, " + playerTwo.getNombre() + ", usará las fichas con el símbolo '" + playerTwo.getChip() + "' y será el ÚLTIMO/A en jugar.";
				
				asignaciones[0] = frase1;
				asignaciones[1] = frase2;
				
			} else {
				
				frase1 = "El jugador 1, " + playerOne.getNombre() + ", usará las fichas con el símbolo '" + playerOne.getChip() + "' y será el ÚLTIMO/A en jugar.";
				frase2 = "El jugador 2, " + playerTwo.getNombre() + ", usará las fichas con el símbolo '" + playerTwo.getChip() + "' y será el PRIMERO/A en jugar.";
				
				asignaciones[0] = frase2;
				asignaciones[1] = frase1;
				
			}
		}
		
		return asignaciones;
	}
	
	/**
	 * Método que convierte los nombres de los jugadores en mayúsculas para mayor legibilidad durante el juego.
	 * Utiliza dos vectores que guardan el mismo número de caracteres (uno para mayúsculas y otro minúsculas) para manetener equivalencias entre sí.
	 * @param nombre, guarda el nombre del jugador.
	 * @return nombreNuevo, guarda el nombre del jugador tras haber sido transformado en mayúsculas.
	 */
	private String nameToUpperCase(String nombre) {
		
		char[] minus = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
						'h', 'i', 'j', 'k', 'l', 'm', 'n',
						'ñ', 'o', 'p', 'q', 'r', 's', 't',
						'u', 'v', 'w', 'x', 'y', 'z',
						'á', 'à', 'â', 'ä',
						'é', 'è', 'ê', 'ë',
						'í', 'ì', 'î', 'ï',
						'ó', 'ò', 'ô', 'ö',
						'ú', 'ù', 'û', 'ü', 'ç'};
		
		char[] mayus = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
						'H', 'I', 'J', 'K', 'L', 'M', 'N',
						'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T',
						'U', 'V', 'W', 'X', 'Y', 'Z',
						'Á', 'À', 'Â', 'Ä',
						'É', 'È', 'Ê', 'Ë',
						'Í', 'Ì', 'Î', 'Ï',
						'Ó', 'Ò', 'Ô', 'Ö',
						'Ú', 'Ù', 'Û', 'Ü', 'Ç'};
		
		String nombreNuevo = "";
		boolean encontrado = false;
		int j = 0;
		
		for (int i = 0; i < nombre.length(); i++) {
			
			j = 0;
			encontrado = false;
			
			while (!encontrado && j < minus.length) {
				
				if (nombre.charAt(i) == minus[j]) {
					
					nombreNuevo += mayus[j];
					encontrado = true;
					
				}
				
				j += 1;
			}
			
			if (!encontrado)
				nombreNuevo += nombre.charAt(i);
			
		}
		
		return nombreNuevo;
	}

	/**
	 * Método toString que genera una cadena de caracteres que forma la visualización del tablero.
	 * @return tablero, que guarda la información sobre el tablero actual.
	 */
	@Override
	public String toString() {
		
		String tablero = "";
		
		tablero += "\n";
			
		for (int i = 0; i < this.tablero.length; i++) {
			
			tablero += " ";
			
			for (int j = 0; j < this.tablero[0].length * 4 + 1; j++) {
				if (j == 0 || j % 4 == 0)
					tablero += "+";
				else
					tablero += "-";
			}
			
			tablero += "\n";
			
			for (int j = 0; j < this.tablero[0].length; j++) {
				
				if (j < this.tablero[0].length)
					tablero += " | ";
				
				tablero += this.tablero[i][j];
			}
			
			tablero += " |\n";
		}
		
		tablero += " ";
		int longLinea = (this.tablero[0].length * 4) + 1;
		
		for (int i = 0; i < longLinea; i++) {
			tablero += "-";
		}
		
		tablero += "\n";
		
		for (int i = 0; i < this.tablero[0].length; i++) {
			
			if (i < this.tablero[0].length)
				tablero += "   ";
			
			tablero += i;
		}
		
		return tablero;
	}
	
	/**
	 * Método que devuelve una cadena con la información del jugador al que le toca jugar en el turno actual.
	 * @return output, guarda una cadena de caracteres sobre el jugador del turno actual.
	 */
	public String mostrarTurnoDe() {
		
		int longitud;
		String s, linea = "", output;
		
		/*
		 * Hay que tener en cuenta si la partida se está desarrollando entre dos jugadores (usuarios) desde un mismo ordenador
		 * o se trata de un juego entre la máquina y un único jugador.
		 */
		if (this.playerOnePlays) {
			
			if (this.numJugadores == 1)
				s = "Turno del jugador: ";
			else
				s = "Turno del jugador 1: ";
			
			longitud = s.length() + this.playerOne.getNombre().length();
			
			for (int i = 0; i < longitud; i++) {
				linea += "-";
			}
			
			output = "\n\n" + linea + "\n";
			
			if (this.numJugadores == 1)
				output += "Turno del jugador: " + this.playerOne.getNombre();
			else
				output += "Turno del jugador 1: " + this.playerOne.getNombre();
			
			output += "\n" + linea;
			
		} else {
			
			if (this.numJugadores == 1)
				s = "Turno de la " + this.playerTwo.getNombre();
			else
				s = "Turno del jugador 2: ";
			
			longitud = s.length() + this.playerTwo.getNombre().length();
			
			for (int i = 0; i < longitud; i++) {
				linea += "-";
			}
			
			output = "\n\n" + linea + "\n";
			
			if (this.numJugadores == 1)
				output += "Turno de la " + this.playerTwo.getNombre();
			else
				output += "Turno del jugador 2: " + this.playerTwo.getNombre();
			
			output += "\n" + linea;
		}
		
		return output;
	}

	/**
	 * Getter que devuelve el nombre del jugador actual.
	 * @return Jugador.getNombre(), que guarda el nombre del jugador en el turno actual.
	 */
	public String getJugadorActual() {
		
		if (playerOnePlays)
			return playerOne.getNombre();
		
		else
			return playerTwo.getNombre();
	}

	/**
	 * Método que establece el tablero a un nuevo tablero predeterminado para comenzar una nueva partida.
	 * @param numJugadores, guarda el número de jugadores (usuarios) que jugarán durante la siguiente partida.
	 * @param oldNumJugadores, guarda el número de jugadores (usuarios) de la partida anterior.
	 */
	public void resetTablero(int numJugadores, int oldNumJugadores) {

		crearTablero();
		this.casillasOcupadas = 0;
		this.numJugadores = numJugadores;
		this.playerOnePlays = !this.playerOnePlays;
		
		/* Se resetean las victorias únicamente en caso de cambiar de modo de juego:
		 * cambio de 'máquina contra jugador' a 'jugador contra jugador', o viceversa.
		 */
		if (numJugadores != oldNumJugadores) {
			this.playerOne.resetVictorias();
			this.playerTwo.resetVictorias();
		}
	}

	/**
	 * Getter que devuelve la información de ambos jugadores: nombres y total de victorias.
	 * @return p1 y p2, que guarda una cadena de texto con información sobre las victorias de cada jugador.
	 */
	public String getVictorias() {
		
		String p1;
		String p2;
		
		// Se tiene en cuenta si uno de los jugadores es la máquina u otro jugador.
		if (this.numJugadores == 1) {
			
			p1 = "Jugador: " + this.playerOne.getNombre() + "  -  Victorias: " + this.playerOne.getVictorias();
			p2 = this.playerTwo.getNombre() + "  -  Victorias: " + this.playerTwo.getVictorias();
		
		} else {
		
			p1 = "Jugador 1: " + this.playerOne.getNombre() + "  -  Victorias: " + this.playerOne.getVictorias();
			p2 = "Jugador 2: " + this.playerTwo.getNombre() + "  -  Victorias: " + this.playerTwo.getVictorias();
		}
		
		return p1 + "   |   " + p2;
	}

	/**
	 * Método que lleva a cabo el movimiento actual de la máquina, comprobando las diferentes situaciones existentes de un modo sencillo.
	 * Además, se comunica con otros métodos que realizan las comprobaciones de las diversas posibilidades que pueda haber.
	 * Cuando se decide un movimiento, se envía la información necesaria al método utilizado para jugar que se usa para los jugadores.
	 * @return resul, guarda el resultado de haber enviado el movimiento al método que se usa para jugar.
	 */
	public int maquinaJuega() {
		
		/* Método para realizar el movimiento de la máquina durante su turno:
		 * 
		 * 	1. Buscar si con el siguiente movimiento puede ganar
		 * 	2. Si no, buscar si con el siguiente movimiento el oponente puede ganar y, en caso afirmativo, bloquearlo
		 * 	3. Si no, buscar un movimiento que acerque a la máquina a ganar
		 * 	4. Si no, colocar la ficha en el centro siempre que la columna no esté llena
		 * 	5. Si nada de lo anterior es posible, colocar al azar en cualquiera de las columnas
		 */
		
		int num;
		int resul = -1;
		boolean posEncontrada = false;
		
		for (int i = 0; !posEncontrada && i < this.tablero[0].length; i++) { // PASO NÚMERO 1
			
			num = simularColocacionFicha(i, this.playerTwo.getChip(), 4);
			
			if (num >= 0) {
				
				resul = jugar(num);
				posEncontrada = true;
			}
		}
		
		if (!posEncontrada) {
			
			for (int i = 0; !posEncontrada && i < this.tablero[0].length; i++) { // PASO NÚMERO 2
				
				num = simularColocacionFicha(i, this.playerOne.getChip(), 4);
				
				if (num >= 0) {
					
					resul = jugar(num);
					posEncontrada = true;
				}
			}
		}
		
		if (!posEncontrada) {
			
			for (int i = 0; !posEncontrada && i < this.tablero[0].length; i++) { // PASO NÚMERO 3
				
				num = simularColocacionFicha(i, this.playerTwo.getChip(), 3);
				
				if (num >= 0) {
					resul = jugar(num);
					posEncontrada = true;
				}
			}
		}
		
		if (!posEncontrada) { // PASO NÚMERO 4
			
			int colCentral = this.tablero[0].length / 2;
			
			if (this.tablero[0][colCentral] == '-') {
				resul = jugar(colCentral);
				posEncontrada = true;
			}
		}
		
		if (!posEncontrada) { // PASO NÚMERO 5
			
			int random;
			
			while (!posEncontrada) {
				
				random = ran.nextInt(this.tablero[0].length);
				resul = jugar(random);
				
				if (resul != -1)
					posEncontrada = true;
			}
		}
		
		return resul;
	}
	
	/**
	 * Método que simula la colocación de una ficha por cada columna posible donde puede colocarse una ficha.
	 * Crea una copia exacta del tablero y realiza un movimiento dentro de la copia por cada columna recibida del método anterior.
	 * Envía la información de la casilla (fila y columna) donde cae la ficha a los diferentes métodos para comprobar diferentes situaciones horizontal, vertical y diagonalmente.
	 * @param col, la columna actual donde debe comprobarse la colocación de la supuesta ficha.
	 * @param player, la ficha que debe comprobarse dependiendo de lo que se quiera averiguar, si hay posibilidad de ganar, bloquear al oponente o acercarse a la victoria.
	 * @param ocurrencias, el total de fichas del mismo tipo seguidas que debe darse para cumplir una condición de comprobación.
	 * @return num, la columna donde es posible colocar la ficha real en función de las comprobaciones realizadas.
	 */
	private int simularColocacionFicha(int col, char player, int ocurrencias) {
		
		char[][] copia = new char[this.tablero.length][this.tablero[0].length];
		
		for (int i = 0; i < copia.length; i++) { // obtención de una copia exacta del tablero
			for (int j = 0; j < copia[0].length; j++) {
				copia[i][j] = this.tablero[i][j];
			}
		}
		
		int f = 0;
		int[] pos = new int[2];
		int num = -1;
		
		/* Está asegurado que sólo se realizan las comprobaciones si esa fila tiene espacios vacíos.
		 * Como al colocar una ficha, esta cae hasta el fondo o hasta que colisiona con otra ficha,
		 * basta con comprobar que el primer espacio de la columna esté vacío.
		 */
		if (copia[0][col] == '-') {
		
			while (f < copia.length && copia[f][col] == '-') {
				f++;
			}
			
			copia[f-1][col] = player;
			
			pos[0] = f - 1;
			pos[1] = col;
			
			num = vertical(pos, copia, player, ocurrencias);
			
			// Se realizan más comprobaciones en caso de que no se encuentre una posible columna donde colocar la ficha
			if (num == -1)
				num = horizontal(pos, copia, player, ocurrencias);
			
			if (num == -1)
				num = diagonalArribaIzquierda(pos, copia, player, ocurrencias);
			
			if (num == -1)
				num = diagonalArribaDerecha(pos, copia, player, ocurrencias);
		}
		
		return num;
	}
	
	/**
	 * Método que comprueba la columna donde se ha insertado la supuesta ficha y usando como punto de partida la posición actual de dicha ficha.
	 * Se comprueba si existe un mismo tipo de ficha un número específico de veces y, en caso de cumplirse esa condición, devuelve la columna donde insertar la ficha.
	 * En caso contrario, si la condición no se evalúa, el valor que devuelve es un valor predeterminado inferior a 0, para no chocar con valores que se consideran correctos.
	 * @param pos, la posición actual (fila y columna) donde ha caído la supuesta ficha.
	 * @param copia, la copia del tablero original con la que realizar comprobaciones sin modificar el tablero original.
	 * @param player, la ficha que debe comprobarse dependiendo de lo que se quiera averiguar, si hay posibilidad de ganar, bloquear al oponente o acercarse a la victoria.
	 * @param ocurrencias, el total de fichas del mismo tipo seguidas que debe darse para cumplir una condición de comprobación.
	 * @return el valor predeterminado en caso de no cumplirse la condición interna del bucle o, en caso contrario, la columna donde puede colocarse la supuesta ficha.
	 */
	private int vertical(int[] pos, char[][] copia, char player, int ocurrencias) {
		
		int resul = -1;
		int contador = 0;
		int fila = pos[0];
		int col = pos[1];
			
		for (int i = fila; i < copia.length; i++) {
				
			if (copia[i][col] == player) {
					
				contador++;
					
				if (contador == ocurrencias)
					return col;
					
			} else {
					
				contador = 0;
			}
		}
		
		return resul;
	}

	/**
	 * Método que comprueba la fila donde se ha insertado la supuesta ficha desde el principio hasta el final.
	 * Se comprueba si existe un mismo tipo de ficha un número específico de veces y, en caso de cumplirse esa condición, devuelve la columna donde insertar la ficha.
	 * En caso contrario, si la condición no se evalúa, el valor que devuelve es un valor predeterminado inferior a 0, para no chocar con valores que se consideran correctos.
	 * @param pos, la posición actual (fila y columna) donde ha caído la supuesta ficha.
	 * @param copia, la copia del tablero original con la que realizar comprobaciones sin modificar el tablero original.
	 * @param player, la ficha que debe comprobarse dependiendo de lo que se quiera averiguar, si hay posibilidad de ganar, bloquear al oponente o acercarse a la victoria.
	 * @param ocurrencias, el total de fichas del mismo tipo seguidas que debe darse para cumplir una condición de comprobación.
	 * @return el valor predeterminado en caso de no cumplirse la condición interna del bucle o, en caso contrario, la columna donde puede colocarse la supuesta ficha.
	 */
	private int horizontal(int[] pos, char[][] copia, char player, int ocurrencias) {

		int resul = -1;
		int contador = 0;
		int fila = pos[0];
		int col = pos[1];
			
		for (int i = 0; i < copia[0].length; i++) {
				
			if (copia[fila][i] == player) {
					
				contador++;
					
				if (contador == ocurrencias)
					return col;
					
			} else {
					
				contador = 0;
			}
		}
		
		return resul;
	}

	/**
	 * Método que comprueba la primera diagonal donde se ha insertado la supuesta ficha desde el principio hasta el final.
	 * Desde la posición donde cae la supuesta ficha comienza comprobando cuál es la posición más cercana a la parte inferior del tablero.
	 * Después, desde esa última posición, comprueba hacia arriba y hacia la izquierda la diagonal completa.
	 * Se comprueba si existe un mismo tipo de ficha un número específico de veces y, en caso de cumplirse esa condición, devuelve la columna donde insertar la ficha.
	 * En caso contrario, si la condición no se evalúa, el valor que devuelve es un valor predeterminado inferior a 0, para no chocar con valores que se consideran correctos.
	 * @param pos, la posición actual (fila y columna) donde ha caído la supuesta ficha.
	 * @param copia, la copia del tablero original con la que realizar comprobaciones sin modificar el tablero original.
	 * @param player, la ficha que debe comprobarse dependiendo de lo que se quiera averiguar, si hay posibilidad de ganar, bloquear al oponente o acercarse a la victoria.
	 * @param ocurrencias, el total de fichas del mismo tipo seguidas que debe darse para cumplir una condición de comprobación.
	 * @return el valor predeterminado en caso de no cumplirse la condición interna del bucle o, en caso contrario, la columna donde puede colocarse la supuesta ficha.
	 */
	private int diagonalArribaIzquierda(int[] pos, char[][] copia, char player, int ocurrencias) {

		int resul = -1;
		int contador = 0;
		int fila = pos[0];
		int col = pos[1];
		
		// Hasta la longitud - 1 para quedarme con el último número menor a la longitud del tablero (vertical y horizontal)
		while (fila < copia.length - 1 && col < copia[0].length - 1) {
			fila++;
			col++;
		}
		
		while (fila >= 0 && col >= 0) {
			
			if (copia[fila][col] == player) {
				contador++;
				
				if (contador == ocurrencias)
					return pos[1];
				
			} else {
				
				contador = 0;
			}
			
			fila--;
			col--;
		}
		
		return resul;
	}

	/**
	 * Método que comprueba la segunda diagonal donde se ha insertado la supuesta ficha desde el principio hasta el final.
	 * Desde la posición donde cae la supuesta ficha comienza comprobando cuál es la posición más cercana a la parte inferior del tablero.
	 * Después, desde esa última posición, comprueba hacia arriba y hacia la derecha la diagonal completa.
	 * Se comprueba si existe un mismo tipo de ficha un número específico de veces y, en caso de cumplirse esa condición, devuelve la columna donde insertar la ficha.
	 * En caso contrario, si la condición no se evalúa, el valor que devuelve es un valor predeterminado inferior a 0, para no chocar con valores que se consideran correctos.
	 * @param pos, la posición actual (fila y columna) donde ha caído la supuesta ficha.
	 * @param copia, la copia del tablero original con la que realizar comprobaciones sin modificar el tablero original.
	 * @param player, la ficha que debe comprobarse dependiendo de lo que se quiera averiguar, si hay posibilidad de ganar, bloquear al oponente o acercarse a la victoria.
	 * @param ocurrencias, el total de fichas del mismo tipo seguidas que debe darse para cumplir una condición de comprobación.
	 * @return el valor predeterminado en caso de no cumplirse la condición interna del bucle o, en caso contrario, la columna donde puede colocarse la supuesta ficha.
	 */
	private int diagonalArribaDerecha(int[] pos, char[][] copia, char player, int ocurrencias) {

		int resul = -1;
		int contador = 0;
		int fila = pos[0];
		int col = pos[1];
		
		// Hasta la longitud - 1 para quedarme con el último número menor a la longitud del tablero (vertical y horizontal)
		while (fila < copia.length - 1 && col > 0) {
			fila++;
			col--;
		}
		
		while (fila >= 0 && col < copia[0].length) {
			
			if (copia[fila][col] == player) {
				contador++;
				
				if (contador == ocurrencias)
					return pos[1];
				
			} else {
				
				contador = 0;
			}
			
			fila--;
			col++;
		}
		
		return resul;
	}
}
