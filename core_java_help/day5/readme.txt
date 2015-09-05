Regarding Java Interfaces
WHY ?
1. As an alternative to multiple inheritance
2. Allows complete loosely coupled architecture -- by allowing separation between specifications (WHAT) & implementation(HOW)


syntax
default/public interface NameOfInterface extends comma sep. list of super i/fs 
{
// Data members --- public static final -- implicitely
//Method memebers --- public abstract --- implicitely
}

syntax for implementation class
default/public class NameOfClass extends SuperclsName implements comma sep list of interfaces
{
//which D.M can be accessed directly ? -- i/f constants
//mandatory requirements  for non-abstract class - MUST imple all methods from all i/fs.
}



Objective --- test i/f & imple class
i/f -- compute --- area & peri of the bounded shapes
---members -  PI, calc functionality declarations.

Point class ---- x,y co-ords , costr, toString

Circle --- x,y,rad , toString,calcArea,calcPeri
Rect --- x,y,w,h,toString ,calcArea,calcPeri



TestIntf  --- Circle inst, Rect inst  -- Initially using direct ref
& later with , dynamic method dispatch --- i/f ref.


Dynamic method dispatch via interfaces ---
Interfaces can't be instantiated BUT can be used as a ref.
I/f ref can directly (w/o type casting) refer to implementation class instance & can access functionality declared within i/f.


static --- keyword in java
Usages
1. static data members --- Mem allocated only once @ class loading time --- not saved on heap --- but in special mem area -- Perm Gen space . -- shared across all objects of the same class.

eg -- public static final int counter=100;

2. static methods --- Can be accessed w/o instantiation. (ClassName.memberName()) 
Can't access 'this' from within static method.

Rules -- 1. Can static methods access other static members directly(w/o inst) -- YES
2. Can static methods access other non-static members directly(w/o inst) -- NO
3. Can non-static methods access other static members directly(w/o inst) -- YES

3. static import ---Can directly use all static members from the specified class.
eg --
import static java.lang.System.*;

main(...)
{
   out.println(.....);
}



4. static initializer blocks
syntax --
static {
// block gets called only once @ class loading time
// usage -- to init all static data members & can add functionality --
//which HAS to be called precisely once.
}

They appear -- within class definition & can access only static members directly.(w/o inst)



5. static nested classes ---
eg --
class Outer {
// static & non-static members
  static class Nested
  {
     //can access ONLY static members of the outer class DIRECTLY
  }
}






Regarding non-static initilizer blocks(inst initilaizer block)
syntax
{
//will be called per instantiation --- before matching constructor
//Better alternative --- parameterized constructor.
}


co-variance --- From Java SE 5 onwards, overriding form of the method , can return sub-type of the , ret type of the overridden method.



Regarding Exception Handling in java.....
Any run time err occurs(eg file not found,accessing out of array size,accessing func from null ref, divide by 0)
---JRE(main thrd) --- creates matching exc class instance(java.io.FileNotFoundException,java.lang.ArrayOutOfBoundsExc,NullPointerExc,ArithmeticExc)
--- JRE checks -- if prog has proivided exc handling code ?
--- NO -- JRE aborts java code(by supplying def handler) & prints details --F.Q exc class name,reason behind failure & location details(err stack trace

--- YES (try---catch) JRE execs exc handling block & continues with the rest of the code.



syntax(key words) --- try,catch,finally,throw,throws
Inheritance hierarchy of exc classes
unchecked vs checked excs.
Creating custom excs
JDK 1.7 syntax --- try-with-resources(in I/O or device prog)



Checked & Unchked exc are detected or occur only in run-time
Compiler(javac) differentiates bet them
Javac forces handling of the checked exc. upon the prog.(Handling by supplying matching try-catch block or including it in the throws clause.)

Legal syntax
1. try {...} catch (exc e){}
2. try {...} catch (exc1 e){} catch (exc2 e) {} ....
3. try {...} catch (exc1 e){} catch (exc2 e) {}catch(Exception e){catch-all}
4. throws syntax ---
method declaration throws comma separated list of exc classes.
5. finally --- keyword in exc handling
finally -- block -- finally block ALWAYS survives(except ....)
i.e in the presence or absence of excs.
5.1 try{...} catch (Exception e){....} finally {....}
5.2 try {...} finally {....}


Creating Custom Exc
1. Create a pkged public class which extends Throwable(not reco but legal)/Exception(reco)/Error(not reco but legal)/RuntimeExc(not reco but legal)

2.CustExc(String msg) : overload the constr : to invoke the super-class constr.
of the form 
Exception (String msg)
OR  
CustExc(String msg,Throwable rootCause)
public Exception(String message,Throwable cause)


Objective :
Check the speed of vehicle on a freeway
Accept the sp using Scanner : can be speed too low(exc) or too high(exc) or in range








About equals.....
Object form :
public boolean equals(Object ref)
Sub-class dev.must override(@Override) equals method : by 1st chking instanceof(ensuring of the same type) & then by chcking on data members : representing the prim key.

Sequence 
TestFinally.java,TestFinally2,TestFinally3,TestFinally4,TestCustomExc.java





