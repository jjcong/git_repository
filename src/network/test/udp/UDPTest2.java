package network.test.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author j_cong
 * @date 2017年9月6日
 * @describe UDP收发测试，先收再发
 * @version V1.0.0
 */
public class UDPTest2 {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(7000);
		byte[] buffer = new byte[1000]; 
		DatagramPacket packet = new DatagramPacket(buffer, 1000);
		socket.receive(packet);
		
		System.out.println(new String(buffer, 0, packet.getLength()));
		
		String str = "Welcome";
		DatagramPacket packet2 = new DatagramPacket(str.getBytes(), str.length(), 
				packet.getAddress(), packet.getPort());
		
		socket.send(packet2);
		socket.close();
		
	}
}
