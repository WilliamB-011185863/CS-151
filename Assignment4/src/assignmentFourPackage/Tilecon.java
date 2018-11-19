package assignmentFourPackage;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class Tilecon {
	//Tilecon - tile-icon. I'm running low on object naming ideas.
	//This class is meant to hold a icon, with it's coordinates.
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
