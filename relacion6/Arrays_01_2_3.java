package relacion5;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Arrays_01_2_3 {

	static int[] arrayCuadrados(int n) {
		
		int[] cuadrados = new int [n];
		
		for (int i = 0; i < cuadrados.length; i++) { // a cada posición le asigno un valor de la propia posición por sí misma, al cuadrado
			cuadrados[i] = i * i; // (int) Math.pow(i, 2);
		}
		
		return cuadrados;
	}
	
	static int cantidadN(int n) {
		Random r = new Random();
		
		int aleatorio;
		int[] valoresRepetidos = new int[20];
		
		for (int i = 0; i < valoresRepetidos.length; i++) {
			aleatorio = r.nextInt(20);
			valoresRepetidos[i] = aleatorio;
		}
		
		int contador = 0;
		
		for (int i = 0; i < valoresRepetidos.length; i++) {
			if (valoresRepetidos[i] == n) { // si en la posición actual "i" el nº indicado por el usuario "n" aparece en el array, contamos 1
				contador++;
			}
		}
		
		return contador;
	}
	
	static int[] arrayDerivadoV1(int n) {
		
		int[] arrayOrigen = {11, 5, 46, 17, 1, 7, 8, 10, 7, 9, 1, 1, 25, 3, 7, 2, 81, 99, 63, 77, 100};
		int[] arrayDerivado = new int[arrayOrigen.length]; // 2º array que contenga el mismo número de valores que la longitud del primero
		
		for (int i = 0; i < arrayOrigen.length; i++) {
			arrayDerivado[i] = arrayOrigen[i] * n; // recorremos el primer array y cada posición se multiplica por "n". El resultado se guarda en la misma posición del 2º array
		}
		
		return arrayDerivado;
	}
	
	static int[] arrayDerivadoV2(int n, int n2, int n3) {
		
		int[] arrayOrigen = new int[n]; // primer array contiene "n" variables o su longitud es de "n" valores
		int[] arrayDerivado = new int[arrayOrigen.length]; // segundo array contiene la misma longitud que el primero
		
		for (int i = 0; i < arrayOrigen.length; i++) { // calculamos un valor multiplicando el índice por "n2" y asignamos el resultado a cada posición del primer array
			arrayOrigen[i] = i * n2;
		}
		
		for (int i = 0; i < arrayOrigen.length; i++) { // recorremos el primer array y cada posición se multiplica por "n3". El resultado se guarda en la misma posición del 2º array
			arrayDerivado[i] = arrayOrigen[i] * n3;
		}
		
		return arrayDerivado;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, num2, num3;
		int[] arrayCuadrados, arrayDerivado1, arrayDerivado2;
		
		//ARRAY VALORES AL CUADRADO
		
		System.out.println("Voy a crear un conjunto de variables elevadas al cuadrado según su posición. ¿Cuántas variables de tipo entero quieres crear?");
		num = sc.nextInt();
		
		arrayCuadrados = arrayCuadrados(num);
		
		for (int i = 0; i < arrayCuadrados.length; i++) {
			System.out.print(arrayCuadrados[i] + " ");
		}
		
		//ARRAY REPETICIÓN DE VALORES
		
		System.out.println("\nTengo un array creado para ti. Inserta un nº del 1 al 10 y te indico cuántas veces aparece:");
		num = sc.nextInt();
		int cantidadNumeros = cantidadN(num);
		System.out.println("El numero que ha introducdio aparece " + cantidadNumeros + " veces");
		
		// ARRAY DERIVADO Versión 1
		
		System.out.println("Vamos a crear un conjunto de variables derivado de otro, multiplicando sus valores por el numero que desees. Dame un nº:");
		num = sc.nextInt();
		arrayDerivado1 = arrayDerivadoV1(num);
		
		for (int i = 0; i < arrayDerivado1.length; i++) {
			System.out.print(arrayDerivado1[i] + " ");
		}
		
		// ARRAY DERIVADO Versión 2
		
		System.out.println("Vamos a crear un conjunto de variables. Dime cuántas variables quieres que tenga:");
		num = sc.nextInt();
		System.out.println("Ahora dime por qué nº multiplico los valores del array para asignarles un valor distinto de 0:");
		num2 = sc.nextInt();
		System.out.println("Por último, vamos a crear un conjunto derivado del anterior. Dime un nº con el que multiplicar los valores del original y asignar el resultado a los valores del conjunto derivado:");
		num3 = sc.nextInt();
		arrayDerivado2 = arrayDerivadoV2(num, num2, num3);
		
		for (int i = 0; i < arrayDerivado2.length; i++) {
			System.out.print(arrayDerivado2[i] + " ");
		}
		
	}
}
