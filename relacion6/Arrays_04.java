package relacion5;

import java.util.Random;
import java.util.Scanner;

public class Arrays_04 {
	
	static int coincidencias(int n, int[] array1, int[] array2) {
		int coincidencia = 0;
		
		for (int i = 0; i < array1.length; i++) { // compruebo cuántas veces coincide un nº de array1 en array2
			
			if (array1[i] == n) {
			
				for (int j = 0; j < array2.length; j++) {
				
					if (array1[i] == array2[j]) {
						coincidencia++;
					}
				}
			}
		}
		
		return coincidencia;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Dame un nº y te digo las coincidencias entre 2 arrays:");
		int num = sc.nextInt();
		int aleatorio = 0;
		
		int[] array1 = new int[20]; // dos arrays del mismo tamaño
		int[] array2 = new int[20];
		
		for (int i = 0; i < array1.length; i++) { // relleno ambos arrays con nºs aleatorios
			aleatorio = random.nextInt(50);
			array1[i] = aleatorio;
		}
		
		for (int i = 0; i < array2.length; i++) {
			aleatorio = random.nextInt(50);
			array2[i] = aleatorio;
		}
		
		int coinciden = coincidencias(num, array1, array2); // envío los arrays y el nº del usuario para comprobar si hay coincidencias
		System.out.println("El num " + num + " del array 1 coincide " + coinciden + " veces.");
	}

}
