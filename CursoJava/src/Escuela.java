/* 
 * El director de una escuela está organizando un viaje de estudios y requiere determinar cuánto debe cobrar a cada alumno y cuánto debe pagar a la compañía de viajes por el servicio. La forma de cobrar es la siguiente:
* Si son 100 alumnos o más, el costo por cada alumno es de 65 euros.
* De 50 a 99 alumnos, el costo es de 70 euros.
* De 30 a 49 alumnos, el costo es de 95 euros.
* Menos de 30 alumnos, el costo de la renta del autobús es de 4000 euros, sin importar el número de alumnos.
 */
public class Escuela {
	public static void main(String[] args) {
		int nAlumnos = 100;
		int costoAlumnos = 0;
		int costoTotal = 0;
		
		if(nAlumnos < 30) {
			costoTotal = 4000;
		}
		
		else if(nAlumnos < 50) {
			costoAlumnos = 95;
		}
		
		else if(nAlumnos < 100) {
			costoAlumnos = 70;
		}
		else {
			costoAlumnos = 65;		
		}
		costoTotal += nAlumnos*costoAlumnos;
		System.out.println(costoTotal);
	}
}
