/*
 * Used to draw a bulls eye in applet.
 * Answered for : http://www.cramster.com/answer/edit/2461697/0
 * Answered on : 26/4/12 
 */

package applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

// <applet code="BullsEye.java" height="1000" width="1000"/> 

public class BullsEye extends Applet{
	
	private static final long serialVersionUID = 1L;
	
	public void init(){
		
	}
	public void paint(Graphics g){
		int x=100,y=200;
		int height = 50;							// Diameter will become 100 pixels
		g.setColor(Color.GREEN);
		g.fillOval(x-75, y-75, height+150, height+150);
		g.setColor(Color.BLUE);
		g.fillOval(x-60, y-60, height+120, height+120);
		g.setColor(Color.GREEN);
		g.fillOval(x-45, y-45, height+90, height+90);
		g.setColor(Color.BLUE);
		g.fillOval(x-30, y-30, height+60, height+60);
		g.setColor(Color.GREEN);
		g.fillOval(x-15, y-15, height+30, height+30);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, height, height);			// Center circle	
		
	}
}
