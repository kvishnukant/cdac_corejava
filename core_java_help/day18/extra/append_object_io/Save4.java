package append_object_io;



import java.awt.*;
import java.io.*;
import java.util.*;


public class Save4 {
  public static void main(String args[]) {

    try {
     

     
	 File f1=new File("save4.data");
	 //static method to create inst. of appendable Object o/p strm.
	ObjectOutputStream oos=appendableObjectOutputStream(f1);
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter number");
      E1 e=new E1(sc.nextInt());
 
      oos.writeObject(e);
      System.out.println(e);
      System.out.println("Enter number");
      e=new E1(sc.nextInt());
      oos.writeObject(e);
	   System.out.println(e);

      oos.flush();
	  oos.close();
  //    fos.close();
    }
    catch(Exception ex) {
      System.out.println("Exception: " + ex);
      ex.printStackTrace();
    }
  }
  

static ObjectOutputStream appendableObjectOutputStream(File f) throws IOException{
  FileOutputStream fos=new FileOutputStream(f,true);
  boolean append=f.exists() && f.length()>0;
 // append=false;
  if (append)
    return new ObjectOutputStream(fos) {
      protected void writeStreamHeader() throws IOException{}
    };     
  else
    return new ObjectOutputStream(fos);
}



}