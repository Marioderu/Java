package relacion5;

import java.util.Random;
import java.util.Scanner;

public class Arrays_06_7 {
	
	static int digitosANum(int[] vector) {
		
		int multiplo = 1, numero = 0;
		
		for (int i = vector.length - 1; i >= 0; i--) { // empiezo desde la última posición
			numero += vector[i] * multiplo; // el dígito lo multiplico por el múltiplo y lo añado al valor de numero (será el numero final)
			multiplo *= 10; // el múltiplo lo multiplico por 10 para que el siguiente dígito quede en la posición en que debe estar
		}
		
		return numero;
	}
	
	static int[] numADigitos(int[] vector, int n) {
		
		int resto = 0;
		
		 // creo mi array y le doy una longitud del nº de dígitos que tiene n
		
		for (int i = vector.length - 1; i >= 0; i--) { // empiezo desde la posición más alta para meter el dígito más a la derecha
			resto = n % 10;
			vector[i] = resto; // saco el último dígito y lo meto en la posición correspondiente del array. Reduzco el nº en un dígito
			n /= 10;
		}
		
		return vector;
	}
	
	static int digitos(int n) {
		int digitosTotales = 0;
		
		while (n > 0) { // este método saca los dígitos de un nº al azar generado en el main
			digitosTotales++;
			n /= 10;
		}
		
		return digitosTotales;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int aleatorio = random.nextInt(500000); // genero un nº aleatorio y llamo al método que me dice los dígitos que tiene
		int digitos = digitos(aleatorio);
		
		int[] vector = new int[digitos]; // creo un array con las posiciones indicadas por los dígitos del nº anterior. Cada elemento del array es un dígito
		int[] arrayDigitos = numADigitos(vector, aleatorio); // llamo al método que coloca cada dígito del nº en su posición correspondiente del array
		
		System.out.println("El nº para introducir en el array es " + aleatorio + " y sus dígitos y posición en el array es tal que así: ");
		for (int i = 0; i < arrayDigitos.length; i++) {
			System.out.print(arrayDigitos[i] + " ");
		}
		
		int aleatorio2;
		int[] vector2 = new int[6]; // creo un nuevo array con un nº determinado de elementos
		
		for (int i = 0; i < vector2.length; i++) { // agrego un nº de un dígito aleatorio a cada posición del array anterior
			aleatorio2 = random.nextInt(10);
			vector2[i] = aleatorio2;
		}
		
		int numCompleto = digitosANum(vector2); // llamo al método que me dicen el nº conjunto que forman los elementos del array
		System.out.println("El número del array es: " + numCompleto);
	}

}
