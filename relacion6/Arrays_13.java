package relacion5;

public class Arrays_13 {

	public static void main(String[] args) {
		
		int[] primos = new int[100]; // array con tamaño 100
		
		int contadorPrimo = 0, num = 2, divisor = 3, indice = 0, posicion;
		boolean esPrimo = true;
		
		while (contadorPrimo < primos.length) { // condición de parada el nº máximo de primos que entran en el array
			
			esPrimo = true;
			divisor = 3;
			
			while (esPrimo && divisor <= Math.sqrt(num)) {
				
				if (num % divisor == 0) { // busco si tiene divisores. Si encuentra alguno, paro el bucle y empiezo con un nº nuevo
					esPrimo = false;
				}
				divisor += 2; // divisor sube de dos en dos para contar sólo los impares, ya que nigún nº par es nº primo
			}
			
			if (esPrimo) { // si un nº entra al bucle y no tiene divisores, meto ese número en el array usando la variable "i" como índice
				primos[indice] = num;
				indice++; // sumo 1 al índice para que cuando encuentre otro primo, lo meta en la siguiente posición
				contadorPrimo++; // si encuentra un primo, subo en 1 el contador del bucle principal
			}
			
			if (num == 2) // si num es 2, el único par primo, lo añado al array y sumo 1 para comprobar el nº 3 en la siguiente vuelta
				num++;
			else
				num += 2; // cualquier otro número distinto de 2, sumo de dos en dos para comprobar solo impares
		}
		
		posicion = 0; // usada como índice para el array en la siguiente linea
		
		for (int i = 0; i < primos.length / 4; i++) { // da vueltas hasta la longitud del array / 4, ya que los nºs van en grupos de 4
			for (int j = 0; j < 4; j++) {
				System.out.print(primos[posicion] + " "); // cada vuelta muestra un nº, hasta 4 vueltas
				posicion++;                               // uso variable indice como posición en el array
			}
			
			System.out.println("\n");
		}
	}
}
