package fivePointTwo;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class BarFrame extends JFrame implements ChangeListener
{

   public BarFrame(DataModel dataModel)
   {
      this.dataModel = dataModel;
      a = dataModel.getData();

      setLocation(0,200);
      setLayout(new BorderLayout());
      
      Icon barIcon = new Icon()
      {
         public int getIconWidth() { return ICON_WIDTH; }
         public int getIconHeight() { return ICON_HEIGHT; }
         public void paintIcon(Component c, Graphics g, int x, int y)
         {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.red);

            double max =  (a.get(0)).doubleValue();
            for (Double v : a)
            {
               double val = v.doubleValue();
               if (val > max)
                  max = val;
            }

            double barHeight = getIconHeight() / a.size();

            int i = 0;
            for (Double v : a)
            {
               double value = v.doubleValue();

               double barLength = getIconWidth() * value / max;

               Rectangle2D.Double rectangle = new Rectangle2D.Double
                  (0, barHeight * i, barLength, barHeight);
               i++;
               g2.fill(rectangle);
            }
         }
         
      };
      
      
      
      
      
      JLabel label = new JLabel(barIcon);
      addMouseListener(rat);
      //System.out.println("stuff added");
      add(new JLabel(barIcon));
      //add(label);
      //label.addMouseListener(rat);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }

   /**
      Called when the data in the model is changed.
      @param e the event representing the change
   */
   public void stateChanged(ChangeEvent e)
   {
      a = dataModel.getData();
      repaint();
   }

   private ArrayList<Double> a;
   private DataModel dataModel;

   private static final int ICON_WIDTH = 200;
   private static final int ICON_HEIGHT = 200;
   
   
   
   MouseListener rat = new MouseListener(){
	   public void MouseClicked(MouseEvent ratty){
		  // int yCord = rat.getY();
		   //int xCord = rat.getX();
		   //if (yCord <= getIconHeight()){
			   System.out.println("test 1");
		   //}
		  // else if (yCord <=  (2 * getIconHeight())){
			   System.out.println("test 2");
		   //}
		   //else if (yCord <=  (3 * getIconHeight())){
			   System.out.println("test 3");
		   //}
		   //else {
			   System.out.println("test 4");
		   //}
	   }
	   public void mouseEntered(MouseEvent ratty){
		   //System.out.print("*");
	   }
	   public void mouseExited(MouseEvent ratty){
		   //System.out.print("*");
	   }
	   public void mousePressed(MouseEvent ratty){
		   //System.out.print("*");
	   }
	   public void mouseReleased(MouseEvent ratty){
		   ArrayList<Double> a = dataModel.getData();
		   int liip = a.size() - 1;
		   double largest = 0; //(int) Math.floor(hourRefinedX) list.get(index)).attribute;
		   for (int i = 0; i <= liip; i++) {
			   //System.out.println(a.get(i));
			   if (a.get(i) > largest) {
				   largest = a.get(i);
			   }
		   }
		   double newratty = 0.0;
		   newratty = (ratty.getX() * (largest/ICON_WIDTH));
		   System.out.println(newratty);
		   
		   //System.out.println(largest);
		   //System.out.print(ratty.getX() + "," + ratty.getY());
		 if (ratty.getY() <= (ICON_HEIGHT/4) + 50){
		   System.out.println("test 1 " + ratty.getY());
		   
		   dataModel.update(0, newratty);
		 }
		 else if (ratty.getY() <=  (ICON_HEIGHT/2 )+ 50){
		   System.out.println("test 2 " + ratty.getY());
		   dataModel.update(1, newratty);
		 }
		 else if (ratty.getY() <=  (3 * ICON_HEIGHT/4)+ 50){
		   System.out.println("test 3 " + ratty.getY());
		   dataModel.update(2, newratty);
		 }
		 else if (ratty.getY() < ICON_HEIGHT + 50){
		   System.out.println("test 4 " + ratty.getY());
		   dataModel.update(3, newratty);
		 }
		   
	   }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
   };
   }