/*
 * Acceder mediante el cmd (o su equivalente) del sistema al repositorio local de su proyecto y generar una nueva rama que se llame 
"DESARROLLO"
Luego, generar un programa sobre dicha rama desde el IDE y actualizarlo en el repositorio remoto (Github). 
El programa debe hacer lo siguiente:
Desarrollar un bot que te pregunte como te sentis el día de hoy, y en base a las siguientes posibilidades haga una accion
1. Triste -> Cuenta un chiste
2. Alegre -> "Enhorabuena"
3. Nervioso -> Mensaje de calma
TIP: A los chistes los pueden almacenar en un array y usar el metodo RANDOM para contar un chiste aleatorio. 
El programa tiene que tener un mensaje de bienvenida, donde te pregunte tu nombre previamente y te informe la fecha actual.
ENTREGABLES: 
Link del repositorio con el codigo almacenado. 
Captura del CMD mostrando la generacion de la rama. 
(!) EL CODIGO DEBE ESTAR ALMACENADO EN LA RAMA "DESARRROLLO (!)
 */

package Git;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Desarrollo {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		String how = "";
		Chistes chistes = new Chistes();
		CalmDown relax = new CalmDown();
		
		chistes.addNewChiste("- ¿Qué hace un mudo bailando? \n- Una mudanza. ja ja ja");
		chistes.addNewChiste("- ¿De qué se quejan siempre los astronautas? \n- De la falta de espacio. je je je");
		chistes.addNewChiste("- ¿Cuáles eran los personajes de dibujos animados favoritos del capitán del Titanic? \n- Timón y Pumba. ji ji ji");
		chistes.addNewChiste("- ¿Qué le dice un 2 a un 0? \n- Veinte conmigo. jo jo jo");
		chistes.addNewChiste("- Van dos videntes en una moto y se cae el del médium. ju ju ju");
	
		
		relax.addMessage("Tranquilo, te va a salir bien.");
		relax.addMessage("No te preocupes, todo irá bien. ");
		relax.addMessage("Relájate y disfruta del proceso.");
		
		
		System.out.println("Buenos días, feliz " + LocalDate.now().getDayOfWeek() + ", " + LocalDate.now().getDayOfMonth() + " de " + LocalDate.now().getMonth() + " de " + LocalDate.now().getYear() + ".");
		System.out.println("¿Cómo te encuentras hoy?");
		how = s.nextLine();
		
		while(!how.equalsIgnoreCase("triste") && !how.equalsIgnoreCase("alegre") && !how.equalsIgnoreCase("nervioso")) {
			System.out.println("No entiendo ese estado de ánimo, prueba de nuevo por favor.");
			how = s.nextLine();
		}
		switch(how.toLowerCase()) {
			case "triste":
				try {
					System.out.println("Te contaré un chiste para alegrarte: ");
					TimeUnit.MILLISECONDS.sleep(1000);							
					String[] frases = chistes.getNewRandomChiste().split("\n");
					
					for(int j = 0; j < frases.length; j++) {
						System.out.println(frases[j]);
						if(j != frases.length-1) {
							for(int i = 0; i < 3; i++) {
								TimeUnit.MILLISECONDS.sleep(700);							
								if(i != 2) {
									System.out.print(".");								
								}
								else {
									System.out.println(".");
								}
							}
						}					
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
				
				break;
			case "alegre":
				System.out.println("Enhorabuena!!! Disfuta mucho del día.");
				break;
			case "nervioso":
				try {
					String[] frases = relax.getMessage().split("\n");
					
					for(int j = 0; j < frases.length; j++) {
						System.out.println(frases[j]);
						if(j != frases.length-1) {
							for(int i = 0; i < 3; i++) {
								TimeUnit.MILLISECONDS.sleep(700);							
								if(i != 2) {
									System.out.print(".");								
								}
								else {
									System.out.println(".");
								}
							}
						}					
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			
				break;
			default:
				break;
		}
		s.close();
		
	}
}



class Chistes{
	private ArrayList<String> jokes = new ArrayList<>();
	Random random = new Random();
	
	public String getNewRandomChiste() {		
		return jokes.get(random.nextInt(jokes.size()));
	}
	public void addNewChiste(String c) {
		jokes.add(c);
	}
}



class CalmDown{
	private ArrayList<String> messages = new ArrayList<>();
	Random random = new Random();
	
	public String getMessage() {
		return messages.get(random.nextInt(messages.size()));
	}

	public void addMessage(String message) {
		messages.add(message);
	}
	
	
}


