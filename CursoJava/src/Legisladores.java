//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.List;
//
///*
// *  Declara una clase abstracta Legislador que herede de la clase Persona,
// *  con un atributo provinciaQueRepresenta (tipo String) y otros atributos. 
// *  Declara un método abstracto getCamaraEnQueTrabaja. 
// *  Crea dos clases concretas que hereden de Legislador: 
// *  la clase Diputado y la clase Senador que sobreescriban 
// *  los métodos abstractos necesarios. 
// *  Crea una lista de legisladores y 
// *  muestra por pantalla la cámara en que trabajan.
// */
//public class Legisladores {	
//	
//	public static void main(String[] args) {
//		Diputado diputado1 = new Diputado();
//		Senador senador1 = new Senador();
//		Path file = Paths.get("info.txt");
//		
//		
//	   
//	
//		
//		diputado1.nombre = "Carlos";
//		diputado1.apellido1 = "Martínez";
//		diputado1.apellido2 = "Suárez";
//		diputado1.edad = 22;		
//		diputado1.provinciaQueRepresenta = "Valencia";
//		diputado1.camaraEnQueTrabaja = "Congreso de los Diputados";
//		diputado1.partidoPolitico = "PSOE";
//		
//		senador1.nombre = "Aurelio";
//		senador1.apellido1 = "Ortiz de Salazar";
//		senador1.apellido2 = "Peris";
//		senador1.edad = 21;
//		senador1.provinciaQueRepresenta = "Alicante";
//		senador1.camaraEnQueTrabaja = "Senado";
//		senador1.partidoPolitico = "PP";
//		
//		
//		System.out.print("El diputado " + diputado1.nombre + " " + 
//		diputado1.apellido1 + " " + diputado1.apellido2 + ", de ");
//		System.out.print(diputado1.edad);
//		System.out.println(" años,");
//		System.out.println("de la provincia de " + diputado1.provinciaQueRepresenta + 
//				", se encuentra en la cámara " + diputado1.camaraEnQueTrabaja + 
//				" por el partido político " + diputado1.partidoPolitico + ".");
//		
//		System.out.print("El senador " + senador1.nombre + " " + 
//				senador1.apellido1 + " " + senador1.apellido2 + ", de ");
//		System.out.print(senador1.edad);
//		System.out.println(" años,");
//		System.out.println("de la provincia de " + senador1.provinciaQueRepresenta + 
//				", se encuentra en la cámara " + senador1.camaraEnQueTrabaja + 
//				" por el partido político " + senador1.partidoPolitico + ".");
//		
//		List<String> lines = Arrays.asList("El diputado " + diputado1.nombre + " " + 
//				diputado1.apellido1 + " " + diputado1.apellido2 + ", de " +
//				String.valueOf(diputado1.edad) +				
//				" años,\nde la provincia de " + diputado1.provinciaQueRepresenta + 
//				", se encuentra en la cámara " + diputado1.camaraEnQueTrabaja + 
//				" por el partido político " + diputado1.partidoPolitico + ".\n",
//				
//				"El senador " + senador1.nombre + " " + 
//				senador1.apellido1 + " " + senador1.apellido2 + ", de " +
//				String.valueOf(senador1.edad) +
//				" años,\nde la provincia de " + senador1.provinciaQueRepresenta + 
//						", se encuentra en la cámara " + senador1.camaraEnQueTrabaja + 
//						" por el partido político " + senador1.partidoPolitico + "."
//				);
//		try {
//			Files.write(file, lines, StandardCharsets.UTF_8);
//		}
//		catch (IOException e){
//			System.out.println("Ocurrio un error.");
//		    e.printStackTrace();
//		}
//		
//		
//	}
//
//}
//
//abstract class Persona{
//	
//	String nombre;
//	String apellido1;
//	String apellido2;
//	
//	int edad;	
//	
//}
//
//abstract class Legislador extends Persona{
//	
//	String provinciaQueRepresenta;
//	String camaraEnQueTrabaja;
//	String partidoPolitico;
//	
//	abstract void getCamaraEnQueTrabaja();	
//}
//
//
//class Diputado extends Legislador{
//	
//	@Override
//	void getCamaraEnQueTrabaja() {
//		System.out.println(camaraEnQueTrabaja);
//	}	
//}
//
//
//class Senador extends Legislador{
//	
//	@Override
//	void getCamaraEnQueTrabaja() {
//		System.out.println(camaraEnQueTrabaja);
//	}	
//}
