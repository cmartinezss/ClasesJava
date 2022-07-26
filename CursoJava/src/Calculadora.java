import java.util.Scanner;


public class Calculadora {
	
	public static void main(String[] args) {
		Scanner captura = new Scanner(System.in);
		System.out.print("¿Qué operación desea realizar  a continuación?: \t");
		String operacion = captura.nextLine();
		while (!"exit".equals(operacion)){
		
			switch (operacion) {
				case "suma":
					suma Suma = new suma();
					Suma.SetNums();
					System.out.print("El resultado es: ");
					System.out.print(Suma.DoSuma());
					break;
				case "resta":
					resta Resta = new resta();
					Resta.SetNums();
					System.out.print("El resultado es: ");
					System.out.print(Resta.DoResta());
					break;
				case "multiplicacion":
					multiplicacion Mul = new multiplicacion();
					Mul.SetNums();
					System.out.print("El resultado es: ");
					System.out.print(Mul.DoMul());
					break;
				case "division":
					division Div = new division();
					Div.SetNums();
					System.out.print("El resultado es: ");
					System.out.print(Div.DoDiv());
					break;
				case "exit":
					break;
				default:
					System.out.print("La operación indicada no es correcta (suma, resta, multiplicacion o division)");
					break;
			}
			
			System.out.print("\n¿Qué operación desea realizar a continuación?: \t");
			operacion = captura.nextLine();
			
		}		
		System.out.print("Calculadora cerrada...");
		captura.close();
	}
}

class operacion{
	Scanner captura = new Scanner(System.in);
	int num1;
	int num2;
	
	void SetNums() {
		System.out.print("Introduzca el primer número: ");
		this.num1 = captura.nextInt();
		
		System.out.print("Introduzca el segundo número: ");			
		this.num2 = captura.nextInt();
	}
}

class suma extends operacion {		
	
	suma(){}
	
	int DoSuma() {
		return this.num1 + this.num2;
	}
}

class resta extends operacion {		
	resta(){}
	int DoResta() {
		return this.num1 - this.num2;
	}
}

class multiplicacion extends operacion {
	multiplicacion(){}
	int DoMul() {
		return this.num1 * this.num2;
	}
}

class division extends operacion {
	division(){}
	int DoDiv() {
		return this.num1 / this.num2;
	}
}
