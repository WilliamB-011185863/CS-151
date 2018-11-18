package assignmentFourPackage;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

public class ShapeDisplayer 
{
   public static void main(String[] args)
   {
      ShapeFrame frame = new ShapeFrame(300,400);
      frame.addShape(new SnowManIcon(40));
      frame.addShape(new CarIcon(40));

      
      //frame.setSize(300, 400);
      frame.setTitle("Shape Displayer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

   }
}
