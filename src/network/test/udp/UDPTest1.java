package network.test.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author j_cong
 * @date 2017年9月6日
 * @describe UDP收发测试
 * @version V1.0.0
 */
public class UDPTest1 {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		String str = "Hello World";
		DatagramPacket packet = new DatagramPacket(str.getBytes(),
				str.length(), InetAddress.getByName("localhost"), 7000);
		socket.send(packet);
		
		byte[] buffer = new byte[1000];
		DatagramPacket packet2 = new DatagramPacket(buffer, 100);
		socket.receive(packet2);
		System.out.println(new String(buffer, 0, packet2.getLength()));
		socket.close();
		
	}
}
