package network.test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author j_cong
 * @date 2017年9月4日
 * @describe 根据url获取指定页面的源代码,字节流的形式
 * @version V1.0.0
 */
public class UrlConnection {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("https://www.baidu.com/");
		
		URLConnection conn  = url.openConnection();
		
		InputStream is = conn.getInputStream();
		
		//等效代码
//		InputStream is = url.openStream();
		
		OutputStream os = new FileOutputStream("D:/baidu.txt");
		byte[] buffer = new byte[2048];
		
		int length = 0;
		
		while ((length = is.read(buffer, 0, buffer.length)) != -1) {
			os.write(buffer, 0, length);
		}
		
		is.close();
		os.close();
	}
}
