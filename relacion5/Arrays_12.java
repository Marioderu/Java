package relacion5;

import java.util.Scanner;

public class Arrays_12 {

	static char letraDNI(char[] v, int dni) {
		
		int resto;
		char letra;
		
		resto = dni % 23; // hago la fórmula y obtengo el resto
		letra = v[resto]; // el resto indica la posición de la letra en el array
		
		return letra;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//creo el array de tipo char
		char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		int DNI;
		char letra;
		
		System.out.println("Dime tu DNI sin letra y te digo la letra que le corresponde:");
		DNI = sc.nextInt();
		
		letra = letraDNI(letras, DNI); // llamo al método que me dice la letra que corresponde con el DNI
		System.out.println("La letra que corresponde es: " + letra);
	}

}
