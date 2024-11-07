package relacion4;

import java.util.Scanner;

public class Abundante {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, suma = 0;
		System.out.println("Dame un nº y te digo si es abundante:");
		num = sc.nextInt();
		
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				suma += i;
				System.out.println("Valor de i: " + i);
			}
		}
		System.out.println("La suma de los divisores de " + num + " es: " + suma);
		if (suma > num) {
			System.out.println("Sí es abundante");
		} else {
			System.out.println("No es abundante");
		}
		
//		todo natural que cumple que la suma de sus divisores propios es mayor
//		que el propio . Por ejemplo, 12 es abundante ya que sus divisores son 1, 2, 3, 4 y 6 y se
//		cumple que 1+2+3+4+6=16, que es mayor que el propio 12

	}

}
