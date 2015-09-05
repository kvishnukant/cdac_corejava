package wrappers;
class AutoBox4 { 
  public static void main(String args[]) { 
     
    Integer iOb = 100; //auto-boxing
    Double dOb = 98.5; //auto-boxing
    
    dOb=iOb+dOb;//auto-unboxing,addition,auto-boxing
    System.out.println("dOb after expression: " + dOb);
    iOb =(int)( dOb + iOb); 
    System.out.println("iOb after expression: " + iOb);
    //observe behaviour for 1byte width --->  -128---127
    Integer i1=-128;
    Integer i2=-128;
    System.out.println(i1==i2);
    //compiler err in next stmt
    //Double d1=50;//explain
    
    
     
  } 
}
