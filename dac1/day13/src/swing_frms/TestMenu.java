/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * Add Text by 1. Create Jlabel 2. add it to the cont. using its layout
 * mgr. 3. make the cont. visible
 */

package swing_frms;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class TestMenu extends JFrame implements ActionListener{
    JTextArea disp;
   
    public TestMenu(String s) {
        //set title : via super class constr.
        super(s);
        JMenu file,edit;
        JMenuBar bar;

        //setting size in pixels
        setSize(400,400);
        setLocationRelativeTo(null);
        
        file=new JMenu("File");
        JMenuItem m11=new JMenuItem("Open",'O');
        m11.addActionListener(this);
        JMenuItem m12=new JMenuItem("Exit",'E');
        m12.addActionListener(this);
        file.add(m11);
        file.add(m12);
        edit=new JMenu("Edit");
        JMenuItem m21=new JMenuItem("Cut",'c');
        m21.addActionListener(this);
        JMenuItem m22=new JMenuItem("Paste",'p');
        m22.addActionListener(this);
        edit.add(m21);
        edit.add(m22);
        bar=new JMenuBar();
        bar.add(file);
        bar.add(edit);
        setJMenuBar(bar);
        disp=new JTextArea(10,50);
        disp.setFont(new Font("verdana",Font.BOLD,20));
        disp.setBackground(Color.CYAN);
        //to add the scroll ar to TA
        JScrollPane jsp=new JScrollPane(disp);
        //add JSP to container.
        add(jsp);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //last : make the frm visible.
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit"))
            System.exit(0);
        disp.setText("U pressed "+e.getActionCommand());
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //to set frm decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        new TestMenu("Hello from Swing");
    }

}
