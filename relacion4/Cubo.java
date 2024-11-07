package relacion4;

import java.util.Scanner;

public class Cubo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, cubo = 0;
		System.out.println("Dime un nº y te digo si es un nº cubo:");
		num = sc.nextInt();
		
		for (int i = 1; i <= Math.cbrt(num); i++) {
			cubo = i * i * i;
			System.out.println("Potencia cúbica de " + i + ": " + cubo);
		}
		if (cubo == num) {
			System.out.println("Sí es un nº Cubo.");
		} else {
			System.out.println("No es Cubo.");
		}

//		todo natural que es el cubo de otro natural. Por ejemplo, 125 es un cubo ya que
//		125=53.
	}

}
