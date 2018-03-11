package network.test.tcp.ip;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author j_cong
 * @date 2017年9月5日
 * @describe 输入线程
 * @version V1.0.0
 */
public class ServerInputThread extends Thread {

	private Socket socket;
	
	public ServerInputThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() { 
		
		try {
			InputStream input = socket.getInputStream();
			
			while(true) {
				byte[] buffer = new byte[1024];
				int length = input.read(buffer);
				String str = new String(buffer, 0, length);
				System.out.println(str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
