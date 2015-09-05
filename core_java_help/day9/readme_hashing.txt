Regarding Hashing based Data structures....(eg : HashSet,HashTable,HashMap,LiknkedHasSet...)
Steps for Creating HashSet of User defined Type OR HashMap 

1. Business Object class(for HashSet) or Key class in Map world must override : hashCode & equals method both
public int hashCode() --- Object class rets int : which represents internal  addr where obj is sitting on the heap(typically -- specific to JVM internals)
public boolean equals(Object ref) -- Object class rets true : iff 2 refs are referring to the same copy.

2. Rule to observe while overriding these methods 
If 2 refs are equal via equals method then their hashCode values must be same.
eg : If ref1.equals(ref2) ---> true then ref1.hashCode() = ref2.hashCode()
Converse may not be mandatory.(i.e if ref1.equals(ref2) = false then its not mandatory that ref1.hashCode() != ref2.hashCode() : but recommended for better working of hashing based D.S)


Thumb rule -- Use same members (private data members) for overriding equals & hashCode methods 

How does hashing based data structure ensure constant time performance?

If no of entries > capacity * load factor --- re-hashing takes place ---
New data structore is created --(hashtable) -- with approx double the original capacity --- HM takes all earlier entries from orig map & places them in newly created D.S -- using hashCode & equals. -- ensures lesser hash collisions.











