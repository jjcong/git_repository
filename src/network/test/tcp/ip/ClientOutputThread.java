package network.test.tcp.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author j_cong
 * @date 2017年9月5日
 * @describe 客户端输出线程
 * @version V1.0.0
 */
public class ClientOutputThread extends Thread {

	private Socket socket;
	
	public ClientOutputThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() { 
		
		try {
			OutputStream output = socket.getOutputStream();
			
			while(true) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String line = reader.readLine();
				
				output.write(line.getBytes());

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
	}
	
}
