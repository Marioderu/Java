package relacion5;

import java.util.Scanner;

public class Arrays_15v1 {
	
	static int menorDeArray(int[] v) {
		
		int contador = 1, indice = 0, menor = 0;
		boolean hayMenor = false;
	
		while (!hayMenor && indice < v.length) {
			contador = 0;
			for (int i = 0; i < v.length; i++) {
				if (v[indice] != v[i] && v[indice] < v[i]) {
					contador++;
					
					if (contador == 9) {
						hayMenor = true;
					}
				}
			}
			
			if (hayMenor)
				menor = indice;
			else
				indice++;
		}
		
		return menor;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, indice = 0, insertarNum;
		int[] v = new int[10];
		
		System.out.println("Inserte un nº. Recuerde que parar detener el programa y conocer su resultado, deberá introducir 0:");
		num = sc.nextInt();
		
		while (num > 0) { // cuando es 0, el bucle parará
			
			if (indice < 10) {
				v[indice] = num;
				indice++;
				
				for (int i = 0; i < v.length; i++) {
					System.out.println(v[i]);
				}
				
			} else {
				
				insertarNum = menorDeArray(v); // enviar al método el array y el nº del usuario para crear el array y ordenarlo
				
				if (num > v[insertarNum]) {
					v[insertarNum] = num;
				}
				
				for (int i = 0; i < v.length; i++) {
					System.out.println(v[i]);
				}
				
			
			System.out.println("Inserte otro nº:");
			num = sc.nextInt();
		}
		
		if (num == 0) { // cuando el bucle pare, mostrar los nºs en orden descendente
			
			System.out.println("Los 10 nºs mayores que ha introducido en orden descendente son:");
			
			for (int i = 0; i < v.length; i++) {
				
				if (v[i] != 0)
					System.out.print(v[i] + " "); // imprime el último nº
			}
		}
	}

	}
}
