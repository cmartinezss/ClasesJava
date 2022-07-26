import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/*
 * Declarar una coleccion de tipo Lista que almacene las fechas de la semana
 *  y las muestre por consola. Si la fecha es igual al día de hoy 
 *  generar un txt informando que el proceso corrio de forma correcta. 
 */
public class FechasSemana {
	public static void main(String[] args){
		ArrayList<LocalDate> fechas = new ArrayList<>();
		
		
		fechas.add(LocalDate.of(2022, Month.JULY, 18));
		fechas.add(LocalDate.of(2022, Month.JULY, 19));
		fechas.add(LocalDate.of(2022, Month.JULY, 20));
		fechas.add(LocalDate.of(2022, Month.JULY, 21));
		fechas.add(LocalDate.of(2022, Month.JULY, 22));
		fechas.add(LocalDate.of(2022, Month.JULY, 23));
		fechas.add(LocalDate.of(2022, Month.JULY, 24));
		
		for(LocalDate f : fechas) {
			
			System.out.println(f.toString());
			
			if(f.toString().equals(LocalDate.now().toString())) {
				try {
					Files.writeString(Path.of("guardado.txt"), "El proceso corrió correctamente.", StandardCharsets.UTF_8);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
