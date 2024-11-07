package relacion4;

import java.util.Scanner;

public class Repunit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, resto, diferenteDeUno = 0;
		boolean continuar = true;
		
		System.out.println("Dame un nº y te digo si es repunit:");
		num = sc.nextInt();
		
		while (continuar) {
			while (num < 0) {
				System.out.println("No se permiten valores negativos. Inserte otro valor:");
				num = sc.nextInt();
			}
			
			while (num >= 0) {
				resto = num % 10;
				if (resto != 1) {
					diferenteDeUno++;
				}
				num /= 10;
			}
			
			if (diferenteDeUno == 0) {
				System.out.println("Sí es un nº REPUNIT.");
			} else {
				System.out.println("No es Repunit.");
			}
			
			System.out.println("Si desea parar pulse -1. Si desea continuar, inserte otro número para analizar:");
			num = sc.nextInt();
			
			if (num == -1) {
				continuar = false;
				System.out.println("Programa Finalizado");
			}
		
		}

	}

}
