/**
 * @author Varadhan
 * 
 * This is a simple program to demonstrate UDP socket programming using Datagrams.
 * This is a server program and transmits "Current temperature is X" where X is random number between 0 and 100 to client every 15s using timer task
 * Run the program with command line arguments as client host name and port number
 * 
 */

package socketProgramming.weather;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Class WeatherUpdater.
 */
public class WeatherUpdater extends TimerTask{

	/** The socket. */
	DatagramSocket socket;
	
	/** The recipient name. */
	String recipientName;
	
	/** The recipient port. */
	int recipientPort;
	
	/**
	 * Instantiates a new weather updater.
	 *
	 * @param recipientName the recipient name
	 * @param recipientPort the recipient port
	 * @param socket creates a new port to send data from. random port
	 * @throws SocketException the socket exception
	 */
	public WeatherUpdater(String recipientName,int recipientPort) throws SocketException{
		this.recipientName = recipientName;
		this.recipientPort = recipientPort;
		socket = new DatagramSocket();
	}
	
	
	@Override
	public void run() {
		Random rand = new Random();
		int temperature = rand.nextInt(100);
		String temp = "Current temperature is "+temperature;
		InetAddress ipaddress = null;
		try {
			ipaddress = InetAddress.getByName(recipientName);
		} catch (UnknownHostException e) {			
			System.out.println("No such recipient available. "+e.getMessage());
			return;
		}
		DatagramPacket packet = new DatagramPacket(temp.getBytes(),temp.length(),ipaddress,recipientPort);
		try {
			socket.send(packet);
		} catch (IOException e) {
			System.out.println("Unable to send packet. "+e.getMessage());
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		if(args.length!=2){
			System.out.println("Usage: \tjava WeatherUpdater [recepient name] [recepient port]");
			return;
		}
		WeatherUpdater updater = null;
		String recipientName = args[0];
		int recipientPort = Integer.parseInt(args[1]);		
		try {
			updater = new WeatherUpdater(recipientName, recipientPort);
			System.out.println("Starting weather updater service.");
			Timer timer = new Timer("Weather updater timer");
			int delay = 0;
			int period = 15000;
			timer.schedule(updater,delay,period);
		} catch (SocketException e) {
			System.out.println("Unable to create weather updater. "+e.getMessage());
		}
		
	}
	

}
