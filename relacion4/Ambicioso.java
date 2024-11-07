package relacion4;

import java.util.Scanner;

public class Ambicioso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, minPerfecto = 0;
		System.out.println("Deme un nº para saber si es un nº ambicioso o no:");
		num = sc.nextInt();
		
		
		if (num < 25) {
			System.out.println("No es ambicioso.");
		} else {
			while (num >= 25) {
				minPerfecto = 0;
				for (int i = 1; i <= num / 2; i++) {
					if (num % i == 0) {
						minPerfecto += i;
					}
				}
				num = minPerfecto;
		}
		if (num == 6) {
			System.out.println("Sí es Ambicioso.");
		} else {
			System.out.println("No lo es.");
		}
		
		
		
		
		
		
//		todo que cumple que la secuencia que se forma al sumar sus divisores
//		propios, después los divisores propios del resultado de esa suma, después los del
//		obtenido…acaba en un perfecto. Por ejemplo, 25 es un aspiring number ya que sus
//		divisores propios son 1 y 5 y se cumple que 1+5=6, que es un perfecto

		}}}
