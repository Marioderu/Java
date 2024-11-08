package relacion5;

public class Arrays_5 {
	
	static int sumaElementos() {
		
		int[] array = {1, 7, 8, 9, 3, 2, 10, 7, 2, 5, 6, 7, 9, 1, 2, 4, 2, 4, 5, 4};
		int suma = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) { // si un elemento es par, lo dejo igual y lo sumo al valor de suma
				suma += array[i];
			} else {
				suma += array[i] * 3; // si es impar, lo multiplico por 3 y lo sumo al valor de suma
			}
		}
		
		return suma;
	}
	
	public static void main(String[] args) {
		
		int sumaEl = sumaElementos();
		System.out.println("La suma de los elementos del array es: " + sumaEl);
	}

}
