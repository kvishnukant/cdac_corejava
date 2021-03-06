I/O handling

Desc of FileInputStream --- java.io.FileInputStream 
bin i/p stream connected to file device(bin/char) -- to read data.

Desc of FileOutputStream --- java.io.FileOutputStream 
bin o/p stream connected to file device(bin/char) -- to write data.

Desc of FileReader--- java.io.FileReader
char i/p stream connected to file device(char) -- to read data.

Desc of FileWriter--- java.io.FileWriter
char o/p stream connected to file device(char) -- to write data.

Objective --- Read data from text file in buffered manner.

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
Adv. of Scanner over above chain ----- contains ready-made parsing methods(eg --- nextInt,nextDouble.....)
But Scanner is not Buffered Stream
Can combine both approaches.(new Scanner(br.readLine())

Objective --- Combine scanner & buffered reader api --- to avail buffering + parsing api. --- to do




Overloaded constructor of FileReader(File f)
java.io.File ---- class represents path to file / folder 
File (String path) --- 
File class API --- boolean exists(),boolean isFile() , boolean canRead()




Objective --- File copy operation --- in buffered manner.

For writing data to text file using Buffered streams

java.io.PrintWriter --- char oriented buffered o/p stream --- which can wrap any device.(Binary o/p stream or Char o/p stream)
Constructors---
PrintWriter(Writer w) --- 
PrintWriter(Writer w, boolean flushOnNewLine)--- automatically flush buffer contents on to the writer stream --upon new line 
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
Create suitable collection of Employees(ArrayList) --- sort list as per emp id & store sorted emp dtls as per id in  1 text file . Sort Emps as doj & store sorted dtls in another file . Before exiting ensure closing of data strms .


Objective -- Restore collection of emps created in above requirement --- store it in form HashMap .  -- buffering not essential


Objective --- using Binary file streams.
Classes --- FileInputStream -- unbuffered bin i/p stream connected to bin file device.
FileOutputStream --unbuffered bin o/p stream connected to bin file device.

But these classes --- have only read() write() methods in units of bytes/byte[]

Using BIS(BufferedInputStream) -- enables buffering BUT doesn't provide any advanced API. Same is true with BOS.(BufferedOutputStream)

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

Stream class --- java.io.DataInputStream -- implements DataInput

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

out--- dest Binary o/p stream  --- where bin stream has to be sent.
API methods ---
public void writeInt(int i) throws IOExc
public void writeChar(char i) throws IOExc
public void writeFloat,writeDouble.....
For Strings 
public void writeUTF(String s) throws IOExc ---uses Modified UTF 8 convention

public void writeObject(Object o) throws IOException



De-serialization---- conversion or re-construction of Java objs from bin stream.
java.io.ObjectInputStream  --- performs de-serialization.
Constructor --- ObjectInputStream(InputStream in) 
API methods ---
readInt,readShort,readUTF,readChars..... +
public Object readObject() throws IOException

Objective --- attach OIS to the bin file using FIS & display customer data.




















































