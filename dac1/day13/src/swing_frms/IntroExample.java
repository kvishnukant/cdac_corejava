package swing_frms;

//  IntroExample.java
// An introduction to building menus and menu items.  Accelerators and
// mnemonics are added to various items.
//
import java.awt.event.*;

import javax.swing.*;

public class IntroExample extends JMenuBar {
//File menu items

    String[] fileItems = new String[]{"New", "Open", "Save", "Exit"};
//Edit menu items
    String[] editItems = new String[]{"Undo", "Cut", "Copy", "Paste"};
    //File menu shortcuts.
    char[] fileShortcuts = {'N', 'O', 'S', 'X'};
    //Edit menu accelarators.
    char[] editShortcuts = {'Z', 'X', 'C', 'V'};

    public IntroExample() {

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu otherMenu = new JMenu("Other");
        JMenu subMenu = new JMenu("SubMenu");
        JMenu subMenu2 = new JMenu("SubMenu2");


        ActionListener printListener = new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                System.out.println("Menu item [" + event.getActionCommand()
                        + "] was pressed.");
            }
        };
        //  Assemble the File menus with mnemonics
        // JMenuItem constructor : public JMenuItem(String text,int mnemonic)
        for (int i = 0; i < fileItems.length; i++) {
            //public JMenuItem(String text,int mnemonic)
            JMenuItem item = new JMenuItem(fileItems[i], fileShortcuts[i]);
            item.addActionListener(printListener);
            fileMenu.add(item);
        }

        //  Assemble the Edit menus with keyboard accelerators
        // JMenuItem method : public void setAccelerator(KeyStroke keyStroke)
        //static method of KeyStroke class:
        //public static KeyStroke getKeyStroke(int keyCode,int modifiers)
        for (int i = 0; i < editItems.length; i++) {
            JMenuItem item = new JMenuItem(editItems[i]);
            //to set the menu item accelarator : 
            item.setAccelerator(KeyStroke.getKeyStroke(editShortcuts[i], InputEvent.CTRL_DOWN_MASK));


            item.addActionListener(printListener);
            editMenu.add(item);
        }

        //  Insert a separator in the Edit Menu in Position 1 after "Undo"
        editMenu.insertSeparator(1);

        //  Assemble the submenus of the Other Menu
        JMenuItem item;
        subMenu2.add(item = new JMenuItem("Extra 2"));
        item.addActionListener(printListener);
        subMenu.add(item = new JMenuItem("Extra 1"));
        item.addActionListener(printListener);
        subMenu.add(subMenu2);

        //  Assemble the Other Menu itself
        otherMenu.add(subMenu);
        otherMenu.add(item = new JCheckBoxMenuItem("Check Me"));
        item.addActionListener(printListener);
        //adding a separator after "check me" menu item
        otherMenu.addSeparator();
        //ButtonGroup to add mutually exclusive items.
        ButtonGroup buttonGroup = new ButtonGroup();
        otherMenu.add(item = new JRadioButtonMenuItem("Radio 1"));
        item.addActionListener(printListener);
        buttonGroup.add(item);
        otherMenu.add(item = new JRadioButtonMenuItem("Radio 2"));
        item.addActionListener(printListener);
        buttonGroup.add(item);
        otherMenu.addSeparator();
        //       public JMenuItem(String text,Icon icon)
        otherMenu.add(item = new JMenuItem("Potted Plant", new ImageIcon("g:/images/image.gif")));
        item.addActionListener(printListener);

        //  Finally, add all the menus to the menu bar
        add(fileMenu);
        add(editMenu);
        add(otherMenu);
    }

    public static void main(String s[]) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                JFrame frame = new JFrame("Simple Menu Example");
                frame.setSize(300, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //attach the JMenuBar directly to JFrame.
                frame.setJMenuBar(new IntroExample());

                frame.setVisible(true);
            }
        });
    }
}
