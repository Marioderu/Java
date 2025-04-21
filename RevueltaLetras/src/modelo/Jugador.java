package modelo;

/**
 * Clase que guarda los elementos del jugador, nombre, número total de jugadas, pistas restantes y pistas utilizadas.
 * @author Mario Delgado Ruiz.
 */
public class Jugador {

	private String nombre;
	private int numJugadas;
	private int pistasRestantes;
	private int pistasUsadas;
	
	/**
	 * Constructor que asigna un nombre al jugador e inicia el resto de atributos a sus valores correspondientes en función de la dificultad.
	 * @param nombre, el nombre escogido por el jugador.
	 * @param pistas, el total de pistas que puede usar el jugador dependiendo de la dificultad elegida.
	 */
	public Jugador(String nombre, int pistas) {
		this.nombre = nombre;
		this.numJugadas = 0;
		this.pistasRestantes = pistas;
		this.pistasUsadas = 0;
	}
	
	/**
	 * Getter que devuelve el nombre del jugador.
	 * @return nombre, el nombre que el jugador elige al principio de la ejecución del programa.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Setter que establece el nombre del jugador al valor recibido por parámetro.
	 * @param nombre, el nombre elegido por el jugador.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Getter que devuelve el número de jugadas del jugador.
	 * @return numJugadas, el número total de jugadas realizada por el jugador.
	 */
	public int getNumJugadas() {
		return numJugadas;
	}
	
	/**
	 * Método que aumenta en uno el número de jugadas cada vez que el jugador realiza un movimiento.
	 */
	public void updateNumJugadas() {
		this.numJugadas += 1;
	}
	
	/**
	 * Método que restablece a 0 el número de jugadas.
	 */
	public void resetNumJugadas() {
		this.numJugadas = 0;
	}
	
	/**
	 * Getter que devuelve el número de pistas sin usar del jugador.
	 * @return pistasRestantes, el total de pistas que quedan por usar.
	 */
	public int getPistasRestantes() {
		return pistasRestantes;
	}
	
	/**
	 * Setter que establece el número de pistas restantes del jugador.
	 * @param num, el número de pistas restantes.
	 */
	public void setPistasRestantes(int num) {
		this.pistasRestantes = num;
	}
	
	/**
	 * Getter que devuelve el número de pistas que han sido usadas por el jugador.
	 * @return pistasUsadas, el número total de pistas utilizadas.
	 */
	public int getPistasUsadas() {
		return pistasUsadas;
	}
	
	/**
	 * Método que restablece a 0 el número de pistas utilizadas.
	 */
	public void resetPistasUsadas() {
		this.pistasUsadas = 0;
	}
	
	/**
	 * Método que actualiza el número de pistas restantes y el número de pistas usadas tras cada uso.
	 * Disminuye en uno el número de pistas restantes y aumenta en uno el número de pistas utilizadas.
	 */
	public void updatePistas() {
		this.pistasRestantes -= 1;
		this.pistasUsadas += 1;
	}
}
