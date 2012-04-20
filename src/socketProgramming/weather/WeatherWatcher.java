/**
 * @author Varadhan
 */
/*
 * This is the client program for weather updater.
 * The client opens port 4444 and waits for server to send data indefinitely.
 * UDP socket used.
 */

package socketProgramming.weather;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * The Class WeatherWatcher.
 */
public class WeatherWatcher {
	
	static final int PORT = 4444;
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(PORT);
		} catch (SocketException e) {
			System.out.println("Unable to create the desired socket. "+e.getMessage());
		}
		int size = 128;
		byte[] b = new byte[size];		
		DatagramPacket packet = new DatagramPacket(b,size);
		System.out.println("Starting weather watcher. ");
		while(true){
			try {
				socket.receive(packet);
			} catch (IOException e) {
				System.out.println("Unable to receive packet. "+e.getMessage());
			}
			String temperature = new String(b);
			System.out.println(temperature);
		}
	}
}
