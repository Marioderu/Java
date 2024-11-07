package relacion4;

import java.util.Scanner;

public class Poderoso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, esPrimoDivisor = 0, esCuadradoDivisor = 0, potencia = 0;
		boolean noPrimo = true, seguir = true, tieneDivisores = false;
		
		System.out.println("Dame un nº y te digo si es poderoso:");
		num = sc.nextInt();
		
		while (seguir) {
			
			if (num < 4) { // Filtro los nºs de 0 a 3, donde solo el 1 es Poderoso, y 2 y 3 son primos.
				
				if (num == 1) {
					System.out.println("Es PODEROSO.");
				} else {
					System.out.println("Es Débil.");
				}
				
			} else {
				
				esPrimoDivisor = 0; // Reiniciar variables reutilizables
				esCuadradoDivisor = 0;
				tieneDivisores = false;
								
				for (int i = 2; i <= num / 2; i++) { // Bucle para sacar los divisores del nº.
													 // Empieza en 2 porque todos los nºs tienen el 1 como divisor
													 // El divisor más grande nunca supera la mitad del num
					
					if (num % i == 0) {
						tieneDivisores = true; // Si tiene algún divisor, cambiar el boolean
						
						if (i != 2 && i != 3) { // Si el divisor es distinto de 2 o 3, comprobar si es primo
												// 2 y 3 son primos, no hay que comprobarlos
							noPrimo = true;
							for (int j = 2; j <= Math.sqrt(i) && noPrimo; j++) {
							
								if (i % j == 0) {
									noPrimo = false;
								}
							}
						}
						
						if (noPrimo) { // Si el booleano es true contar que i es primo y divisor de n
							esPrimoDivisor++;
							potencia = i * i;
							
							if (num % potencia == 0) { // Comprobar si i al cuadrado también es divisor de n
								esCuadradoDivisor++;
							}
						}				
						
					}
							
				}
				if (esPrimoDivisor == esCuadradoDivisor && tieneDivisores) {
					System.out.println("Es un nº PODEROSO");
				} else {
					System.out.println("Es débil");
				}
			}
		
			System.out.println("Si desea parar pulse -1. Si desea evaluar otro nº, inserte un nuevo nº:");
			num = sc.nextInt();
			if (num == -1) {
				seguir = false;
				System.out.println("Programa Finalizado.");
			}
	}
	
	
	}

}
