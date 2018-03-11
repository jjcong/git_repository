package io.test.file;

import java.io.File;
/**
 * 展示指定目录下的所有目录或文件，没有实现遍历访问
 * 
 * @author  j_cong
 * @date    2017/10/03
 * @version V1.0
 */
public class ListAllFileTest {
	
	public static void main(String[] args) {

	    //为了不同系统的兼容性使用File.separator,表示“\”
		String fileName = "D:" + File.separator + "java";
		File f = new File(fileName);
		File[] listFiles = f.listFiles();

		if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                System.out.println(file);
            }
        }
	}
}
