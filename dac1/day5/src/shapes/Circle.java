package shapes;

import intf.Compute;

public class Circle extends Point implements Compute{
	private double radius;
	public Circle(int x,int y,double rad)
	{
		super(x,y);
		radius=rad;
	}
	@Override
	public String toString()
	{
		return "Circle "+super.toString()+" radius="+radius;
	}
	public double getRadius() {
		return radius;
	}
	
	@Override
	public double calcArea()
	{
		return PI*radius*radius;
	}
	@Override
	public double calcPerimeter()
	{
		return 2*PI*radius;
	}
	
	

}
