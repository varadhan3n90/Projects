/*			7 segment display
 * 
 * 						5
 *               ---------------
 *              |				|
 * 			1	|				| 3
 * 				|				|
 * 				|		6		|
 * 				 ---------------
 *              |				|
 * 			2	|				| 4
 * 				|				|
 * 				|		7		|
 * 				 --------------- 
 *
 * 	Bits are activated accordingly to the input. Position specifies the position of the boxes
 * 
 */




package digitApplet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 
/*
 * <applet code="DigitApplet.java" height="1000" width="1000" />
 */




/**
 * The Class DigitApplet.
 */
public class DigitApplet extends Applet implements ActionListener{

	/** The Constant serialVersionUID. */	
	private static final long serialVersionUID = 1L;
	
	/** The Constant sevenSegmentDisplay. */
	private static final int sevenSegmentDisplay = 7;
	
	/** The digit filed to enter single digit. */
	TextField digit = new TextField(1);
	
	/** The submit button. */
	Button submit = new Button("Draw digit");
	
	/** The display variable. */
	boolean display[] = new boolean[sevenSegmentDisplay];
	
	/** The ONE. */
	int ONE[] = {3,4};
	
	/** The TWO. */
	int TWO[] = {2,3,5,6,7};
	
	/** The THREE. */
	int THREE[] = {3,4,5,6,7};
	
	/** The FOUR. */
	int FOUR[] = {1,3,4,6};
	
	/** The FIVE. */
	int FIVE[] = {1,4,5,6,7};
	
	/** The SIX. */
	int SIX[] = {1,2,4,5,6,7};
	
	/** The SEVEN. */
	int SEVEN[] = {3,4,5};
	
	/** The EIGHT. */
	int EIGHT[] = {1,2,3,4,5,6,7};
	
	/** The NINE. */
	int NINE[] = {1,3,4,5,6};
	
	/** The ZERO. */
	int ZERO[] = {1,2,3,4,5,7};
	
	/** The positions. */
	int positions[][] = {
			{50,60,30,70},{50,150,30,70},{120,60,30,70},{120,150,30,70},
			{60,40,80,20},{60,130,80,20},{60,220,80,20}
	};
	
	/**
	 * Clear display.
	 */
	private void clearDisplay(){
		for(int i=0;i<display.length;i++){
			display[i] = false;
		}
	}
	
	/**
	 * Sets the display segments.
	 *
	 * @param val the new display segments
	 */
	private void setDisplaySegments(int val[]){
		clearDisplay();
		for(int i=0;i<val.length;i++){
			display[val[i]-1] = true;			
		}
	}
	
	/**
	 * Sets the display.
	 *
	 * @param number the new display
	 */
	private void setDisplay(int number){
		switch (number){
			case 1: setDisplaySegments(ONE);break;
			case 2: setDisplaySegments(TWO);break;
			case 3: setDisplaySegments(THREE);break;
			case 4: setDisplaySegments(FOUR);break;
			case 5: setDisplaySegments(FIVE);break;
			case 6: setDisplaySegments(SIX);break;
			case 7: setDisplaySegments(SEVEN);break;
			case 8: setDisplaySegments(EIGHT);break;
			case 9: setDisplaySegments(NINE);break;
			case 0: setDisplaySegments(ZERO);break;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	public void init(){
		clearDisplay();
		this.add(digit);
		this.add(submit);
		submit.addActionListener(this);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){		
		g.setColor(Color.BLUE);
		g.clearRect(0, 0, 1000, 1000);
		for(int i=0;i<display.length;i++){
			if(display[i]){
				int []number = positions[i];
				g.fillRect(number[0],number[1],number[2],number[3]);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.applet.Applet#stop()
	 */
	public void stop(){
		
	}
		
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("Draw digit")){
			int number = Integer.parseInt(digit.getText())%10;			
			setDisplay(number);
			this.repaint();
		}
	}
	
}
