package relacion3;

import java.util.Scanner;

public class Ej11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		boolean seguir1 = true, seguir2 = true, seguir3 = true;
		
		while (seguir1) {
			System.out.println("Dame un número");
			num = sc.nextInt();
			if (num < 1000) {
				seguir1 = false;
			}
		}
		if (seguir1 == false) {
			System.out.println("El programa se ha detenido.");
		}
		
		while (seguir2) {
			System.out.println("Dame un número");
			num = sc.nextInt();
			if (num > 99 && num < 1001) {
				seguir2 = false;
			}
		}
		if (seguir2 == false) {
			System.out.println("El programa se ha detenido.");
		}
		
		while (seguir3) {
			System.out.println("Dame un número");
			num = sc.nextInt();
			if ((num > 99 && num < 1001) || num < 0) {
				seguir3 = false;
			}
		}
		if (seguir3 == false) {
			System.out.println("El programa se ha detenido.");
		}
		
		
//		Se desea leer desde teclado una serie de números hasta que
//		aparezca alguno menor que 1000.
//		aparezca alguno en el intervalo [100, 1000]
//		aparezca alguno en el intervalo [100, 1000], o que sea negativo
//		Construir un programa para cada uno de estos casos. 
		
		sc.close();
	}

}
