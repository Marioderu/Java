package relacion4;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Raiz_Newton_BigDecimal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MathContext mc = new MathContext(10);
		
		int vueltas = 5;
		boolean continuar = true;
		BigDecimal num, numerador, denominador, raiz, resultado, dos, potencia, cero;
		
		System.out.println("Dame un nº y te digo su raíz cuadrada:");
		num = sc.nextBigDecimal();
		
		resultado = new BigDecimal("1");
		dos = new BigDecimal("2");
		cero = new BigDecimal("0");
		
		while (continuar) {
			while (num.compareTo(cero) <= 0) {
				System.out.println("Los valores negativos o el valor 0 no están permitidos. Inserte otro valor:");
				num = sc.nextBigDecimal();
			}
			
			for (int i = 0; i < vueltas; i++) {
				potencia = resultado.pow(2, mc);
				numerador = potencia.subtract(num, mc);
				denominador = dos.multiply(resultado, mc);
				raiz = resultado.subtract(numerador.divide(denominador, mc), mc);
				resultado = raiz;
			}
			
			System.out.println("La raíz de " + num + " es: " + resultado);
			
			System.out.println("Si desea parar, pulse -1. Si desea calcular otro valor, inserte un nuevo nº:");
			num = sc.nextBigDecimal();
			
			if (num.compareTo(cero) < 0) {
				System.out.println("Programa Finalizado.");
				continuar = false;
			}
		}
		
		

	}

}
