package shapes;

import intf.Compute;

public class Rect extends Point implements Compute {
	private double width, height;

	public Rect(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rect " + super.toString() + " width=" + width + ", height="
				+ height;

	}

	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return width*height;
		
	}

	@Override
	public double calcPerimeter() {
		// TODO Auto-generated method stub
		return 2*(width+height);
	}

	public double getHeight() {
		return height;
	}
	

}
