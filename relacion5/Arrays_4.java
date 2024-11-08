package relacion5;

public class Arrays_4 {
	
	static void coincidencias() {
		int[] array1 = {4, 7, 2, 10, 7, 10, 2, 7, 4, 3, 2, 5, 7, 8, 5, 1, 10, 4, 9, 7};
		int[] array2 = {6, 2, 5, 9, 7, 7, 1, 5, 6, 8, 1, 7, 5, 1, 8, 4, 7, 7, 9, 1, 10, 5, 5, 7, 4, 7, 10, 5, 10, 6};
		int coincidencia = 0;
		
		for (int i = 0; i < array1.length; i++) { // compruebo cuántas veces coincide un nº de array1 en array2
			
			for (int j = 0; j < array2.length; j++) {
				
				if (array1[i] == array2[j]) {
					coincidencia++;
				}
			}
		}
		
		System.out.println("Hay un total de " + coincidencia + " coincidencias.");
	}
	
	public static void main(String[] args) {
		
		coincidencias();
		
	}

}
