package relacion3;

import java.util.Scanner;

public class Ej25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num, menor;
		System.out.println("Dame un nº:");
		menor = sc.nextInt();
		System.out.println("Dame un nº:");
		num = sc.nextInt();
		
		while (menor != 0 && num != 0) {
			if (num < menor) {
				menor = num;
				System.out.println("El valor del menor es: " + menor);
			}
			num = sc.nextInt();
		}
		if (num == 0) {
			System.out.println("El número más pequeño es: " + menor);
		}
		
		
		
		sc.close();
	}

}
