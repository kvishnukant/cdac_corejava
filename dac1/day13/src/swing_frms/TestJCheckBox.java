/*
 * 
 *Changes the font style of a TF , as per the selected chkbox.
 */

package swing_frms;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Administrator
 */
public class TestJCheckBox extends JFrame implements ItemListener{
    JLabel l1;
    JCheckBox[] c;
    JTextField text;
    int styles[]={Font.PLAIN,Font.BOLD,Font.ITALIC};
    public TestJCheckBox(String s) {
        //set title : via super class constr.
        super(s);
        //setting size in pixels
        setSize(400,200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);
        //ading comps.
        JPanel p1=new JPanel();
        
        c=new JCheckBox[3];
        String[] lbls={"Plain","Bold","Italic"};
        //create,attach EL,add them to a panel
        for (int i=0;i<c.length;i++)
        {
            c[i]=new JCheckBox(lbls[i]);
            c[i].addItemListener(this);
            p1.add(c[i]);
        }
        add(p1,BorderLayout.SOUTH);
        text=new JTextField("Some Sample Text");
        text.setEditable(false);
        text.setFont(new Font("Verdana",Font.PLAIN,20));
        text.setForeground(Color.red);
        add(text,BorderLayout.NORTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //last : make the frm visible.
        setVisible(true);
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        int style=Font.PLAIN;
        for (int i=1;i<c.length;i++)
            if (c[i].isSelected())
                style +=styles[i];
        System.out.println("style="+style);
        text.setFont(new Font("Verdana",style,20));

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //to set frm decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        new TestJCheckBox("Testing Fonts");
    }

}
