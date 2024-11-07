package relacion4;

import java.util.Scanner;

public class Mersenne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, contador;
		double mersenne;
		boolean seguir = true;
		
		System.out.println("Introduce un nº y te digo si es un nº de Mersenne:");
		num = sc.nextInt();
		
		while (seguir) {
			while (num < 0) {
				System.out.println("No se permiten nºs negativos. Inserte otro nº:");
				num = sc.nextInt();
			}
			if (num == 0 || num == 1) {
				System.out.println("Los nºs 1 o 0 no se consideran nºs de Mersenne.");
			} else if (num == 2) {
				System.out.println("Sí es un nº de Mersenne.");
			} else {
				contador = 0;
				for (int i = 3; i <= Math.sqrt(num); i+=2) {
					if (num % i == 0) {
						contador++;
					}
				}
				if (contador > 0) {
					System.out.println("No es un nº de Mersenne.");
				} else {
					mersenne = Math.pow(2, num) - 1;
					for (int i = 3; i <= Math.sqrt(mersenne); i+=2) {
						if (mersenne % i == 0) {
							contador++;
						}
					}
					if (contador > 0) {
						System.out.println("No es un nº de Mersenne.");
					} else {
						System.out.println("Sí es de Mersenne.");
					}
				}
			}
			System.out.println("Si desea detener el programa, inserte -1, si no, inserte otro nº para averiguar si es de Mersenne o no:");
			num = sc.nextInt();
			if (num == -1) {
				seguir = false;
				System.out.println("Programa Finalizado");
			}
		}
		
//		todo natural de la forma 2p-1, siendo p un primo. Si ese resulta ser
//		primo se denomina primo de Mersenne.
	}

}
