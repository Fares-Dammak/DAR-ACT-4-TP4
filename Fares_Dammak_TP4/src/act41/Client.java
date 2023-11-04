package act41;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
	private static final int PORT=1234;
	private static byte[] buffer = new byte[1024];
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Donner votre nom : ");
		String userName = scanner.nextLine();
		byte[] data = userName.getBytes();
		InetAddress adress = InetAddress.getByName("localhost");
		DatagramPacket dataToSend = new DatagramPacket(data,data.length,adress,PORT);
		socket.send(dataToSend);
		DatagramPacket receivedPacket = new DatagramPacket(buffer,buffer.length);
		socket.receive(receivedPacket);
		System.out.println("Server : "+ new String(receivedPacket.getData(),0,receivedPacket.getLength()));
	}

}
