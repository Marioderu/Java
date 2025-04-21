package modelo;

/**
 * Clase que guarda los elementos del jugador, nombre, número total de victorias y el tipo de ficha ('X' u 'O').
 * @author Mario Delgado Ruiz.
 */
public class Jugador {

	private String nombre;
	private char chip;
	private int victorias;

	/**
	 * Constructor sin parámetros que crea un jugador por defecto.
	 * Los atributos se asignan durante la ejecución del programa.
	 */
	public Jugador() {
		this.nombre = "anónimo";
		this.chip = '.';
		this.victorias = 0;
	}
	
	/**
	 * Getter que devuelve el nombre del jugador.
	 * @return nombre, guarda el nombre elegido por el jugador.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Getter que devuelve el tipo de ficha usada por el jugador durante el juego.
	 * @return chip, guarda la ficha asignada al jugador.
	 */
	public char getChip() {
		return chip;
	}
	
	/**
	 * Setter que asigna un valor al atributo nombre del jugador.
	 * @param nombre, contiene el nombre elegido por el jugador.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Setter que asigna el tipo de ficha a usar por el jugador.
	 * @param chip, contiene la ficha que usará el jugador durante el juego.
	 */
	public void setChip(char chip) {
		this.chip = chip;
	}
	
	/**
	 * Getter que obtiene el número de victorias del jugador.
	 * @return victorias, contiene el total de victorias del jugador tras una partida.
	 */
	public int getVictorias() {
		return victorias;
	}
	
	/**
	 * Método que resetea las victorias del jugador y las establece a 0.
	 */
	public void resetVictorias() {
		this.victorias = 0;
	}
	
	/**
	 * Método que suma uno al número de victorias del jugador si, tras un juego, ha ganado la partida.
	 */
	public void sumarVictoria() {
		this.victorias += 1;
	}
}
