/*
 * This program creates a frame where user can enter temperature in centigrade and press submit
 * button to get temperature in farenheit.
 * 
 */
package swingsFrames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Varadhan
 * The Class Temperature.
 */
public class Temperature extends JFrame implements ActionListener{

	/** The Constant serialVersionUID for version of program. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant FRAME_HEIGHT. */
	static final int FRAME_HEIGHT = 200;
	
	/** The Constant FRAME_WIDTH. */
	static final int FRAME_WIDTH = 300;
	
	/** The history is stored in this variable. */
	String history = new String();
	
	/** The label l1 to display information. */
	JLabel l1 = new JLabel("Enter centigrade ");
	
	/** The label l2 to display information. */
	JLabel l2 = new JLabel("Temperature in farenhiet ");
	
	/** The submit button to perform require action. */
	JButton submit = new JButton("Convert");
	
	/** The stored history is displayed with this text area. In case the area is too large maximize the screen. */
	JTextArea storedHistory = new JTextArea(10,25);
	
	/** The celcius input field. */
	JTextField celcius = new JTextField(5);
	
	/** The farenheit output field. */
	JTextField farenheit = new JTextField(5);
	
	
		
	/**
	 * Converts temperature from celcuius to farenheit.
	 *
	 * @param celcius the celcius
	 * @return the double
	 */
	double convertTemperature(double celcius){
		double farenheit = 0.0;
		farenheit =  celcius * 9 / 5 + 32.0 ;
		return farenheit;
	}
	
	/**
	 * Instantiates a new temperature.
	 */
	Temperature(){
		super("Temperature conversion");
		setLayout(new FlowLayout());
		add(l1);
		add(celcius);
		add(l2);
		add(farenheit);
		add(submit);
		add(storedHistory);
		farenheit.setEditable(false);
		setVisible(true);
		submit.addActionListener(this);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		new Temperature();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		/*
		 * on clicking submit button the required actions are performed
		 */
		if(ae.getActionCommand().equals("Convert")){
			double celcius = Double.parseDouble(this.celcius.getText());
			double farenheit = convertTemperature(celcius);
			this.farenheit.setText(farenheit+"");			
			history = celcius+" in Centigrade is "+farenheit+"in Farenhiet.\n"+history;
			storedHistory.setText(history);
			
		}
	}

}
