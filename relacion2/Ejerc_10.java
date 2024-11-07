package relacion2;
import java.util.Scanner;

public class Ejerc_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h, min, seg;
		
		System.out.println("Dame las horas");
		h = sc.nextInt();
		
		System.out.println("Dame los minutos");
		min = sc.nextInt();
		
		System.out.println("Dame los segundos");
		seg = sc.nextInt();
		
		if (seg == 59) {
			seg = 0;
			
			if (min == 59) {
				min = 0;
				h++;
				System.out.println("segundos: " + seg);
				System.out.println("horas: " + h);
				System.out.println("minutos: " + min);
			} else {
				min++;
				System.out.println("segundos: " + seg);
				System.out.println("horas: " + h);
				System.out.println("minutos: " + min);
			}
		} else {
			seg++;
			System.out.println("segundos: " + seg);
			System.out.println("horas: " + h);
			System.out.println("minutos: " + min);
		}
		
		sc.close();
	}

}
