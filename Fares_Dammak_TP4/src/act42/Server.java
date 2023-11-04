package act42;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	private static final int  PORT = 1234;
	private static byte[] buffer = new byte[1024];
	
	
	public static void main(String[] args)throws Exception {
			DatagramSocket socket = new DatagramSocket(PORT);
			System.out.println("demarage du server ");
			while (true) {
				DatagramPacket userNamePacket = new DatagramPacket(buffer,buffer.length);
				socket.receive(userNamePacket);
				
				String time = getCurentTime();
				DatagramPacket msgToSend = new DatagramPacket(time.getBytes(),time.length(),userNamePacket.getAddress(),userNamePacket.getPort());
				socket.send(msgToSend);
			}
		
	}
	public static String getCurentTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY MM DD HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
