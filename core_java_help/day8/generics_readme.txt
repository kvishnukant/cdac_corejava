1.Understand Java world before generics & see dis-advantages --using readymade class
Use Raw (w/o type def) ArrayList
Check --- overheads  of down-casting & illegal casting excs.
2.  Objective -- Create your own non generic class , its dis-advantages.
Convert it to generic type class , see advantages.

A generic class means that the class declaration includes a type parameter.
eg --- class MyGeneric<T>

3.Confirm type - erasure via showDetails() -- it will print class name as Generics1 & not as Generics1<String>


4.  Apply generics to Pair<T> --eg of generic class
example uses ---  Pair,ArrayUtils,TestGenericClass.java
Desc --Pair<T> --- generic class, holding 2 refs of Type T, constr, getters & setters.
ArrayUtils class --- contains method for finding min & max from specified string array.
minMax(String[] data) --- rets Pair<String> --containg min & max strings


5. Objective -- How will u find middle element from ANY type of array?
Answer is --- usage of Generic methods.
A generic method means that the method declaration uses a type parameter in its signature.
eg ---
public <T> void test(T[] data)

If the class itself doesn't use a type parameter, you can still  specify one for a method, by declaring it in a really unusual manner --- Add type info between method modifiers
& space-before the return type, Above  method says that T is the Type of array.

code example in ---ArrayUtils1.java & TestGenericMethod.java

6. Generic Interfaces --- Means  i/f declaration includes a type parameter.
eg : List<E> , Map<K,V> --- i/fs belonging to Collection framework.

Objective : Accept no of customers, cust dtls(Using pop-up dialog boxes)  , store them in an array: un-sorted manner.
disp unsorted array & then sort cust array : as per IDs & disp sorted o/p.


1.Natural ordering of Java objects

2. Generic i/f : java.lang.Comparable<T>

3. UDT(User defined type) MUST imple. java.lang.Comparable<T>
T= UDT to be compared.

4. UDT must implement
int compareTo(T o)
this < o ret <0
 if this=o(content wise) --- ret 0 
if this > o --- ret +ve int
5. Arrays.sort() will auto invoke compareTo & give sorted array.


7. Specifying Upper Bound in generic programming
extends keyword in generics --- supplies upper bound
Consider this eg of generic method.
eg ---
public <T extends Animal> void takeThing(ArrayList<T> list)
Vs
public void takeThing(ArrayList<Animal> list)
Both of above versions are legal.
But 1st one allows you to create ArrayList of Animal or any of its sub-type , whereas 2nd one can be used  only for Animal type.


Another eg --- Method below says , T is arg to dispSal , where T can be Emp or sub-type
public <T extends Emp> dispSal(T o)

eg T extends Emp  --  If Emp is class then => T can be any type of Emp or its subType(sub-class)
eg T extends Comparable ---Comparable is an i/f ---so it implies => T must be an implementation class of Comparable i/f
eg T extends Comparable & Runnable ---T must implement both Comparable & Runnable i/fs.


super --- keyword in geneneric prog
super ---- specifies lower bound.
eg ---T super Mgr ----> T must be Mgr or its super-type(eg Emp,Object)

----------------------------------------------------------


Objective --  what if user wants to find min & max from any type of array?
4. Refer to ArrayUtils2.java 
syntax of generic method ---
Type def exists between method modifiers & its ret type.
So replace String type by Type T & it gets converted into generic method.
4. But there is compiler prob.
5. U have to tell compiler that T type will always have compareTo method for comparing 2 objs.
compareTo method belongs to Comparable i/f
6. Comparable is eg of generic i/f
public interface Comparable<T> 
T --- type of the object to compare
& it has method compareTo
7. Refer to ArrayUtils3 --- where bounds in generic prog are introduced. & its tester in TestBoundedGenericMethod
extends --- supplies upper bound
eg T extends Emp  --  Emp is class then => T can be any type of Emp or its subType(sub-class)
eg T extends Comparable ---Comparabe is an i/f ---so it implies => T must be an implementation class of Comparable i/f
eg T extends Comparable & Runnable ---T must implent both Comparable & Runnable i/fs.

8. Generic types exist only till compilation takes place.In JVM there are no generic objects. Phenomenon called type-erasure takes place during compilation.
class Pair<T> simply gets replaced by class Pair
& T first --- by Object first.
When we use 
Pair<String> p1=new Pair<String>("aa","bb");
String s=p1.getFirst();

Compiler actually applies the type cast(narrowing conversion) from Object to String
eg --
Pair<Employee> buddies = new Pair(new Employee("a"),new Employee("a"));
Employee buddy = buddies.getFirst();
The erasure of getFirst has return type Object. The compiler automatically inserts the type -cast to Employee.
i.e 
Pair buddies = new Pair(new Employee("a"),new Employee("a"));
Employee buddy =(Employee) buddies.getFirst();

9. Wild card need
Suppose u have 2 mgr paired as below
Pair<Mgr> p1=new Pair(new Mgr(1,"aa" ,100),new Mgr(2,"bb",200));
printBuddies(p1);
& method def of printBuddies(Pair<Emp> p) --- as it should be able to print buddies of any pair.
gives compiler err at invocation of printBuddies. 
As : Emp <---- Mgr BUT Pair<Emp> is NOT a super class of  Pair<Mgr>
so u have to supply ---- a wild card character 
printBuddies(Pair<? extends Emp> p) & then it works.

eg --WildCardUsage.java,TestWildCard.java




