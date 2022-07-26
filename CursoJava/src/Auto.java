/*
 * Armar un programa que contenga información de vehiculos, 
 * y que tenga una clase hija llamada autos que herede metodos
 *  de la clase abstracta y la muestre por pantalla
 */

abstract class Vehiculo{
	
	int nRuedas;
	String tipo;
	String matricula;
	
	public void display() {
		System.out.print("El vehiculo de tipo ");
		System.out.print(tipo);
		System.out.print(" y con matrícula ");
		System.out.print(matricula);
		System.out.print(" tiene un total de ");
		System.out.print(nRuedas);
		System.out.println(" ruedas.");
	}
}
	
public class Auto extends Vehiculo {
	
    public static void main(String[] args) {
    	
        Auto coche = new Auto();
        coche.nRuedas = 4;
        coche.matricula = "4448GYP";
        coche.tipo = "coche";
        
        coche.display();
        
        
        
    }
}
	

