package relacion3;

import java.util.Scanner;

public class Ej27 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num, menor, contador = 0, posicion = 0;
		System.out.println("Dame un nº:");
		menor = sc.nextInt();
		System.out.println("Dame un nº:");
		num = sc.nextInt();
		
		while (menor != 0 && num != 0) {
			if (num < menor) {
				menor = num;
				System.out.println("El valor del menor es: " + menor);
				posicion = contador + 2;
			}
			num = sc.nextInt();
			contador++;
		}
		if (num == 0) {
			System.out.println("El número más pequeño es: " + menor);
			System.out.println("Su posición es: " + posicion);
		}
		
		
		
		sc.close();
	}

}
