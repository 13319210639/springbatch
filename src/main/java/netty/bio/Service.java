package netty.bio;

import org.apache.catalina.Executor;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service {
    private static ServerSocket server;


    public static void main(String[] args) throws IOException {
        server = new ServerSocket(9999);
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("服务器启动");
        while (true) {
            Socket accept = server.accept();

            System.out.println("有服务连接");
            executorService.execute(() -> {
                InputStream inputStream=null;
                try {
                    inputStream = accept.getInputStream();
                    byte bytes[]=new byte[8096];
                    while (inputStream.read(bytes)!=-1){
                        System.out.println(new String(bytes,0,bytes.length));
                    }
                    System.out.println(Thread.currentThread());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {

                }
            });
        }
    }
}
