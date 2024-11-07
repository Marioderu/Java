package relacion3;

import java.util.Scanner;

public class Ej21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int alumnos, rango1 = 0, rango2 = 0, rango3 = 0, rango4 = 0;
		float peso;
		boolean seguir = true;
		
		System.out.println("Inserte un valor para el peso:");
		peso = sc.nextFloat();
		
		while (peso <= 0) {
			System.out.println("Debe ser un valor superior a 0. Vuelve a insertar el valor:");
			peso = sc.nextFloat();
		}
		
		while (seguir && peso > 0) {
			if (peso < 40) {
				rango1++;
			} else {
				if (peso >= 40 && peso <= 50) {
					rango2++;
				} else {
					if (peso > 50 && peso < 60) {
						rango3++;
					} else {
						rango4++;
					}
				}
			}
			System.out.println("Si desea parar el programa y visualizar los cálculos, pulse 500. Si desea continuar, meta el siguiente valor del peso de alguno de los alumnos:");
			peso = sc.nextFloat();
			if (peso == 500) {
				seguir = false;
			} else {
				while (peso <= 0) {
					System.out.println("Debe ser un valor superior a 0. Vuelve a insertar el valor:");
					peso = sc.nextFloat();
				}
			}
		}
		alumnos = rango1 + rango2 + rango3 + rango4;
		rango1 *= 100 / alumnos;
		rango2 *= 100 / alumnos;
		rango3 *= 100 / alumnos;
		rango4 *= 100 / alumnos;
		System.out.printf("El porcentaje de alumnos con un peso menor a 40 es del %d %% %n", rango1);
		System.out.printf("El porcentaje de alumnos con un peso entre 40 y 50 es del %d %% %n", rango2);
		System.out.printf("El porcentaje de alumnos con un peso entre 50 y 60 es del %d %% %n", rango3);
		System.out.printf("El porcentaje de alumnos con un peso superior a 60 es del %d %% %n", rango4);
		
		
//		Se desea realizar una estadística de los pesos de los alumnos de un colegio de
//		acuerdo a la siguiente tabla:
//		 Alumnos de menos de 40 kg.
//		 Alumnos entre 40 y 50 kg.
//		 Alumnos de más de 50 y menos de 60 kg.
//		 Alumnos con un peso igual o mayor de 60 kg.
//		Escribir un programa que lea el peso de un conjunto de alumnos y visualice esta
//		estadística
		sc.close();
	}

}
