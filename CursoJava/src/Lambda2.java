import java.util.Random;
import java.util.Scanner;

/*
 * CONSIGNA:
Generar un programa que funcione como un juego de adivinanzas, donde el usuario tenga que adivinar un numero entre 1 y 1000. 
Donde si adivina le damos un mensaje de "Adivinaste, campeon" y sino adivino que siga iterando hasta adivinar 
ESTRUCTURA DEL PROGRAMA:
Clase de usuario, clase principal, interfaz que implemente alguna variable y/o metodo que el programa utilice. 
Utilizando lambda. 
ENTREGABLES:
Codigo del programa
 */
public class Lambda2 {
	
	public static void main(String[] args) {
		
		Usuario user = new Usuario();
		int numToGuess = user.getNewRandomNum();
		Scanner s = new Scanner(System.in);
		int newNum = -1;
		
		do {
			System.out.println("Adivine el número que estoy pensando: ");
			newNum = s.nextInt();
			if(newNum == numToGuess) {				
				System.out.println("Adivinaste, campeón/a !!!");
			}
			else {
				System.out.print("Nop, prueba de nuevo!");
			}
			
		}while(newNum != numToGuess);
		
		
		
	}
	
}

class Usuario{
	Random r = new Random();
	RandomNum rn = () -> (r.nextInt(1001));
	AskForNumber afn = (a, b) -> {
		while(a != b) {
			
		}
	};
	
	String winMessage = "Adivinaste, campeón/a";
	String tryAgain = "Fallaste, prueba de nuevo";
	String initMessage = "Adivine el número que estoy pensando: ";
	
	int getNewRandomNum() {
		return rn.getNum();
	}	
	
}


interface RandomNum{
	public int getNum();
}

interface AskForNumber{
	public void ask(int a, int b);
}
