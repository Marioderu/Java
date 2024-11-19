package relacion5;

import java.util.Random;

public class Arrays_09 {

	static int vectorPares(int[] v) { // cuento cuántas posiciones pares tiene el array
		
		int posicionPar = 0;
		
		for (int i = 0; i < v.length; i++) {
			
			if (i % 2 == 0) {
				posicionPar++;
			}
		}
		
		return posicionPar;
	}
	
	static int vectorImpares(int[] v) { // cuento cuántas posiciones impares tiene el array
		
		int posicionImpar = 0;
		
		for (int i = 0; i < v.length; i++) {
			
			if (i % 2 != 0) {
				posicionImpar++;
			}
		}
		
		return posicionImpar;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int longitud = random.nextInt(10, 50);
		int aleatorio, cantidadPares, cantidadImpares, contador1, contador2;
		int[] vector = new int[longitud]; // creo un array con un tamaño de 30 elementos
		int[] pares, impares;
		
		for (int i = 0; i < vector.length; i++) {
			aleatorio = random.nextInt(1, 50); // a cada índice del array le añado un nº aleatorio
			vector[i] = aleatorio;
		}
		
		// llamo a los métodos para saber cuántas posiciones pares e impares hay en el array principal
		cantidadPares = vectorPares(vector);
		cantidadImpares = vectorImpares(vector);
		
		// asigno el nº de posiciones a sus arrays correspondientes para conocer cuánto elementos tiene cada uno.
		pares = new int[cantidadPares];
		impares = new int[cantidadImpares];
		contador1 = 0;
		contador2 = 0;
		
		for (int i = 0; i < vector.length; i++) { // los nºs de las posiciones pares se insertan en el array de pares
			if (i % 2 == 0) {
				pares[contador1] = vector[i];
				contador1++;
			}
		}
		
		for (int i = 0; i < vector.length; i++) { // los nºs de las posiciones impares se insertan en el array de impares
			if (i % 2 != 0) {
				impares[contador2] = vector[i];
				contador2++;
			}
		}
		
		System.out.println("El array inicial es: ");
		
		for (int i = 0; i < vector.length; i++) { // muestro la información de los 3 arrays
			System.out.print(vector[i] + " ");
		}
		
		System.out.println("\nEl nuevo array con los elementos de las posiciones pares es: ");
		
		for (int i = 0; i < pares.length; i++) {
			System.out.print(pares[i] + " ");
		}
		
		System.out.println("\nEl otro nuevo array con los elementos de las posiciones impares es: ");
		
		for (int i = 0; i < impares.length; i++) {
			System.out.print(impares[i] + " ");
		}
	}
}
