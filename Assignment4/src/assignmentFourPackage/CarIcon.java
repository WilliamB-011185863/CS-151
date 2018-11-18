package assignmentFourPackage;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class CarIcon implements Icon{
	private int car_width;
	public CarIcon(int widthOfIcon)
	{
	car_width = widthOfIcon;
	}
	public void setIconWidth(int widthofIcon){
	car_width = widthofIcon;
	}
	public int getIconWidth()
	{
	return car_width;
	}
	public int getIconHeight()
	{
	return car_width / 2;
	}
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
	Graphics2D g2 = (Graphics2D)g;
	Rectangle2D.Double body = new Rectangle2D.Double(x + car_width/5, y, car_width*1/2, car_width/4);
	Ellipse2D.Double frontTire = new Ellipse2D.Double(x + car_width/5, y + car_width/4, car_width/8, car_width/8);
	Ellipse2D.Double rearTire = new Ellipse2D.Double(x + car_width*3/5, y + car_width/4, car_width/8, car_width/8);
	g2.draw(frontTire);
	g2.draw(rearTire);
	g2.draw(body);
	}

}
