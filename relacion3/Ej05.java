package relacion3;

import java.util.Scanner;

public class Ej05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int rango = 2, suma = 0, potencia;
		
		while (rango <= 100) {
			potencia = rango * rango;
			suma += potencia;
			rango += 2;
		}
		System.out.println("Resultado: " + suma);
		
		sc.close();
	}

}
