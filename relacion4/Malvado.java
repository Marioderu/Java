package relacion4;

import java.util.Scanner;

public class Malvado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, contador = 0;
		System.out.println("Dame un nº y te digo si es malvado:");
		num = sc.nextInt();
		
		while (num > 0) {
			if (num % 2 == 1) {
				contador++;
			}
			num /= 2;
		}
		if (contador % 2 == 0) {
			System.out.println("Sí es Malvado.");
		} else {
			System.out.println("No es Malvado.");
		}

	}

}
