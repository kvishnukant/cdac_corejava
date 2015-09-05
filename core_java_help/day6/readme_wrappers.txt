Regarding wrapper classes
1. What's need of wrapper classes?
---1. to be able to add prim types to growable collection(growable data structure eg -- LinkedList)
--- 2.  wrapper classes contain useful api(eg --- parseInt,parseFloat....)
2. What are wrappers? --- object equivalent for primitive types
-- Inheritance hierarchy
java.lang.Object --- Character (char)
java.lang.Object --- Boolean
Object -- Number -- Byte,Short,Integer,Long,Float,Double
3. Constrs & methods --- for boxing & unboxing
boxing= conversion from prim type to the wrapper type(class type)
un-boxing = conversion from wrapper type to the prim type
eg 
Integer(int data) --- boxing 
Integer i1=new Integer(100);
//un-boxing
int data=i1.intValue();

4. JDK 1.5 onwards --- boxing &unboxing performed automatically by java compiler.
5. examples








