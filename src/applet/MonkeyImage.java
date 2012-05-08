/*
 * Create an applet or Java application that displays 3 monkey faces with a hand. 
 * 1st one with hands on ear and below saying hear no evil. 
 * 2nd with Hands covering eyes with text below saying see no evil. 
 * 3rd Hands covering mouth with text below it saying speak no evil 
 * Answered on : 8/5/12
 * Answered for : http://www.cramster.com/answers-may-12/computer-science/java-create-applet-java-application-displays_2522195.aspx
 */
package applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
// <applet code="MonkeyImage.java" height="500" width="500" />
/**
 * The Class MonkeyImage.
 */
public class MonkeyImage extends Applet{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 325473884405392544L;

	/** The image see. */
	Image see;
	
	/** The image hear. */
	Image hear;
	
	/** The image speak. */
	Image speak;
	
	/** The string see no evil. */
	String seeNoEvil = "See no evil";
	
	/** The string hear no evil. */
	String hearNoEvil = "Hear no evil";
	
	/** The string speak no evil. */
	String speakNoEvil = "Speak no evil";
		
	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	public void init(){
		try {
			see = ImageIO.read(new File("see.png"));
			hear = ImageIO.read(new File("hear.png"));
			speak = ImageIO.read(new File("speak.png"));			
			
		} catch (IOException e) {
			System.out.println("Images not found..");
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){
		g.drawImage(see, 0, 0, null);
		g.drawImage(hear, 150, 0, null);
		g.drawImage(speak, 300, 0, null);
		
		g.drawString(seeNoEvil, 0, 160);
		g.drawString(hearNoEvil, 150, 160);
		g.drawString(speakNoEvil, 300, 160);
	}
}
