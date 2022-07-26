import java.util.Scanner;


/*
 * Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, año) y calcule su número
de la suerte.
El número de la suerte se calcula sumando el día, mes y año de la fecha de nacimiento y a continuación
sumando las cifras obtenidas en la suma.
Por ejemplo:
Si la fecha de nacimiento es 12/07/1980
Calculamos el número de la suerte así: 12+7+1980 = 1999 1+9+9+9 = 28
Número de la suerte: 28
 */
public class PideFechas {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String f = "";
		Fecha fecha = new Fecha();
		do {
			
			System.out.print("Introduce la fecha de nacimiento (dd/mm/aaaa): ");
			f = s.nextLine();
			if(f.length() == 10) {
				
				fecha.toFecha(f);				
				fecha.computeFechaSum();
				fecha.computeLuckyNum();
				
				System.out.println("Tu número de la suerte es: " + fecha.luckyNum);
			}
			else {
				System.out.println("--- Formato de fecha introducido incorrectamente. ---");
			}
			
		}while((fecha.dia != 0 && fecha.mes != 0 && fecha.año != 0) || f.length() != 10);
	}
}

class Fecha{
	public int dia;
	public int mes;
	public int año;
	
	public int fechaSum;
	public int luckyNum;
	
	public void toFecha(String s) {		
		dia = Integer.valueOf(s.substring(0, 2));
		mes = Integer.valueOf(s.substring(3, 5));
		año = Integer.valueOf(s.substring(6, 10));
		fechaSum = 0;
		luckyNum = 0;
	}
	
	public void printFecha() {
		System.out.println("Has introducido: " + dia + mes + año);
	}
	
	public void computeFechaSum() {
		fechaSum = dia + mes + año;
	}
	
	public void computeLuckyNum() {
		int len = Integer.toString(fechaSum).length();
		
		float newNum = fechaSum;
		while(len > 0) {			
			luckyNum += newNum % 10;
			newNum = newNum / 10;
			len -= 1;
		}
	}
}
