Creating user defined packages
Need ?
1. To group functionally similar classes together.
2. Avoids name space collision
3. Finer control over access specifiers.




Objective ---
Create Bank Account class ---
D.M ---acctNo(int)---auto inc generator,name(String),type(String),balance(double)
static d.m --counter(int)---offset -- inited in static init block--- gets called once per class loading.
Functionality --Methods --- String getAccountSummary()
void withdraw(double amt),void deposit(double amt)

TestAccount --- main(...) ---1 Create A/c 2: withdraw 3:deposit 4 get summary 5 exit

Step 1 ---
Place both the classes under same pkg --- bank.mybank
Step 2 
Place Account class in bank.mybank & TestAccount1 in "tester" package.


About Packages 
1. Creation : package stmt has to be placed as the 1st stmt in Java source.
eg : package p1; => the classes will be part of package p1.
2.Package names are mapped to folder names.
eg : package p1; Class A{....}
A.class must exist in folder p1.
3.  For simplicity --- create folder p1 -- under <src> & compile from <src>
From <src>
javac -d ..\bin p1\A.java

-> javac will auto. create the sub-folder <p1> under the <bin> folder & place A.class within <p1>

NOTE : Its not mandatory to create java sources(.java) under package named folder. BUT its mandatory to store packged compiled classes(.class) under package named folders

Earlier half is just maintained as convenience(eg --- javac can then detect auto. dependencies & compile classes ).




4. To run the pkged classes from any folder : u must set Java specific  env var. : classpath
set classpath=g:\dac1\day2;


With the classpath set, JRE's classloader 1st searches in the curnt folder, if not found then will continue to search in the folders specified in the classpath & try to load the pkged classes.

classpath= Java only env .var
Used by JRE's classloader : to locate & load the classes.
Classloader will try to locate the classes from current folder, if not found --- will refer to classpath entries : to resolve & load Java classes.

set classpath=G:\dac\dac1\day2\bin;(cmd line invocation)



Objective : 
Create Account class ----id,name,type,bal
Constr, Bl -- getSummary,withdraw/deposit
Tester --- Use scanner -- to accept a/c dtls from user, disp summary.

1.Place both of above classes --- in bank pkg. & test the same.

2.Place Account class  bank pkg & place TestAccount in tester pkg. & test the same


---------------------------------------------


static keyword usage --- static data members,static methods,static nested classes,import static & static init blocks.

Check Parameter passing

--------------------------------------------

simple(single) inheritance hierarchy
Class A(in pkg inh) --- private D.M -- int i
 access specifier for ---constr,methods(show---to disp state of A)

Class B(in pkg inh)  -- sub-class -- inherited D.M + additional D.M 
default access specifier for ---constr,methods(show---to disp state of B)+ additional method test

TestInh class --- in  pkg tester 
1. create super cls obj & test func.


sub-class IS A super class & something more + some thing modified


Objective : test single inheritance --- 



Method overloading --- static polymorphism --- resolved by compiler 
Rules---
same method name
different signature(no/type/both)
ret type - ignored by the complier
Overloaded methods can be defined in the same class.



eg --- void test(int i,int j)
int test(int a,int b)   ---> compiler err.


Method Overriding --- Means of achieving run-time polymorphism
All java methods can be overridden : if they are not marked as private,static,final
Super-class form of method - --- overridden method
sub-class form --- overriding form of the method
Rules : to be followed by overriding method in a sub-class
1. same method name, same signature, ret type must be same or its sub-type(co-variance)
2. scope---must be same or wider
3. can not add in its throws clause any new checked exceptions.
BUT can add any new unchecked excs.
Can add any subset or sub-class of checked excs.
Can't add super class of the checked excs.

4. From JDK 1.5 onwards : Annoations are available --- metadata meant for Compiler or JRE.
Annotation for javac
While overridng the method --- if u want to inform the compiler that : following is the overriding form of the method use :
@Override
method declaration


Dynamic method dispatch --- Super -class ref. can directly refer to sub-class object(direct=w/o type casting) as its the example of up-casting(similar to widening auto. conversion) . When such a super-ref is used to invoke the overriding method: which form of the method to send for execution : this decision is taken by JRE & not by compiler. In such case --- overriding form of the method(sub-class version) will be dispatched for exec.

 Super -class ref. can directly refer to sub-class inst BUT it can only access the members declared in super-class -- directly.











eg : A ref=new B(); ref.show()  ---> this will invoke the sub-class: overriding form of the show () method


Objective : apply inh & poly. to organization scenario
Emp --- id,name,basic --- pkg org
B.L --- dispEmpInfo(rets a string for emp info), computeNet sal(ret double net sal).

Mgr(same pkg org) ---id,name,basic,perfBonus
B.L ----dispEmpInfo(rets a string for mgr info),compute Net sal = basic+perfBonus
display perfBonus  --- public double getPerfBonus()


Worker(same pkg org) ---id,name,basic,hoursWorked,hourlyRate
B.L--- dispEmpInfo(rets a string for worker info),compute Net sal = basic+(hrs*rate)
display hrlyRate of the worker  --- public double getHourlyRate()


Tester class  -- TestOrg --- tester pkg.
1. How many emps in org ?
2. Display options 
2.1 Hire Mgr --- 
2.2 Hire worker
2.3 Display Org details (info + net sal) -- single for-each loop
& display perf bonus if its mgr or rate if its worker
2.4 Fire Emp --- i/p id
2.5 Display emp details -- i/p id & o/p --- emp not found OR actual; details 
2.6 Update Salary of Emp --- i/p id , sal inc
2.7 Exit

Create org structure --- m1,w1,w2,m2
in 1 line
Emp[] emps=new Emp[sc.nextInt()];


create ORG structure(currently array based) --- using dyn init of array .
to populate m1,w1,w2,m2 in the org.

Using single for-each loop --- disp emp info & net sal.
Display mgr's perfBonus from the very same loop.
Display worker's rate from the same loop.


java.lang.Object ---- universal super-class of all Java classes
API - 
public String toString()  --- Rets the string representation of the Object --- F.Q class Name@Hashcode  (internal representation of mem addr)



abstract : keyword in Java
abstract methods ---methods only with declaration & no definition
eg : public abstract double calNetsalry();

Any time a class has one or multilple abstract methods ---- class must be declared as abstract class.
eg. public abstract class Emp {....}

Abstract classes can't be instantiated BUT can create the ref. of abstract class type to refer to concrete sub-class instances.

Abstract classes CAN HAVE concrete(non-abstract) methods.

Abstract classes MUST provide constructor/s to init its own private data members.

Can a class be decalred as abstract & final ? NO 

Can an abstract class be crerated with 100% concrete functionality?
Yes 
eg --- Event adapter classes.





















