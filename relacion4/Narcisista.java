package relacion4;

import java.util.Scanner;

public class Narcisista {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, vuelta, aux, resto, potencia = 0;
		boolean seguir = true;
		System.out.println("Dame un nº y te digo si es narcisista o no:");
		num = sc.nextInt();
		
		
		while (seguir) {
			while (num < 0) {
				System.out.println("No se permiten nºs negativos. Inserte un nº superior a 0:");
				num = sc.nextInt();
			}
			if (num >= 0 && num <= 9) {
				System.out.println(num + " es NARCISISTA. Recuerda que todos los números de una cifra se consideran nºs Narcisistas.");
			} else {
				aux = num;
				vuelta = 0;
				potencia = 0;
				while (aux > 0) {
					vuelta++;
					aux /= 10;
				}
				
				aux = num;
						
				for(int i = 0; i < vuelta; i++) {
					resto = aux % 10;
					potencia += Math.pow(resto, vuelta);
					aux /= 10;
				}
				
				if (num == potencia) {
					System.out.println(num + " es un nº NARCISISTA.");
				} else {
					System.out.println(num + " NO es narcisista");
				}
			}
			
			
			System.out.println("Si desea parar, pulse -1. Si no, inserte otro número para ser evaluado:");
			num = sc.nextInt();
			if (num == -1) {
				seguir = false;
				System.out.println("Programa Finalizado");
			}	
		}
		
//		todo nº de "x" dígitos que cumple que es igual a la suma de sus dígitos elevados al nº "x" dígitos
//		de los que se compone es un narceisita. Por ejemplo, 153 es un narcisita de 3 dígitos, ya que
//		13+53+33=153.
	}

}
