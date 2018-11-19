package assignmentFourPackage;

//Note to tester, there is a chance that the jpanel will be black.
//This won't prevent the program from functioning properly (per sae), 
//but it will make it difficult to know it functions properly
//I have done what I could to minimize the chances of this occourence.

//Note: You will need to mouse over the buttons (top left) to get them to show up

public class ShapeDisplayer 
{
   public static void main(String[] args)
   {
      ShapeFrame frame = new ShapeFrame(300,400);
      //All the JFrame's properties are defined in it's class
      frame.addShape(new SnowManIcon(40));
      frame.addShape(new CarIcon(40));
      frame.addShape(new SunIcon(40));
      //Side note: addShape (and everything else) was created with 40x40 icons in mind
   }
}