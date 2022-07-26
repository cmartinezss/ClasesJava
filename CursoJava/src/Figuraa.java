public class Figuraa {
    
	abstract class Fig
	{
	    int b = 20;
	    public void display()
	    {
	        System.out.println("Hola");
	    }
	//abstract public void calcularArea();
	}
	public class Rectangulo extends Fig
	{
	    public void main ()
	    {
	        Rectangulo obj = new Rectangulo();
	        obj.display();
	        obj.b = 20;
	    }
	    //public void calcularArea();
	}
	public void main ()
	{
	    Rectangulo obj = new Rectangulo();
	    obj.display();
	    obj.b = 20;
	}
}