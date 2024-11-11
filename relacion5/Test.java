package relacion5;

import java.util.Random;

public class Test {
	
	static int cabezaCombinada(int[] v, int[] o, int[] n, int[] s) {
		
		int cent, dec, uni, digitos;
		
		cent = o[v[0]];
		dec = n[v[1]];
		uni = s[v[2]];
		
		digitos = (cent * 100) + (dec * 10) + uni;
		
		return digitos;
	}
	
	static int[] partesIndividuales() {
		Random r = new Random();
		
		int aleatorio;
		int[] posiciones = new int[3];
		
		for (int i = 0; i < 3; i++) {
			aleatorio = r.nextInt(10);
			posiciones[i] = aleatorio;
		}
		
		return posiciones;
	}
	
	public static void main(String[] args) {
		
		int longitud = 10, combinacion;
		int[] partesInd;
		int[] ojos = new int[longitud];
		int[] narices = new int[longitud];
		int[] sonrisas = new int[longitud];
		int[] cabezas = new int[50];
		
		for (int i = 0; i < ojos.length; i++) {
			ojos[i] = i;
			narices[i] = i;
			sonrisas[i] = i;
		}
		
		for (int i = 0; i < cabezas.length; i++) {
			partesInd = partesIndividuales();
			combinacion = cabezaCombinada(partesInd, ojos, narices, sonrisas);
			cabezas[i] = combinacion;
		}
		
		
		
		for (int i = 0; i < cabezas.length; i++) {
			System.out.println(cabezas[i]);
		}
		
		
		int masFrecuente = 0, h = 0, contador = 0, posicion = 0;
		boolean aparece = false;
		
		for (int i = 0; i < cabezas.length; i++) {
			aparece = false;
			h = 0;
			while (!aparece && h < i) {
				if (cabezas[h] == cabezas[i]) {
					aparece = true;
				} else
					h++;
			}
			
			if (!aparece) {
				contador = 0;
				for (int j = 0; j < cabezas.length; j++) {
					if (cabezas[i] == cabezas[j]) {
						contador++;
					}
				}
				
				if (masFrecuente < contador) {
					masFrecuente = contador;
					posicion = cabezas[i];
				}
			}
		}
		
		System.out.println("El nº más frecuente es: " + posicion);
	}

}
