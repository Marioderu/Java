package relacion4;

import java.math.BigInteger;
import java.util.Scanner;

public class Relacion4 {
	
	// es void porque informa al usuario, no devuelve ningún valor al main
	static void tablaMultiplicar(int n) {
				
		int tabla;
		System.out.println("Tabla de Multiplicar del " + n);
		
		// Cada vuelta muestra n multiplicado por i (las vueltas) y la solución de cada multiplicación
		for (int i = 0; i <= 10; i++) {
			tabla = n * i;
			System.out.println(n + " x " + i + " = " + tabla);
		}
		System.out.print("\n");
	}
	
	static boolean esPrimo(int n) {
		
		int divisor = 2;
		boolean esPrimo = true;
		
		//si n es 0 o 1, no son Primos. Si n es divisible por 2, no es un primo
		if (n == 0 || n == 1) {
			esPrimo = false;
		} else if (n % divisor == 0 && n != 2) {
			// Excluir el 2 porque 2 es primo, entonces se salta todo, incluido el bucle porque empieza en 3 y es mayor que la raiz de 2.
				esPrimo = false;
		} else {
			divisor = 3; // excluir los nºs pares porque ningún nº par es primo
			while (esPrimo && divisor <= Math.sqrt(n)) {
				if (n % divisor == 0) { // si encuentra algún divisor, cambiamos el boolean y aumentamos en 2 para comprobar solo los impares
					esPrimo = false;
					}
				divisor += 2;
				}				
			}
		return esPrimo;
			
	}
	
	static boolean esCompuesto(int n) {
		return !esPrimo(n); // usamos el código de esPrimo() y lo negamos para devolver el valor contrario
	}
	
	static boolean esPerfecto(int n) {
		int suma = 0;
		boolean perfecto = false;
		
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) { // sacamos los divisores del nº y lo sumamos al valor de suma
			
				suma += i;
			}
		}
		if (suma == n) { // comprobamos si el valor de suma (suma de divisores de n) es igual al nº inicial
			perfecto = true;
		}
		
		return perfecto;
	}
	
	static boolean esAbundante(int n) {
		int suma = 0;
		boolean abundante = false;
		
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) { // sacamos los divisores del nº y lo sumamos al valor de suma
				suma += i;
			}
		}
		
		if (suma > n) { // comprobamos que el valor suma sea mayor que n, en cuyo caso es un nº abundante
			abundante = true;
		}
		
		return abundante;
	}
	
	static boolean esDeficiente(int n) {
		return !esAbundante(n); // negamos el valor devuelto por esAbundante(). Deficiente es lo contrario
	}
	
	static boolean esApocaliptico(int n) {
		int contador = 0;
		boolean apocaliptico = false;
		BigInteger dos, potencia, cero, resto, diez, seis;
		cero = new BigInteger("0");
		diez = new BigInteger("10");
		seis = new BigInteger("6");		
		dos = new BigInteger("2");
		potencia = dos.pow(n);
		
		while (potencia.compareTo(cero) != 0 && !apocaliptico) {
			resto = potencia.mod(diez);
			// comprobar si el resto de n / 10 es igual a 6
			// contar tres 6 seguidos, sino, resetear el contador
			if (resto.compareTo(seis) == 0) {
				contador++;
				if (contador == 3) {
					apocaliptico = true;
				}
			} else {
				contador = 0;
			}
			potencia = potencia.divide(diez); // reducir el nº dividiendo entre 10
			
			}
		return apocaliptico;
	}
	
	static boolean esAmbicioso(int n) {
		int divisor = 1, sumaDivisores = 0, vueltas = 0;
		
		while (n > 9 && vueltas < 20) {
			divisor = 1;
			sumaDivisores = 0;
			while (divisor <= n/2) { // sacamos todos los divisores de n y los sumamos con cada vuelta
				if (n % divisor == 0) {
					sumaDivisores += divisor;
				}
				divisor++;
			}
			n = sumaDivisores; // asignamos a n el valor de la suma para comprobar si n tiene más de 1 cifra
			vueltas++; 
			// si n es un nº cuya suma de sus divisores equivale a otro nº y viceversa, se crea un bucle infinito
			// Se pone un límite de comprobaciones para salir del bucle en caso de que ocurra
			// ejemplo: 220, la suma de sus divisores es 284 y, a su vez, la suma de los divisores de 284 es 220
		}
		
		return esPerfecto(n); // comprobamos el resultado con la función que comprueba si es perfecto
	}
	
	static boolean esCurioso(int n) {
		int potencia, aux, digitos = 1, equivalencia;
		boolean curioso = false;
		potencia = n * n;
		aux = n;
		
		while (aux > 0) {
			digitos *= 10; // Multiplicamos por 10 para saber cuántos dígitos tiene el numero inicial
			aux /= 10; // Reducimos el número de la condición para eliminar el último digito
		}
		
		// Dividimos la potencia del número inicial entre los dígitos, su resto corresponde con e valor inicial
		equivalencia = potencia % digitos;
		
		// si el nº inicial es igual a lo que hay en equivalencia, es curioso
		if (n == equivalencia) {
			curioso = true;
		}
		
		return curioso;
	}
	
	static boolean esCuadrado(int n) {
		int potencia = 0, divisor = 1;
		boolean cuadrado = false;
		
		while (divisor <= Math.sqrt(n) && !cuadrado) {
			potencia = divisor * divisor;
			// encontrar si un nº al cuadrado y menor que n es igual a n
			if (potencia == n) {
				cuadrado = true;
			}
			divisor++;
		}
		
		return cuadrado;
	}
	
	static boolean esCubo(int n) {
		double divisor = 1, potencia = 0;
		boolean cubo = false;
		
		while (divisor <= Math.cbrt(n) && !cubo) {
			potencia = Math.pow(divisor, 3);
			// encontrar si un nº al cubo y menor que n es igual a n
			if (potencia == n) {
				cubo = true;
			}
			divisor++;
		}
		
		return cubo;
	}
	
	static boolean esMalvado(int n) {
		int contadorUnos = 0;
		boolean malvado = false;
		
		while (n > 0) {
			if (n % 2 == 1) { // para pasar a binario dividimos entre 2. Si el resto es 1, añadimos 1 al contador
				contadorUnos++;
			}
			n /= 2;
		}
		if (contadorUnos % 2 == 0) { // si el contador es par, es malvado
			malvado = true;
		}
		
		return malvado;
	}
	
	static boolean esOdioso(int n) {
		return !esMalvado(n); // usamos el valor de esMalvado() y lo negamos para obtener el odioso
	}
	
	static boolean esFeliz(int n) {
		int resto, potencia = 0;
		boolean feliz = false;
		
		while (n > 0) {
			resto = n % 10; // sacamos la última cifra y sumamos su cuadrado al valor de potencia
							// dividimos entre 10 para reducir el nº y obtener el siguiente dígito
			potencia += resto * resto;
			n /= 10;
			
			//cuando n es 0 y el valor de potencia sea de más de un dígito, reiniciamos n con el valor de potencia para volver a calcularlo hasta reducirlo a un nº de un dígito
			if (n == 0 && potencia > 9) {
				n = potencia;
				potencia = 0;
			}
		}
			
		if (potencia == 1) {
			feliz = true;
		}
		
		return feliz;
	}
	
	static boolean esInfeliz(int n) {
		return !esFeliz(n); // Negamos el valor devuelto por esFeliz()
	}
	
	static boolean esDeMersenne(int n) {
		int posiblePrimo, mersenne = 1;
		boolean esMersenne = false, esPrimo;
		
		esPrimo = esPrimo(n);
		
		if (esPrimo) {
			posiblePrimo = 2;
			while (mersenne <= n && !esMersenne) { // comprobamos que n es primo, ya que la fórmula tiene que ser primo, y n es igual al resultado de la fórmula, por lo tanto n es primo
				esPrimo = esPrimo(posiblePrimo); // comprobamos que p (posiblePrimo) de la fórmula 2p-1, sea también un primo
				if (esPrimo) {
					mersenne = (int) Math.pow(2, posiblePrimo) - 1; // si p es primo, hacemos la fórmula hasta ver si mersenne es igual al n inicial
				}
				if (mersenne == n) {
					esMersenne = true;
				}
				
				posiblePrimo++;	// aumentamos en 1 posiblePrimo para comprobar el siguiente
			}
		}
		
		return esMersenne;
	}
	
	static boolean esNarcisista(int n) {
		int digitos, aux, resto, potencia = 0;
		boolean narcisista = true;
		
		if (n >= 0 && n <= 9) {
			narcisista = false; // todos los nºs del 1 al 9 son narcisistas
		} else {
			aux = n;
			digitos = 0;

			while (aux > 0) { // sacamos el nº de dígitos que tiene n
				digitos++;
				aux /= 10;
			}
				
			if (aux == 0) { // cuando aux llegue a 0, quiere decir que ya sabemos cuántos dígitos tiene n. Reiniciamos aux para que vuelva a valer n
				aux = n;
				potencia = 0;
				for(int i = 0; i < digitos; i++) { // sacamos los dígitos del num, los elevamos al nº de dígitos y los vamos sumando en cada vuelta
					resto = aux % 10;
					potencia += Math.pow(resto, digitos);
					aux /= 10; // reducimos aux en un dígito para sacar el siguiente dígito en la siguiente vuelta
				}
			}
			
			if (n != potencia) { // si n es igual a la suma de sus dígitos elevados al nº de dígitos que tiene n, es narcisista. Si no, no lo es
				narcisista = false;
			}
		}
		
		return narcisista;		
	}
	
	static boolean esPoderoso(int n) {
		int esPrimoDivisor = 0, esCuadradoDivisor = 0, potencia = 0;
		boolean poderoso = false, esPrimo = esPrimo(n);
		
			if (n == 1) { // Filtro solo el 1 es ya que es Poderoso
				poderoso = true;
				
			} else if (!esPrimo) { // compruebo si n es primo o no. Si n es primo, no hago cálculos, ningún primo es poderoso porque sólo tiene 2 divisores
				
				esPrimoDivisor = 0;
				esCuadradoDivisor = 0;
				int divisor = 2;
				
				while (divisor <= n/2) {
					esPrimo = esPrimo(divisor); // compruebo si divisor es primo
					
					if (n % divisor == 0 && esPrimo) { // si divisor es primo y también es divisor de n, cuento 1 para esPrimoDivisor y calculo su cuadrado
						esPrimoDivisor++;
						potencia = divisor * divisor;
						
						if (n % potencia == 0) { // si su cuadrado es también divisor de n, sumo 1 a esCuadradoDivisor
							esCuadradoDivisor++;
						}
					}
					
					divisor++;
				}
				
				if (esPrimoDivisor == esCuadradoDivisor) { // compruebo si todos los divisores primos de n, sus cuadrados también son divisores de n
					poderoso = true;
				}
			}
			
			return poderoso;
	}
	
	static boolean esOblongo(int n) {
		int producto, multiplicador = 0;
		boolean oblongo = false;
			
		while (multiplicador <= n/2 && !oblongo) { // buscar un num que multiplicado por el siguiente sea igual a n
			producto = multiplicador * (multiplicador + 1);
			
			if (producto == n) {
				oblongo = true;
			}
			
			multiplicador++;
		}
		
		return oblongo;
	}
	
	static boolean esRepunit(int n) {
		int resto;
		boolean repunit = true;
			
		while (n > 0 && repunit) { // saco cada dígito por cada vuelta
			resto = n % 10;
			
			if (resto != 1) { // si el dígito NO es 1, paro el bucle. Necesito que todos los dígitos sean 1
				repunit = false;
			}
			n /= 10;
		}
		
		return repunit;
	}
	
	static double raizHerondeAlejandria(int n) {
		int vueltas = 4;
		double vuelta = 1, raiz, fraccion1, fraccion2;
			
		for (int i = 0; i < vueltas; i++) {
			fraccion1 = 1d/2d;
			fraccion2 = n/vuelta;
			raiz = fraccion1 * (vuelta + fraccion2); // hago la fórmula donde vuelta es el valor de la vuelta anterior y n es el num del que se quiere conocer la raíz
			vuelta = raiz; // asigno el valor de raiz a vuelta para volver a calcularlo y afinar el resultado
		}
		
		return vuelta;
	}
	
	static double raizNewtonRaphson(int n) {
		double raiz, vuelta = 1, numerador, denominador, parada = 4;

		while (parada > 0) {
			numerador = Math.pow(vuelta, 2) - n;
			denominador = 2 * vuelta;
			raiz = vuelta - (numerador / denominador);
			vuelta = raiz;
			parada--;
		}
		
		return vuelta;
	}
	
	static boolean sonAmigos(int n, int n2) {
		int suma1 = 0, suma2 = 0;
		boolean amigos = false;
			
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				suma1 += i;
			}
		}
			
		for (int i = 1; i <= n2 / 2; i++) {
			if (n2 % i == 0) {
				suma2 += i;
			}
		}
			
		if (suma1 == n2 && suma2 == n) {
			amigos = true;
		}

		return amigos;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un nº y te digo qué tipo de número es:");
		
		int num = sc.nextInt();
		
		tablaMultiplicar(num);
		
		boolean primo = esPrimo(num);
		System.out.println("¿Es primo? " + primo + "\n");
		
		primo = esCompuesto(num);
		System.out.println("¿Es compuesto? " + primo + "\n");
		
		boolean perfecto = esPerfecto(num);
		System.out.println("¿Es perfecto? " + perfecto + "\n");
		
		boolean abundante = esAbundante(num);
		System.out.println("¿Es abundante? " + abundante + "\n");
		
		abundante = esDeficiente(num);
		System.out.println("¿Es deficiente? " + abundante + "\n");
		
		boolean apocaliptico = esApocaliptico(num);
		System.out.println("¿Es apocalíptico? " + apocaliptico + "\n");
		
		boolean ambicioso = esAmbicioso(num);
		System.out.println("¿Es ambicioso? " + ambicioso + "\n");
		
		boolean curioso = esCurioso(num);
		System.out.println("¿Es curioso? " + curioso + "\n");
		
		boolean cuadrado = esCuadrado(num);
		System.out.println("¿Es cuadrado? " + cuadrado + "\n");
		
		boolean cubo = esCubo(num);
		System.out.println("¿Es cubo? " + cubo + "\n");
		
		boolean malvado = esMalvado(num);
		System.out.println("¿Es malvado? " + malvado + "\n");
		
		boolean odioso = esOdioso(num);
		System.out.println("¿Es odioso? " + odioso + "\n");
		
		boolean feliz = esFeliz(num);
		System.out.println("¿Es feliz? " + feliz + "\n");
		
		boolean infeliz = esInfeliz(num);
		System.out.println("¿Es infeliz? " + infeliz + "\n");
		
		boolean mersenne = esDeMersenne(num);
		System.out.println("¿Es de Mersenne? " + mersenne + "\n");
		
		boolean narcisista = esNarcisista(num);
		System.out.println("¿Es de narcisista? " + narcisista + "\n");
		
		boolean poderoso = esPoderoso(num);
		System.out.println("¿Es poderoso? " + poderoso + "\n");
		
		boolean oblongo = esOblongo(num);
		System.out.println("¿Es oblongo? " + oblongo + "\n");
		
		boolean repunit = esRepunit(num);
		System.out.println("¿Es repunit? " + repunit + "\n");
		
		double raizHeron = raizHerondeAlejandria(num);
		System.out.println("Su raíz con la fórmula de Herón de Alejandría es: " + raizHeron + "\n");
		
		double raizNewtonRaphson = raizNewtonRaphson(num);
		System.out.println("Su raíz con la fórmula de Newton-Raphson es: " + raizNewtonRaphson + "\n");
		
		System.out.println("Si me das otro número, puedo comprobar si el primer número y éste son amigos:");
		int num2 = sc.nextInt();
		
		boolean amigos = sonAmigos(num, num2);
		System.out.println("¿Son amigos? " + amigos);
	}

}
