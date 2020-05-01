package netty.nio.day03;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        String org="E:/xqs.txt";
        File orgFile= new File(org);
        String target = "E:/xqs21.txt";
        File targetFile = new File(target);

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        FileInputStream fileInputStream=new FileInputStream(orgFile);
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        FileOutputStream outputStream =new FileOutputStream(targetFile);
        FileChannel outputStreamChannel = outputStream.getChannel();

        outputStreamChannel.transferFrom(inputStreamChannel,0,inputStreamChannel.size());



    }
}
