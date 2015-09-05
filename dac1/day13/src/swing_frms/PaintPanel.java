package swing_frms;

// Using class MouseMotionAdapter.
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	

	// array list of  java.awt.Point references
	private ArrayList<Point> points;
	private Color c;
	private Random r;

	// set up GUI and register mouse event handler
	public PaintPanel() {
		r = new Random();
		points=new ArrayList<>(1000);

		// handle frame mouse motion event
		addMouseMotionListener(

		new MouseMotionAdapter() // anonymous inner class
		{
			// store drag coordinates and repaint
			public void mouseDragged(MouseEvent event) {
				
					points.add(event.getPoint()); // find point & add it to AL
					
					repaint(); // repaint JPanel
				
			} 
		}
		); 
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				randomColor();
				points.clear();// to start filling point arraylist from beginning
			}

		});
	}

	// draw ovals in a 10X10 bounding box at specified locations on window
	public void paintComponent(Graphics g) {
//		super.paintComponent(g); // clears drawing area
		g.setColor(c);//set current draw/fill color
		// draw all points in arraylist
		for (Point p : points)
			g.fillOval(p.x,p.y, 10,10);
	} 

	// generates a random color
	private void randomColor() {
		c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
	}
} 

