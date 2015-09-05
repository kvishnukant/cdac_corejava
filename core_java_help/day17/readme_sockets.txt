Pre-requisite : Visit & understand TCP-IP primer.

API : java.net Pkg

Any error in networking is represented by java.net.SocketException or IOException/ConnectExc./EOFExc


1. Server side steps
1.1
Create a server socket instance. (Control socket)
API : java.net.ServerSocket
Constructor 
1.ServerSocket(int portNo) throws IOExc
portNO : 1024 onwards : local port No.
Def. backlog = 50.(backlog ---> max concurrent no of clnt  side cn establishment requests--- total no of rqs

2. ServerSocket(int portNo,int backlog) throws IOExc
Desc : SS represents the port used for the purpose of the con. establishment.
When the con. is established bet clnt & server , TCP server side process will auto. route the data traffic to newly created data socket.

1.2 Place SS in 'wait for clnt req' mode.
API : ServerSocket has a blocking method :
public Socket accept() throws IOExc.
Above method will be blocked till : valid conn. establishment with the clnt occurs.
It will raise IOExc : if cn. establishment fails.
If cn estblshment succeeds : 
Ret Type : Socket : representing Data socket : to be used for data xfer bet. clnt & server.
Cn is established


1.3 
Attach suitable data streams.
Socket class API

To read the data from a socket :
InputStream getInputStream() throws IOExc.

To write data to a socket :
OutputStream getOutputStream throws IOExc

U can't attach DIRECTLY Reader or Writer(i.e char strms) to a socket device.

1.4

As an example scenario : If u want to xfer strings in a buffered manner bet. server & clnt
: Can use PrintWriter(OutputStream out) for sending data in char. buffered manner
& can use BufferedReader or Scanner to read the data in char mode.

1.5 Upon data xfer completion from a clnt, close cn (i.e close the data socket asso. with the clnt)



1.6 When data xfer from all clnts over or while exiting from server side appln, close SS & exit.



2. Client side steps
2.1 
Establish the TCP conn. with a server by specifying the rem. Host(server host) IP addr/DNS qualified Host name & remote port no.
API : java.net.Socket(String hostName/ipAdr,int remPort) throws UnknownHostExc,IOExc,ConnectExc

If this rets : without the exc. : This marks the successful cn. establishment bet. clnt & server.

2.2
Attach suitable data streams.
Socket class API

To read the data from a socket :
InputStream getInputStream() throws IOExc.

To write data to a socket :
OutputStream getOutputStream throws IOExc

U can't attach DIRECTLY Reader or Writer(i.e char strms) to a socket device.

2.3 As an example scenario : If u want to xfer strings in a buffered manner bet. server & clnt
: Can use PrintWriter(OutputStream out) for sending data in char. buffered manner
& can use BufferedReader or Scanner to read the data in char mode.


2.4 When data xfer is complete, close socket & exit.



Objectives
1. Establish conn. bet server & clnt , create streams , exchange data(clnt says Hello Server,Server gets this & send response) & exit.

1.5 Modify above for supporting full-duplex communication.

User should see received data on console.
Open i/p dialog box to send data. press ok & receiver should get it.
If user presses cancel, stop transmission. Take it as application termination signal, so close sockets & terminate
How to ?
For actual full-duplex support , xmit operation SHOULDN't be blocked by receive.
Must create thrds for asynch working of receiver & xmitter.
transmit thread -- responsible for send data
receiver thrd --responsible for rec data
main thrd -- creates above thrd , starts them & then get blocked till both thrds are over(join -- no orphans)
Then main() should ret terminating application.

, close socket, that should auto. terminate , receiver from remote end .
Main thread should stop last.

2. Clnt -- Establish connection with server. Accept numbers from user ---  using JOptionPane.showInputDialog. After numbers ,  accept command (avg,sum,product) . Send collection of numbers , cmd to server . Wait for result , display result & exit.

Objective --- Server --- Accepts connection from the clnt. accepts collection of 
numbers & command(add/multiply)  --- performs operation & rets result to client & terminates.


2.1 Modify server only , clnt remains the same ---Prompts to user(server -side user) --- Want to service client? If yes --accepts cn from client & waits to accept data & cmd from client, upon accepting ,  computes result & sends the same to clnt. Server now should be able to support concurrent clients till --- server side user specifies end of server side appln.

Ensure that no orphan thrds are created.


2.2 
Objective --- In continuation with earlier EmpUtils -- 
Clnt.java --- GUI clnt (tcp clnt) --- in init -- connect to srvr , manipulate emp records & upon closing of the frm --send emp collection to the server & then clnt appln terminates.
Server --- sets up server side net. ---- receives collection from indi. clnts (max no of clnts) , adds the same in thrd safe manner to srvr side collection , & stores it to srvr side bin file before termination.


3. Customer care center ---Prompt for Center Name to user.
Establish cn to server .
 clnt acccepts complaint from user , creates complaint object & stores it into suitable collection -- upon 'Register Complaint' button.
When clnt closes appln  ---send center name & then  upload  collection of cust complaints to server & then exit.


Server --- accepts cn from clnts ---  center name & complaints from all centers in suitable collection , save the same in bin file.
Write a separate tester on server side to confirm uploaded contents



3. Client side --- Represents Bank Branch -- GUI frm.-- Accept Branch code 1st. Create GUI to accept Bank account details, store them in a collection,view & remove.
Upon closing frm---  clnt should send collection to srvr & then terminate.

Srvr side --- non-GUI --- create Suitable collection to store all branch details. When all clnts terminate,display branch details & terminate.


3. Clnt sends emp id to the srvr, srvr gets the details from db & sends to the clnt
(covers clnt : GUI + Networking & for srvr : net +DB)




4.clnt side : emp data insertion form. add button : for adding it to the local coll.Send button to send the data to server, where server displays rcvd emp records. (gui+coll+i/o+net)


4. single chat clnt & srvr./ muliti chat

5. Client side --- JFrame using JFileChooser & JMenu , allow user to open any file (bin or text) & upload the same on send Button to the server.

Server side --- receives uploaded content & stores the same in suitable  server side folder .

























