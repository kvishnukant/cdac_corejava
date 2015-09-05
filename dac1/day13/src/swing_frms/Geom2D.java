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
public class Geom2D extends JFrame{

    public Geom2D(String s) {
        //set title : via super class constr.
        super(s);
        //setting size in pixels
        setSize(200,200);
        setLocationRelativeTo(null);
        //to set in maximized state
       // setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setting BG color
        getContentPane().setBackground(Color.CYAN);
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
        new Geom2D("Hello from Swing");
    }
    @Override
      public void paint(Graphics g)
    {
        super.paint(g);
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
