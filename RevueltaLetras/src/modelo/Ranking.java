package modelo;

/**
 * Clase que guarda los rankings del juego en una matriz de dos dimensiones.
 * Se encarga de guardar los jugadores y el número de jugadas en función de la dificultad y ordenados por número de jugadas totales.
 * @author Mario Delgado Ruiz.
 */
public class Ranking {

	Jugador[][] ranking;
	
	/**
	 * Constructor sin parámetros que inicializa una matriz de dos dimensiones de 3 x 100.
	 * Cada fila equivale a una dificultad y cada dificultad tiene espacios suficientes desde el principio.
	 */
	public Ranking() {
		
		this.ranking = new Jugador[3][100];
		
	}
	
	/**
	 * Método que se encarga de actualizar el ranking en función de la dificultad y la información del jugador recibida.
	 * Añade un jugador a una dificultad tras completar una partida y se encarga de ordenar por número de jugadas, de menor a mayor.
	 * @param dificultad, la dificultad en la que el jugador ha completado una partida.
	 * @param jugador, la información del jugador necesaria para incluirla en el ranking.
	 */
	public void actualizarRanking(String dificultad, Jugador jugador) {
		
		int fila;
		int c1 = 0, c2 = 0;
		boolean hayEspacio = false;
		Jugador aux;
		
		if (dificultad.equals("Fácil")) {
			
			fila = 0;
			
		} else if (dificultad.equals("Media")) {
			
			fila = 1;
			
		} else {
			
			fila = 2;
		}
		
		for (int i = 0; i < this.ranking[fila].length; i++) {
			
			if (this.ranking[fila][i] == null)
				hayEspacio = true;
		}
		
		if (!hayEspacio)
			agrandarEspacioRanking();
		
		boolean colocado = false;
		
		while (!colocado && c1 < this.ranking[fila].length) {
			
			if (this.ranking[fila][c1] == null) {
				this.ranking[fila][c1] = jugador;
				colocado = true;
			}
			
			c1 += 1;
		}
		
		c1 = 0;
		
		// ordena el ranking por número de jugadas (de menor a mayor)
		while (c1 < this.ranking[fila].length && this.ranking[fila][c1] != null) {
			
			c2 = 0;
			
			while (c2 < this.ranking[fila].length && this.ranking[fila][c2] != null) {
				
				if (this.ranking[fila][c1].getNumJugadas() < this.ranking[fila][c2].getNumJugadas()) {
					
					aux = this.ranking[fila][c1];
					this.ranking[fila][c1] = this.ranking[fila][c2];
					this.ranking[fila][c2] = aux;
				}
				
				c2 += 1;
			}
			
			c1 += 1;
		}
	}
	
	/**
	 * Método que se encarga de duplicar el espacio del ranking en caso de que alguna de las dificultades esté llena.
	 */
	private void agrandarEspacioRanking() {
		
		Jugador[][] nuevo = new Jugador[3][this.ranking[0].length * 2];
		
		for (int i = 0; i < this.ranking.length; i++) {
			
			for (int j = 0; j < this.ranking[0].length; j++) {
				
				nuevo[i][j] = this.ranking[i][j];
			}
		}
		
		this.ranking = nuevo;
	}
	
	/**
	 * Método que devuelve una cadena con la información del ranking elegido por el jugador.
	 * @param num, el número correspondiente con la fila de la matriz que representa una de las tres dificultades.
	 * @return str, el ranking creado en formato texto con la información necesaria.
	 */
	public String crearRanking(int num) {
		
		boolean isEmpty = false;
		String str = "";
		String dificultad;
		
		if (num == 0)
			dificultad = "Dificultad: Fácil";
		else if (num == 1)
			dificultad = "Dificultad: Media";
		else
			dificultad = "Dificultad: Difícil";
		
		if (this.ranking[num][0] == null)
			isEmpty = true;
		
		if (!isEmpty) {
			
			int col = 0;
			int longNombre, longJugadas, longPos;
			String encabezado = " |  Posición  |  Nombre de Jugador  |  Total Jugadas  |  Pistas Usadas  | ";
			String linea = " +------------+---------------------+-----------------+-----------------+ ";
			String espacio = "";
			
			str += "\n RANKING DE JUGADORES  || " + dificultad + "\n";
			str += "\n" + linea + "\n" + encabezado + "\n" + linea;
			
			while (col < this.ranking[num].length && this.ranking[num][col] != null) {
				
				espacio = "";
				longNombre = this.ranking[num][col].getNombre().length();
				
				if (this.ranking[num][col].getNumJugadas() < 10)
					longJugadas = 1;
				else if (this.ranking[num][col].getNumJugadas() < 100)
					longJugadas = 2;
				else
					longJugadas = 3;
				
				if (col < 9)
					longPos = 1;
				else if (col < 99)
					longPos = 2;
				else
					longPos = 3;
				
				for (int i = 0; i < 8 - longPos; i++) {
					espacio += " ";
				}
				
				str += "\n |            |                     |                 |                 | \n";
				str += " |  " + (col + 1) + espacio + "  |  ";
				
				espacio = "";
				
				for (int i = 0; i < 17 - longNombre; i++) {
					espacio += " ";
				}
				
				str += this.ranking[num][col].getNombre() + espacio + "  |  ";
				
				espacio = "";
				
				for (int i = 0; i < 13 - longJugadas; i++) {
					espacio += " ";
				}
				
				str += this.ranking[num][col].getNumJugadas() + espacio + "  |  ";
				str += this.ranking[num][col].getPistasUsadas() + espacio + "   | ";
				str += "\n |            |                     |                 |                 | \n";
				str += linea;
				
				col += 1;
			}
			
		} else {
			
			str += "\n RANKING DE JUGADORES  ||  Dificultad: " + dificultad + "\n";
			str += " +--------------------------------------------------------------------+\n";
			str += " | Este ranking todavía está vacío.                                   |\n";
			str += " | No hay jugadores que hayan completado el juego en esta dificultad. |\n";
			str += " | Podrías ser el/la primero/a en hacerlo. ¡Anímate y juega!          |\n";
			str += " +--------------------------------------------------------------------+";
		}
		
		return str;
	}
}
