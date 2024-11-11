package relacion5;

import java.util.Random;
import java.util.Scanner;

public class Arrays_11 {
	
	static int estaEnArray1(int[] v, int n) {
		
		boolean contiene = false;
		int i = 0;
		
		while (!contiene && i < v.length) {
			if (v[i] == n) {
				contiene = true; // comparo n con los índices del array y comprobar si se encuentra en el array
			} else {
				i++;
			}
		}
		
		if (!contiene) // si se mantiene falso, no ha encontrado ninguna coincidencia
			i = -1;
		
		return i;
	}
	
	static int estaEnArray2(int[] v, int n) {
		
		boolean contiene = false;
		int i = 0;
		
		while (!contiene && i < v.length) {
			if (v[i] == n) {
				contiene = true; // comparo n con los índices del array y comprobar si se encuentra en el array
			} else {
				i++;
			}
		}
		
		if (!contiene) // si se mantiene falso, no ha encontrado ninguna coincidencia
			i = -1;
		
		return i;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int num, aleatorio, estaEn1, estaEn2;
		int[] vector = new int[20];
		int[] vector2 = new int[30];
		
		for (int i = 0; i < vector.length; i++) { // creo ambos arrays con nºs aleatorios
			aleatorio = random.nextInt(20);
			vector[i] = aleatorio;
		}
		
		for (int i = 0; i < vector2.length; i++) {
			aleatorio = random.nextInt(20);
			vector2[i] = aleatorio;
		}
		
		System.out.println("Dime un nº y te digo si aparece o no en alguno de los dos arrays creados y su posición en el array. Si la posición es -1, no se encuentra en el array:");
		num = sc.nextInt();
		
		estaEn1 = estaEnArray1(vector, num); // llamo a ambos métodos para comprobar si num está en alguno de los arrays
		estaEn2 = estaEnArray2(vector2, num);
		
		System.out.println("El primer array es: ");
		
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
		
		System.out.println("\n<-------------------------------------------------------->");
		System.out.println("\nEl segundo array es: ");
		
		for (int i = 0; i < vector2.length; i++) {
			System.out.print(vector2[i] + " ");
		}
		
		System.out.println("\n<-------------------------------------------------------->");
		System.out.println("El nº " + num + " está en la posición " + estaEn1 + " del primer array");
		System.out.println("El nº " + num + " está en la posición " + estaEn2 + " del segundo array");
	}

}
