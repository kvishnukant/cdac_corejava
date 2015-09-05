package shapes;

public class Point {
	private int x,y;

	public Point(int x, int y) {
	//	super();
		this.x = x;
		this.y = y;
	}

	/*public Point() {
		// TODO Auto-generated constructor stub
	}*/
	@Override
	public String toString() {
		return "@ [x=" + x + ", y=" + y + "]";
	}
	
	

}
