package network.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 * @author j_cong
 * @date 2017年9月4日
 * @describe 根据url获取指定页面的源代码,字符流的形式
 * @version V1.0.0
 */
public class UrlConnection2 {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://www.baidu.com");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	    String line = null;
		
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
		InetAddress address = InetAddress.getByName("www.baidu.com");
		System.out.println(address);
	}
	
}
