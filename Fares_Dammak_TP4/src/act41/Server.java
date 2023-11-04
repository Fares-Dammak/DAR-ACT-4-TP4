package act41;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
	private static final int  PORT = 1234;
	private static byte[] buffer = new byte[1024];
	public static void main(String[] args)throws SocketException,IOException {
			DatagramSocket socket = new DatagramSocket(PORT);
			System.out.println("demarage du server ");
			while (true) {
				DatagramPacket userNamePacket = new DatagramPacket(buffer,buffer.length);
				socket.receive(userNamePacket);
				String userName = new String(userNamePacket.getData(),0,userNamePacket.getLength());
				System.out.println(userNamePacket.getAddress() + " : " + userName);
				userName="Bienvenu "+userName;
				DatagramPacket msgToSend = new DatagramPacket(userName.getBytes(),userName.length(),userNamePacket.getAddress(),userNamePacket.getPort());
				socket.send(msgToSend);
			}
		
	}

}
