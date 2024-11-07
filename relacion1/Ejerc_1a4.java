package relacion1;

import java.util.Scanner;

public class Ejerc_1a4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// declaramos todas las variables
		
		double radio = 0, altura = 0, volumen = 0, gradosF = 0, gradosC = 0;
		int segundos = 0, horas = 0, seg_restantes = 0, minutos = 0, seg_finales = 0;
		byte seleccion;
		
		System.out.println("Bienvenido a nuestro programa. Puede realizar varios cálculos.");
		System.out.println("Escriba 1 para calcular el volumnen de un cono");
		System.out.println("Escriba 2 para pasar de grados Farenheit a grados Celsius");
		System.out.println("Escriba 3 para pasar de segundos a horas, minutos y segundos");
		
		seleccion = sc.nextByte(); // pedimos al usuario un número
		
		while (seleccion <= 0 || seleccion > 3) { // nos aseguramos de que el usuario introduce el valor correcto
			System.out.println("Ha insertado un número incorrecto. Debe insertar los números 1, 2 o 3.");
			System.out.println("Pruebe de nuevo");
			seleccion = sc.nextByte();
		}
		
		while (seleccion > 0 && seleccion < 4) {
			
			if (seleccion == 1) { // identificamos el número seleccionado por el usuario
				System.out.println("Vamos a calcular el volumen de un cono.");
				System.out.println("Deme el radio.");
				
				radio = sc.nextDouble();
				
				System.out.println("Ahora deme la altura.");
				
				altura = sc.nextDouble();
				
				while (radio < 0 || altura < 0) {
					
					System.out.println("No se permiten valores negativos. Pruebe de nuevo");
					
					if (radio < 0 && altura < 0) {
						
						System.out.println("Deme el radio.");
						
						radio = sc.nextDouble();
						
						System.out.println("Ahora deme la altura.");
						
						altura = sc.nextDouble();
						
					} else {
						
						if (radio < 0 && altura > 0) {
							
							System.out.println("Vuelva a darme el radio.");
							
							radio = sc.nextDouble();
						} else {
							
							System.out.println("Vuelva a darme la altura.");
							
							altura = sc.nextDouble();
						}
					}
				}
				
				volumen = (Math.PI * Math.pow(radio, 2) * altura) / 3; // hacemos las operaciones y devolvemos el valor
				
				System.out.println("El volumen del cono es: " + volumen);
			} else {
				
				if (seleccion == 2) {
					
					System.out.println("Vamos a convertir de grados Farenheit a grados Celsius");
					System.out.println("Deme un valor en grados Farenheit");
					
					gradosF = sc.nextDouble();
					
					gradosC = 5.0 / 9.0 * (gradosF - 32);
					
					System.out.println("La equivalencia es: " + gradosC + "ºC");
					
				} else {
					
					System.out.println("Vamos a pasar de segundos a horas, minutos y segundos");
					System.out.println("Deme un valor en segundos");
					segundos = sc.nextInt();
					
					while (segundos <= 0) {
						
						System.out.println("Debe insertar un valor mayor que 0. Tampoco puede ser negativo.");
						segundos = sc.nextInt();
						
					}
					
					if (segundos >= 1) {
						
						horas = segundos / 3600;
						seg_restantes = segundos % 3600;
						minutos = seg_restantes / 60;
						seg_finales = seg_restantes % 60;
						
						System.out.printf("La conversión es: %d horas, %d minutos y %d segundos\n", horas, minutos, seg_finales);
						
					}
				}
			}
			
			// Preguntamos si quiere seguir dentro del bucle o salir de el y parar
			
			System.out.println("El programa ha llegado a su fin. Si desea volver a hacer la misma operación, pulse el número correspondiente.");
			System.out.println("Si desea hacer otra operación, pulse el número asignado.");
			System.out.println("Recuerde: 1 para el volumen del cono, 2 para pasar de Farenheit a Celsius, y 3 para pasar de segundos a horas, minutos y segundos");
			System.out.println("Si en su lugar desea parar el programa, pulse 0");
			seleccion = sc.nextByte();
		}
		
		if (seleccion == 0) {
			
			System.out.println("Usted ha salido del programa.");
			System.out.println("Muchas gracias por usar nuestro programa.");
			
		}
		
		sc.close();
	}

}
