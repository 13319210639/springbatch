package netty.nio.day02;

import sun.nio.ch.FileChannelImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Chnanel {

    public static void main(String[] args) throws IOException {
        String string="xqs test NIO";
        String path="E:/xqs33.txt";
        FileOutputStream fileOutputStream =new FileOutputStream(path);
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(8096);
        byteBuffer.put(string.getBytes());
        byteBuffer.position(0);
        channel.write(byteBuffer);
    }
}
