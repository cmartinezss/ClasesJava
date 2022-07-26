package curso;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class LeerArchivo {
	private static String nombreArchivo = "emplea2.txt";
	private static BufferedReader br = null;
	
	public static void main(String[] args) {
		try {
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String texto = br.readLine();
			while(texto != null) {
				System.out.println(texto);
				texto = br.readLine();
			}
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
