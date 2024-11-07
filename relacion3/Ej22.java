package relacion3;

import java.util.Scanner;

public class Ej22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int grupos = 0, numero, conteo;
		float suma;
		
		while (grupos < 5) {
			conteo = 0;
			suma = 0;
			while (conteo < 4) {
				System.out.println("Dame un nº:");
				numero = sc.nextInt();
				suma += numero;
				conteo++;
			}
			suma /= 4;
			if (grupos == 0) {
				System.out.printf("La media del primer grupo es: %f%n", suma);
			} else {
				if (grupos == 1) {
					System.out.printf("La media del segundo grupo es: %f%n", suma);
				} else {
					if (grupos == 2) {
						System.out.printf("La media del tercer grupo es: %f%n", suma);
					} else {
						if (grupos == 3) {
							System.out.printf("La media del cuarto grupo es: %f%n", suma);
						} else {
							System.out.printf("La media del último grupo es: %f%n", suma);
						}
					}
				}
			}
			
			grupos++;
		}
		
		
		
//		Escribir un programa que lea 5 grupos de cuatro valores cada uno y que, para cada
//		grupo, calcule la media y la escriba en pantalla.
		
		sc.close();
	}

}
