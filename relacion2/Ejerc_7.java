package relacion2;
import java.util.Scanner;

public class Ejerc_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1 = 15, n2 = 7, n3;
		
		if (n1 > n2) {
			n3 = n1;
			n1 = n2;
			n2 = n3;
		}
		
		System.out.println(n1 + " y " + n2);
		
		sc.close();
	}

}
