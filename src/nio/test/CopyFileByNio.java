package nio.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用NIO实现文件的复制
 *
 * @author  j_cong
 * @date    2018/03/07
 * @version V1.0
 */
public class CopyFileByNio {

    public static void main(String[] args) throws IOException {

        //1、读数据，通过inputStream获取Channel，抛异常
        FileInputStream fileInputStream = new FileInputStream("E:\\SingleNumber\\Person.java");

        FileChannel infileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //把Channel中的数据写入buffer中，若读到末尾，则返回-1

        //2、将数据写入文件
        //获得一个通道
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\1\\jc.java");

        FileChannel outfileChannel = fileOutputStream.getChannel();

        while (true) {
            //需抛异常
            int eof = infileChannel.read(byteBuffer);

            if (eof == -1) {
                break;
            } else {
                //将读模式改为写模式
                byteBuffer.flip();
                outfileChannel.write(byteBuffer);

                byteBuffer.clear();
            }
        }

        infileChannel.close();
        outfileChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
