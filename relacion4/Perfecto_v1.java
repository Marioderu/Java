package relacion4;

import java.util.Scanner;

public class Perfecto_v1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un nº y te digo si es un nº perfecto:");
		int num, suma = 0;
		
		num = sc.nextInt();
		
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				suma += i;
			}
			System.out.println("Vuelta " + i);
		}
		if (suma == num) {
			System.out.println("Es un nº perfecto");
		} else {
			System.out.println("NO es un nº perfecto");
		}
//		todo natural que es igual a la suma de sus divisores propios (es decir, todos
//		sus divisores excepto el propio ). Por ejemplo, 6 es un perfecto ya que sus divisores
//		propios son 1, 2, y 3 y se cumple que 1+2+3=6. Los s 28, 496 y 8128 también son
//		perfectos.
		
		
	}

}
