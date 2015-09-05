Steps in Event delegation
1.Create Event Listener class --- By implementing Event Listener i/f from the pkg java.awt.event / javax.swing.event(eg ActionListener,MouseListener,MouseMotionListener....)
eg --- public class MyListener imple. ActionListener
2. Implement in the same class- Event listener i/f methods as per requirement
eg --- ActionListener i/f --- imple public void actionPerformed(ActionEvent e)
3.Identify event src & Register event listener with the event source
Event src=GUI component which raises events(eg -- ActionEvent raised by JButton) or Component which detects event(eg -- MouseEvent detected by the container viz JFrame/JApplet)
API -- public void addTypeListener(TypeListener inst) --- inst ----inst of the class imple. TypeListener i/f

Type --- type of the event generated.
eg --- b1.addActionListener(new MyListener());