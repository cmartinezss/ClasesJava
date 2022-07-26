import java.util.Scanner;

/*
 * Crear un programa que implemente una funcion lambda, una interfaz y
 *  una clase donde se pase por consola los resultados de 1 suma. 
 *  Se deben pedir 2 valores por consola. 
 */
public class Lambda1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce el primer número: ");
		int n1 = s.nextInt();		
		System.out.println("Introduce el segundo número: ");
		int n2 = s.nextInt();
		
		HacerSuma sum = (a , b) -> a + b;
		System.out.println("La suma es: " + sum.doSuma(n1, n2));
	}
}



interface HacerSuma{
	int doSuma(int a, int b);
}

/*
package expresionesLambda;
public class lambdaEjemplo 
{
    //Ejemplo de lambda
    public static void main(String args [])
    {
    
        ModificacionCadena exclamacion = (t) -> "!" + t + "!";
        imprimir("Java rocks", exclamacion);
    }
    
    
    public static void imprimir(String texto, ModificacionCadena formato)
    {
        String resultado = formato.ejecutar(texto);
        System.out.println(resultado);
    }
    
}
interface ModificacionCadena
{
     String ejecutar(String texto);
}
//OUTPOUT
//! Java Rocks ! 
*/