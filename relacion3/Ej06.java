package relacion3;

import java.util.Scanner;

public class Ej06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int km = 1;
		double millasM, millasT;
		
		while (km <= 25) {
			if (km == 1) {
				System.out.println("    Km    |    Millas Marinas    |    Millas Marinas    ");
			}
			millasM = km / 1.852;
			millasT = km / 1.609;
			System.out.printf("    " + km + "      |           " + millasM + "           |            " + millasT + "          \n");
			km++;
		}
		
		//Escribir un programa que visualice una tabla de conversión de kilómetros a millas
		// marinas y millas terrestres, mostrar de 1km a 25km:
		// 1 milla marina = 1852 metros
		// 1 milla terrestre = 1609 metros
		
		sc.close();
	}

}
