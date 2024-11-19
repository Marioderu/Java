package relacion5;

import java.util.Scanner;

public class Arrays_15v2 {
	
	static int[] arrayAuxiliar(int[] v, int num) { // inserta el valor del usuario y ordena los elementos del array de manera ascendente
		
		int indice = 0, aux;
		
		if (v[indice] < num) // por cada nº introducido compruebo si es mayor al primer elemento del array y lo introduzco
			v[indice] = num;
		
		for (int i = 0; i < v.length; i++) { // compruebo los nºs del array y los ordeno ascendentemente usando una auxiliar
			
			for (int j = i + 1; j < v.length; j++) {
			
				if (v[i] > v[j]) { // si la posición actual es mayor que la siguiente posicion
					aux = v[i];    // el nº mayor lo guardo en una auxiliar
					v[i] = v[j];   // ahora el nº menor lo guardo donde estaba el mayor
					v[j] = aux;    // por último asigno el valor de la auxiliar a donde estaba el menor
				}
			}
		}
		
		return v;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		int[] v = new int[10], sortArray = null;
		
		System.out.println("Inserte un nº. Recuerde que parar detener el programa y conocer su resultado, deberá introducir 0:");
		num = sc.nextInt();
		
		while (num > 0) { // cuando es 0, el bucle parará
			
			sortArray = arrayAuxiliar(v, num); // enviar al método el array y el nº del usuario para crear el array y ordenarlo
			
			System.out.println("Inserte otro nº:");
			num = sc.nextInt(); // pedir otro nº al final del bucle para que la condición del while se evalúe primero
		}
		
		if (num == 0) { // cuando el bucle pare, mostrar los nºs en orden descendente
			
			System.out.println("Los 10 nºs mayores que ha introducido en orden descendente son:");
			
			for (int i = sortArray.length - 1; i > 0; i--) {
				
				if (sortArray[i] != 0)
					System.out.print(v[i] + " ");
			}
		}
	}
}
