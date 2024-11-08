package relacion5;

import java.util.Scanner;

public class Arrays_6_7 {
	
	static int digitosANum() {
		int[] digitos = {3, 8, 5, 1, 9, 9};
		int multiplo = 1, numero = 0;
		
		for (int i = digitos.length - 1; i >= 0; i--) { // empiezo desde la última posición
			numero += digitos[i] * multiplo; // el dígito lo multiplico por el múltiplo y lo añado al valor de numero (será el numero final)
			multiplo *= 10; // el múltiplo lo multiplico por 10 para que el siguiente dígito quede en la posición en que debe estar
		}
		
		return numero;
	}
	
	static void numADigitos(int n) {
		
		int aux, contadorDigitos = 0, resto = 0;
		aux = n;
		
		while (aux > 0) { // creo una auxiliar con el valor de n para no modificar n
			contadorDigitos++; // por cada vuelta, cuento un dígito y reduzco el nº en un dígito hasta que sea 0
			aux /= 10;
		}
		
		int[] numEnDigitos = new int[contadorDigitos]; // creo mi array y le doy una longitud del nº de dígitos que tiene n
		
		for (int i = numEnDigitos.length - 1; i >= 0; i--) { // empiezo desde la posición más alta para meter el dígito más a la derecha
			resto = n % 10;
			numEnDigitos[i] = resto; // saco el último dígito y lo meto en la posición correspondiente del array. Reduzco el nº en un dígito
			n /= 10;
		}
		
		for (int i = 0; i < numEnDigitos.length; i++) {
			System.out.print(numEnDigitos[i] + " "); // imprimo todos los elementos del array en orden ascendente
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numero = digitosANum();
		System.out.println("El número del array es: " + numero);
		
		System.out.println("Dame un nº y lo meto en un array:");
		int num = sc.nextInt();
		
		numADigitos(num);
	}

}
