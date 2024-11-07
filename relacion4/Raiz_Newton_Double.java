package relacion4;
import java.util.Scanner;

public class Raiz_Newton_Double {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int vueltas = 5;
		double num, raiz, resultado = 1, numerador, denominador;
		boolean continuar = true;
		
		System.out.println("Dame un nº y te digo su raíz cuadrada:");
		num = sc.nextDouble();
		
		while (continuar) {	
			while (num <= 0) {
				System.out.println("No se permiten valores negativos ni 0. Inserte otro valor:");
				num = sc.nextDouble();
			}
			
			for (int i = 0; i < vueltas; i++) {
				numerador = Math.pow(resultado, 2) - num;
				denominador = 2 * resultado;
				raiz = resultado - (numerador / denominador);
				resultado = raiz;
			}
			
			System.out.println("La raíz de " + num + " es: " + resultado);
			
			System.out.println("Si desea detener el programa, pulse -1. Si quiere evaluar otro valor, inserte un nuevo nº:");
			num = sc.nextDouble();
			
			if (num == -1) {
				continuar = false;
				System.out.println("Programa Finalizado");
			}
		}
		

	}

}

