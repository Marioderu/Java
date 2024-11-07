package relacion4;

import java.util.Scanner;

public class Cuadrado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, potencia = 0;
		System.out.println("Dime un nº y te digo si es un nº cuadrado:");
		num = sc.nextInt();
		
		for (int i = 1; i <= Math.sqrt(num); i++) {
			potencia = i * i;
			System.out.println("Potencia de " + i + ": " + potencia);
		}
		if (potencia == num) {
			System.out.println("Sí es un nº Cuadrado.");
		} else {
			System.out.println("No es un Cuadrado.");
		}
		
//		todo natural que es el cuadrado de otro natural. Por ejemplo, 9 es un
//		cuadrado ya que 9=32.
	}

}
