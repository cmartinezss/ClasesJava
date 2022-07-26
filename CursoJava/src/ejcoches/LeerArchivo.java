package ejcoches;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class LeerArchivo {
	private static String nombreArchivo = "coches.txt";
	private static BufferedReader br = null;
	public static String bmw;
	public static String audi;
	public static String chevrolet;
	
	
	public static void main(String[] args) {
		try {
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String texto = br.readLine();
			while(texto != null) {
				if(texto.contains("bmw")) {
					bmw = texto;
				}
				if(texto.contains("audi")) {
					audi = texto;
				}
				if(texto.contains("chevrolet")) {
					chevrolet = texto;
				}
				texto = br.readLine();
			}
			
			System.out.println(bmw + " " + audi + " " + chevrolet);
			br.close();
		}
		catch(FileNotFoundException fe){
			System.out.println("ERROR: No existe el archivo");
		}
		catch(IOException io) {
			System.out.println("ERROR: Excepcion entrada/salida");
		}
		
		}
	
	
}
