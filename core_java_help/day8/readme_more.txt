String class API
Imp String class constructors
1.String(byte[] bytes) --- byte[] ----> String converter

2.String(char[] chars)   --- char[] ---> String converter

3.String (byte[] bytes,int offset,int len)  ---byte[] ----> String converter from the specified offset , specified len no of bytes will be converted.
eg . String s=new String(bytes,3,4);   --- String will contain bytes[3]----bytes[6]

4. String(char[] ,int offset,int len)

5. String(String s)

String class methods --- to go through
charAt,compareTo,contains,copyValueOf,format,valueOf,getBytes,toCharArray,toLowerCase,indexOf,lastIndexOf,split,replace,startsWith,endsWith,length.


1.
boolean equals(Object o) ---- ret true iff 2 strings are having same contents (case sensitive)

About equals()
super class def. --- java.lang.Object
public boolean equals(Object o)
Rets true iff both refs(this & o) are equal i.e referring to the same object.

Sub-class developers MUST override equals for content-wise(depending on Object's state) comparison.








2. concat,charAt,indexOf,lastIndexOf,toUpperCase,toLowerCase,format,split

printf & Formatter class
Refer to java.util.Formatter class for formatting conversion details.

Imp ---

Formatting details
%c -- character
%b -- boolean
%h -- hex value of hashcode of obj ref.
%s -- string
%d -- int
%f,%g -- float/double
%x -- hex value
%n -- line separator
%tD  -- Date 
%tT  -- Time
%tc  -- Time stamp(date & Time)
%td-%1$tb-%1$tY -- can be applied to GC or Date. 

Date/Time Handling in Java

API
1. java.util.Date--- represents system date.
Constructor
1.Date() --- creates Date class instance representing system date.
2.Date(long msec) --- creates Date class instance representing date for msec elapsed after epoch(=1st Jan 1970)

2. java.util.GregorianCalendar
GregorianCalendar(int yr,int mon,int date);
GregorianCalendar(int yr,int mon,int date,int hr,int min,int sec);


3. Date/Time formatting via printf
%tc -- for complete timestamp(date & time)
%tD -- for date
%tT -- time 

Arguments --- Date, GregorianCalendar

static import syntax ---
eg -- import static java.util.Calendar.*;
or import static java.lang.System.*;

in such src   -  u can access directly static members of Calendar class or from 2nd statement u can directly use out.println("testing static imports!");

var-args
variable args syntax.--- Must be last arg in the method args.
Can use primitive type or Object ref types.
Legal ---
void doStuff(int... x) { } // expects from 0 to many ints
// as parameters
void doStuff2(char c, int... x) { } // expects first a char,
// then 0 to many ints
void doStuff3(Animal... animal) { } // 0 to many Animals

Illegal:
void doStuff4(int x...) { } // bad syntax
void doStuff5(int... x, char... y) { } // too many var-args
void doStuff6(String... s, byte b) { } // var-arg must be last

Generic syntax ---
Available from Java SE 5 onwards.
Represents Parameterized Types.
Can Create Generic classes, interfaces, methods and constructors.
Operates on Parameterized data Types
In Pre-generics world , similar achieved via Object class reference.

Advantages
Adds Type Safety to the code @ compile time
Can add type safe code where type-mismatch errors are caught at compile time.
No need of explicit type casting, as all casts are automatic and implicit.


A generic class means that the class declaration includes a type parameter.
eg --- class MyGeneric<T>

Bounds example --- showing usage of keyword extends in generics.
eg -- BoundsDemo.java(from generics pkg)
A generic method means that the method declaration uses a type parameter in its signature,


eg ---
public <T extends Animal> void takeThing(ArrayList<T> list)

public <T extends Comparable> void takeThing(ArrayList<T> list)


If the class itself doesn't use a type parameter, you can still  specify one for a method, by declaring it in a really unusual manner
(but available) 
space-before the return type, Above  method says that T can be "any type of Animal",



Another eg --- Method below says , T is arg to dispSal , where T can be Emp or sub-type
public <T extends Emp> void dispSal(T o)



eg ---API of java.util.Collections
public static <T extends Comparable<? super T>> void sort(List<T> list)



Meaning --- sort method accepts List of Type T.
where T  -- MUST implement(extends keyword in generics is used to show upper bound of inheritance or implemented interface name) Comparable i/f 
? super T --- Comparable Type -- can be ANY THING(?) as T or its super class












