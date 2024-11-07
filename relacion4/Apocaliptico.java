package relacion4;

import java.math.BigInteger;
import java.util.Scanner;

public class Apocaliptico {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int num, contador = 0;
//		boolean noApocaliptico = true;
//		BigInteger dos, potencia, cero, resto, diez, seis, cociente;
//		cero = new BigInteger("0");
//		diez = new BigInteger("10");
//		seis = new BigInteger("6");
//		
//		System.out.println("Dime un nº y te digo si es apocalíptico:");
//		num = sc.nextInt();
//		
//		dos = new BigInteger("2");
//		potencia = dos.pow(num);
//		
//		while (potencia.compareTo(cero) != 0 && noApocaliptico) {
//			resto = potencia.mod(diez);
//			if (resto.equals(seis)) {
//				contador++;
//				if (contador == 3) {
//					noApocaliptico = false;
//					System.out.println("Sí es apocaliptico.");
//				}
//			} else {
//				contador = 0;
//			}
//			potencia = potencia.divide(diez);
//			
//			}
//		if (noApocaliptico) {
//			System.out.println("NO ES");
//		}
		
		int n=157, contador = 0;
		boolean apocaliptico = false;
		BigInteger dos, potencia, cero, resto, diez, seis;
		cero = new BigInteger("0");
		diez = new BigInteger("10");
		seis = new BigInteger("6");		
		dos = new BigInteger("2");
		potencia = dos.pow(n);
		
		
		System.out.println("POTENCIA: " + potencia);
		
		while (potencia.compareTo(cero) != 0 && !apocaliptico) {
			resto = potencia.mod(diez);
			System.out.println("RESTO: " + resto);
			if (resto.compareTo(seis) == 0) {
				contador++;
				if (contador == 3) {
					apocaliptico = true;
				}
			} else {
				contador = 0;
			}
			System.out.println("CONTADOR: " + contador);
			potencia = potencia.divide(diez);
			
			}

		System.out.println(apocaliptico);
//		todo natural n que cumple que 2n contiene la secuencia 666. Por
//		ejemplo, los s 157 y 192 son s apocalípticos.
	}

}
