package relacion5;

import java.util.Scanner;

public class Arrays_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//creo el array de tipo char
		char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		int DNI, resto;
		char letra;
		
		System.out.println("Dime tu DNI sin letra y te digo la letra que le corresponde:");
		DNI = sc.nextInt();
		
		resto = DNI % 23;
		letra = letras[resto];
		
		System.out.println("La letra que corresponde es: " + letra);
	}

}
