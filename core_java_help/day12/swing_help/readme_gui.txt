Objective -- Creating swing based application
1. How to create JLabel ?
Constr -- JLabel(String text,Icon i,int horizontalAlignment)
1.5 
How to set fonts of GUI comps?
java.awt.Font(String name,int style,int size)
Method inherited from Coponent class 
public void setFont(Font f)

2. How to create buttons?
 JButton --- push-button implementation.
constructor--- public JButton(String text,Icon icon)
API methods ---- getText,setText,getIcon,setIcon

3. Regarding placement of Components
Placement can be done in absolute manner or by using exisitng or custom layout managers.

For absolute placements
Component class API
public void setBounds(int x,int y, int width,int height)
But not recommended --- 
Alternative is -- use Layout Managers.
java.awt.LayoutManager --- i/f
Implemented by classes  ---FlowLayout , BorderLayout,GridLayout,GridBagLayout,CardLayout,SpringLayout,BoxLayout.....
FlowLayout --- Places the components from top left corner --- row wise. -- def layout mgr for Applet,Panel & JPanel
public FlowLayout(int align,int hgap,int vgap)

BorderLayout -- Places the components along borders(NORTH,SOUTH,WEST,EAST) & default region = CENTER
def layout mgr -- Frame,JFrame , JApplet
public BorderLayout(int hgap,int vgap)

GridLayout --- Divides container into equal sized grids.
public GridLayout(int rows,int cols,int hgap,int vgap)

How to change def layout manager?
Method inherited from Container
public void setLayout(LayoutManager mgr)

How to mix/combine different layout managers to suit look of the application/applet?
Can be done easily using JPanel or in complex manner using GridbagLayout.
Via JPanel
1. Create empty JPanel -- (def layout mgr = FlowLayout) -- either using def or supply required mgr.
JPanel() -- Flow Layout
JPanel(LayoutManager mgr)
2. Add components to the JPanel
3. Add populated JPanel to JFrame or JApplet -- in suitable region.


Regarding Event handling flow
Any external action takes place (mouse click,key press,btn click,check box selection changes,window closing,list selection changes.....) ---- JVM (EDT --event dispatcher thrd) ---creates instance of matching Event class (java.awt.event OR javax.swing.event) ---- EDT chks --- any registered event handler exists (i.e is event source -- JButton,JFrame,JCheckBox... registered or attached with any event listener --- i/f ) --- NO ---event is ignored.
Yes --- EDT invokes event handling logic(mouseClicked,keyPressed....) --- upon returning --- EDT isfree again to respond to further events OR to invoking painting realted methods(eg -- public void paint(Graphics g) , public void paintComponent(Graphics g))

Golden prog rules swing programming
1. Never delay or block EDT --- by writing longer event handling logic or painting logic. If required (for time consuming tasks) ,create your  own thrds & DO NOT burden system thrds.

2. Pending....
Event Handling based upon Event Delegation Model 
Event source --- Fires events --- delegates event handling to a separate listener or listeners(broadcasting)

Steps in Event delegation
1.Create Event Listener class --- By implementing Event Listener i/f from the pkg java.awt.event / javax.swing.event(eg ActionListener,MouseListener,MouseMotionListener....)
eg --- public class MyListener imple. ActionListener
2. Implement in the same class- Event listener i/f methods as per requirement
eg --- ActionListener i/f --- imple public void actionPerformed(ActionEvent e)
3.Identify event src & Register event listener cls instance with the event source.
Event src=GUI component which raises events(eg -- ActionEvent raised by JButton) or Component which detects event(eg -- MouseEvent detected by the container viz JFrame/JApplet)
API -- public void addTypeListener(TypeListener inst) --- inst ----inst of the class imple. TypeListener i/f

Type --- type of the event generated.
eg --- b1.addActionListener(new MyListener());


Need of Adapter classes---
In the absence of adapter classes, prog has to implement even un-necessary methods in the listener implementation class.

What is adapter class ?
=abstract class implementing (blank/empty) listener i/f methods.
eg --- MouseAdapter or MouseMotionAdapter

eg --- WindowAdapter imple. WindowListener & provides empty imple. for all listener i/f methods--- so that prog can extend this adpater class & override methods of interest only.(eg ---windowClosing)


Objective : Using MouseAdapter.

For random no generation---
java.util.Random
1.Random() --- creates random no generator.
2. nextInt,nextBoolean,nextFloat...,int nextInt(int limit)

Color class constructor 
Color (int r,int g,int b)

Painting sequence in swing components
EDT will automatically invoke painting related methods --- triggers---
invisible --> visible transition or resizing of the components OR user requesting refresh (repaint --- req for painting)
Component class API
public void paint(Graphics g)
Graphics --- java.awt.Graphics --- abstract super class --- sub-classed by Graphics2D , Graphics3D.....

API 
public void fillOval(int x,int y,int width,int height)

repaint --- paintComponent ---paintBorder---paintChildren

Use JPanel --- to create custom panel & override  --
public void paintComponet(Graphics g) --- for any drawing or painting operations.  




























1. Understand ActionListener
2. set default look & feel decorated. -- for JFrame.
3. How will AWT Frame exit upon window closing event?
Need of Adapter classes---
In the absence of adapter classes, prog has to implement even un-necessary methods in the listener class.

What is adapter class ?
=abstract class implementing (blank/empty) listener i/f methods.
eg --- MouseAdapter or MouseMotionAdapter

eg --- WindowAdapter imple. WindowListener & provides empty imple. for all listener i/f methods--- so that prog can extend this adpater class & override methods of interest only.(eg ---windowClosing)

4
For textfield & password field
LoginForm --- Email & password , JTA --- displaying user details or error mesg.

4.Create User Form having basic swing components , accept user details & display the same using pop-up dialog box.
--- 
1. Readymade Pop-up dialog Boxes

javax.swing.JOptionPane
1.  Mesg dialog box ---public static void showMessageDialog(Component parent,Object msg)
2. I/p dialog box --- public static String  showInputDialog(Component parent,Object msg)(rets null if cancel is pressed)

2. Basic Swing GUI components

JLabel -- public JLabel(String text,Icon icon,int horizontalAlignment)

API -- methods -- getText(),setText(...),setIcon(...)

3. JButton --- push-button implementation.
constructor--- public JButton(String text,Icon icon)
API methods ---- getText,setText,getIcon,setIcon

4. JCheckBox
public JCheckBox(String text,Icon icon,boolean selected)
public boolean isSelected()
 -- can imple. ItemListener & ActionListener.

For ItemListener
public void itemStateChanged(ItemEvent ie)

For ActionListener ---
If u want to get all choices selected by user -- via multiple use instead --- 
l1 -- ArrayList<String>
If they are in a panel --- p.getComponents() ---
for (Component c : comps)
{
JCheckBox c1=(JCB) c);
if (c1.isSelected() )
l1.add(c1.getText());
}

5. JRadioButton
Constructor -- JradioButton(String text,Icon img,boolean selected)
Imp API methods --- 
isSelected(),setSelected(),setText,getText,setIcon,getIcon



Use ButtonGroup  -- for mutually exclusive radio buttons.
Steps --- 1. Create ButtonGroup inst.--- ButtonGroup()
2. Create JRadioButtons.  --- NOTE --- must use setActionCommand(String lable) --- to set the action cmd for the JRadioButton. (in case of ActionListener only , not needed in ItemListener)
3. Add JRadioButtons to the Button grp. --- using BG's add()
eg -- bg.add(r1);
4. Add individually RadioBtns to the Panel/Frame.
eg -- p1.add(r1);p1.add(r2)......


How To get label of selected Radio Button
API -- 
 bg.getSelection().getActionCommand();(prior to this must setActionCommand)




JTextField -- constructors
API --- getText,setText,setEditable(boolean flag)
supports ActionEvent & TextEvent
JPasswordField ---
Method 
char[]  getPassword ---convert it to String
supports ActionEvent

JTextArea
Constructor
public JTextArea(String text,int rows,int columns)
supports TextEvent
How to make JTextArea scrollable ?
1. Create inst of JScrollPane(Component c) --- c componet for scrolling.
eg -- JScrollPane jsp=new JScrollPane(jta);
2. Add JSP to the container.
eg -- add(jsp); --- adds scrollable JTA to the center region of the frm.


Handling JList --- to display list Items
class --- javax.swing.JList<E>
E -- type of the element in the list
Constructors
1. JList() --- empty list
2.JList (E[] elems) -- populates JList with array of specified elements.
3. JList(Vector<? extends E> v)  --- populates JList with vector of specified elements.

Imp API 
1. public void setSelectionMode(int mode)
2. public void setVisibleRowCount(int count)
3. int getSelectedIndex()
4. int[] getSelectedIndexes()

How to attach scroll bars to any JComponent?
1.JScrollPane(Component c) --- c--component to be scrolled.
eg --- add(new JScrollPane(l1));




JCombobox<E> --- combination of TextField & drop-down list.
By default --- uneditable.

Constructors  ---
JComboBox(E[] elems), JComboBox(Vector<? extends E> elems)

API ---methods 
Object getSelectedItem ---rets selected item.
getSelectedIndex() -- rets index of selected item.

By default -- uneditable.
Can make it editable --- by 
For Handling JComboBox --- setEditable(true)
addItem(E o) -- adds elem at the  end.
,insertItemAt(E o,int index),removeItem
getItemAt(int index),int getItemCount(),


Can attach ActionListener.
The listener's actionPerformed method is called when the user selects an item from the combo box's menu or in an editable combo box, when the user presses Enter. 

Can attach ItemListener
The listener's itemStateChanged method is called when the selection state of any of the combo box's items change. 

Regarding Applet/JApplet
Have same life-cycle.
1.Life-cycle of the Applet/JApplet

1.1 JVM will create 3 thrds --- applet's main thrd -- for invoking applet's life cycle meths, EDT -- for paint(g), event handling methods & GC  -- daemon(bg) thrd.
1.2  Applet's main thrd --- invokes 
public void init()
---will be invoked once per applet life-cycle--- after class loading & inst.
--- prog jobs --- one time jobs viz . -- create GUI comps, attach event listeners,place the comps.
1.3 Applet's main thrd --- invokes 
public void start() ---
--- will be invoked after init, every time client re-visits applet containing page.
--- prog uses this --- to create/strt thrds.
1.4 EDT invokes --
public void paint(Graphics g)
g--- Graphical console ref. 
java.awt.Graphics class --contains methods for draw/paint operations.
--- EDT invokes paint --- 1. init--start---paint
2. any invisible ---> visible transtion of applet .

1.5 Applet's main thrd --- invokes 
public void stop()
-- will be invoked when user leaves applet conaining page(eg -- via a link or minimize)
prog jobs-- stop user defined thrds if any.

1.6 Applet's main thrd --- invokes 
public void destroy()
--- will be invoked only once -- before garbage collecting applet inst.
--- prog job-- clean up of non-java resources.

Create Swing Applet by extending JApplet --- to test life cycle of the applet.
2. Create HTML page to embed applet content


3. Launch the same applet via IDE


2.GeomApplet
3. Un-trustedness of Applet(GeomApplet2) --- 
3.1 Run JApplet from IDE. -- no run time errs
3.2 Create HTML --- test it on external browser. -- access denied exc when applet tried to access data file from outside bin folder.

How to specify to appletviewer the loc of policy file?
appletviewer -J-Djava.security.policy="g:\new_policy" test.html

3.3 If Datafile to read is from codebase or document base --- observe. -- no run time errs again
WHY ? --- Applet can access directly any content from its docBase or codebase.


3.4 If file not from code base or docbase observe what happens
--- run time err --- access denied ---  create security policy file using policytool(to be saved under homedir with name as .java.policy  & grant required permissions.)


Creating Menus
JMenuBar,JMenu,JMenuItem,JCheckBoxMenuItem,JRadioButtonMenuItem

Steps 
1. Create JMenu empty instance.
JMenu
2.Create instances of JMenuItem belonging to a menu.
3.Add menuItems to the menu 
public void add(JMenuItem menuItem)
4. Repeat step 1...3 for all menus.
5. Create JMenuBar using def. constr
& add it to the container(JFrame/JApplet) using setJMenuBar(JMneuBar inst) method.
Event handling 
MenuItems when clicked : fire ActionEvent.

Examples ---day16/src/menus
TestMenu.java --- basic introduction to Menu api
IntroExample.java --- submenus,short-cuts,accelarators,different types of menu-items
TestJMenu.java -- File chooser--- menu + file chooser

Regarding simple date formatting

SDF -- java.text.SimpleDateFormat

1. String to Date conversion(parse method of SDF)
2. Date to String conversion (format method of SDF)

Commonly used Formats available ---
"dd MMMMM yyyy"
"dd.MM.yy"
"MM/dd/yy"
yyyy-MM-dd

Time Formats 

"h:mm a" -- am/pm format(12 Hr clock)
"H:mm:ss:SSS" -- with msec
hh:mm:ss a,z -- 12 hr with timezone
hh:mm:ss z  -- 24 Hr with timezone


Time stamp(Date & Time both)
dd/mm/yyyy hh:mm:ss z

JDialog
paint(Graphics g)
Thrds in swing
Applet programming.




