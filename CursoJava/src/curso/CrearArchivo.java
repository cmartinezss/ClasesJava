/*
 * Cree un programa que a traves de distintos modulos genere un archivo con 
 * información de empleados, la misma debe contener Nombre, Apellido, Edad, 
 * Fecha de nacimiento, Estado civil ('S' para soltero, 'C' para casado), lugar 
 * de origen, email. El archivo al principio del mismo debe tener informada la 
 * fecha del día de hoy con el siguiente estilo (ARCHIVO GENERADO EL YYYY/MM/DD).
 *  Una vez generado el archivo correspondiente, leerlo y mostrarlo por consola.
 */

package curso;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class CrearArchivo {
	public static void main(String[] args) {
		Empleado e1 = new Empleado();
		Empleado e2 = new Empleado();
		Empleado e3 = new Empleado();
		Empleado e4 = new Empleado();
		Empleado e5 = new Empleado();
		
		e1.setNombre("Carlos");
		e1.setApellido1("Martínez");
		e1.setApellido2("Suárez");
		e1.setEdad(22);
		e1.setNacimiento(LocalDate.of(2000, 5, 5));
		e1.setEstadoCivil("S");
		e1.setCiudad("Valencia, Valencia");
		e1.setEmail("camacar36@gmail.com");
		
		e2.setNombre("Aurelio");
		e2.setApellido1("Ortiz de Salazar");
		e2.setApellido2("Peris");
		e2.setEdad(21);
		e2.setNacimiento(LocalDate.of(2000, 8, 21));
		e2.setEstadoCivil("S");
		e2.setCiudad("San Juan, Alicante");
		e2.setEmail("aods1@gmail.com");
		
		e3.setNombre("Belén");
		e3.setApellido1("Aroca");
		e3.setApellido2("Chula");
		e3.setEdad(23);
		e3.setNacimiento(LocalDate.of(1999, 3, 31));
		e3.setEstadoCivil("S");
		e3.setCiudad("Aranjuez, Madrid");
		e3.setEmail("baroca@gmail.com");
	
		e4.setNombre("Moon");
		e4.setApellido1("Negro");
		e4.setApellido2("Fuego");
		e4.setEdad(1);
		e4.setNacimiento(LocalDate.of(2022, 1, 22));
		e4.setEstadoCivil("S");
		e4.setCiudad("Alcoi, Alicante");
		e4.setEmail("m00n@gmail.com");
		
		e5.setNombre("Paula");
		e5.setApellido1("Perales");
		e5.setApellido2("Izquierdo");
		e5.setEdad(21);
		e5.setNacimiento(LocalDate.of(2000, 11, 26));
		e5.setEstadoCivil("S");
		e5.setCiudad("Benetússer, Valencia");
		e5.setEmail("ppi9@gmail.com");
		
		ArrayList<Empleado> empleados = new ArrayList<>();
		empleados.add(e5);
		empleados.add(e4);
		empleados.add(e3);
		empleados.add(e2);
		empleados.add(e1);
		
		ArrayList<String> lines = new ArrayList<>();
		lines.add("ARCHIVO GENERADO EL " + LocalDate.now().toString()); 
		lines.add("\n" + "-----------------------------------------------------------" + "\n");
		for(Empleado e : empleados) {
			lines.add("Empleado: " + e.getNombre() + " " + e.getApellido1() + " " + e.getApellido2() + ". ");
			lines.add("Edad: " + e.getEdad());
			lines.add("Fecha de nacimiento: " + e.getNacimiento());
			lines.add("Estado Civil: " + e.getEstadoCivil());
			lines.add("Lugar de origen: " + e.getCiudad());
			lines.add("Email: " + e.getEmail());
			lines.add("\n" + "-----------------------------------------------------------" + "\n");
		}
		
		try {
			Path file = Paths.get("emplea2.txt");
			Files.write(file , lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
