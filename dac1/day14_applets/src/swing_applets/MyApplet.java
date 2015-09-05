package swing_applets;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MyApplet extends JApplet
{
	private StringBuilder sb;
	@Override
		public void init()
	{
		sb=new StringBuilder("In init ");
			System.out.println("init by "+Thread.currentThread());
		
		MyPanel p1=new MyPanel();
		p1.setBackground(Color.CYAN);
		p1.setFont(new Font("Serif",Font.BOLD,25));
		add(p1);
		try
		{
			//attach a file reader
		FileReader fin=new FileReader("g:/bank_accts.txt");
		}
		catch (Exception e )
		{
			e.printStackTrace();
		}
		
	}
	@Override
		public void start()
	{
		sb.append(" In start ");
			System.out.println("start by "+Thread.currentThread());
		
	}
	@Override
		public void stop()
	{
		sb.append(" In stop ");
			System.out.println("stop by "+Thread.currentThread());
		
	}
	@Override
		public void destroy()
	{
		sb.append(" In destroy ");
			System.out.println("destroy by "+Thread.currentThread());
		
	}
	private class MyPanel extends JPanel
	{
		@Override
			public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			System.out.println("paint by "+Thread.currentThread());
			sb.append(" in paint ");
			g.setColor(Color.RED);
			g.drawString(sb.toString(),20,100);

		}
	}
}
