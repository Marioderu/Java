package relacion5;

import java.util.Random;

public class Arrays_05 {
	
	static int sumaElementos(int[] vector) {
	
		int suma = 0;
		
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 == 0) { // si un elemento es par, lo dejo igual y lo sumo al valor de suma
				suma += vector[i];
			} else {
				suma += vector[i] * 3; // si es impar, lo multiplico por 3 y lo sumo al valor de suma
			}
		}
		
		return suma;
	}
	
	public static void main(String[] args) {
		
		Random random = new Random();
		int[] vector = new int[30];
		int num;
		
		for (int i = 0; i < vector.length; i++) {
			num = random.nextInt(50);
			vector[i] = num;
		}
		
		int sumaEl = sumaElementos(vector);
		System.out.println("La suma de los elementos del array es: " + sumaEl);
	}

}
