package relacion4;

import java.util.Scanner;

public class Amigos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, suma1 = 0, suma2 = 0;
		boolean seguir = true;
		
		System.out.println("Dame dos nºs y te digo si son amigos:");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		while (seguir) {
			if (num1 <= 0 || num2 <= 0) {
				System.out.println("No se admiten nºs negativos ni 0. Inserte otro valor:");
				if (num1 <= 0 && num2 > 0) {
				num1 = sc.nextInt();
				} else {
					if (num2 <= 0 && num1 > 0) {
						num2 = sc.nextInt();
					} else {
						num1 = sc.nextInt();
						num2 = sc.nextInt();
					}
				}
			}
			
			for (int i = 1; i <= num1 / 2; i++) {
				if (num1 % i == 0) {
					suma1 += i;
				}
			}
			
			for (int i = 1; i <= num2 / 2; i++) {
				if (num2 % i == 0) {
					suma2 += i;
				}
			}
			
			if (suma1 == num2 && suma2 == num1) {
				System.out.println("Son amigos");
			} else {
				System.out.println("No son amiguetes");
			}
			suma1 = 0;
			suma2 = 0;
			System.out.println("Deseas meter otros dos números? Si es así, introduce otros dos");
			System.out.println("Si no, escribe -1");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			if (num1 == -1 || num2 == -1) {
				seguir = false;
				System.out.println("Programa finalizado. Gracias por usarlo.");
			}
		}
		
		
//		parejas de s que cumplen que la suma de los divisores propios de cada uno de
//		ellos da como resultado el otro . Por ejemplo, 220 y 284 son s amigos.

	}

}
