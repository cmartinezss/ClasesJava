
public class Areas {
	public static void main (String[] args) {
		Cuadrado cuadrado = new Cuadrado();
		Rectangulo rectangulo = new Rectangulo();
		Circulo circulo = new Circulo();
		
		cuadrado.setLado(10);
		rectangulo.setLados(10,20);
		circulo.setRadio(100);
		
		System.out.print("El área del cuadrado es: ");
		System.out.println(cuadrado.calcularArea());
		System.out.println(" m^2");
		
		System.out.print("El área del circulo es: ");
		System.out.print(circulo.calcularArea());
		System.out.println(" m^2");
		
		System.out.print("El área del rectangulo es: ");
		System.out.print(rectangulo.calcularArea());
		System.out.println(" m^2");
	}
		
	
}

interface Figura{
	public float calcularArea();
}

class Cuadrado implements Figura{

	private float lado;	
	
	public void setLado(float l) {
		lado = l;
	}
	
	@Override
	public float calcularArea() {
		return lado * lado;
	}
	
}
class Rectangulo implements Figura{
	
	private float lado1;	
	private float lado2;	
	
	public void setLados(float l1, float l2) {
		lado1 = l1;
		lado2 = l2;
	}
	
	@Override
	public float calcularArea() {
		return lado1 * lado2;
	}
	
}
class Circulo implements Figura{
	
	private float radio;	
	
	public void setRadio(float r) {
		radio = r;
	}
	
	@Override
	public float calcularArea() {
		return (float) (radio * radio * 3.14);
	}
	
}
