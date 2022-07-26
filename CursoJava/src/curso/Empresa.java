package curso;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * En la empresa se quiere implementar un programa que genere una salida ("proceso_hr.txt"). Con los empleados y sus datos personales. Los cuales son los siguiente:
- Nombre
- Apellido
- Ciudad
- Edad
- Estado Civil
- ID del empleado (heredado)
- Puesto del empleado (heredado)
- Jefe directo (heredado)
- Salario
El programa debe contar con la siguiente estructura (como minimo): 
2 interfaces:
- asignaJefe donde se genere un metodo que asigne al jefe       
- asignaSalario donde se asigne un salario
Estas interfaces deben ser implementadas por la clase empleado.
3 clases:
- Clase empleado 
- Clase persona 
- Clase jefe 
Cada clase debe poseer atributos propios de la misma
ACLARACION: Se debe hacer para 3 empleados y 1 jefe
 */
public class Empresa {
	public static void main (String[] args) {
		Scanner captura = new Scanner(System.in);
		ArrayList<Empleado> empleados = new ArrayList<>();
		Jefe jefe = null;
		Path file = Paths.get("dataBase.txt");
		
		int opcion = 0;		
		
		while(opcion != 3) {
			
			System.out.println("----- ¿Qué operación desea realizar? -----");
			System.out.println("1.- Añadir persona a la base de datos.");
			System.out.println("2.- Guardar los datos actuales.");
			System.out.print("3.- Salir. ");	
			
			opcion = captura.nextInt();
			
			switch(opcion) {
			
				case 1:
					System.out.println("----- ¿Es empleado (1) o jefe (2)? -----");
					int opcion2 = captura.nextInt();
					
					switch(opcion2) {
						case 1:
							Empleado empleado = new Empleado();
							
							System.out.print("Indique el nombre del empleado: ");
							empleado.setNombre(captura.next());
							 
							
							System.out.print("Indique el primer apellido del empleado: ");
							empleado.setApellido1(captura.next());
							 
							
							System.out.print("Indique el segundo apellido del empleado: ");
							empleado.setApellido2(captura.next());
							 
							
							System.out.print("Indique la ciudad del empleado: ");
							empleado.setCiudad(captura.next());
							 
							
							System.out.print("Indique el estado civil del empleado: ");
							empleado.setEstadoCivil(captura.next());
							 
							
							System.out.print("Indique la edad del empleado: ");
							empleado.setEdad(captura.nextInt());
							 
							
							System.out.print("Indique el ID del empleado: ");
							empleado.setID(captura.next());
							 
							
							System.out.print("Indique el puesto del empleado: ");
							empleado.setPuesto(captura.next());	
							
							System.out.print("Indique el salario del empleado: ");
							empleado.asignarSalario(captura.nextFloat());
							
							System.out.println("Indique el jefe del empleado: ");
							Jefe j = new Jefe();
							
							System.out.print("Indique el nombre del jefe: ");
							j.setNombre(captura.next());
							
							System.out.print("Indique el primer apellido del jefe: ");
							j.setApellido1(captura.next());
							
							System.out.print("Indique el segundo apellido del jefe: ");
							j.setApellido2(captura.next());
							 
							System.out.print("Indique el ID del jefe: ");
							j.setID(captura.next());
							
							empleado.asignarJefe(j);
							 
							
							int oldLen = empleados.size();
							empleados.add(empleado);
							int newLen = empleados.size();
							
							if(newLen - oldLen == 1) {
								System.out.println("¡Se ha añadido el empleado correctamente!");
							}
							else {
								System.out.println("No se ha añadido con éxito. Pruebe de nuevo.");
							}							
							
							break;
							
						case 2:
							jefe = new Jefe();
							
							System.out.print("Indique el nombre del jefe: ");
							jefe.setNombre(captura.next());
							 
							
							System.out.print("Indique el primer apellido del jefe: ");
							jefe.setApellido1(captura.next());
							 
							
							System.out.print("Indique el segundo apellido del jefe: ");
							jefe.setApellido2(captura.next());
							 
							
							System.out.print("Indique la ciudad del jefe: ");
							jefe.setCiudad(captura.next());
							 
							
							System.out.print("Indique el estado civil del jefe: ");
							jefe.setEstadoCivil(captura.next());
							 
							
							System.out.print("Indique la edad del jefe: ");
							jefe.setEdad(captura.nextInt());
							 
							
							System.out.print("Indique el ID del jefe: ");
							jefe.setID(captura.next());
							 
							
							System.out.print("Indique el salario del jefe: ");
							jefe.asignarSalario(captura.nextFloat());
							 
													
							System.out.println("¡Se ha añadido el jefe correctamente!");
							
							break;
							
						default:
							System.out.println("No existe ese cargo. Comience de nuevo.");
							break;
					}

					break;
					
				case 2:
					System.out.println("Guardando datos...");
					ArrayList<String> lines = new ArrayList<>();
					if (jefe != null){
					lines.add("ID: " + jefe.getID() + " - " + jefe.getNombre() + " " + jefe.getApellido1() + " " + jefe.getApellido2());
					lines.add("Tiene el cargo de jefe, con un salario de " + jefe.getSalario() + " euros.");
					}
					
					
					for(Empleado e : empleados) {
						lines.add("ID : " + e.getID() + " - " + e.getNombre() + " " + e.getApellido1() + " " + e.getApellido2());
						lines.add("Tiene el cargo de empleado en " + e.getPuesto() + " con un salario de " + e.getSalario() + " y cuyo jefe es: ");
						lines.add("ID: " + e.getJefe().getID() + " - " + e.getJefe().getNombre() + " " + e.getJefe().getApellido1() + " " + e.getJefe().getApellido2());
					}
					
					try {
						Files.write(file, lines, StandardCharsets.UTF_8);
					} catch (IOException e) {
						e.printStackTrace();
					}

					break;
					
				case 3:
					System.out.println("Saliendo...");
					break;
					
				default: 
					System.out.println("No existe esa opción. Por favor seleccione una de las que se indican.");
					break;
			}
		}	
		
		captura.close();
	}
}

class Empleado extends Persona implements asignaJefe, asignaSalario{
	private String id;
	private String puesto;
	private Jefe jefeDirecto;
	private float salario;
	private LocalDate nacimiento;
	private String email;
	
	@Override
	public void asignarJefe(Jefe j) {
		jefeDirecto = j;
	}
	
	@Override
	public void asignarSalario(float s) {
		salario = s;
	}
	
	public void setPuesto(String p) {
		puesto = p;
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	public void setNacimiento(LocalDate n) {
		nacimiento = n;
	}
	
	public void setID(String i) {
		id = i;
	}
	
	public String getPuesto() {
		return puesto;
	}
	
	public String getID() {
		return id;
	}
	
	public Jefe getJefe() {
		return jefeDirecto;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNacimiento() {
		return nacimiento.toString();
	}

}


class Jefe extends Persona implements asignaSalario{
	private String id;
	private ArrayList<Empleado> empleados = new ArrayList<>();
	private float salario;
	
	@Override
	public void asignarSalario(float s) {
		salario = s;
	}
	
	public void setID(String i) {
		id = i;
	}

	public void addEmpleado(Empleado e) {
		empleados.add(e);
	}
	
	public String getID() {
		return id;
	}
	
	public float getSalario() {
		return salario;
	}
	
	
	
}

class Persona{
	String nombre;
	String apellido1;
	String apellido2;
	String ciudad;
	String estadoCivil;
	int edad;
	
	public void setNombre(String n) {
		nombre = n;
	}
	
	public void setApellido1(String a1) {
		apellido1 = a1;
	}
	
	public void setApellido2(String a2) {
		apellido2 = a2;
	}
	
	public void setCiudad(String c) {
		ciudad = c;
	}
	
	public void setEstadoCivil(String ec) {
		estadoCivil = ec;
	}
	
	public void setEdad(int e) {
		edad = e;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public String getNombre() {
		return nombre;
	}
}

interface asignaJefe{
	public void asignarJefe(Jefe j);
}

interface asignaSalario{
	public void asignarSalario(float s);
}


