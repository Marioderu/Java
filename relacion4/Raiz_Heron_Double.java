package relacion4;

import java.util.Scanner;

public class Raiz_Heron_Double {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int vueltas = 4;
		boolean continuar = true;
		double num, x = 1, raiz;
		
		
		System.out.println("Dame un nº y te digo su raíz cuadrada:");
		num = sc.nextDouble();
		
		while (continuar) {
			while (num <= 0) {
				System.out.println("Solo se permiten números superiores a 0. Inserte otro valor:");
				num = sc.nextDouble();
			}
			
			for (int i = 0; i < vueltas; i++) {
				raiz = (1d/2d) * (x + (num/x));
				x = raiz;
			}
			
			System.out.println("La raíz cuadrada de " + num + " es: " + x);
			System.out.println("Si desea detener el programa, inserte -1. Si desea continuar, inserte un nuevo valor:");
			num = sc.nextDouble();
			
			if (num == -1) {
				continuar = false;
				System.out.println("Programa Finalizado.");
			}
		}

	}

}
