package relacion5;

import java.util.Random;

public class Arrays_16v1 {

	static int cabezaCombinada(int[] v, int[] o, int[] n, int[] s) { // asigno cada nº aleatorio generado arriba a posiciones de cada array principal
		
		int cent, dec, uni, digitos;
		
		cent = o[v[0]]; // el primer nº del array "v" se usa como referencia para una posición del array "o", y así sucesivamente
		dec = n[v[1]]; // el segundo...
		uni = s[v[2]]; // el tercero...
		
		digitos = (cent * 100) + (dec * 10) + uni; // uno los dígitos para formar un nº de tres cifras
		
		return digitos;
	}
	
	static int numMasFrecuente(int[] v) { // averiguo qué nº del array de 10000 elementos es el más frecuente
		
		int masFrecuente = 0, h = 0, contador = 0, posicion = 0;
		boolean aparece = false;
		
		for (int i = 0; i < v.length; i++) { // recorro todo el array comparando cada nº con el resto de nºs
			
			aparece = false;
			
			h = 0;
			
			while (!aparece && h < i) { // compruebo si el nº actual ha aparecido ya o no, para no contarlo
				
				if (v[h] == v[i]) // si el nº actual ha aparecido ya, paro este bucle y paso al siguiente nº, si no, sigo comprobando si ha aparecido o no
					aparece = true;
				else
					h++;
			}
			
			if (!aparece) {  // si el nº no ha aparecido, lo comparo con el resto y cuento cuántas veces aparece
				contador = 0;
				for (int j = 0; j < v.length; j++) {
					if (v[i] == v[j]) {
						contador++;
					}
				}
				
				if (masFrecuente < contador) { // si el nº guardado en masFrecuente es más pequeño que el nº de veces que aparece el nº actual
					masFrecuente = contador;   // sustituyo el valor de masFrecuente por el valor del contador actual
					posicion = v[i];		   // y guardo el número actual que es el más frecuente
				}
			}
		}
		
		return posicion;
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		int longitud = 10, fabricado, combinacion, random; // inicio variables y arrays
		int[] ojos = new int[longitud];
		int[] narices = new int[longitud];
		int[] sonrisas = new int[longitud];
		int[] cabezas = new int[10000];
		int[] partesConjuntas = new int[3];
		
		for (int i = 0; i < ojos.length; i++) { // asigno a los 3 arrays los valores correspondientes de 0 a 9 según su posición
			ojos[i] = i;
			narices[i] = i;
			sonrisas[i] = i;
		}
				
		for (int i = 0; i < cabezas.length; i++) {
			
			for (int j = 0; j < partesConjuntas.length; j++) { // innserto 3 nºs aleatorios en cada posición
				random = r.nextInt(10);
				partesConjuntas[j] = random;
			}
			
			combinacion = cabezaCombinada(partesConjuntas, ojos, narices, sonrisas);  // asignarlos a un valor contenido en cada uno de los 3 arrays anteriores y formar el nº de 3 dígitos
			cabezas[i] = combinacion;											// y crear el array final con los 10000 elementos
		}
		
		fabricado = numMasFrecuente(cabezas); // envío el array final creado para encontrar el nº más frecuente
		
		System.out.println("Si el número mostrado es de 1 o 2 cifras, se entiende que se rellena con ceros al principio hasta completar 3 cifras.");
		System.out.println("La combinación fabricada más frecuentemente es: " + fabricado);
		
	}

}
