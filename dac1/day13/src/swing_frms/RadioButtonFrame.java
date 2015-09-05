package swing_frms;

// Creating radio buttons using ButtonGroup and JRadioButton.
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame {
	private static final int FONT_SIZE = 20;
	private JTextField textField; // used to display font changes
	private Font plainFont; // font for plain text
	private Font boldFont; // font for bold text
	private Font italicFont; // font for italic text
	private Font boldItalicFont; // font for bold and italic text
	private JRadioButton plainJRadioButton; // selects plain text
	private JRadioButton boldJRadioButton; // selects bold text
	private JRadioButton italicJRadioButton; // selects italic text
	private JRadioButton boldItalicJRadioButton; // bold and italic
	private ButtonGroup radioGroup; // buttongroup to hold radio buttons

	// RadioButtonFrame constructor adds JRadioButtons to JFrame
	public RadioButtonFrame() {
		super("RadioButton Test");
		// creates empty H box
		Box hBox1 = Box.createHorizontalBox();

		textField = new JTextField(
				"Watch the font style change & test Box Layout");
		// hBox1.add(Box.createHorizontalStrut(20));
		hBox1.add(textField); // add textField to Hbox 1

		// hBox1.add(Box.createHorizontalStrut(20));

		Box hBox2 = Box.createHorizontalBox();
		// create radio buttons
		plainJRadioButton = new JRadioButton("Plain", true);
		boldJRadioButton = new JRadioButton("Bold", false);
		italicJRadioButton = new JRadioButton("Italic", false);
		boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
//		hBox2.add(Box.createHorizontalGlue());
		// create hspace=20 pics
		hBox2.add(Box.createHorizontalStrut(20));
		hBox2.add(plainJRadioButton); // add plain button to HBox2
		hBox2.add(Box.createHorizontalGlue());
		hBox2.add(boldJRadioButton); // add bold button to JFrame
		hBox2.add(Box.createHorizontalGlue());
		hBox2.add(italicJRadioButton); // add italic button to JFrame
		hBox2.add(Box.createHorizontalGlue());
		hBox2.add(boldItalicJRadioButton); // add bold and italic button
		hBox2.add(Box.createHorizontalStrut(20));
		add(hBox1, BorderLayout.NORTH);
		add(hBox2, BorderLayout.SOUTH);
		// create logical relationship between JRadioButtons
		radioGroup = new ButtonGroup(); // create ButtonGroup
		radioGroup.add(plainJRadioButton); // add plain to group
		radioGroup.add(boldJRadioButton); // add bold to group
		radioGroup.add(italicJRadioButton); // add italic to group
		radioGroup.add(boldItalicJRadioButton); // add bold and italic

		// create font objects
		plainFont = new Font("Serif", Font.PLAIN, FONT_SIZE);
		boldFont = new Font("Serif", Font.BOLD, FONT_SIZE);
		italicFont = new Font("Serif", Font.ITALIC, FONT_SIZE);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, FONT_SIZE);
		textField.setFont(plainFont); // set initial font to plain

		// register events for JRadioButtons
		plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldItalicJRadioButton.addItemListener(new RadioButtonHandler(
				boldItalicFont));
	} // end RadioButtonFrame constructor

	
	
	
	// private inner class to handle radio button events
	private class RadioButtonHandler implements ItemListener {
		private Font font; // font associated with this listener

		public RadioButtonHandler(Font f) {
			font = f; // set the font of this listener
		} // end constructor RadioButtonHandler

		// handle radio button events
		public void itemStateChanged(ItemEvent event) {
			textField.setFont(font); // set font of textField
		}
	}
}
