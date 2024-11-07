package relacion3;

import java.util.Scanner;

public class Ej23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, contador, media;
		boolean seguir = true;
		
		while (seguir) {
			media = 0;
			contador = 0;
			while (contador < 4) {
				System.out.println("Dame un nº:");
				num = sc.nextInt();
				if (num == 0 && contador == 0) {
					System.out.println("El programa se ha detenido");
					seguir = false;
					contador = 4;
				} else {
					media += num;
					contador++;
					if (contador == 4) {
						media /= 4;
						System.out.println("La media es: " + media);
					}
				}
			}
		}
		
//		Escribir un programa que lea N grupos de cuatro valores cada uno y que, para cada
//		grupo, calcule la media y la escriba en pantalla. El proceso finaliza al encontrarse un
//		grupo cuyo primer valor es 0.
		
		sc.close();
	}

}
