//import java.io.*;
//import java.util.*;
//import java.nio.file.*;
//import java.nio.charset.*;
//
//
////Creacion de un archivo que pueda realizar las siguientes acciones:
////3 opciones
////1. Creación de un txt que muestre la siguiente información:
//// Nombre y apellido, lugar donde vivis y comida favorita 
////2. Mostrar por pantalla el contenido del TXT
////3.  Salir del archivo
//
//
//public class MenuArchivo {
//	
//	public static void main(String[] args) {
//		
//		Menu menu = new Menu();
//		Scanner captura = new Scanner(System.in);
//		int currentOperation = 0;
//		
//		do {
//			
//			menu.displayMainMenu();
//			currentOperation = captura.nextInt();
//			
//			switch(currentOperation) {
//				case 1:
//					
//					int fillOperation = 0;
//					
//					do {
//						
//						menu.displayFillMenu();
//						fillOperation = captura.nextInt();
//						captura.nextLine();
//						
//						switch(fillOperation) {
//							case 1:		
//								System.out.print("Introduzca nombre del fichero: ");
//								menu.data.setFileName(captura.nextLine());
//								break;
//							case 2:
//								System.out.print("Introduzca nombre del usuario: ");
//								menu.data.setName(captura.nextLine());								
//								System.out.print("Introduzca priemer apellido del usuario: ");
//								menu.data.setFirstSurname(captura.nextLine());
//								System.out.print("Introduzca segundo apellido del usuario: ");
//								menu.data.setSecondSurname(captura.nextLine());
//								break;
//							case 3:
//								System.out.println("Introduzca lugar de residencia: ");
//								menu.data.setPlace(captura.nextLine());
//								break;
//							case 4:
//								System.out.println("Introduzca comida favorita: ");
//								menu.data.setFood(captura.nextLine());
//								break;
//								
//							case 5:
//								System.out.println("Saliendo del menú actual...");
//								try {
//									Path file = Paths.get(menu.data.getFileName());
//									List<String> lines = Arrays.asList(
//											menu.data.getName() + " " + 
//											menu.data.getFirstSurname() + " " +
//											menu.data.getSecondSurname(),
//											menu.data.getPlace(),
//											menu.data.getFood());
//									
//								    Files.write(file, lines, StandardCharsets.UTF_8);
//								}
//								catch (IOException e){
//							      System.out.println("Ocurrio un error.");
//							      e.printStackTrace();
//							    }								
//								break;
//								
//							default:
//								System.out.println("No existe esa opción. Por favor, elija otra.");
//								break;		
//						}
//					}
//					while(fillOperation != 5);					
//					break;
//				case 2:
//				try {
//					List<String> file = Files.readAllLines(Paths.get(menu.data.getFileName()));
//					for(String s : file) {
//						System.out.println(s);
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//					break;
//				case 3:
//					System.out.println("Saliendo del programa...");
//					break;
//				default:
//					System.out.println("No existe esa opción. Por favor, elija otra.");
//					break;		
//			}
//			
//		}
//		while(currentOperation != 3);
//		
//		captura.close();		
//		
//	}
//}
//
//class Data{
//	private String fileName;
//	private String name;
//	private String firstSurname;
//	private String secondSurname;
//	private String place;
//	private String food;
//	
//	void setFileName(String s) {
//		this.fileName = s;
//	}
//	void setName(String s) {
//		this.name = s;
//	}
//	void setFirstSurname(String s) {
//		this.firstSurname = s;
//	}
//	void setSecondSurname(String s) {
//		this.secondSurname = s;
//	}
//	void setPlace(String s) {
//		this.place = s;
//	}
//	void setFood(String s) {
//		this.food = s;
//	}
//	
//	String getFileName() {
//		return this.fileName;
//	}
//	String getName() {
//		return this.name;
//	}
//	String getFirstSurname() {
//		return this.firstSurname;
//	}
//	String getSecondSurname() {
//		return this.secondSurname;
//	}
//	String getPlace() {
//		return this.place;
//	}
//	String getFood() {
//		return this.food;
//	}
//	
//	
//}
//
//class Menu{
//	
//	Data data;
//	
//	public Menu() {
//		// Default	
//		data = new Data();		
//		}
//	
//	
//	void displayMainMenu() {
//		System.out.println("----- MENÚ DE SELECCIÓN PRINCIPAL -----");
//		System.out.println("¿Qué acción desea realizar?");
//		System.out.println("1. Crear el archivo de texto.");
//		System.out.println("2. Mostrar el contenido del archivo de texto.");
//		System.out.println("3. Salir");
//	}
//	void displayFillMenu() {
//		System.out.println("----- MENÚ PARA RELLENAR LOS DATOS -----");
//		System.out.println("¿Qué dato desea actualizar?");
//		System.out.println("1. Nombre del fichero.");
//		System.out.println("2. Nombre y apellidos del usuario.");
//		System.out.println("3. Lugar de residencia.");
//		System.out.println("4. Comida favorita.");
//		System.out.println("5. Salir");
//	}
//	
//}
