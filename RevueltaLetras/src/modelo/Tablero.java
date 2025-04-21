package modelo;

import java.util.Random;

/**
 * Clase que posee los atributos y métodos relacionados con el funcionamiento y almacenamiento del tablero del juego.
 * @author Mario Delgado Ruiz.
 */
public class Tablero {

	Random r = new Random();
	
	private String[] frasesEsp = {"NUNCA DEJES ESO", "HOY ES CALUROSO", "GAMEBOY ADVANCE", "EL FUTURO LLEGA", "VUELA SIN MIRAR", "VINE, VI, VENCÍ",
								"ERES ALUCINANTE", "¿ERES ESPAÑOLA?", "COME CHUPACHUPS", "COMER UN PEPINO", "EL ORNITORRINCO", "MUNDO FUTURISTA",
								"¡ELECTROCÚTAME!", "PIZZAS CON PIÑA", "POLLO CON CURRY", "MONKEY D. LUFFY", "¡DOBBY Y HARRY!", "BOTELLA DE AGUA",
								"OCARINA OF TIME", "¿SEGARRO AMEGO?", "CHOCOLATE NEGRO", "TAPAS ANDALUZAS", "A VAREAR OLIVOS", "NARUTO Y SASUKE",
								"KRATOS Y ATREUS", "BOÑIGAS DE VACA", "CAZARRECOMPENSA", "FILETE EMPANADO", "BOCATA LOMO YA!", "LEGEND OF ZELDA"};

	private String[] frasesEng = {"DO NOT LEAVE IT", "IT IS HOT TODAY", "GAMEBOY ADVANCE", "FUTURE’S COMING", "FLY BEING BLIND", "CAME, SAW, WENT",
								"YOU ARE AWESOME", "WELSH OR IRISH?", "SUCK LOLLIPOPS!", "HAVE A CUCUMBER", "I AM A PLATYPUS", "FUTURIST PLANET",
								"ELECTROCUTE ME!", "PINEAPPLE PIZZA", "CHICKEN & CURRY", "MONKEY D. LUFFY", "DOBBY AND HARRY", "MY WATER BOTTLE",
								"OCARINA OF TIME", "U HAVE A JOINT?", "BLACK CHOCOLATE", "TOROS AND TAPAS", "SOURDOUGH BREAD", "NARUTO & SASUKE",
								"KRATOS & ATREUS", "HORSE DROPPINGS", "A BOUNTY HUNTER", "BREADED CHICKEN", "A GUINNESS NOW!", "LEGEND OF ZELDA"};
	
	private char[][] tablero;
	private String[] chosenSentences;
	private boolean[] frasesReves;
	private boolean[] frasesCompletadas;
	private String idioma;
	private String dificultad;
	private Ranking ranking;
	private Jugador jugador;
	private double porcentaje;
	
	/**
	 * Constructor que inicializa los atributos necesarios a valores predeterminados o según los valores recibidos por parámetro.
	 * @param nombreJ, el nombre elegido por el jugador.
	 * @param dificultad, la dificultad escogida por el jugador.
	 * @param idioma, el idioma de preferencia que el jugador ha elegido.
	 */
	public Tablero(String nombreJ, String dificultad, String idioma) {
		this.tablero = new char[6][15];
		this.chosenSentences = new String[6];
		this.frasesReves = new boolean[6];
		this.frasesCompletadas = new boolean[6];
		this.idioma = idioma;
		this.dificultad = dificultad;
		this.ranking = new Ranking();
		
		// En función de la dificultad, el atributo jugador se crea con un número de pistas diferente
		if (this.dificultad.equals("Fácil"))
			
			this.jugador = new Jugador(nombreJ, 2);
		
		else if (this.dificultad.equals("Media"))
			
			this.jugador = new Jugador(nombreJ, 4);
		
		else
			this.jugador = new Jugador(nombreJ, 8);
		
		this.porcentaje = 0;
		crearTablero();
		setPorcentaje();
	}
	
//	public void setPorcentajePrueba(double num) {
//		this.porcentaje = num;
//	}
//	
//	public void aumentarUnPorc() {
//		this.porcentaje += 1;
//	}
	
	/**
	 * Getter que devuelve la información del jugador.
	 * @return jugador, el jugador de la partida con toda la información necesaria.
	 */
	public Jugador getJugador() {
		return this.jugador;
	}
	
	public int getPistasJugador() {
		int pistas = this.jugador.getPistasRestantes();
		return pistas;
	}

	/**
	 * Método que crea el tablero en función de la dificultad y del idioma escogido por el jugador.
	 * Elige al azar las frases que se mostrarán en el tablero y las coloca en un vector unidimensional como referencia para comprobaciones.
	 * Elige aleatoriamente qué frases van a ser mostradas al revés y lo indica usando un vector unidimensional para tomarlo como referencia durante el programa.
	 * Llama al método para desordenar las letras y al método que da la vuelta a algunas frases aleatoriamente.
	 */
	private void crearTablero() {
		
		int frasesReves, frase, num, letrasFijas, ind;
		boolean repetida = false;
		
		if (this.dificultad.equals("Fácil")) {
			
			letrasFijas = 8;
			frasesReves = r.nextInt(2);
			
		} else if (this.dificultad.equals("Media")) {
			
			letrasFijas = 4;
			frasesReves = r.nextInt(1, 3);
			
		} else {
			
			letrasFijas = 1;
			frasesReves = r.nextInt(2, 5);
		}
		
		// Elige las 6 frases aleatoriamente en función del idioma
		if (this.idioma.equals("ESP")) {
			
			num = 0;
			repetida = false;
						
			while (num < 6) {
				
				frase = r.nextInt(30);
				ind = 0;
				repetida = false;
				
				while (!repetida && ind < this.chosenSentences.length) {
					
					if(this.chosenSentences[ind] != null && this.chosenSentences[ind].equals(this.frasesEsp[frase])) {
						repetida = true;
					}
					
					ind += 1;
				}
				
				if (!repetida) {
					
					this.chosenSentences[num] = this.frasesEsp[frase];
					num += 1;
				}
			}
			
		} else {
			
			num = 0;
			repetida = false;
						
			while (num < 6) {
				
				frase = r.nextInt(30);
				ind = 0;
				repetida = false;
				
				while (!repetida && ind < this.chosenSentences.length) {
					
					if(this.chosenSentences[ind] != null && this.chosenSentences[ind].equals(this.frasesEng[frase])) {
						repetida = true;
					}
					
					ind += 1;
				}
				
				if (!repetida) {
					
					this.chosenSentences[num] = this.frasesEng[frase];
					num += 1;
				}
			}
		}
		
		// Coloca los caracteres en el tablero, todavía sin desordenar nada
		for (int i = 0; i < this.tablero.length; i++) {
				
			for (int j = 0; j < this.tablero[0].length; j++) {
					
				this.tablero[i][j] = this.chosenSentences[i].charAt(j);
					
			}
		}
		
		desordenarLetras(letrasFijas); // Desordena los caracteres necesarios
		
		// Elige aleatoriamente qué frases van a ser dadas la vuelta
		if (frasesReves > 0) {
		
			while (frasesReves > 0) {
				
				num = r.nextInt(this.chosenSentences.length);
				
				if (!this.frasesReves[num]) {
					
					this.frasesReves[num] = true;
					frasesReves -= 1;
				}
			}
			
			darVueltaFrases(); // Da la vuelta a las frases
		}
	}
	
	/**
	 * Método que da la vuelta a las frases que han sido elegidas aleatoriamente para mostrarse al revés (de derecha a izquierda).
	 * Toma como referencia el vector unidimensional 'frasesReves', que indica qué frases han sido elegidas.
	 */
	private void darVueltaFrases() {
		
		String frase = "";
		String frase2 = ""; // frase2 sirve para poner la frase dada la vuelta en el array chosenSentences y tenerlo como guía para comprobar que esté bien hecha la frase por el usuario
		int ind = 0;
		
		for (int i = 0; i < this.frasesReves.length; i++) {
			
			frase = "";
			frase2 = "";
			ind = 0;
			
			if (this.frasesReves[i]) {
				
				for (int j = this.tablero[0].length - 1; j >= 0; j--) {
					
					frase += this.tablero[i][j];
					frase2 += this.chosenSentences[i].charAt(j);
				}
				
				for (int j = 0; j < this.tablero[0].length; j++) {
					
					this.tablero[i][j] = frase.charAt(ind);
					ind++;
				}
				
				this.chosenSentences[i] = frase2;
			}
		}
	}

	/**
	 * Método que se encarga de desordenar las letras de todas las frases de manera aleatoria en función del número fijo de letras.
	 * Recorre todas las letras que no son fijas y las reemplaza por otra letra al azar (que no sea fija).
	 * Este método realiza sus acciones antes de dar la vuelta a las frases (en caso de haber alguna), por lo que las posiciones de las letras a intercambiar será el mismo para cada frase.
	 * @param letrasFijas, el número de letras fijas totales según la dificultad que sirve como punto de partida para recorrer los caracteres de cada frase.
	 */
	private void desordenarLetras(int letrasFijas) {
		
		int fila, col;
		char aux;
		
		for (int i = 0; i < this.tablero.length; i++) {
			
			for (int j = letrasFijas; j < this.tablero[0].length; j++) {
				
				fila = r.nextInt(0, this.tablero.length);
				col = r.nextInt(letrasFijas, this.tablero[0].length);
				
				aux = this.tablero[i][j];
				this.tablero[i][j] = this.tablero[fila][col];
				this.tablero[fila][col] = aux;
				
			}
		}
		
	}
	
	/**
	 * Método que se encarga de recoger las dos filas y dos columnas proporcionadas por el jugador y comprueba si es posible o no realizar el movimiento.
	 * Comprueba la dificultad del juego y determina desde qué carácter empezar las comprobaciones para frases mostradas al revés y las que no están al revés.
	 * En caso de poder realiza el movimiento, intercambia los dos caracteres según las posiciones indicadas por el jugador.
	 * @param posiciones, las cuatro posiciones necesarias para la realización de un movimiento, fila y columna de origen y fila y columna de destino.
	 * @return intercambiado, valor que indica si el intercambio ha sido realizado o no.
	 */
	public boolean intercambiarCaracter(int[] posiciones) {
		
		int fila = posiciones[0];
		int col = posiciones[1];
		int fila2 = posiciones[2];
		int col2 = posiciones[3];
		
		int fraseNormal, fraseReves;
		char aux = '·';
		boolean intercambiado = false;
		
		if ((fila < 6 && col < 15) && (fila2 < 6 && col2 < 15)) {
			
			if (this.dificultad.equals("Fácil")) {
				
				fraseNormal = 7; // a partir del índice 7 (sin incluir)
				fraseReves = 14 - fraseNormal; // = 7 -> hasta el índice 7 (sin incluir)
				
			} else if (this.dificultad.equals("Media")) {
				
				fraseNormal = 3; // a partir del índice 3 (sin incluir)
				fraseReves = 14 - fraseNormal; // = 11 -> hasta el índice 11 (sin incluir)
				
			} else {
				
				fraseNormal = 0; // a partir del índice 0 (sin incluir)
				fraseReves = 14 - fraseNormal; // = 14 -> hasta el índice 14 (sin incluir)
				
			}
			
			/*
			 * Comprueba si la frase con el caracter que quiere mover está al revés y el caracter es un caracter no fijo para esa frase
			 * En caso afirmativo, comprueba si la frase con el caracter con el que se quiere intercambiar está al revés y el carácter es un caracter no fijo para esa frase, o viceversa
			 * En caso negativo, hace las mismas comprobaciones para la situación contraria
			 */
			if (this.frasesReves[fila] && col < fraseReves) {
				
				if ((this.frasesReves[fila2] && col2 < fraseReves) || (!this.frasesReves[fila2] && col2 > fraseNormal)) {
					
					aux = this.tablero[fila][col];
					this.tablero[fila][col] = this.tablero[fila2][col2];
					this.tablero[fila2][col2] = aux;
					
				}
				
			} else if (!this.frasesReves[fila] && col > fraseNormal) {
				
				if ((this.frasesReves[fila2] && col2 < fraseReves) || (!this.frasesReves[fila2] && col2 > fraseNormal)) {
					
					aux = this.tablero[fila][col];
					this.tablero[fila][col] = this.tablero[fila2][col2];
					this.tablero[fila2][col2] = aux;
					
				}
				
			}
			
			/* El caracter usado como predeterminado para la variable 'aux' es el punto que hay en la tecla del numero 3, diferente del punto normal,
			 * para asegurarse de que ese carácter no vaya a estar en ninguna de las frases iniciales que conforman el tablero.
			 */
			if (aux != '·') {
				intercambiado = true;
				setPorcentaje();
				jugador.updateNumJugadas();
				checkFrasesCompletadas();
			}
		}
		
		return intercambiado;
	}

	/**
	 * Método que comprueba qué frases han sido completadas, es decir, todos sus caracteres están en la posición correcta.
	 * Utiliza como referencia el vector 'chosenSentences' que contiene las frases sin caracteres desordenados.
	 */
	private void checkFrasesCompletadas() {
		
		int num = 0;
		
		for (int i = 0; i < this.tablero.length; i++) {
			
			num = 0;
			
			for (int j = 0; j < this.tablero[0].length; j++) {
				
				if (this.tablero[i][j] == this.chosenSentences[i].charAt(j)) {
					
					num += 1;
					
					if (num == 15)
						this.frasesCompletadas[i] = true;
				}
			}
			
			// En caso de que se modifique una frase correcta, volver a ponerla en false
			if (num < 15)
				this.frasesCompletadas[i] = false;
		}
	}
	
	/**
	 * Método que comprueba si el jugador ha conseguido colocar todos los caracteres en el lugar correcto.
	 * Tiene en cuenta el porcentaje de compleción del tablero, proporcionado por el atributo 'porcentaje'.
	 * En caso de que haya ganado, envía la información del jugador al ranking para que sea actualizado.
	 * @return el resultado de la comprobación, que puede ser positivo o negativo.
	 */
	public boolean comprobarGanador() {
		
		if (this.porcentaje == 100) {
			
			this.ranking.actualizarRanking(this.dificultad, this.jugador);
			
			return true;
			
		} else
			return false;
		
	}
	
	/**
	 * Método que calcula el porcentaje total de compleción del tablero en función del total de caracteres colocados en el lugar correcto.
	 * Cuenta el total de aciertos y hace una media respecto del total de caracteres que hay en el tablero.
	 * Redondea el valor obtenido, multiplica por 100 y divide de nuevo entre 100 para obtener un número decimal con solo dos decimales.
	 */
	private void setPorcentaje() {
		
		double aciertos = 0;
		double porcentajeAciertos;
		
		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero[0].length; j++) {
				
				if(this.tablero[i][j] == this.chosenSentences[i].charAt(j))
					aciertos += 1;
				
			}
		}
		
		porcentajeAciertos = (aciertos * 100) / (15 * 6); // comprobar los porcentajes para ver si son correctos
		porcentajeAciertos = Math.round(porcentajeAciertos * 100);
		porcentajeAciertos /= 100;
		this.porcentaje = porcentajeAciertos;
	}
	
	/**
	 * Método que devuelve una pista para el usuario informando de un posible movimiento.
	 * Busca un carácter aleatorio cuya posición sea incorrecta y encuentra qué carácter debería ir en esa posición.
	 * Informa al usuario sobre la fila y columna donde debería posicionar un carácter y qué carácter debería ser el correcto.
	 * @return pistaGenerada, la pista en formato texto con la fila, columna y carácter a tener en cuenta.
	 */
	public String pedirPista() {
		
		char caracter = '~';
		int start, end, c;
		int frase = r.nextInt(6);
		boolean parar = false;
		
		while (this.frasesCompletadas[frase]) {
			
			frase = r.nextInt(6);		
		}
		
		int[] span = setStartEnd(frase);
		start = span[0];
		end = span[1];
		
		String pista = "";
		String linea = "\n +";
		
		while (!parar) {
			
			c = r.nextInt(start, end);
			
			if (this.tablero[frase][c] != this.chosenSentences[frase].charAt(c)) {
				caracter = this.chosenSentences[frase].charAt(c);
				pista = " | El caracter que va en fila " + frase + " y columna " + c + " debería ser: '" + caracter + "'. |";
				parar = true;
			}
		}
		
		for (int i = 0; i < pista.length() - 3; i++) {
			linea += "-";
		}
		
		linea += "+\n";
		
		String pistaGenerada = linea + pista + linea;
		
		this.jugador.updatePistas();
		
		return pistaGenerada;
	}
	
	/**
	 * Método que devuelve el principio y el comienzo de comprobación de caracteres del tablero en función de la dificultad y de si se trata de una frase al revés o no.
	 * @param fila, la frase que debe ser comprobada.
	 * @return span, el vector unidimensional con dos valores, el valor desde el que comenzar y el valor en el que finalizar.
	 */
	private int[] setStartEnd(int fila) {
		
		int start, end;
		
		if (this.frasesReves[fila]) {
			
			start = 0;
			
			if (this.dificultad.equals("Fácil")) {
				
				end = 7;
				
			} else if (this.dificultad.equals("Media")) {
				
				end = 11;
				
			} else {
			
				end = 14;
			}
			
		} else {
			
			end = 15;
			
			if (this.dificultad.equals("Fácil")) {
				
				start = 8;
				
			} else if (this.dificultad.equals("Media")) {
				
				start = 4;
				
			} else {
				
				start = 1;
			}
		}
		
		int[] span = new int[2];
		span[0] = start;
		span[1] = end;
		
		return span;
	}
	
	/**
	 * Método que restablece el tablero, el juego y la información del jugador necesaria según las elecciones del jugador, para poder comenzar un nuevo juego.
	 * @param dificultad, la nueva, o misma, dificultad elegida por el jugador.
	 * @param idioma, el mismo o diferente idioma en el que se mostrarán las frases del tablero.
	 */
	public void resetTablero(String dificultad, String idioma) {
		
		this.dificultad = dificultad;
		this.idioma = idioma;
		this.jugador.resetPistasUsadas();
		this.jugador.resetNumJugadas();
		
		if (dificultad.equals("Fácil"))
			
			this.jugador.setPistasRestantes(2);
		
		else if (dificultad.equals("Media"))
			
			this.jugador.setPistasRestantes(4);
		
		else
			
			this.jugador.setPistasRestantes(8);
		
		resetArrays();
		crearTablero();
		setPorcentaje();
	}
	
	/**
	 * Método que restablece algunos de los atributos que son vectores a sus valores predeterminados.
	 */
	private void resetArrays() {
		
		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero[0].length; j++) {
				this.tablero[i][j] = '-';
			}
		}
		
		for (int i = 0; i < this.chosenSentences.length; i++) {
			this.chosenSentences[i] = "";
		}
		
		for (int i = 0; i < this.frasesReves.length; i++) {
			this.frasesReves[i] = false;
		}
	}
	
	/**
	 * Método que pregunta y recoge la información sobre el ranking indicado por el usuario.
	 * @param num, el número correspondiente a la dificultad, indicando el ranking que quiere ser visualizado.
	 * @return el ranking elegido proveniente de la clase Ranking.
	 */
	public String pedirRanking(int num) {
		
		return this.ranking.crearRanking(num);
		
	}
	
	/**
	 * Método que mueve una letra aleatoria colocada correctamente a otro lugar del tablero dependiendo de la dificultad y de si se trata de una frase al revés.
	 * Dependiendo de la dificultad, hay una probabilidad que el movimiento se realice.
	 * @return el resultado de la probabilidad, que puede ser afirmativo en caso de realizarse o negativo si no se cumple la probabilidad.
	 */
	public boolean moverLetraAleatoria() {
		
		int probabilidad, num;
		int[] span;
		boolean mover;
		
		if (this.dificultad.equals("Fácil")) {
			
			probabilidad = 10;
			
		} else if (this.dificultad.equals("Media")) {
			
			probabilidad = 25;
			
		} else {
			
			probabilidad = 40;
		}
		
		num = r.nextInt(100);
		
		if (num < probabilidad)
			mover = true;
		else
			mover = false;
		
		if (mover) {
			
			int comienzo, fin, fila, caracter, fila2;
			boolean movida = false;
			boolean stop = false;
			char aux;
			
			while (!movida) {
				
				fila = r.nextInt(6);
				
				span = setStartEnd(fila);
				comienzo = span[0];
				fin = span[1];
				
				caracter = r.nextInt(comienzo, fin);
				
				/* Comprueba que un caracter aleatorio esté en la posición correcta.
				 * En caso de ser correcto, busca otro caracter aleatorio por el que ser sustituido siempre que ambos sean diferentes.
				 */
				if (this.tablero[fila][caracter] == this.chosenSentences[fila].charAt(caracter)) {
					
					fila2 = r.nextInt(6);
					span = setStartEnd(fila2);
					comienzo = span[0];
					fin = span[1];
					
					for (int i = comienzo; !stop && i < fin; i++) {
						
						if(this.tablero[fila2][i] != this.tablero[fila][caracter]) {
							aux = this.tablero[fila][caracter];
							this.tablero[fila][caracter] = this.tablero[fila2][i];
							this.tablero[fila2][i] = aux;
							stop = true;
							movida = true;
						}
					}
				}
			}
			
			if (movida) {
				setPorcentaje();
				checkFrasesCompletadas();
			}
			
			return true;
			
		} else {
			
			return false;
			
		}
	}

	/**
	 * Método toString que genera una cadena de caracteres que forma la visualización del tablero.
	 * @return str, que guarda la información sobre el tablero actual.
	 */
	@Override
	public String toString() { // crea el tablero en formato String
		
		String str = "\n ";
		
		str += "Porcentaje de compleción: " + this.porcentaje + "%\n\n ";
		str += "Nº de jugadas: " + this.jugador.getNumJugadas();
		
		str += "\n\n ";
		
		for (int j = 0; j < 61; j++) {
			if (j == 0 || j % 4 == 0)
				str += "+";
			else
				str += "-";
		}
		
		str += "\n";
		
		for (int i = 0; i < this.tablero.length; i++) {
			
			str += " | ";
			
			for (int j = 0; j < this.tablero[0].length; j++) {
				
				str += this.tablero[i][j];
				
				if (j < this.tablero[0].length - 1)
					str += " | ";
			}
			
			str += " | ";
			str += i + "\n ";
			
			for (int j = 0; j < 61; j++) {
				if (j == 0 || j % 4 == 0)
					str += "+";
				else
					str += "-";
			}
			
			if (i < this.tablero.length - 1)
				str += " -";
			
			str += "\n";
			
		}
		
		str += "   ";
		
		for (int i = 0; i < this.tablero[0].length; i++) {
			
			if (i < 10)
				str += i + " | ";
			else {
				str += i;
				if (i < this.tablero[0].length - 1)
					str += "| ";
			}
		}
		str += "\n";
		
		return str;
	}
}
