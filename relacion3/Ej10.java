package relacion3;

import java.util.Scanner;

public class Ej10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char letra1 = 'A', letra2 = 'a';
		
		while (letra1 <= 'Z') {
			System.out.print(letra1);
			System.out.print(letra2 + "\n");
			letra2++;
			letra1++;
		}
		
		
		sc.close();
	}

}
