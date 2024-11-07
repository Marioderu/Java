package relacion3;

import java.util.Scanner;

public class Ej20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, rango = 4;
		num = sc.nextInt();
		while (num <= 4) {
			System.out.println("El número ha de ser mayor que 4. Introduce otro valor:");
			num = sc.nextInt();
		}
		while (rango <= num) {
			if (rango % 4 == 0) {
				System.out.println(rango);
			}
			rango++;
		}
		
//		Visualizar los múltiplos de 4 comprendidos entre 4 y N, donde N es un número
//		introducido por teclado
		
		sc.close();
	}

}
