package relacion5;

public class Arrays_8 {

	public static void main(String[] args) {
		
		int[] elementos = {6, 2, 5, 9, 7, 7, 1, 5, 6, 8, 1, 7, 5, 1, 8, 4, 7, 7, 9, 1, 10, 5, 5, 7, 4, 7, 10, 5, 10, 6};
		int contadorRep = 0;
		boolean valorRepetido = false;
		
		for (int i = 0; i < elementos.length; i++) {
			
			valorRepetido = false;
			
			for (int j = 0; j < i; j++) { // compruebo si el elemento "i" ha aparecido antes en la lista
			
				if (elementos[i] == elementos[j]) {
					valorRepetido = true; // si aparece, hay un valor repetido, entonces lo ignoro y paso al siguiente elemento
				}
			}
			
			contadorRep = 0;
			
			if (!valorRepetido) {
				for (int j = 0; j < elementos.length; j++) { // si el elemento "i" no ha aparecido todavía, cuento cuántas veces aparece "i" en la lista
					if (elementos[j] == elementos[i]) {
						contadorRep++;
					}
				}
				
				System.out.println("El nº " + elementos[i] + " aparece repetido " + contadorRep + " veces.");
			}
		}
	}

}
