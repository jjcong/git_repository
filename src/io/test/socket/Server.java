package io.test.socket;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket通信测试
 *
 * @author  j_cong
 * @date    2018/06/26
 * @version V1.0
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            Socket socket = server.accept();
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = is.readLine();
            System.out.println("Recevied from client" + line);

            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("received data" + line);

            pw.flush();

            pw.close();
            is.close();
            socket.close();
            server.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
