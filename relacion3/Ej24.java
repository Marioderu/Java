package relacion3;

import java.util.Scanner;

public class Ej24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, total = 0;
		
		System.out.println("Dame 2 numeros:");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		while (num2 > 0) {
			total += num1;
			num2--;
			System.out.println("Num 1 vale: " + total);
			System.out.println("Num 2 decremento: " + num2);
		}
		if (num2 == 0) {
			System.out.println(total);
		}
		
//		Escribir un programa que lea dos números enteros positivos y calcular el producto de
//		los mismos por sumas sucesivas

		sc.close();
	}

}
