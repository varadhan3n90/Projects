/*
 * Displays choice of colors and sets background accordingly.
 */
package applet;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class ColorApplet.
 */
public class ColorApplet extends Applet implements ItemListener{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9008917998853416736L;
	
	/** The colors. */
	HashMap<String, Color> colors = new HashMap<String,Color>();
	
	/** The red. */
	Color red = new Color(0xFF0000);
	
	/** The blue. */
	Color blue = new Color(0x00FF00);
	
	/** The green. */
	Color green = new Color(0x0000FF);
	
	/** The color group. */
	CheckboxGroup colorGroup = new CheckboxGroup();
	
	/** The r. */
	Checkbox r = new Checkbox("Red",true,colorGroup);
	
	/** The g. */
	Checkbox g = new Checkbox("Blue",false,colorGroup);
	
	/** The b. */
	Checkbox b = new Checkbox("Green",false,colorGroup);
	
	/** The selected. */
	String selected = new String();				
	
	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	public void init(){
		colors.put("Red",red);
		colors.put("Blue",blue);
		colors.put("Green",green);		
		
		add(r);
		add(b);
		add(g);
		
		r.addItemListener(this);
		b.addItemListener(this);
		g.addItemListener(this);		
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){
		Color c = colors.get(selected);
		if(c!=null){			
			setBackground(c);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkbox s = colorGroup.getSelectedCheckbox();
		if(s==r){
			selected = "Red";			
		}
		else if(s==b){
			selected = "Blue";
		}else{
			selected = "Green";
		}
		repaint();
	}
	
}
