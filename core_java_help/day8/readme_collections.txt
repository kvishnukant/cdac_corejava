Objective -- Using ArrayList in practical scenario
Store Customer records -- for Stock Trading scenario
Customer details -- email(String primary key),dmat a/c no(int),stocks(StringBuilder -- representing stock names),funds for investing(double), regDate(SDF)
B.L 
purchase(String stockName,int quantity,double price) -- throws InvalidTransactionExc(if funds are insufficient)

sell (String stockName,int quantity,double price) --- throws InvalidTransactionExc (if stock is not found)

Tester 

Register Customer details : using Scanner/dialog box
Populate Customer Collection

Display entire collection

User enter email ---- display cust dtls if found ow raise custom exc.

Remove customer details --- i/p --customer email , o/p customer removed or err msg(customer not found)

purchase stocks -- i/p ---customer email,stockName,quantity,price

sell stocks  --- i/p -- customer email,stockName,quantity,price

sort customers as per email

sort customers as per funds(separate cls --  Comparator)

sort customers as per ac nos (ano innner  cls --  Comparator)

NOTE
About searching in List implementations -----
search methods --- contains(Object ref)
indexOf(Object ref), lastIndexOf(Object ref)
1. ref type must be same type as UDT.(same as List type)
eg --- In customer list scenario---
l1<Customer>
l1.contains(ref) ---- ref : Customer
It will auto. invoke  --  overriding equals(Object o) from UDT class.

For correct searching
1. Create overloaded constr --- having Args = prim key dtls.
2. Must override -- equals --for content equality.

Generic method syntax ---
eg  ---
public static <T extends Comparable<? super T>> void sort(List<T> list)
Meaning --- Collections.sort() will ONLY allow arg of List<T>
rules imposed on Type T --
1.T extends Comparable => T must be imple. class of Comparable i/f
2. Comparable<? super T> ==> Any Type of comparable must be T or its super -type
extends ---- fixing upper bound
super --- fixing lower bound

 2 types of ordering --- available in Java
1. Natural Ordering

Steps for Natural Ordering of UDTs
1. UDT MUST implement java.lang.Comparable<T>
T = type of object being compared.
2. UDT must implement 
public int compareTo(T o)

MUST return
<0 --- if this < o
=0 --- if this=o(content equality wise)
> 0 if this > o

3. Invoke
Collections.sort(List<T> l) --- Automatically invoke compareTo method as per modified sorting alogrithm.








Custom / external ordering of elems
Need : to be able to supply multiple sorting criteria : w/o touching Business Object(UDT class) class.
Steps
1. Create a new class : implements java.util.Comparator<T>
T : type of element to be compared.

2.Override the method
public int compare(T o1,T o2)  --- rets <0 if o1<o2,=-if o1=02 ,>0 if o1>o2
3. For List sorting 
use java.util.Collections class API
public static void sort(List<T> l1,Comparator<T> inst)
Desc --- Above method sort the elements from the specified list as per custom ordering criteria(i.e by calling compare method of the Comparator inst --- instance of class which imple Comparator)




  OR




3. Sorting of Set : as per C.O 
API : TreeSet(Comparator inst)

Important Map Implementation classes
1.HashMap<K,V> --- un-sorted & un-ordered , hash table based implementation of Map i/f --- fastest & guarantees NO duplicate keys.
Allows single null key ref & allows multiple null val refs.
Guarantees constant time performance for put & get operations.

Constructors
1. HashMap() ---creates EMPTY map with def init capacity=16 & Load factor = .75
2. HashMap(int capacity,float loadfactor) --- creates EMPTY map with specified init capa & load factor.
3 HashMap(Map<? extends K,? extends V> m) ---creates populated map(with size of m.size() no of entries) --- 
? extends K --- K or sub type
? extends V --- V or sub type

Objective 
1. Store emp data in suitable map
(start with empty map & populate the same)
HashMap<Integer,Emp> --- 



















Map based Objective 

Objective : Create AccountMap
Identify key & value type
create empty unsorted map(HashMap<K,V>) & populate the same
Disp all entries of HM ---can use only toString
disp acct ids of all accounts ---impossible directly....(will be done by Collection view of map @ the end)
get acct summary --- i/p --id o/p --- err / dtls
apply interest (half yrly) on all saving a/cs
Withdraw --- specify  Account id & Amt  ---- o/p : update acct dtls if acct exists o.w err msg or exc
Sort the map as per : asc order of  accts Ids.
Sort the map as per : desc order of accts Ids
Sort the accts as per : any other criteria(eg : name based sorting) ---

Sort the accts as per bal








 difficult directly ---so get a collection view of the map & sort the same.

Limitations on Maps 
1. Maps can be sorted ONLY as per key's criteria alone.(Natural or custom)
2. can't attach iterators/for-each OR to search a map based on non-key based criteria -- more time consuming 


To fix --- get a collection view of a map (i.e convert map to collection)

API of Map i/f

1. To get set of keys asso. with a Map
Set<K> keySet();
2. To get collection of values from a map
Collection<V> values();
3. To get set of Entries(key & val pair) ---
Set<Map.Entry> entrySet()

IMP Note regarding Comparable & Comparator
Ensure that compareTo or compare definitions are always consistent with its equals method
eg --- ref is of type Emp/Cust/P.O......any Business obj.
if ref1.equals(ref2) is true 
then ref1.compareTo(ref2) MUST ret 0
& if c is Comparator inst , then c.compare(ref1,ref2) must be 0.
Otherwise typically in case of TreeSet & TreeMap strange behaviour is observed.






  


