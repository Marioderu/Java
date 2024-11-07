package relacion1;
import java.util.Scanner;

public class Ejerc_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = 12, y = 3;
		double sigma = 2.1836, lambda = 1.11695, alfa = 328.67, f;
		
		f = 3 * ((x + sigma * y) / (Math.pow(x, 2) - Math.pow(y, 2))) - lambda * (alfa -13.7);
		
		System.out.println("x = " + x + "\ny = " + y + "\nsigma = " + sigma + "\nlambda = " + lambda + "\nalfa = " + alfa);
		System.out.println("f = " + f);
		
		sc.close();

	}

}
