package relacion4;

import java.util.Scanner;

public class Odioso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, contador;
		boolean seguir = true;
		System.out.println("Dame un nº y te digo si es Odioso:");
		
		num = sc.nextInt();
		
		while (seguir) {
			
			while (num <= 0) {
				System.out.println("No se permiten ni nºs negativos ni el valor 0. Inserte un valor mayor a 0:");
				num = sc.nextInt();
			}
			contador = 0;
			while (num > 0) {
				if (num % 2 != 0) {
					contador++;
				}
				num /= 2;
			}
			if (contador % 2 != 0) {
				System.out.println("SÍ es un nº ODIOSO.");
			} else {
				System.out.println("NO es Odioso.");
			}
			System.out.println("Si desea continuar introduzca otro valor para evaluar. Si desea parar, inserte -1:");
			num = sc.nextInt();
			if (num == -1) {
				seguir = false;
				System.out.println("Programa Finalizado.");
			}
		}

	}

}
