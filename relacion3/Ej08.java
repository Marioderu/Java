package relacion3;

import java.util.Scanner;

public class Ej08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float horasM, horasN, horasF, salario;
		int parada = 1;
		
		while (parada != -1) {
			System.out.println("Cuántas horas has trabajado en horario de mañana");
			horasM = sc.nextFloat();
			
			while (horasM < 0) {
				System.out.println("no se admiten numeros negativos. Vuelva a insertar otro número");
				horasM = sc.nextFloat();
			}
			
			if (horasM != 0) {
				horasM *= 60;
				System.out.println("Recibes " + horasM + "€ por horario de mañana");
			}
			
			System.out.println("Cuántas horas has trabajado en horario de tarde");
			horasN = sc.nextFloat();
			
			while (horasN < 0) {
				System.out.println("no se admiten numeros negativos. Vuelva a insertar otro número");
				horasN = sc.nextFloat();
			}
			
			if (horasN != 0) {
				horasN *= 100;
				System.out.println("Recibes " + horasN + "€ por horario de noche");
			}
			
			System.out.println("Cuántas horas has trabajado en horario de noche");
			horasF = sc.nextFloat();
			
			while (horasF < 0) {
				System.out.println("no se admiten numeros negativos. Vuelva a insertar otro número");
				horasF = sc.nextFloat();
			}
			
			if (horasF != 0) {
				horasF *= 100;
				System.out.println("Recibes " + horasF + "€ por horario de día festivo");
			}
			
			salario = horasM + horasN + horasF;
			System.out.println("Su salario es: " + salario + "€");
			
			if (parada != -1) {
				System.out.println("Si desea continuar con más cáclculos, pulse 1. Si desea parar, inserte -1");
				parada = sc.nextInt();
			}
		}
		
		if (parada == -1) {
			System.out.println("Gracias por utilizar nuestro programa. Tenga un buen día.");
		}
		
		
		
		// Escribir un programa que calcule el sueldo semanal de cualquier trabajador a partir del número de horas trabajadas por día y las siguientes tarifas:
		// 60 euros/hora Turno de mañana
		// 80 euros/hora Turno de noche
		// 100 euros /hora Turno de días festivos
		// el programa parara el introducir el numero -1
		
		sc.close();
	}

}
