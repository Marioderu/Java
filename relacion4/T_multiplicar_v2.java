package relacion4;

import java.util.Scanner;

public class T_multiplicar_v2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Qué tabla de multiplicar quieres saber?");
		int num = sc.nextInt(), tabla;
		boolean seguir = true;
		
		while (num < 0) {
			System.out.println("No se permiten valores negativos. Introduzca otro número");
			num = sc.nextInt();
		}
		while (seguir) {
			for (int i = 1; i <= num; i++) {
				for (int j = 0; j <= 10; j++) {
					tabla = i * j;
					System.out.println(i + " x " + j + " = " + tabla);
				}
				
			}
			System.out.println("Si desea parar introduzca un valor negativo, sino introduzca otro valor para ser calculado:");
			num = sc.nextInt();
			if (num < 0) {
				seguir = false;
				System.out.println("Programa finalizado.");
		}
			
			
		}
		
		
		
		

	}

}
