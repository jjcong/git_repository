package network.test.tcp.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author j_cong
 * @date 2017年9月26日
 * @describe Socket通信测试：客户端，对应Server
 * @version V1.0.0
 */
public class Client {

	public static void main(String[] args) throws Exception, IOException {
		
		Socket socket = new Socket("127.0.0.1", 30001);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String line = br.readLine();
		
		System.out.println("来自服务器的数据：" + line);
		
		br.close();
		socket.close();
	}
}
