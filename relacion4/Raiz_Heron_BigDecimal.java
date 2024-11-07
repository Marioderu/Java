package relacion4;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Raiz_Heron_BigDecimal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int vueltas = 4;
		boolean continuar = true;
		BigDecimal num, fraccionUno, fraccionDos, primeraParte, x, segundaParte, terceraParte, raiz, cero;
		MathContext mc = new MathContext(10);
		
		cero = new BigDecimal("0");
		fraccionUno = new BigDecimal("1");
		fraccionDos = new BigDecimal("2");
		x = new BigDecimal("1");
		
		
		System.out.println("Dame un nº y te digo su raíz cuadrada:");
		num = sc.nextBigDecimal();
		
		while (continuar) {
			while (num.compareTo(cero) <= 0) {
				System.out.println("Solo se permiten números superiores a 0. Inserte otro valor:");
				num = sc.nextBigDecimal();
			}
			
			for (int i = 0; i < vueltas; i++) {
				// División de la fracción 1/2 de cada iteración de la fórmula
				primeraParte = fraccionUno.divide(fraccionDos, mc);
				
				// División de la segunda fracción al final de la fórmula n/x, donde 'n' es el nº indicado por el usuario
				segundaParte = num.divide(x, mc);
				
				// Suma de las dos partes anteriores, contenidas en el segundo paréntesis (x + (n/x))
				terceraParte = x.add(segundaParte, mc);
				
				// Multiplicación del primer paréntesis con el segundo (1/2) * (x + (n/x))
				raiz = primeraParte.multiply(terceraParte, mc);
				
				// Reasignar el valor de x con el valor de raiz, para que en cada vuelta utilice ese valor para realizar la aproximación
				x = raiz;
			}
			
			System.out.println("La raíz cuadrada de " + num + " es: " + x);
			System.out.println("Si desea detener el programa, inserte -1. Si desea continuar, inserte un nuevo valor:");
			num = sc.nextBigDecimal();
			
			if (num.compareTo(cero) < 0) {
				continuar = false;
				System.out.println("Programa Finalizado.");
			}
		}
	}

}
