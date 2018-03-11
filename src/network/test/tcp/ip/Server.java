package network.test.tcp.ip;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author j_cong
 * @date 2017年9月26日
 * @describe Socket通信测试：服务器端，对应Client
 * @version V1.0.0
 */
public class Server {

	public static void main(String[] args) throws Exception {
		
		ServerSocket ss = new ServerSocket(30001);
		
		while (true) {
			Socket s = ss.accept();
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.print("您好!您收到了服务器的新年祝福！");
			
			ps.close();
			s.close();
		}
	}
}
