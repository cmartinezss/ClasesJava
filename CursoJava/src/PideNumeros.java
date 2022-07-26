import java.util.Scanner;

/*
 * Crear un programa que pida un numero por consola de 5 digitos, 
 * si tiene 5 digitos que informe por consola (analizando el largo del numero)
 *  cuantos digitos tiene el numero. 
 *  Si no tiene 5 digitos pedir que siga ingresando numeros
 */
public class PideNumeros {
	public static void main(String[] args) {
		Scanner captura = new Scanner(System.in);
		int len = 0;
		
		do {
			System.out.println("Introduce un número: ");
			int num = captura.nextInt();	
			len = Integer.toString(num).length();
			if(len == 5) {
				System.out.println("El número tiene " + len + " dígitos.");
			}
			else {
				
				System.out.print("Prueba de nuevo... ");
			}
		}while(len != 5);
		
		captura.close();
	}
}
