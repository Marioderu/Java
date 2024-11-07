package relacion4;

import java.util.Scanner;

public class ConversionABinario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num, resto, binario = 0, contadorCeros = 0, vueltas = 0;
		System.out.println("Dame un nº:");
		num = sc.nextInt();
		
		while (num > 0) {
			resto = num % 2;
			if (resto == 0) {
				contadorCeros++;
			} else if (resto == 1) {
				if (contadorCeros > 0) {
					binario += Math.pow(10, contadorCeros);
					contadorCeros = 0;
				} else {
					binario += Math.pow(10, vueltas);
				}
			}
			vueltas++;
			num /= 2;
		}
		
		System.out.println("Valor: " + binario);
		
//		todo natural cuya expresión en base 2 (binaria) contiene un par de unos. Por
//		ejemplo,12 y 15 son s malvados ya que 12=11002 y 15=11112

	}

}
