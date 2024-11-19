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
