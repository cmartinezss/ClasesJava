import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import GenerarTXT.TxtGenerator;

/*
 * //CONSIGNA:
// Desarrollar un programa que genere N txts de salida conteniendo la siguiente información: 
// Un TXT que informe los ingredientes que son los siguientes:
//Arroz bomba
//1500 g
//Pollo de corral 1
//Conejo 0.5
//Judía verde plana 500 g
//Garrofó 500 g
//Alcachofa (opcional) 500 g
//Aceite de oliva virgen extra
//Pimentón dulce
//Tomate triturado
//Azafrán
//Romero fresco
//Sal
//Otro TXT que genere las instrucciones:
// Dificultad: Media
// Tiempo total 1 h 25 m
// Elaboración 10 m
// Cocción 1 h 15 m
// Reposo 5 m
// Estructura del programa:
// Una clase de Ingredientes
// Una clase de preparacion
// Una interfaz que implemente el metodo abstracto generaSalida
//Una vez generado el archivo txt subirlo a traves de la consola a nuestro repositorio remoto de GitHub 
// Entregables:
// Captura del CMD (consola)
// LINK del Repositorio 
 */

public class Paella {
	
	public static void main(String[] args) {
		
		TxtGenerator ingredientesTxt = new TxtGenerator();
		TxtGenerator instruccionesTxt = new TxtGenerator();
		Ingredientes ingredientes = new Ingredientes();
		Preparacion preparacion = new Preparacion();
		
		ingredientesTxt.setTxtName("Ingredientes de la paella.txt");
		instruccionesTxt.setTxtName("Instrucciones para la paella.txt");
		
		ingredientes.setAmount("Arroz bomba", (float) 1500);
		ingredientes.setAmount("Pollo corral", (float) 1);
		ingredientes.setAmount("Conejo", (float) 0.5);
		ingredientes.setAmount("Judía verde plana", (float) 500);
		ingredientes.setAmount("Garrofón", (float) 500);
		ingredientes.setAmount("Alcachofa (opcional)", (float) 500);
		ingredientes.setAmount("Pimentón dulce", (float) 5);
		ingredientes.setAmount("Aceite de oliva virgen extra", (float) 10);
		ingredientes.setAmount("Tomate triturado", (float) 1);
		ingredientes.setAmount("Sal", (float) 1);
		ingredientes.setAmount("Romero fresco", (float) 1);
		
		ingredientes.setNewIngredient("Arroz bomba");
		ingredientes.setNewIngredient("Pollo corral");
		ingredientes.setNewIngredient("Conejo");
		ingredientes.setNewIngredient("Judía verde plana");
		ingredientes.setNewIngredient("Garrofón");
		ingredientes.setNewIngredient("Alcachofa (opcional)");
		ingredientes.setNewIngredient("Pimentón dulce");
		ingredientes.setNewIngredient("Aceite de oliva virgen extra");
		ingredientes.setNewIngredient("Tomate triturado");
		ingredientes.setNewIngredient("Sal");
		ingredientes.setNewIngredient("Romero fresco");
		
		preparacion.setTime("media", "Dificultad");
		preparacion.setTime("1,25 h", "Tiempo total");
		preparacion.setTime("10 m", "Elaboración");
		preparacion.setTime("1,15 h", "Cocción");
		preparacion.setTime("5 m", "Reposo");
		
		preparacion.setNewOrder("Dificultad");
		preparacion.setNewOrder("Tiempo total");
		preparacion.setNewOrder("Elaboración");
		preparacion.setNewOrder("Cocción");
		preparacion.setNewOrder("Reposo");
		
	
		
		for(String i: ingredientes.getIngredients()) {
			ingredientesTxt.addToContent(i + " - " + ingredientes.getAmount(i));
		}
		
		for(String p: preparacion.getOrders()) {
			instruccionesTxt.addToContent(p + " - " + preparacion.getTime(p));
		}
		
		ingredientesTxt.generate();
		instruccionesTxt.generate();
	}

}

class Ingredientes{
	private ArrayList<String> ing = new ArrayList<>();
	private HashMap<String, Float> amount = new HashMap<>();
	
	
	public Float getAmount(String ing) {
		return amount.get(ing);
	}

	public void setAmount(String s, Float f) {
		amount.put(s, f);
	}

	public void setNewIngredient(String s) {
		ing.add(s);
	}
	
	public List<String> getIngredients(){
		return ing;
	}
}

class Preparacion{

	private ArrayList<String> orders = new ArrayList<>();
	private HashMap<String, String> times = new HashMap<>();
	
	public String getTime(String s) {
		return times.get(s);
	}

	public void setTime(String t, String s) {
		times.put(s, t);
	}

	public void setNewOrder(String s) {
		orders.add(s);
	}
	
	public List<String> getOrders(){
		return orders;
	}
}
