package relacion4;

import java.util.Scanner;

public class Compuesto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Dame un nº y te digo si es primo o compuesto:");
		int num = sc.nextInt();
		boolean continuar = true;
		
		
		while (continuar) {
			while (num < 0) {
				System.out.println("No se admiten valores negativos. Introduzca otro valor:");
				num = sc.nextInt();
			}
			if (num == 0 || num == 1) {
			System.out.println(num + " no es ni primo ni compuesto");
			} else {
				if (num == 2) {
					System.out.println(num + " es primo");
				} else {
					if (num % 2 == 0) {
						System.out.println(num + " es compuesto.");;
					} else {
						boolean esCompuesto = false;
						for (int i = 3; i <= Math.sqrt(num) && !esCompuesto; i+=2) {
							if (num % i == 0) {
								esCompuesto = true;
							}
						}
						if (esCompuesto) {
							System.out.println("Es compuesto");
						} else {
							System.out.println("Es primo");
						}
					}				
				}
			}
			System.out.println("Quieres insertar otro nº?");
			System.out.println("Inserta un número positivo para calcular o inserta -1 para parar");
			num = sc.nextInt();
			if (num == -1) {
				continuar = false;
			}
		}
		
		
		
	}

}
