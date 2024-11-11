package relacion5;

import java.util.Random;
import java.util.Scanner;

public class Arrays_08 {
	
	static int seRepite(int[] vector, int n) {
		
		int contadorRep = 0;
		
		for (int i = 0; i < vector.length; i++) { // compruebo  cuántas veces aparece n (nº indicado por usuario) en el array
			if (n == vector[i]) {
				contadorRep++;
			}
		}
		
		return contadorRep;
		
//		for (int i = 0; i < vector.length; i++) {
//			valorRepetido = false;
//			for (int j = 0; j < i; j++) { // compruebo si el elemento "i" ha aparecido antes en la lista
//				if (vector[i] == vector[j]) {
//					valorRepetido = true; // si aparece, hay un valor repetido, entonces lo ignoro y paso al siguiente elemento
//				}
//			}
//			contadorRep = 0;
//			if (!valorRepetido) {
//				for (int j = 0; j < vector.length; j++) { // si el elemento "i" no ha aparecido todavía, cuento cuántas veces aparece "i" en la lista
//					if (vector[j] == vector[i]) {
//						contadorRep++;
//					}
//				}
//				System.out.println("El nº " + vector[i] + " aparece repetido " + contadorRep + " veces.");
//			}
//		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int[] elementos = new int[20]; // creo un array con 20 elementos
		int aleatorio;
		
		for (int i = 0; i < elementos.length; i++) { // al array anterior añado un nº anterior a cada posición
			aleatorio = random.nextInt(20);
			elementos[i] = aleatorio;
		}
		
		System.out.println("Dime un nº y te digo si aparece en el array y cuántas veces aparece:");
		int num = sc.nextInt();
		
		int repetido = seRepite(elementos, num); // llamo al método para que me diga si el nº indicado por el usuario está o no en el array y cuántas veces aparece
		System.out.println("El num " + num + " aparece " + repetido + " veces.");
	}

}
