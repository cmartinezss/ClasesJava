import java.util.Scanner;

/*
 * Declara un string y pasalo por consola, si ese string es igual a tu nombre, 
 * genera un mensaje por consola que te de la bienvenida, sino,
 * que siga pidiendo ingresar la cadena de caracteres 
 * hasta que coincida con tu nombre.
 */
public class PideNombre {
	public static void main(String[] args) {
		String nombreReal = "Carlos";
		String nombreRecogido = "";
		Scanner captura = new Scanner(System.in);
		
		do{
			System.out.print("Introduce tu nombre: ");
			nombreRecogido = captura.next();
			if (nombreRecogido.equals(nombreReal)) {
				System.out.println("Bienvenido " + nombreRecogido + "!!!");
			}
			
			
		}while(!nombreRecogido.equals(nombreReal));
		
		
		
		
	}
}
