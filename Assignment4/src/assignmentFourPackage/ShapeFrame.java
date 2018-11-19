package assignmentFourPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class ShapeFrame extends JFrame implements ChangeListener
{
	static JPanel mainPanel;
	static JButton shapeButton;
	private Icon currentIcon = null;
	private ArrayList<Tilecon> TileconIndex;
	//TileconIndex is where we store all the "placed icons
	int numOfButtons = 0;
	public ShapeFrame(int width, int height){
		//All the basic properties of the JFrame and JPanel are defined
		//and the JPanel is attached to the JFrame
		//(also, the tilecon array is instantiated)
		mainPanel = new JPanel();
		setVisible(true);
	    setSize(width, height);
		setLocation(50,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Shape Displayer");
		addMouseListener(ratListener);
		mainPanel.setBounds(0, 40,width, (height-40));
	    this.add(mainPanel);
		TileconIndex = new ArrayList<Tilecon>();
	}
	public void addShape(Icon iconToAdd) {
		//Meant to take in a 40x40 icon, create a button,
		//set the button's icon to the input'd icon,
		//and attach a listener for setting the currentIcon
		//to match the icon on the button
		shapeButton = new JButton();
		shapeButton.setBounds((numOfButtons * 40), 0, 40, 40);
		shapeButton.setIcon(iconToAdd);
		numOfButtons++;
		shapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton curButton = (JButton)e.getSource();
				currentIcon = curButton.getIcon();
				//System.out.println("Debug: Button Pressed");
			}
		});
		shapeButton.setLayout(null);
		this.setLayout(null);
		this.add(shapeButton);
	}
	public void stateChanged(ChangeEvent e){
	}
	public void paint(Graphics g) {
		//Draws all the tilecons in our TileconIndex
		if (TileconIndex.size() > 0){
			for (int i = 0; i < TileconIndex.size(); i++) {
			Icon image = TileconIndex.get(i).getIcon();
			int xx = TileconIndex.get(i).getX().intValue();
			int yy = TileconIndex.get(i).getY().intValue();
			image.paintIcon(mainPanel, g, xx, yy);
			}
		}
	}

	MouseListener ratListener = new MouseListener(){
		public void mouseEntered(MouseEvent ratty){
		}
		public void mouseExited(MouseEvent ratty){
		}
		public void mousePressed(MouseEvent ratty){
		}
		public void mouseReleased(MouseEvent ratty){
			double xCord = ratty.getX() - 20;
			double yCord = ratty.getY() - 20;
			//The images are meant to be 40x40, getX/Y-20 allows
			//us to center where the image appears on the pointer
			System.out.println(xCord + "," + yCord);
			if (currentIcon == null) {
				//System.out.println("Debug: Null Icon");
				//We do not attempt to add a tilecon when currentIcon is null
				//As this would error when attempting to paint the tilecon
			}
			else {
				TileconIndex.add(new Tilecon(xCord, yCord, currentIcon));
				repaint();
			}
		}
		public void mouseClicked(MouseEvent ratty) {
		}
	};
	
}


