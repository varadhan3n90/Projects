/*
 * Gives JOption pane to enter temperature ( number followed by c or f ) and converted to other metric
 * and displays the output.
 * 
 * Answered for : http://www.cramster.com/answers-apr-12/computer-science/java-joptionpane-write-program-user_2454955.aspx
 */
package swingsFrames;

import javax.swing.JOptionPane;

/**
 * The Class OptionPaneTemperature.
 */
public class OptionPaneTemperature {
		
	/** The message. */
	String message = "Enter temperature: ";
	
	/** The finished. */
	boolean finished = false;
	
	/**
	 * Convert to farenhiet.
	 *
	 * @param celcius the celcius
	 * @return the double
	 */
	double convertToFarenhiet(double celcius){
		double farenheit = 0.0;
		farenheit =  celcius * 9 / 5 + 32.0 ;
		return farenheit;
	}
	
	/**
	 * Convert to celcius.
	 *
	 * @param farenheit the farenheit
	 * @return the temperature in celcius (double)
	 */
	double convertToCelcius(double farenheit){
		double celcius = 0.0;
		celcius = 5 * (farenheit - 32.0) / 9;
		return celcius;
	}
	
	/**
	 * Process input.
	 *
	 * @param input the input
	 */
	public void processInput(String input){
		double temperature = 0.0;
		String output="";
		try{			
			char t = input.charAt(input.length() - 1 );
			input = input.substring(0,input.length()-1);
			input.trim();
			if(t=='c'||t=='C'){		
					temperature = convertToFarenhiet(Double.parseDouble(input));
					output = " degree F ";					
			}
			if(t=='f'||t=='F'){		
					temperature = convertToCelcius(Double.parseDouble(input));
					output = " degree C " ;
			}
		}catch(Exception e){ 
			JOptionPane.showMessageDialog(null, "Error invalid input", "Error", JOptionPane.ERROR_MESSAGE);			
			return;
		}
		output = "Temperature is "+temperature+output;
		JOptionPane.showMessageDialog(null, output, "Conversion", JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Instantiates a new option pane temperature.
	 */
	public OptionPaneTemperature(){
		
		while(!finished){		
			String input = JOptionPane.showInputDialog(null, message, "Temperature conversion", JOptionPane.QUESTION_MESSAGE);
			processInput(input);
			int result = JOptionPane.showConfirmDialog(null, "Do you want to continue","Temperature conversion", JOptionPane.YES_NO_OPTION);
			if(result != JOptionPane.YES_OPTION){
				finished = true;
			}
		}
		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		new OptionPaneTemperature();
	}
}
