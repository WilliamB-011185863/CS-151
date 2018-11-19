package assignmentFourPackage;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class SnowManIcon implements Icon{
	private int snowman_width;
	public SnowManIcon(int widthOfIcon)
	{
		snowman_width = widthOfIcon;
	}
	public void setIconWidth(int widthofIcon){
		snowman_width = widthofIcon;
	}
	public int getIconWidth()
	{
	return snowman_width;
	}
	public int getIconHeight()
	{
	return snowman_width / 2;
	}
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
	Graphics2D g2 = (Graphics2D)g;
	Ellipse2D.Double body = new Ellipse2D.Double(x + snowman_width/4, y, snowman_width/2, snowman_width/2);
	Ellipse2D.Double head = new Ellipse2D.Double(x + snowman_width*3/8, y + snowman_width/2, snowman_width/4, snowman_width/4);
	g2.draw(body);
	g2.draw(head);
	}

}
