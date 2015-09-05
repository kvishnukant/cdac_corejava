package swing_frms;
// Testing MouseTrackerFrame.
import javax.swing.JFrame;

public class MouseTracker 
{
   public static void main( String[] args )
   { 
      MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame(); 
      mouseTrackerFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      mouseTrackerFrame.setSize( 400, 200 ); // set frame size
      mouseTrackerFrame.setLocationRelativeTo(null);
      mouseTrackerFrame.setVisible( true ); // display frame
   } 
} 

