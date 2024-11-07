package relacion4;

import java.util.Scanner;

public class Feliz_o_Infeliz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, resto, potencia;
		boolean seguir = true;
		System.out.println("Dame un nº y te digo si es un nº feliz o infeliz:");
		num = sc.nextInt();
		
		while (seguir) {
			while (num <= 0) {
				System.out.println("Sólo se admiten nºs superiores a 0. Vuelva a insertar un nº:");
				num = sc.nextInt();
			}
			potencia = 0;
			while (num > 0) {
				resto = num % 10;
				potencia += resto * resto;
				num /= 10;
				if (num == 0 && potencia > 9) {
					num = potencia;
					potencia = 0;
				}
				System.out.println("Resto: " + resto + ". Pot: " + potencia + ". Num: " + num);
			}
			
			if (potencia == 1) {
				System.out.println("Sí es un nº FELIZ");
			} else {
				System.out.println("Es INFELIZ");
			}
			
			System.out.println("Si desea detener el programa, inserte -1, si no, inserte otro número para ser evaluado:");
			num = sc.nextInt();
			if (num == -1) {
				seguir = false;
				System.out.println("Programa Finalizado.");
			}
		}
	}
}
