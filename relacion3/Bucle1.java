package relacion3;

import java.util.Scanner;

public class Bucle1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int contador = 0, num = 1;
		boolean tope = true;
		
		while (num > 0) {
			contador = 0;
			while (contador < num) {
				System.out.print("1");
				contador++;
			}
			System.out.println("\n");
			
			if (tope) {
				num++;
				if (num == 10) {
					tope = false;
				}
			} else {
				num--;
			}
		}
		
		sc.close();

	}

}
