package append_object_io;

// 
import java.io.*;
public class E1 implements Serializable {
  int e;
  static int s;
  transient int t;
  static {
	  s=10;
	  System.out.println("in static block");
  }

  public E1(int i) {
    System.out.println("in constr");
    e = i;
	t=i*2;
	s++;
  }
  public String toString() {
    return "state = " + e+" static val= "+s+" transient= "+t;
  }

 
}
