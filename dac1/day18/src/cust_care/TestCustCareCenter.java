package cust_care;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.awt.Component;

import javax.swing.*;



public class TestCustCareCenter extends JFrame {
	private JPanel[] panels;
	private JLabel[] lbls;
	private JTextField[] tf;
	private JComboBox cities;
	private ButtonGroup bg;
	private JRadioButton[] rbtns;
	private JCheckBox[] boxes;
	private JTextArea jta;
	private JButton submit;
	private HashMap<Integer, CustomerComplaint> complaints;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestCustCareCenter();

	}

	public TestCustCareCenter() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		initGUI("Testing GUI Comps");
	}

	private void initGUI(String title) {
		setTitle(title);
		setSize(600, 400);
		setResizable(false);
		setLocationRelativeTo(null);

		String[] names = { "Name", "Email", "Addr", "OS", "Technology",
				"Complaint Desc" };
		lbls = new JLabel[names.length];
		// creating JPanels
		panels = new JPanel[names.length + 1];
		panels[0] = new JPanel(new GridLayout(1, 2, 40, 10));
		panels[1] = new JPanel(new GridLayout(1, 2, 40, 10));
		panels[2] = new JPanel(new GridLayout(1, 2, 40, 10));
		panels[3] = new JPanel(new GridLayout(1, 4, 15, 10));
		panels[4] = new JPanel(new GridLayout(1, 4, 15, 10));
		panels[5] = new JPanel(new GridLayout(1, 2, 40, 10));
		panels[6] = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Font f=new Font("Verdana",Font.BOLD,20);
		// create lbls & add the same to panel
		for (int i = 0; i < lbls.length; i++) {
			lbls[i] = new JLabel(names[i]);
			lbls[i].setFont(f);
			panels[i].add(lbls[i]);
		}
		// create TFs & add them to panel
		tf = new JTextField[2];
		for (int i = 0; i < tf.length; i++) {
			tf[i] = new JTextField(40);
			tf[i].setFont(f);
			panels[i].add(tf[i]);
		}
		// create JCB populated with cities & add the same to panel
		Vector<String> cityNames = new Vector<String>();
		cityNames.add("Pune");
		cityNames.add("Mumbai");
		cityNames.add("Chennai");

		cities = new JComboBox(cityNames);
		panels[2].add(cities);
		// create bg, radio btns,add rb to bg,add rbs to panel
		bg = new ButtonGroup();
		rbtns = new JRadioButton[3];
		String[] nms = { "Win", "Linux", "Mac" };
		for (int i = 0; i < rbtns.length; i++) {
			rbtns[i] = new JRadioButton(nms[i]);
			//MUST set ActionCommand for JRadioButton
			//
			rbtns[i].setActionCommand(nms[i].toUpperCase());
			bg.add(rbtns[i]);
			panels[3].add(rbtns[i]);
		}
		// create chkboxes & add the same to panel
		boxes = new JCheckBox[3];
		String[] aa = { "Java", ".NET", "XML" };
		for (int i = 0; i < aa.length; i++) {
			boxes[i] = new JCheckBox(aa[i]);
			panels[4].add(boxes[i]);
		}
		// create ta , attach sb, & add it to panel
		jta = new JTextArea(10, 60);
		jta.setFont(f);
		JScrollPane jsp = new JScrollPane(jta);
		panels[5].add(jsp);
		submit = new JButton("Register Complaint");

		// attach anonymous inner class for event handling
		//defines new class which implements AL
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				registerComplaint();

			}
		});
		panels[6].add(submit);
		setLayout(new GridLayout(7, 1));
		for (int i = 0; i < panels.length; i++)
			add(panels[i]);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Registered Complaints -- " + complaints);
				System.exit(0);
			}
			
		});
		setVisible(true);
		initCollection();
	}

	private void initCollection() {
		complaints = new HashMap<Integer, CustomerComplaint>();
	}

	private void registerComplaint() {
		// read user i/ps --- complaint -- store it in hm
		//from ButtonGrp, get selected Radio Button model
		//model = state of the component --- data asso. with it
		// from Button Model -- extract its action cmd 
		String os = bg.getSelection().getActionCommand();
		String city = (String) cities.getSelectedItem();
		// get info from mult selcted chkboxes -- add the same to AL
		ArrayList<String> techno = new ArrayList<String>();
		//JPanel method --- Panel[] getComponents()
		Component[] comps = panels[4].getComponents();

		for (Component c : comps) {
			if (c instanceof JCheckBox) {
				JCheckBox b = (JCheckBox) c;
				if (b.isSelected())
					techno.add(b.getText());
			}
		}
		System.out.println("desc "+jta.getText());
		CustomerComplaint c1 = new CustomerComplaint(tf[0].getText(),
				tf[1].getText(), city, os, jta.getText(), techno);
		
		JOptionPane.showMessageDialog(this,c1);
		complaints.put(c1.getId(), c1);
		clearFields();
		
	}
	private void clearFields()
	{
		for (int i = 0; i < tf.length; i++) 
			tf[i].setText("");
		bg.clearSelection();
		for (int i = 0; i <boxes.length; i++) 
			boxes[i].setSelected(false);
		jta.setText("");
	}

}
