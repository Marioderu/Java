package relacion3;

import java.util.Scanner;

public class Ej09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float notas;
		int cero = 0, cinco = 0, diez = 0, restoNotas = 0, numParada;
		boolean masNotas = true;
		
		while (masNotas) {
			System.out.println("Introduzca una nota:");
			notas = sc.nextFloat();
			while (notas < 0 || notas > 10) {
				System.out.println("Las notas deben estar comprendidas de 0 a 10, ambos inclusive. No se permiten valores negativos ni superiores a 10.");
				System.out.println("Inserte un valor permitido.");
				notas = sc.nextFloat();
			}
			if (notas == 0 || notas == 5 || notas == 10) {
				if (notas == 0) {
					cero++;
				} else {
					if (notas == 5) {
						cinco++;
					} else {
						diez++;
					}
				}
			} else {
				restoNotas++;
			}
			System.out.println("Desea parar el programa? Pulse 1 si desea parar o pulse 0 para continuar.");
			numParada = sc.nextInt();
			if (numParada == 1) {
				masNotas = false;
			}
		}
		System.out.println("Hay un total de " + cero + " ceros.");
		System.out.println("Hay un total de " + cinco + " cincos.");
		System.out.println("Hay un total de " + diez + " dieces.");
		System.out.println("Para el resto de notas hay " + restoNotas + " notas.");
		
		
		// Se realiza un examen, se piden las notas del número de alumnos introducidos por el
		// usuario, las cuales pueden ser únicamente enteras entre 0 y 10. Debe decirse cuantos 0,
		// 5 y 10 han aparecido. También deben decirse las notas introducidas que no sean 0, 5 o
		// 10. 

		sc.close();
	}
}
