package relacion5;

import java.util.Random;

public class Arrays_10 {
	
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
		int aleatorio, pares, impares, posPar, posImpar;
		
		for (int i = 0; i < vector.length; i++) {
			aleatorio = random.nextInt(50); // asigno un nº aleatorio a todos los índices del array
			vector[i] = aleatorio;
		}
		
		pares = numerosPares(vector); // llamo a los métodos para saber cuántos nºs pares e impares hay
		impares = numerosImpares(vector);
		
		System.out.println("El array de los pares contiene " + pares + " elementos.");
		System.out.println("El array de los impares contiene " + impares + " elementos.");
		
		vectorPar = new int[pares];
		vectorImpar = new int[impares];
		posPar = 0;
		posImpar = 0;
		
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 == 0) {
				vectorPar[posPar] = vector[i];
				posPar++;
			} else {
				vectorImpar[posImpar] = vector[i];
				posImpar++;
			}
		}
		
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
