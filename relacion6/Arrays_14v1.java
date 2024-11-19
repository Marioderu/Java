package relacion5;

import java.util.Random;
import java.util.Scanner;

public class Arrays_14v1 {

	static boolean numNuevoRepetido(int[] v, int nuevo) { // comprueba si un numero nuevo generado por S de seguir sacando bolas, está ya en el array original
		
		boolean encontrado = false;
		int indice = 0;
		
		while (!encontrado && indice < v.length) { // mientras no se encuentre, girará y subirá el índice comprobando si un num aparece en el array o no
			if (v[indice] == nuevo)				   // si hay una coincidencia, para el bucle. Se envía una respuesta al main
				encontrado = true;
			else
				indice++;
		}
		
		return encontrado;
	}
	
	private static boolean comprobarBingo(int[] vOriginal, int[] usuario) { // compruebo si los nºs introducidos por el usuario aparecen en el bingo y cantar bingo
		
		int contador = 15;
		boolean hayBingo = false;
		
		for (int i = 0; i < usuario.length; i++) { // por cada elemento del array del usuario, se comprueba la equivalencia con todos los elementos del array de bingo
			
			for (int j = 0; j < vOriginal.length; j++) {
				
				if (usuario[i] == vOriginal[j]) // si encuentra una equivalencia, restamos uno al contador
					contador--;
			}
		}
		
		if (contador == 0) { // si el contador llega a 0, los 15 nºs del usuario coinciden con los del Bingo, entonces se canta bingo
			hayBingo = true;
		}
		
		return hayBingo; // devolvemos el valor al main
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int[] numBingo = new int[15], numNuevos, bingoUsuario = new int[15]; // Inicializar variables
		int aleatorio = 0, numeroUsuario, respuesta, indice = 0, posicion;
		boolean detener = false, comprobar, aleatorioYaExiste, generarRandom = true;
		
		boolean encontrado = false;
		
		while (indice < numBingo.length) { // recorro el array del Bingo para buscar nºs repetidos
									// compruebo posición por posición
			encontrado = false;
			aleatorio = random.nextInt(1, 91); // genero un nº aleatorio
			posicion = 0;
			
			while (!encontrado && posicion < indice) { // recorro el array desde 0 hasta la posición actual
				
				if (numBingo[posicion] == aleatorio)	// si el nº actual es igual al generado arriba, paro el bucle interno porque hay una coincidencia
					encontrado = true;
				else			// si no hay coincidencia, aumento el una posición para comprobar el siguiente valor antes de la posición actual
					posicion++;
			}
			
			if (!encontrado) { // si no se encuentran nºs repetidos en la vuelta, añado el nº generado random a la posición actual del array
				numBingo[indice] = aleatorio;
				indice++;
			}
		}
		
		System.out.println("Los 15 primeros nºs son:\n");
		
		for (int i = 0; i < numBingo.length; i++) { // muestro al usuario el bingo generado
			System.out.print(numBingo[i] + " ");
		}
		
		
		while (!detener) {
			System.out.println("\n\n¿Siguiente bola (1), Comprobar bingo (2) o Terminar (3)?"); // entramos al bucle para generar más nºs, comprobar bingo o terminar programa
			System.out.println("Inserte uno de los números para realizar una acción.");			 // recojo 1, 2 o 3 según la acción
			respuesta = sc.nextInt();
			
			if (respuesta == 1){
				generarRandom = true;
				
				while (generarRandom) { // genero un nº random y lo envío al método para comprobar si ese nº existe o no en el bingo
					aleatorio = random.nextInt(1, 91);
					aleatorioYaExiste = numNuevoRepetido(numBingo, aleatorio);
					
					if (!aleatorioYaExiste) { // si el nº existe, paro el bucle. Si existe, doy la vuelta, genero otro nº y vuelvo a comprobar
						generarRandom = false;
					}
				}
				
				numNuevos = new int[numBingo.length + 1]; // creo un array nuevo con el tamaño del array original + 1 del nuevo numero a introducir
				
				for (int i = 0; i < numBingo.length; i++) { // copio el contenido del array original en el array nuevo
					numNuevos[i] = numBingo[i];
				}
				
				numNuevos[numNuevos.length - 1] = aleatorio; // añado el numero nuevo a la última posición del array
				numBingo = numNuevos; // reasigno el valor del bingo original al nuevo generado
				
				System.out.println("Nuevo nº: " + aleatorio);
				
			} else if (respuesta == 2) {
				
				System.out.println("Vamos a comprobar si tienes bingo.");
				
				for (int i = 0; i < 15; i++) {
					System.out.println("Introduce un nº"); // con un bucle le pido al usuario que inserte los 15 nºs para ganar el bingo y los inserto en un array
					numeroUsuario = sc.nextInt();
					bingoUsuario[i] = numeroUsuario;
				}
				
				comprobar = comprobarBingo(numBingo, bingoUsuario); // envío el array creado por los nºs del usuario para comprobar si tiene bingo
				
				if (comprobar) {
					System.out.println("¡¡¡¡BIIINGOOOOO!!!!"); // según la respuesta del método, paro el programa o continúo al principio del bucle
					System.out.println("Enhorabuena, has ganado un premio");
					detener = true;
				} else {
					System.out.println("No tienes bingo, lo siento. Sigue jugando.");
				}
				
			} else if (respuesta == 3) { // paro el programa
				
				detener = true;
				
			}
		}
	}
}
