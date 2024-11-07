package relacion4;

import java.util.Scanner;

public class Oblongo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, resultado;
		boolean oblongo = false, seguir = true;
		
		System.out.println("Dame un nº y te digo si es oblongo:");
		num = sc.nextInt();
		
		while (seguir) {
			while (num < 0) {
				System.out.println("Solo se permite nºs a partir de 0. Inserte un valor permitido:");
				num = sc.nextInt();
			}
			
			oblongo = false;
			for (int i = 1; i <= num / 2 && !oblongo; i ++) {
				resultado = i * (i + 1);
				if (resultado == num) {
					oblongo = true;
				} else if (resultado > num) {
					i += num;
				}
				System.out.println(resultado);
			}
			if (oblongo) {
				System.out.println("Es OBLONGO.");
			} else {
				System.out.println("No es Oblongo.");
			}
			
			System.out.println("Si desea parar, pulse -1. Si desea evaluar otro valor, inserte un nuevo nº:");
			num = sc.nextInt();
			if (num == -1) {
				seguir = false;
				System.out.println("Programa Finalizado.");
			}
		}
		

	}

}
