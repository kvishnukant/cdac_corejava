package append_object_io;


import java.io.*;

public class Restore4 {
  public static void main(String args[]) {
    try {
     E1 e=null;
      FileInputStream fis =new FileInputStream("save4.data");
      ObjectInputStream ois = new ObjectInputStream(fis);
	  while ((fis.available() !=0)&&(e=(E1)ois.readObject()) != null)
	  {
		  System.out.println(e);
	  }
      
	   ois.close();
    }
    catch(Exception ex) {
      System.out.println("Exception: " + ex);
	  ex.printStackTrace();
    }
  }
}