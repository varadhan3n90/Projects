/*
 * Program to get input using JOption pane and dispaly perimeter as output.
 * Answered for : http://www.cramster.com/answers-may-12/computer-science/convert-import-javaio-class-function-void-squareint-sideint_2510193.aspx
 * Answered on: 6/5/12
 */
package swingsFrames;

import javax.swing.JOptionPane;

class Perimeter {
	String output;
	void square(int side, int b) {
		int perimeter;
		perimeter = 4 * side;
		output = "Perimeter of the Square is :" + perimeter;
		JOptionPane.showMessageDialog(null, output, "Perimeter", JOptionPane.PLAIN_MESSAGE);
	}

	void rectangle(int length, int width) {
		int perimeter;
		perimeter = 2 * (length + width);
		output = "Perimeter of the Rectangle is :" + perimeter;
		JOptionPane.showMessageDialog(null, output, "Perimeter", JOptionPane.PLAIN_MESSAGE);
	}

	void circle(int radius, int b) {
		double perimeter;
		perimeter = 2 * 3.14 * radius;
		output = "Perimeter of the Circle is :" + perimeter;
		JOptionPane.showMessageDialog(null, output, "Perimeter", JOptionPane.PLAIN_MESSAGE);
	}
}

/**
 * The Class OptionPanePerimeter.
 */
class OptionPanePerimeter extends Perimeter {	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {			
			int a, b, choice;
			OptionPanePerimeter function = new OptionPanePerimeter();
			do {
				String input;
				String message = " * * M E N U * *\n" + 
				" 1 : Square" +
				" 2 : Rectangle"+
				" 3 : Circle" +
				" 5 : Exit\n" +
				" Enter your choice :";
				choice = Integer.parseInt(JOptionPane.showInputDialog(null, message, "Perimeter", JOptionPane.QUESTION_MESSAGE));
				switch (choice) {
				case 1:
					input = "Enter any one side : ";
					a = Integer.parseInt(JOptionPane.showInputDialog(null, input, "Perimeter", JOptionPane.QUESTION_MESSAGE));
					function.square(a, 0);
					break;
				case 2:
					input = "Enter the length :";
					a = Integer.parseInt(JOptionPane.showInputDialog(null, input, "Perimeter", JOptionPane.QUESTION_MESSAGE));
					input = "Enter the width :";
					b = Integer.parseInt(JOptionPane.showInputDialog(null, input, "Perimeter", JOptionPane.QUESTION_MESSAGE));
					function.rectangle(a, b);
					break;
				case 3:
					input = "Enter the radius :";
					a = Integer.parseInt(JOptionPane.showInputDialog(null, input, "Perimeter", JOptionPane.QUESTION_MESSAGE));
					function.circle(a, 0);
					break;
				}
			} while (choice != 5);
		} catch (Exception e) {
		}
	}
}