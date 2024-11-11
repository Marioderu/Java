package relacion5;

import java.util.Random;

public class Arrays_10 {

	static int[] vectorPares(int[] v, int n) {
		
		int[] pares;
		int indice = 0;
		
		pares = new int[n]; // asigno un tamaño del array según n
		
		for (int i = 0; i < v.length; i++) {
			
			if (v[i] % 2 == 0) { // añado los nºs pares al nuevo array con un contador que funciona como índice
				pares[indice] = v[i];
				indice++;
			}
		}
		
		return pares;
	}
	
	static int[] vectorImpares(int[] v, int n) {
		
		int[] impares;
		int indice = 0;
		
		impares = new int[n]; // asigno un tamaño del array según n
		
		for (int i = 0; i < v.length; i++) {
			
			if (v[i] % 2 != 0) { // añado los nºs pares al nuevo array con un contador que funciona como índice
				impares[indice] = v[i];
				indice++;
			}
		}
		
		return impares;
	}
	
	static int numerosPares(int[] v) {
		
		int pares = 0;
		
		for (int i = 0; i < v.length; i++) { // cuento los nºs pares del array original para saber el tamaño del array de nºs pares
			if (v[i] % 2 == 0) {
				pares++;
			}
		}
		
		return pares;
	}
	
	static int numerosImpares(int[] v) {
		
		int impares = 0;
		
		for (int i = 0; i < v.length; i++) { // cuento los nºs pares del array original para saber el tamaño del array de nºs pares
			if (v[i] % 2 != 0) {
				impares++;
			}
		}
		
		return impares;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] vector = new int[35], vectorImpar, vectorPar;
		int aleatorio, pares, impares;
		
		for (int i = 0; i < vector.length; i++) {
			aleatorio = random.nextInt(50); // asigno un nº aleatorio a todos los índices del array
			vector[i] = aleatorio;
		}
		
		pares = numerosPares(vector); // llamo a los métodos para saber cuántos nºs pares e impares hay
		impares = numerosImpares(vector);
		
		System.out.println("El array de los pares contiene " + pares + " elementos.");
		System.out.println("El array de los impares contiene " + impares + " elementos.");
		
		vectorPar = vectorPares(vector, pares); // llamo a los métodos para crear dos arrays en función de las llamadas a los métodos anteriores para conocer la longitud de cada array
		vectorImpar = vectorImpares(vector, impares);
		
		System.out.println("\n<------------------------------------------------------->");
		System.out.println("El array original es: ");
		
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
		
		System.out.println("\n<------------------------------------------------------->");
		System.out.println("\nEl array de nºs pares contiene estos elementos: ");
		
		for (int i = 0; i < vectorPar.length; i++) {
			System.out.print(vectorPar[i] + " ");
		}
		
		System.out.println("\n<------------------------------------------------------->");
		System.out.println("\nEl array de nºs impares contiene estos elementos: ");
		
		for (int i = 0; i < vectorImpar.length; i++) {
			System.out.print(vectorImpar[i] + " ");
		}
		
	}

}
