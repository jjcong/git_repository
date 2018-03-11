package network.test.tcp.ip;

import java.io.IOException;
import java.net.Socket;

/**
 * @author j_cong
 * @date 2017年9月5日
 * @describe 服务端
 * @version V1.0.0
  */
public class MainClient {

	public static void main(String[] args) throws Exception, IOException {
		Socket socket = new Socket("127.0.0.1", 4000);
		
		new ClientInputThread(socket).start();
		new ClientOutputThread(socket).start();
	}
}
