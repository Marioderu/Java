package relacion4;

import java.util.Scanner;

public class Deficiente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, suma = 0;
		System.out.println("Dame un nº y te digo si es deficiente:");
		num = sc.nextInt();
		
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				suma += i;
				System.out.println("Valor de i: " + i + " y valor de suma: " + suma);
			}
		}
		System.out.println("La suma de los divisores de " + num + " es: " + suma);
		if (suma < num) {
			System.out.println("Sí es deficiente");
		} else {
			System.out.println("No es deficiente");
		}
		
//		todo natural que cumple que la suma de sus divisores propios es menor que
//		el propio . Por ejemplo, 16 es un deficiente ya que sus divisores propios son 1, 2, 4 y 8
//		y se cumple que 1+2+4+8=15, que es menor que 16

	}

}
