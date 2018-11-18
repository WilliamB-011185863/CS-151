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
	int numOfButtons = 0;
	public ShapeFrame(int width, int height){
		mainPanel = new JPanel();
		setVisible(true);
	    setSize(width, height);
		setLocation(50,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(ratListener);
		mainPanel.setBounds(0, 40,width, (height-40));
	    this.add(mainPanel);
		TileconIndex = new ArrayList<Tilecon>();
		
	    
	}
	public void addShape(Icon iconToAdd) {
		shapeButton = new JButton();
		shapeButton.setBounds((numOfButtons * 40), 0, 40, 40);
		shapeButton.setIcon(iconToAdd);
		shapeButton.setText("tst:" + numOfButtons);
		numOfButtons++;
		shapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton curButton = (JButton)e.getSource();
				currentIcon = curButton.getIcon();
				System.out.println(shapeButton.getText());
				System.out.println("Debug: Button Pressed");
			}
		});
		shapeButton.setLayout(null);
		this.setLayout(null);
		this.add(shapeButton);
	}
	public void stateChanged(ChangeEvent e)
	{
		System.out.println("State changed");
		repaint();
	}
	public void paint(Graphics g) {
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
		public void MouseClicked(MouseEvent ratty){
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
			double xCord = ratty.getX();
			double yCord = ratty.getY();
			System.out.println(xCord + "," + yCord);
			if (currentIcon == null) {
				System.out.println("Debug: Null Icon");
			}
			else {
				TileconIndex.add(new Tilecon(xCord, yCord, currentIcon));
				repaint();
			}
			
			//if setting =... draw snowman/car/neither
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
}


