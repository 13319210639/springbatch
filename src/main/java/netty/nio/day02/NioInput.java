package netty.nio.day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioInput {

    public static void main(String[] args) throws IOException {
        String string ="E:/xqs.txt";

        FileInputStream fileInputStream =new FileInputStream(string);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(8096);
        channel.read(byteBuffer);
     System.out.println(new String(byteBuffer.array()));
    }
}
