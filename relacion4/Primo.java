package relacion4;

import java.util.Scanner;

public class Primo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un nº y te digo si es primo o no:");
		int num = sc.nextInt();
		
		
		while (num < 0) {
			System.out.println("No se admiten valores negativos. Introduzca otro valor:");
			num = sc.nextInt();
		}
		while (num >= 0) {
			if (num == 0 || num == 1) {
			System.out.println("0 o 1 no son primos");
			} else {
				if (num == 2) {
					System.out.println("Es primo");
				} else {
					boolean esPrimo = true;
					for (int i = 3; i <= Math.sqrt(num) && esPrimo; i+=2) {
						if (num % i == 0) {
							esPrimo = false;
						}
					}
					if (esPrimo) {
						System.out.println("Es primo");
					} else {
						System.out.println("No es primo");
					}
					
				}
			}
			System.out.println("Quieres insertar otro nº?");
			System.out.println("Inserta un número positivo para calcular o inserta -1 para parar");
			num = sc.nextInt();
		}
		
		
		

	}

}
