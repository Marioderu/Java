package relacion3;

import java.util.Scanner;

public class Ej12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 0, mayor = 0;
		System.out.println("El programa va a comenzar a ejecutarse. Si desea parar, debe ingresar el número -99 cuando se le pida un número.");
		
		while (num != -99) {
			System.out.println("Dame un número:");
			num = sc.nextInt();
			if (num > 0 && num > mayor) {
				mayor = num;
			}
		}
		if (num == -99) {
			System.out.println("El número más grande de la serie es: " + mayor);
		}
		
//		Construir un programa que permita leer una serie de números enteros positivos
//		distintos de 0 (el último número de la serie debe ser el -99) y obtener el máximo
		sc.close();
	}

}
