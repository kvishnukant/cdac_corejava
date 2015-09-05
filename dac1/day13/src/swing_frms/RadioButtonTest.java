package swing_frms;
// Testing RadioButtonFrame.
import javax.swing.JFrame;

public class RadioButtonTest  
{
   public static void main( String[] args )
   {
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
      radioButtonFrame.setLocation(300,300);
      radioButtonFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      radioButtonFrame.setSize( 400, 120 ); // set frame size
      radioButtonFrame.setVisible( true ); // display frame
   } 
}  

