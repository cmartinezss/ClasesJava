import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * En la ciudad de Buenos Aires suceden muchos accidentes de transito, se realizo un estudio indicando las marcas de autos mas propensas a participar de dichos accidentes, las cuales son las siguientes:
- Audi
- Alfa Romeo
- Ferrari
- Ford
Para cada una de estas marcas, se esta realizando un analisis que nos permita entender cuales son los modelos que mas participaron. 
Se nos pidio desarrollar un programa que almacene y muestre lo siguiente: 
- De cada marca de autos, informar los modelos que participaron de los siniestros
- Informar tambien la velocidad maxima de cada uno de los modelos
DESARROLLAR un txt que muestre, ordenado alfabeticamente, las marcas y sus respectivos modelos y sus velocidades maximas permitidas. 
Almacenarlo en el branch de Desarrollo. 
 */

public class EjAutos {
	public static void main(String[] args) {
		XMLDecoder d = new XMLDecoder();
		ArrayList<String> lines = new ArrayList<>();
		ArrayList<Automovil> vehiculos = (ArrayList<Automovil>) d.read();
		
		
	
		
		for(Automovil a : vehiculos) {
			lines.add(a.getMarca() + " - " + a.getModelo() + "\t| " + a.getMaxVel() + "km/h.");
		}
		
		Collections.sort(lines);
		
		lines.add(0,"--------\t| ------------");
		lines.add(0,"Modelos:\t| Velocidades:");

		try {
			Path file = Paths.get("accidentes.txt");
			Files.write(file , lines, StandardCharsets.UTF_8);
			System.out.println("Escrito correctamente.");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

class Automovil{
	
	
	private String marca;
	private String modelo;
	private int maxVel;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getMaxVel() {
		return maxVel;
	}
	public void setMaxVel(int maxVel) {
		this.maxVel = maxVel;
	}
	
}

class XMLDecoder{
	public static final String SEPARATOR=";";
	private String path = "Marcas_y_modelos.csv";
	private BufferedReader br = null;
	
	
	
	
	public List<Automovil> read() {
		ArrayList<Automovil> coches = new ArrayList<>();
		
		try{
			
			br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			
			@SuppressWarnings("unused")
			String [] fields = line.split(SEPARATOR);
            
            line = br.readLine();
            
			while (null!=line) {
	            
	            String[] data1 = line.split(SEPARATOR);
	            
	            Automovil a = new Automovil();
	            
	            a.setMarca(data1[0]);
	            a.setModelo(data1[1]);
	            a.setMaxVel(Integer.valueOf(data1[2]));
	            
	            coches.add(a);
	            
	            line = br.readLine();
	         }
			br.close();
			System.out.println("Leído correctamente");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return coches;
		
	}
}
