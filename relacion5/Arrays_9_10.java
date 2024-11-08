package relacion5;

public class Arrays_9_10 {

	public static void main(String[] args) {
		
		int[] valores = {6, 2, 5, 9, 7, 7, 1, 5, 6, 8, 1, 7, 5, 1, 8, 4, 7, 7, 9, 1, 10, 5, 5, 7, 4, 7, 10, 5, 10, 6};
		int[] valoresPares;
		int[] valoresImpares;
		int contadorPares = 0, contadorImpares = 0;
		
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] % 2 == 0) {
				contadorPares++;
			} else {
				contadorImpares++;
			}
		}
		
		valoresPares = new int[contadorPares];
		valoresImpares = new int[contadorImpares];
		int indicePar = 0, indiceImpar = 0;
		
		for (int i = 0; i < valores.length; i++) {
			
			if (valores[i] % 2 == 0) {
				valoresPares[indicePar] = valores[i];
				indicePar++;
			} else {
				valoresImpares[indiceImpar] = valores[i];
				indiceImpar++;
			}
		}
		
		System.out.println("Se han pasado del array principal al array de nºs pares un total de " + indicePar + " elementos");
		
		for (int i = 0; i < valoresPares.length; i++) {
			System.out.print(valoresPares[i] + " ");
		}
		
		System.out.println("\nSe han pasado del array principal al array de nºs impares un total de " + indiceImpar + " elementos");
		
		for (int i = 0; i < valoresImpares.length; i++) {
			System.out.print(valoresImpares[i] + " ");
		}
	}

}
