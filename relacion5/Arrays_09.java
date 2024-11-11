package relacion5;

import java.util.Random;

public class Arrays_09 {

	static int[] vectorPares(int[] v) {
		
		int[] pares;
		int indice = 0;
		
		pares = new int[v.length / 2]; // asigno un tamaño del array a la mitad del original
		
		for (int i = 0; i < v.length; i++) {
			
			if (i % 2 == 0) { // añado los nºs en una posición par al nuevo array con un contador que funciona como índice
				pares[indice] = v[i];
				indice++;
			}
		}
		
		return pares;
	}
	
	static int[] vectorImpares(int[] v) {
		
		int[] impares;
		int indice = 0;
		
		impares = new int[v.length / 2]; // asigno un tamaño del array a la mitad del original
		
		for (int i = 0; i < v.length; i++) { 
			
			if (i % 2 != 0) { // añado los nºs en una posición par al nuevo array con un contador que funciona como índice
				impares[indice] = v[i];
				indice++;
			}
		}
		
		return impares;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int aleatorio;
		int[] vector = new int[30]; // creo un array con un tamaño de 30 elementos
		
		for (int i = 0; i < vector.length; i++) {
			aleatorio = random.nextInt(50); // a cada índice del array le añado un nº aleatorio
			vector[i] = aleatorio;
		}
		
		// llamo a los métodos para crear dos arrays en función de la posición de los elementos del array original, par o impar
		int[] pares = vectorPares(vector);
		int[] impares = vectorImpares(vector);
		
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
