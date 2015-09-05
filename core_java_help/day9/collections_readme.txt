Objective --- Create simple List(ArrayList) of integers & test complete API
1. ArrayList -- constructor
API 
ArrayList() -- default constructor. -- creates EMPTY array list object , with init cpapacity=10

2. add methods
boolean add(E e)
void add(int index,E e)
void addAll(Collection<E> e)

2.5 Retrieve elem from list 
E get(int index)

3. display list contents using --- toString


Attaching Iterator
Collection<E> interface method -- implemented by ArrayList
Iterator<E> iterator()
---places iterator BEFORE 1st element ref.
Iterator<E> i/f methods 
boolean hasNext() -- rets true if there exists next element, false otherwise.

E next() --- returns the element next to iterator position

void remove() -- removes last returned element from iterator.

Limitation --- type forward only

Attaching for-each  = attaching implicit iterator.

Attaching ListIterator ---scrollable iterator


4. search for a particular element in list
boolean contains(Object o)

5. searching for 1st occurrence
use -- indexOf
int indexOf(Object o)
rets index of 1st occurrence of specified elem. Rets -1 if elem not found.
searching for last occurrence 
use -- lastIndexOf
int lastIndexOf(Object o)
rets index of last occurrence of specified elem. Rets -1 if elem not found.

5.5
E set(int index,E e)
Replaces old elem at spepcified index by new elem.
Returns old elem


6. remove methods
E remove(int index) ---removes elem at specified index & returns removed elem.

boolean  remove(Object o) --- removes element specified by argument , rets true -- if elem is removed or false if elem cant be removed.

101 abc sav 3456 1-jan-2013
23 def chk 35000 23-feb-2009
34 xyz sav 12000 15-mar-2010

Sorting --- For sorting elements as per Natural(implicit i.e criteria defined within UDT class definition) ordering or Custom(explicit i.e criteria defined outside UDT , in a separate class or anonymus iner class)

Steps for Natural ordering
Natural Ordering is specified in generic i/f
java.lang.Comparable<T>
T -- UDT , class type of the object to be compared.
eg -- Emp,Account , Customer

I/f method
int compareTo(T o)
Steps 
1. UDT must implement Comparable<T>
2. Must override method
public int compareTo(T o)
{
 use sorting criteria to ret
< 0 if this < o,
=0 if this = o
> 0 if this > o

}
3.Use java.util.Collections class API
Method
public static void sort(List<T> l1)
l1 -- List of type T.

sort method internally invokes compareTo method(prog supplied) & using advanced sorting algorithm , sort the list elems.

Limitation of natural Ordering
Can supply only 1 criteria at given time & that too is embedded within UDT class definition

Alternative is Custom Ordering
I/f used is --- java.util.Comparator<T>
T -- type of object to be compared.
 
Steps
1. Create a separate class (eg. AccountBalComparator) which implements Comparator<T>
eg 
public class AccountBalComparator implements Comparator<Account>

2.Implement(override) i/f method -- to supply comparison criteria.

int compare(T o1,T o2)
Must return 

< 0 if o1<o2
=0 if o1=o2
> 0 if o1 > o2

3. Invoke Collections class method for actual sorting.

public static void sort(List<T> l1,Comparator<T> c)
parameters
l1 --- List to be sorted(since List is i/f --- any of its implementation class inst. can be passed)

c -   instance of the class which has implemented compare method.

Internally sort method invokes compare method from the supplied Comparator class instance.


Map API

Objective : Create AccountMap
Identify key & value type
create empty unsorted map(HashMap<K,V>) & populate the same
Disp all entries of HM ---can use only toString
get acct summary --- i/p --id o/p --- err / dtls
Withdraw --- specify  Account id & Amt  ---- o/p : update acct dtls if acct exists o.w err msg or exc
remove --- id

Attach for-each to map & observe.
Sort the map as per : asc order of  accts Ids.
Sort the map as per : desc order of accts Ids
Sort the accts as per : any other criteria(eg : balance based sorting) ---


 Regarding generic syntax & its usage in TreeMap constructor.
<? super K>
? --- wild card --- any type
super --- gives lower bound
K --- key type
? super K --- Any type which is either K or its super type.

TreeMap(Comparator<? super K> c)  --- creates new empty TreeMap, which will sort its element as per custom ordering(i.e will invoke compare(...) of Key type )


<? extends K>
? -- any type or wild card
extends -- specifies upper bound 
K -- key type
? extends K --- Any type as Key type or its sub type.

same meaning for <? extends V>
TreeMap(Map<? extends K,? extends V> m)









disp acct ids of all accounts ---impossible directly....(will be done by Collection view of map @ the end)
Apply interest to all saving type a/cs

 difficult directly ---so get a collection view of the map & sort the same.

Limitations on Maps 
1. Maps can be sorted as per key's criteria alone.
2. can't attach iterators/for-each


To fix --- get a collection view of a map (i.e convert map to collection)

API of Map i/f

1. To get set of keys associated with a Map
Set<K> keySet(); --- returns Set of Keys(refs)
2. To get collection of values from a map
Collection<V> values(); --- rets collection of values(ref)
3. To get set of Entries(key & val pair) ---
Set<Map.Entry<K,V>> entrySet() --- returns set of entries













7. conversion from collection to array
Object[] toArray() -- non generic version --- rets array of objects

T[] toArray(T[] type)
T = type of collection .
Rets array of actual type.




8. sorting lists --- Natural ordering creiteria
Using java.util.Collections --- collection utility class.
static void sort(List<E> l1) ---sorts specified list as per natural sorting criteria. 
