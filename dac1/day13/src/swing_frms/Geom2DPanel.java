/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * Display a string at specified x,y coords.
 * 1. Create a class extending JPanel.
 * 2. add JPanel's instance to the Jframe
 * 3. Override public void paintComponent(Graphics g)
 * This method gets called by the GUI controller auto. for any re-painting
 * operations eg : frame's invisible -> visible transition.
 */

package swing_frms;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**

 *
 * @author Administrator
 */
public class Geom2DPanel extends JFrame{

    public Geom2DPanel(String s) {
        //set title : via super class constr.
        super(s);
        //setting size in pixels
        setSize(200,200);
        setLocationRelativeTo(null);
        //setting BG color
        getContentPane().setBackground(Color.CYAN);
        //instatiate JPanel & add the same.
        MyPanel p1=new MyPanel();
        add(p1);
        //set closing operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //last : make the frm visible.
        setVisible(true);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //to set frm decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Geom2DPanel("Hello from Swing");
    }
    //inner class def.
    class MyPanel extends JPanel
    {
        String s;
        MyPanel()
        {
            setBackground(Color.YELLOW);
            s="Text via drawString";
        }
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            //to get 2D ref
            Graphics2D g2=(Graphics2D)g;
            g2.setColor(Color.red);
            Rectangle2D rect=new Rectangle2D.Double(50, 50, 120, 120);
            g2.draw(rect);
            Ellipse2D e1=new Ellipse2D.Double();
            e1.setFrame(rect);
            g2.setColor(Color.GREEN);
            g2.fill(e1);

        }
    }

}
