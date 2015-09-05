package enums;

// An enumeration of Colors 
enum Colors {  
  RED,YELLOW,GREEN,BLUE,ORANGE
} 
 
class EnumDemo { 
  public static void main(String args[])  
  { 
    Colors c;
 
    c = Colors.GREEN;
 
    // Output an enum value. 
    System.out.println("Value of clr: " +c); 
    
 
   
 
    // Compare two enum values. 
    if(c == Colors.GREEN)  
      System.out.println("Color is green\n"); 
 
    // Use an enum to control a switch statement. 
    switch(c) { 
      case RED: 
        System.out.println("1"); 
        break; 
      case GREEN: 
        System.out.println("2"); 
        break; 
      case BLUE:  
        System.out.println("3"); 
        break; 
      case YELLOW: 
        System.out.println("4"); 
        break; 
      case ORANGE: 
        System.out.println("5"); 
        break; 
    } 
  } 
}
