package app;

import controlador.Control;

/**
 * Clase cuyo fin es el de iniciar la aplicación llamando al Controlador.
 * @author Mario Delgado Ruiz.
 */

public class App {

	/**
	 * Método main que arranca/ejecuta la aplicación.
	 * @param args.
	 */
	public static void main(String[] args) {
		
		Control control = new Control();

		control.start();
	}

}
