package assignmentFourPackage;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class Tilecon {
	Icon tilecon;
	Double xCord;
	Double yCord;
	public Tilecon(Double xx, Double yy, Icon iconIn) {
		this.tilecon = iconIn;
		this.xCord = xx;
		this.yCord = yy;
	}
	public Icon getIcon() {
		return tilecon;
	}
	public Double getX() {
		return xCord;
	}
	public Double getY() {
		return yCord;
	}
	
	
}
