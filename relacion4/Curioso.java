package relacion4;

import java.util.Scanner;

public class Curioso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, potencia, aux, digitos = 1, equivalencia;
		System.out.println("Dime un nº y te digo si es un nº curioso o no:");
		num = sc.nextInt();
		potencia = num * num;
		aux = num;
		
		while (aux > 0) {
			digitos *= 10; // Multiplicamos por 10 para saber cuántos dígitos tiene el numero inicial
			aux /= 10; // Reducimos el número de la condición para eliminar el último digito
			System.out.println("DIG: " + digitos + " y aux: " + aux);
		}
		
		// Dividimos la potencia del número inicial entre los dígitos, su resto será el numero inicial o no
		equivalencia = potencia % digitos;
		
		
		if (num == equivalencia) {
			System.out.println("Es un nº Curioso.");
		} else {
			System.out.println("NO es Curioso.");
		}
		
//		todo natural n que cumple que n2 tiene al propio n como última cifra. Por
//		ejemplo, 25 y 36 son s curiosos

	}

}
