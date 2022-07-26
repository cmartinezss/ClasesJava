/*
 * Cree un programa que a traves de distintos modulos genere un archivo con 
 * información de empleados, la misma debe contener Nombre, Apellido, Edad, 
 * Fecha de nacimiento, Estado civil ('S' para soltero, 'C' para casado), lugar 
 * de origen, email. El archivo al principio del mismo debe tener informada la 
 * fecha del día de hoy con el siguiente estilo (ARCHIVO GENERADO EL YYYY/MM/DD).
 *  Una vez generado el archivo correspondiente, leerlo y mostrarlo por consola.
 */

package ejcoches;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class CrearArchivo {
	public static void main(String[] args) {
		Coche c1 = new Coche();
		Coche c2 = new Coche();
		Coche c3 = new Coche();
		
		c1.setMarca("bmw");
		c2.setMarca("audi");
		c3.setMarca("chevrolet");
		
		ArrayList<Coche> coches = new ArrayList<>();
		coches.add(c1);
		coches.add(c2);
		coches.add(c3);
		
		ArrayList<String> lines = new ArrayList<>();
		for(Coche c : coches) {
			lines.add(c.getMarca());
		}
		
		try {
			Path file = Paths.get("coches.txt");
			Files.write(file , lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
