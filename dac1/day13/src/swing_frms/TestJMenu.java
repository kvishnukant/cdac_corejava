/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package swing_frms;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class TestJMenu extends JFrame implements ActionListener{
    JMenuItem m11,m12;
    JFileChooser fc;
    JTextArea ta;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        new TestJMenu("Welcome to Swing GUI");
    }
    TestJMenu(String title)
    {
        super(title);
        setSize(200,200);
        JMenu m1=new JMenu("File");
        m11=new JMenuItem("Open",'O');
        m11.addActionListener(this);
        m12=new JMenuItem("Exit",'E');
        m12.addActionListener(this);
        m1.add(m11);
        m1.add(m12);

        JMenu m2=new JMenu("Edit");
        JMenuItem m21=new JMenuItem("Cut",'C');
        m21.addActionListener(this);
        JMenuItem m22=new JMenuItem("Paste",'P');
        m22.addActionListener(this);
        m2.add(m21);
        m2.add(m22);
        JMenuBar mb=new JMenuBar();
        mb.add(m1);
        mb.add(m2);
        setJMenuBar(mb);
        fc=new JFileChooser();
        ta=new JTextArea();
        ta.setEditable(false);
        JScrollPane jsp=new JScrollPane(ta);
        add(jsp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == m11)
    {
        int ret=fc.showOpenDialog(this);
                if (ret == JFileChooser.APPROVE_OPTION) {
                    try {
                    File f1=fc.getSelectedFile();
                    Scanner sc=new Scanner(f1);
                    while (sc.hasNextLine())
                        ta.append(sc.nextLine()+"\n\r");
                    sc.close();
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }

                }

        return;
    }
    if (e.getSource() == m12)
    {
       System.exit(0);
    }
        System.out.println("MenuItem : " +e.getActionCommand());
    }


}
