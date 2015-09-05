package wrappers;
class AutoBox2 { 
   
  static int m(Integer v) { 
	  v++;//auto-unboxing,inc,auto-boxing
    return v ; // auto-unbox to int 
  }  
  static void m1(Integer v)
  {
    v++;//auto-unbox,inc,auto-boxing
  }
 
  public static void main(String args[]) {     
    
    Integer iOb = m(100);  
 
    System.out.println(iOb); 
    m1(iOb);
    System.out.println(iOb);
    
  } 
}
