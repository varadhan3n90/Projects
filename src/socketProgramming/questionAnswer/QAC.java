/*
 * Program may not execute
 * 
 *  This program asks the user for a question (abbreviated)
 * to be asked of the server. It then displays the answer
 * sent from the server. Five questions are currently
 * supported. "Quit" ends the interaction.
 *
 * Note that the server is assumed to be running on
 * afsconnect1.njit.edu; its port number is given on the
 * command-line.
 *
 * USAGE: java qac <PORT>
 *
 * where <PORT> is the server's port #.
 *
 * Question (not answered) : http://www.cramster.com/answers-apr-12/computer-science/javasocketfill-replace-yyy-code-statements-incomplete_2442517.aspx
 */
package socketProgramming.questionAnswer;

import java.util.*;
import java.net.*;
import java.io.*;

/**
 * The Class QAC.
 */
public class QAC {
	
	/** The Constant USAGE. */
	public static final String USAGE = "USAGE: java qac <PORT>";

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws java.io.IOException {

		Socket socket;
		boolean finished; // controls loop.
		String user_question; // question from user.
		String answer; // answer obtained from server.
		int port; // from command-line.

		String hostname = "afsconnect1.njit.edu";

		Scanner sc = new Scanner(System.in);

		try {
			// use the port indicated on command-line

			port = Integer.parseInt(args[0]);

			// create a new socket to connect to server, and
			// establish write and read capabilities

			socket = new Socket(hostname, port);

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			Scanner in = new Scanner(new InputStreamReader(
					socket.getInputStream()));

			// keep getting questions until the user chooses to quit

			finished = false;

			while (!finished) {
				// get question from the user

				user_question = sc.nextLine();

				// if input is "Quit", we're finished. Make certain
				// to let the server know.
				// Otherwise, send the question and get a response
				if (user_question.equalsIgnoreCase("quit")) {
					finished = true;					
				} else {
					// send question to server
					out.write(user_question.toCharArray());
					// read response and display it
					answer = in.nextLine();
					System.out.println("Answer from server: "+answer);
				}
			}
			out.close();
			in.close();
			sc.close();
			socket.close();

		} 
		catch (IOException e) // socket problems
		{
			System.out.println(e);
		}

		catch (NumberFormatException e) // port not a number (int)
		{
			System.out.println("First argument must be the port number.");
			System.out.println(USAGE);
		}

		catch (ArrayIndexOutOfBoundsException e) // no port # given
		{
			System.out.println("Need to supply the port number.");
			System.out.println(USAGE);
		}

	} // end main
} // end qac 