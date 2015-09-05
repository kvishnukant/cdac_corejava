I/O handling

Desc of FileInputStream --- java.io.FileInputStream 
bin i/p stream connected to file device(bin/char) -- to read data.

Desc of FileOutputStream --- java.io.FileOutputStream 
bin o/p stream connected to file device(bin/char) -- to write data.

Desc of FileReader--- java.io.FileReader
char i/p stream connected to file device(char) -- to read data.

Desc of FileWriter--- java.io.FileWriter
char o/p stream connected to file device(char) -- to write data.

Objective --- Read data from text file in buffered manner  --- with appropriate exc handling & closing of non-java resources.

1. java.io.FileReader(String fileName) throws FileNotFoundException
--- Stream class to represent unbuffered char data reading from a text file.
Has methods -- to read data using char/char[]


2. Improved version -- Buffered data read .
For char oriented streams--- java.io.BufferedReader(Reader r)

API --- 
String readLine() --- reads data from a buffer -- & rets null at end of Stream condition.

Objective -- Replace JDK 1.6 try-catch-finally BY JDK 1.7 try-with-resources syntax.
Meaning --- From Java SE 7 onwards --- Introduced java.lang.AutoCloseable -- i/f
It represents --- resources that must be closed -- when no longer required.
i/f method
public void close() -- closing resources.
java.io --- classes -- have implemented this i/f -- to auto close resource when no longer required.


Objective ---To confirm device independence of Java I/O --- replace File device by Console
i.e --- Read data from console i/p --- in buffered manner till 'stop'  & echo back it on the console.


required stream classes --- BR(ISR(System.in))
Alternative is --- use Scanner class.
Advantage  of Scanner over above chain ----- contains ready-made parsing methods(eg --- nextInt,nextDouble.....)
But Scanner is not Buffered Stream
Can combine both approaches.(new Scanner(br.readLine())

Objective --- Combine scanner & buffered reader api --- to avail buffering + parsing api. --- to do




Overloaded constructor of FileReader(File f)
java.io.File ---- class represents path to file / folder 
File (String path) --- 
File class API --- boolean exists(),boolean isFile() , boolean canRead()




Objective --- Text File copy operation --- in buffered manner.

For writing data to text file using Buffered streams

WHY PrintWriter?
1. Provides buffering
2. supplies auto-flushing capacity.
3. Can wrap ANY bin o/p stream as well as char o/p stream
4. API --- print,println,printf(same API as PrintStream)

java.io.PrintWriter --- char oriented buffered o/p stream --- which can wrap any device.(Binary o/p stream or Char o/p stream)
Constructors---
1.PrintWriter(Writer w) --- wraps char o/p stream & supplies buffer, no auto flushing.

2. PrintWriter(Writer w, boolean flushOnNewLine)---wraps  char o/p stream , supplies buffer, automatically flushes buffer contents on to the writer stream --upon new line
 
PrintWriter(OutputStream  w) --- can wrap bin o/p stream
PrintWriter(OutputStream w , boolean flushOnNewLine) --- 

API Methods----print/println/printf same as in PrintStream class(same type as System.out)


Stream class which represents --- Char o/p stream connected to Text file. --- java.io.FileWriter
Constructor
FileWriter(String fileName) throws IOException -- new file will be created & data will be written in char format.
FileWriter(String fileName,boolean append) --- if append is true , data will be appended to existing text file.

Regarding java.io.File -----
Does not follow stream class hierarchy, extends Object directly.
File class --- represents abstract path which can refer to file or folder.
Usage --- 1. To access/check file/folder attributes(exists,file or folder,read/w/exec permisssions,path,parent folder,create new empty file,create tmp files & delete them auto upon termination,mkdir,mkdirs,rename,move,size,last modified ,if folder---list entries from folder,filter entries)
Constructor --- 
File (String path) --- 
eg --- File f1=new File("abc.dat");
if (f1.exists() && f1.isFile() && f1.canRead())
...attach FIS

Objective ---
Create suitable collection of Employees(HashMap) --- sort map as per emp id & store sorted emp dtls as per id in  1 text file(Buffered manner) . Sort Emps as doj & store sorted dtls in another file . Before exiting ensure closing of data strms .

Emp -- id,nm,sal,joinDate
StoreInfo 
empty HM<I,Emp>
populate it ....
sorted emp dtls as per id
TM<I,E> tm=new TM<>(hm);
//store dtls
PW pw=new PW(new FW(....),...);
Coll<V> c=tm.values();
for(Emp e : c)
pw.println(e)

HM / TM ---->  Collection<V>  -- coll
//sort emps as per doj
Collection<V> coll=tm.values();
LinkedList<V> l1=new LinkedList<>(coll);
Collections.sort(l1,new Comp()....{
 compare --- 
});
//itr -- for each ---









Objective -- Restore collection of emps created in above requirement --- store it in form HashMap .  -- 
i/p --- text data file -- buffered read
JA --- BR - FR---Text File
File f1=new File(....);
if (f1.exists() && f1.isFile() && f1.canRead())
  BR br=new BR(new FR(filename)); ---   
  while(...s)
{
     sc=new Scanner(s);
hm.put(id,new Emp(.....);
}  
method -- rets HM  (empty or filled)                                  


Objective --- using Binary file streams.
Classes --- FileInputStream -- unbuffered bin i/p stream connected to bin file device.
FileOutputStream --unbuffered bin o/p stream connected to bin file device.

But these classes --- have only read() write() methods in units of bytes/byte[]

Important read methods of InputStream
 (inherited by  FileInputStream)
1. public int read() throws IOException
--- Tries to read 1 byte from the underlying stream --- converts it into int & rets to caller. Rets -1 @ End of stream condition.
No data -- method blocks.
eg -- int data=System.in.read();

2. public int read(byte[] bytes) throws IOException
-- Tries to read bytes from the stream , rets actual no of bytes read from the stream , max no limited by array size.
eg ---
byte[] buf=new byte[100];
int num = System.in.read(buf);
What will happen if 
1 no data --- BLOCK
2. 10 bytes  -- num=10,buf[0].....buf[9]
3. 110 bytes --- num=100, buf[0]----buf[99], pending 10 bytes on the stream.

3. public int read(byte[] bytes,int offset,int maxBytes) throws IOException
-- Tries to read maxBytes from the stream , rets actual no of bytes read from the stream , max no limited by array size. & data will stroed from offset --- offset+maxBytes-1
eg ---
byte[] buf=new byte[100];
int num = System.in.read(buf,12,15);
What will happen if 
1 no data --- BLOCK
2. 10 bytes  -- num=10, data --- buf[12]-----buf[21]
3. 110 bytes --- num=15, data --- buf[12]----buf[26]

Important write() methods of OutputStream (inherited by FileOutputStream)

1. public void write(int data) throws IOException ---- writes 1 byte(least siginificant) to the underlying stream.

2. public void write(byte[] bytes) throws IOException ---- writes bytes.length  bytes to the underlying stream.

3. public void write(byte[] bytes,int offset,int maxBytes) throws IOException ---- writes maxBytes from bytes[offset]----bytes[offset+maxBytes-1] 

Objective -- Write binary data to a file (buffered manner) & read back the same in buffered manner.





Using BIS(BufferedInputStream) -- enables buffering BUT doesn't provide any advanced API. Same is true with BOS.(BufferedOutputStream)

Chain of streams in this case ---
Buffered Write to Bin file
JA  --- BufferedOutputStream ---- FileOutputStream ---  Bin File

Disadvantage --- Appln data HAS to be converted into byte / byte[] by Programmer . 
Un-suitable -- since --- there exist advanced Stream classes (Mixed data streams) -- for ready made conversion.



Objective --- 
Create Customer/Account based collection. Sort if reqd.
Store Sorted collection to bin file in buffered manner -- 
& re-store the same.
Use advanced streams in such cases ---
Mixed Data streams
java.io.DataOutputStream ---implements DataOutput i/f
Constructor -- DataOutputStream (OutputStream out)
API ---
public void writeInt(int i) throws IOExc
public void writeChar(char i) throws IOExc
public void writeFloat,writeDouble.....
For Strings 
public void writeUTF(String s) throws IOExc ---uses Modified UTF 8 convention
or
public void writeChars(String s) throws IOExc --- uses UTF16 convention


Objective ---
Customer data is already stored in bin file.
Read customer data from Bin file --- in buffered manner & upload the same in HM .display customer details.

Stream class --- java.io.DataInputStream -- implements DataInput i/f.

Chain of strms
JA -- DIS --- BIS --- FIS ---Bin file

Constructor
DataInputStream(InputStream in)
API Methods
public int readInt() throws IOException
public double readDouble() throws IOException
public char readChar() throws IOException
public String readUTF() throws IOException(must be used with writeUTF)
public String readChars() throws IOException(must be used with writeChars)
Most Advanced streams ---
Binary streams which can read/write data from/to binary stream in units of Object/Collection of Object refs (i.e Data Transfer Unit = Object/Collection of Objects)

Stream Class for writing Objects to bin. stream
java.io.ObjectOutputStream implements DataOutput,ObjectOutput

Description --- ObjectOutputStream class performs serialization.
serialization= extracting state of object & converting it in binary form.

state of object = non-static & non-transient data members


Constructor 
ObjectOutputStream(OutputStream out) 
out--- dest Binary o/p stream  --- where extracted bin state info has to be sent.
Objective -- To store collection (map/set/list) of emps on bin file --using serializer.
JA ---OOS   ---- FOS ---Bin file 

OR 
 To upload collection (map/set/list) of emps on server --using serializer.
JA --OOS ---SOS --- socket....
OR 
 To sendcollection (map/set/list) of emps to other concurrently running thrd  --using serializer.
JA --- OOS --- POS --- pipe

API methods ---
public void writeInt(int i) throws IOExc
public void writeChar(char i) throws IOExc
public void writeFloat,writeDouble.....
For Strings 
public void writeUTF(String s) throws IOExc ---uses Modified UTF 8 convention
public void writeObject(Object o) throws IOException --- declared on ObjectOutput i/f


De-serialization---- conversion or re-construction of Java objs from bin stream.
java.io.ObjectInputStream  --- performs de-serialization.
Constructor --- ObjectInputStream(InputStream in) 
API methods ---
readInt,readShort,readUTF,readChars..... +
public Object readObject() throws IOException

Objective --- attach OIS to the bin file using FIS & display customer data.




















































