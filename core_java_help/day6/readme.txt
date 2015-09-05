Custom Exception --- Programmer created exception --- Raised as a result of validation errs or business logic errs.

Need --- Business logic errs cant' be detected as exceptions by JRE , so prog has to create them & 'throw' them to the code.

Steps for Creating Custom Exc
1. Create a pkged public class which extends Throwable(not reco but legal)/Exception(reco)/Error(not reco but legal)/RuntimeExc(not reco but legal)

2.CustExc(String msg) : overload the constr : to invoke the super-class constr.
of the form 
Exception (String msg)
OR  
CustExc(String msg,Throwable rootCause)
public Exception(String message,Throwable cause)




Check the speed of vehicle on a freeway
Accept the speed using Scanner : can be speed too low(exc) or too high(exc) or in range

Better objective -- Applying validations for user bank a/c  creation.

Create Account class 
data members --- acct ID(system generated --auto inc) 
type,balance,creationDate.
CustomerDetails(separate class)  --- has A relationship(one--one). --- email,password,address.
(constructor,toString)
setter for setting customer details

validations --
email -- must be min 5 , max 20 , must have @ char
password -- must contain  $  min 5 max 10 chars
creationDate --- must be within 1st Jan 2011 --- 31 July 2013
opening  balance -- > min balance

Account Creation utility class
main---

accept account details including customer details from user , create the object & display its info ---only in case successful validations.
In case of validation errs --- give suitable error mesgs.

MUST be done with exc handling constructs.











Later ....
Accept max accounts from admin user.
Options
1. Register customer
2. Display Cust Details
3. Un-subscriobe customer
4. Update Customer subscription
5. Exit



1. Date Time Handling in Java
1.1 API class
java.util.Date
constructor -- Date() -- creates Date class instance for current date.
Date (long ms)  -- Home work -- read API documentation & explain.

Important Methods
after,before,compareTo,toString,getTime,setTime
--go thro' API docs & test their usage in code example.

1.2 How to parse string to Date?
API class -- java.text.SimpleDateFormat
Steps
1.2.1 Create its instance
SimpleDateFormat(String pattern)
eg --
SimpleDateFormat sdf=new SimpleDateFormat("dd|MMM|yyyy");
MM -- month in number(1-12)
MMM -- abbreviated month name
> 3 M -- complete month name
1.2.2
API method (inherited from DateFormat)
public Date parse(String source) throws ParseException
eg ---
Date d1=sdf.parse(sc.next());

1.2.3
API method of SDF
public String format(Date d)
rets formatted string for specified date instance.


How to create ready made dialog boxes
1. javax.swing.JOptionPane -- class
static methods 
1.1  For message dialog boxes
public static void showMessageDialog(Component parent,Object mesg)
1.2  For I/P dialog boxes
public static String showInputDialog(Component parent,Object mesg)
OR 
public static String showInputDialog(Object mesg)











