package relacion3;

import java.util.Scanner;

public class Ej07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int contador = 1, num = 0, suma = 0;
		
		while (contador <= 10) {
			System.out.println("Dame un número");
			num = sc.nextInt();
			if (num < 0) {
				suma += num;
				System.out.println(suma);
			}
			System.out.println(contador);
			contador++;
		}
		
		
		sc.close();
	}

}
