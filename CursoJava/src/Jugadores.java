import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * //Generar un programa que contenga 3 clases y 1 interfaz. 
//  Se dio inicio a La liga y la empresa que se encarga de la misma necesita contar con un programa que pueda informar las transferencias de jugadore a otros equipos. Para ello, cuentan
//  con un TXT que tiene la lista de equipos y sus respectivos jugadores. En este mercado de pases surgieron las siguientes modificaciones:
// David Villa del Barcelona al Real Madrid
// Leo Messi del Barcelona al Valencia
// Cristiano Ronaldo del Real Madrid al Betis
// Generar un TXT de salida que informe las modificaciones correspondientes y reemplazarlos en el archivo de salida. 
// El formato del TXT debera ser el siguiente:
// nombreEquipo1:
// nombreJugador1 
// nombreJugador2
// nombreJugador3
/*
 * Crear una clase que contenga atributos del jugador
 * Crear una clase que contenga atributos del equipo
 * Crear una clase que contenga atributos de main, donde se debe ejecutar el metodo abstracto heredado de la interfaz
from Formador Cursos to everyone:    10:37 AM
 * Crear una interfaz que contenga un metodo abstracto que se llame asignaJugador
 * ENTREGABLE:
 * TXT
 * El proyecto
 */
public class Jugadores{

	
	public static void main(String[] args) {
		String plantilla = "Plantilla.txt";
		String plantillaFichajes = "PlantillaFichajes.txt";
		ArrayList<String> writeLines = new ArrayList<>();
		String line = null;
		int prevLineSize = 0;
		ArrayList<Equipo> equipos = new ArrayList<>();
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(plantilla));
			
			line = br.readLine();
			
			// Leer y guardar listas de equipos y jugadores
			
			while(line != null) {
				
				if(prevLineSize == 0) {
					Equipo newTeam = new Equipo();
					newTeam.setNombre(line.split(":")[0]);
					equipos.add(newTeam);
				}				
				
				else if(line.length() != 0) {
					Jugador player = new Jugador();
					player.setNombre(line);
					
					player.setEquipo(equipos.get(equipos.size() - 1).getNombre());
					jugadores.add(player);
				}
				
				prevLineSize = line.length();
				line = br.readLine();
			}
			br.close();
			
			// Asignar jugadores a cada equipo
			for(Jugador j : jugadores) {
				
				for(Equipo e: equipos) {
					if(Objects.equals(j.getEquipo(), e.getNombre())) {
						e.removePlayer(j);
					}					
				}
				
				if(j.getNombre().equals("Leo Messi")) {
					j.setEquipo("VALENCIA");
				}
				if(j.getNombre().equals("David Villa")) {
					j.setEquipo("REAL MADRID");
				}
				if(j.getNombre().equals("Cristiano Ronaldo")) {
					j.setEquipo("BETIS");
				}
				
				for(Equipo e: equipos) {
					if(Objects.equals(j.getEquipo(), e.getNombre())) {
						e.asignaJugador(j);
					}
					
				}
			}
			
			
			for(Equipo e: equipos) {
				writeLines.add(e.getNombre() + ":");
				for(Jugador j : e.getPlantilla()) {
					writeLines.add(j.getNombre());
				}
				writeLines.add("\n");
			}
			
			Path file = Paths.get(plantillaFichajes);
			Files.write(file , writeLines, StandardCharsets.UTF_8);
			
			
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

class Equipo implements AsignaJugador {

	
	
	private String nombre;
	private float presupuesto;
	private String estadio;
	private HashSet<Jugador> plantilla = new HashSet<>();
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getPresupuesto() {
		return presupuesto;
	}
	
	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public String getEstadio() {
		return estadio;
	}
	
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	public HashSet<Jugador> getPlantilla() {
		return plantilla;
	}
	
	public void setPlantilla(HashSet<Jugador> plantilla) {
		this.plantilla = plantilla;
	}
	
	public void removePlayer(Jugador j) {
		this.plantilla.remove(j);
	}
	
	@Override	
	public void asignaJugador(Jugador j) {
		this.plantilla.add(j);
	}
}

class Jugador{
	private String nombre;
	private String equipo;
	
	
	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}


interface AsignaJugador{
	public void asignaJugador(Jugador j);
}
