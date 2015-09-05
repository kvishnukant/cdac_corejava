Need -- In the absence of Object streams, if u want to persist(save in permanent manner) state of objects or application data in binary manner --- prog has to convert all data to binary & then only it can be written to streams.

Object streams supply ready made functionality for the same.

Serialization/De-serialization

Ability to write or read  a Java object to/from  a binary stream

Supported since JDK 1.1

Saving an object to persistent storage(current example -- bin file later can be replaced by DB or sockets) is called persistence

Java provides a java.io.Serializable interface for checking serializability of java classes.




Meaning --- At the time of serialization(writeObject) or de-serialization(readObject) --- JVM checks if the concerned object is Serializable(i.e has it implemented Serializable i/f ? ) --if yes then only proceeds , otherwise throws Exception ---java.io.NotSerializableException

Serializable has no methods and is a marker interface. Its role is to provide a run time marker for serialization.

Details 
What actually gets serialized?
When an object is serialized, only state of the object(=non-static & non-transient data members)  are preserved.
Details about serialized bin stream 
Magic code(specific to JVM) --- sequence no (serial no) -- class descriptor(F.Q class Name & data members structure + Serial version UID) --- State info(consisting of values of data members).......
eg ---out.writeObject(hm)
HM -- seq no d.m --- Integer -- seq no --vals --- Emp 



If a data variable(data member)  is an object(ref) , data members of the object are also serialized if that object’s class is serializable

out.writeObject(e);

e --- emp --- id,nm,sal,joinDate,adr(Address --- city,country,zipCode)

The tree of object’s data, including these sub-objects constitutes an object graph
eg  -- out.writeObject(hm);

HM ---S -- Key -- Integer --Value -- Emp --id,nm,sal,date,adr---city,co,zipcode...

If a serializable object contains reference to non-serializable element, the entire serialization fails

If the object graph contains a non-serializable object reference, the object can still be serialized if the non-serializable reference is marked “transient”

Details --- transient is a keyword in java.
Can be applied to data member.
transient implies ---skip from serialization.(meant for JVM)
---------------------------------------





If super-class is serializable, then sub-class is automatically serializable.

If super-class is NOT serializable --- sub-class developer has to explicitely write the state of super-class.

What happens during deserialization?

When an object is deserialized, the JVM tries to bring the object back to life by making a new object on the heap that has the same state the serialized object had at the time it was serialized. 
The transient or static  variables, which come back have either null (for object references) or as default
primitive values. Constructor does not get called.

What are pre-requisites for de-serialization?
.class file for Class Obj to be de-serialized + Bin data stream containing state.

What is serialversion UID?
Each time an object is serialized,  the object (including every object in its graph) is 'stamped' with a version ID number for the object's class. The ID is called the serialVersionUlD, and it's computed based on information about the class structure. As an object is being deserialized, if the class has changed since the object was serialized, the class could have a different serialVersionUID, and deserialization will fail.  But you can control this - by adding your own UID.





