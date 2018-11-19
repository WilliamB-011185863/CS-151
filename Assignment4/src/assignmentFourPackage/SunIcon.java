package assignmentFourPackage;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

public class SunIcon implements Icon{
	//This class represents the sun icon, which can be AddShape'd to the ShapeFrame
	private int sun_width;
	public SunIcon(int widthOfIcon)
	{
		sun_width = widthOfIcon;
	}
	public void setIconWidth(int widthofIcon){
		sun_width = widthofIcon;
	}
	public int getIconWidth()
	{
	return sun_width;
	}
	public int getIconHeight()
	{
	return sun_width / 2;
	}
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
	Graphics2D g2 = (Graphics2D)g;
	Ellipse2D.Double center = new Ellipse2D.Double(x + sun_width/4, y + sun_width/4, sun_width/2, sun_width/2);
	g2.draw(center);
	g2.drawLine(x + sun_width/2, y, x + sun_width/2, y + sun_width/4);
	g2.drawLine(x, y + sun_width/2, x + sun_width/4, y + sun_width/2);
	g2.drawLine(x + sun_width*3/4, y + sun_width/2, x + sun_width, y + sun_width/2);
	g2.drawLine(x + sun_width/2, y + sun_width*3/4, x + sun_width/2, y + sun_width);
	}

}